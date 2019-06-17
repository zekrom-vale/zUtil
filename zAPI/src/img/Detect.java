package img;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.w3c.dom.ranges.RangeException;

/**
 * Contains various methods dealing with images
 *
 * @author Zekrom
 */
public class Detect{
	/**
	 * Contains info about a map
	 *
	 * @author Zekrom
	 */
	public static class Map{
		/**
		 * The unaltered image
		 */
		public byte[][][] img;
		/**
		 * What each value represents as a range
		 */
		public HashMap<Long, byte[][]> key;
		/**
		 * The map of the image
		 */
		public long[][] map;


		/**
		 * @param map
		 *                The map of the image
		 * @param key
		 *                The key of the map
		 * @param img
		 *                The unaltered image
		 */
		public Map(
			final long[][] map, final HashMap<Long, byte[][]> key,
			final byte[][][] img
		){
			this.map=map;
			this.key=key;
			this.img=img;
		}
	}


	/**
	 * Tests if two pixels are equal
	 *
	 * @param  pixel
	 *                    The first pixel to test
	 * @param  pixel2
	 *                    The second pixel to test
	 * @return        The equality of the pixel
	 */
	public static boolean equal(final byte[] pixel, final byte[] pixel2){
		for(int i=0; i<pixel.length; i++){
			if(pixel[i]!=pixel2[i]) return false;
		}
		return true;
	}

	/**
	 * Tests if two pixels are equal
	 *
	 * @param  pixel
	 *                       The first pixel to test
	 * @param  pixel2
	 *                       The second pixel to test
	 * @param  tolerance
	 *                       The tolerance amount per pixel
	 * @return           The equality of the pixel
	 */
	public static boolean
		equal(final byte[] pixel, final byte[] pixel2, final int tolerance){
		for(int i=0; i<pixel.length; i++){

			if(
				pixel[i]-tolerance>pixel2[i]||pixel2[i]>pixel[i]+tolerance
			) return false;
		}
		return true;
	}

	public static void find(){

	}

	private static void fixSynonyms(
		final HashMap<Long, ArrayList<Long>> sym, final Long key,
		final ArrayList<Long> values, final HashSet<Long> set
	){
		//Remove from Map
		sym.remove(key);
		for(final long value : values){
			if(set.add(value)){
				Detect.fixSynonyms(sym, value, sym.get(value), set);
			}
		}
	}

	/**
	 * <code><pre>
	 * 100
	 * 000
	 * 000
	 * </pre></code>
	 *
	 * <code><pre>
	 * 110
	 * 010
	 * 000
	 * </pre></code>
	 *
	 * <code><pre>
	 * 112
	 * 012
	 * 000
	 * </pre></code>
	 *
	 * <code><pre>
	 * 112
	 * 312
	 * 030
	 * </pre></code>
	 *
	 * <code><pre>
	 * 112
	 * 312
	 * 430
	 * </pre></code>
	 *
	 * <code><pre>
	 * 112
	 * 312
	 * 435
	 * </pre></code>
	 *
	 * @param  img
	 *                       The image to analyze
	 * @param  range
	 *                       The amount of pixels to look around
	 * @param  tolerance
	 *                       How much of a difference to match pixels
	 * @return           A map of similar pixels
	 */
	public static Map
		map(final byte[][][] img, final int range, final int tolerance){
		if(range<=0){
			throw new RangeException((short)0, "Range must be positive.");
		}
		final long[][] map=new long[img.length][img[0].length];
		final HashMap<Long, ArrayList<Long>> sym=new HashMap<>();
		long gen=0;
		sym.put(gen, new ArrayList<>());
		for(int row=0; row<img.length; row++){
			for(int col=0; col<img[row].length; col++){
				if(map[row][col]==0){
					map[row][col]=gen++;
					sym.put(gen, new ArrayList<>());
				}
				final int _sCol=Math.min(col+range-1, img[row].length);
				for(int sCol=col+1; sCol<_sCol; sCol++){
					if(Detect.equal(img[row][col], img[row][sCol], tolerance)){
						if(map[row][sCol]!=0){
							//Add synonym
							sym.get(map[row][col]).add(map[row][sCol]);
							sym.get(map[row][sCol]).add(map[row][col]);
						}
						else map[row][sCol]=map[row][col];
					}
				}
				final int _sRow=Math.min(row+range-1, img.length);
				for(int sRow=row+1; sRow<_sRow; sRow++){
					for(int sCol=col-range; sCol<_sCol; sCol++){
						if(
							Detect
								.equal(img[row][col], img[row][sCol], tolerance)
						){
							if(map[row][sCol]!=0){
								//Add synonym
								sym.get(map[row][col]).add(map[row][sCol]);
								sym.get(map[row][sCol]).add(map[row][col]);
							}
							else map[row][sCol]=map[row][col];
						}
					}
				}
			}
		}
		//Fix synonyms
		final ArrayList<HashSet<Long>> sets=new ArrayList<>();
		for(
			final Iterator<Entry<Long, ArrayList<Long>>> iterator
				=sym.entrySet().iterator();
			iterator.hasNext();
		){
			final Entry<Long, ArrayList<Long>> entry=iterator.next();
			if(sym.containsKey(entry.getKey())){//Is this required?
				final HashSet<Long> set=new HashSet<>();
				set.add(entry.getKey());
				sets.add(set);
				Detect.fixSynonyms(sym, entry.getKey(), entry.getValue(), set);
			}
		}
		//Transfer to mapset
		final HashMap<Long, Long> mapset=new HashMap<>(sets.size()*10);
		{
			long key=0;
			for(final HashSet<Long> set : sets){
				key++;
				for(final long value : set){
					mapset.put(value, key);
				}
			}
		}
		//Simplify map and get pixel range
		final HashMap<Long, byte[][]> keys=new HashMap<>();
		for(int row=0; row<map.length; row++){
			for(int col=0; col<map[row].length; col++){
				map[row][col]=mapset.get(map[row][col]);
				final byte[][] key=keys.get(map[row][col]);
				if(key!=null){
					//Min
					for(int i=0; i<key.length; i++){
						if(img[row][col][i]<key[0][i]){
							key[0][i]=img[row][col][i];
						}
					}
					//Max
					for(int i=0; i<key.length; i++){
						if(img[row][col][i]>key[1][i]){
							key[1][i]=img[row][col][i];
						}
					}
					keys.put(map[row][col], key);
				}
				else{
					keys.put(
						map[row][col],
						new byte[][]{Arrays.copyOf(
							img[row][col], img[row][col].length
						), Arrays.copyOf(img[row][col], img[row][col].length)}
					);
				}
			}
		}
		return new Map(map, keys, img);
	}
}
