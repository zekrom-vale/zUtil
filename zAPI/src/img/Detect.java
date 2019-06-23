package img;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;


/**
 * Contains various methods dealing with images
 *
 * @author Zekrom
 */
public class Detect{
	/**
	 * Contains various methods to find the query in a map<br>
	 * <code>null</code> is returned if no match is found
	 *
	 * @author Zekrom
	 */
	public static class Find{
		/**
		 * Finds the all occurrences of a query in a map, an empty ArrayList if none was found
		 *
		 * @param  map
		 *                   The image map to detect the query in
		 * @param  query
		 *                   The map to find, use 0 to ignore
		 * @return       The top left position of the find
		 */
		public static ArrayList<int[]> all(final Map map, final Map query){
			return null;
		}

		/**
		 * Finds the all occurrences of a query in a map, ignoring color range, an empty ArrayList if none
		 * was found
		 *
		 * @param  map
		 *                   The image map to detect the query in
		 * @param  query
		 *                   The map to find, use 0 to ignore
		 * @return       The top left positions of the finds
		 */
		public static ArrayList<int[]>
			allIgnoreColor(final Map map, final Map query){
			final int _mapRow=map.map.length-query.map.length,
				_mapCol=map.map[0].length-query.map[0].length;
			final ArrayList<int[]> all=new ArrayList<>();
			for(int mapRow=0; mapRow<_mapRow; mapRow++){
				for(int mapCol=0; mapCol<_mapCol; mapCol++){
					//Try to find the query
					final int[] find=Detect
						.innerFindIgnoreColor(map, query, mapRow, mapCol);
					if(find!=null){
						all.add(find);
					}
				}
			}
			return all;
		}

		/**
		 * Finds the first occurrence of a query in a map, <code>null</code> if no match is found
		 *
		 * @param  map
		 *                   The image map to detect the query in
		 * @param  query
		 *                   The map to find, use 0 to ignore
		 * @return       The top left position of the find
		 */
		public static int[] first(final Map map, final Map query){
			return null;
		}

		/**
		 * Finds the first occurrence of a query in a map, ignoring color, <code>null</code> if no match is
		 * found
		 *
		 * @param  map
		 *                   The image map to detect the query in
		 * @param  query
		 *                   The map to find, use 0 to ignore
		 * @return       The top left position of the find
		 */
		public static int[] ignoreColor(final Map map, final Map query){
			final int _mapRow=map.map.length-query.map.length,
				_mapCol=map.map[0].length-query.map[0].length;
			for(int mapRow=0; mapRow<_mapRow; mapRow++){
				for(int mapCol=0; mapCol<_mapCol; mapCol++){
					//Try to find the query
					final int[] find=Detect
						.innerFindIgnoreColor(map, query, mapRow, mapCol);
					if(find!=null) return find;
				}
			}
			return null;
		}
	}
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
		public HashMap<Long, byte[][]> keys;
		/**
		 * The map of the image
		 */
		public long[][] map;


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
		 * @param img
		 *                      The image to analyze
		 * @param range
		 *                      The amount of pixels to look around
		 * @param tolerance
		 *                      How much of a difference to match pixels
		 */
		public Map(final byte[][][] img, final int range, final int tolerance){
			if(range<=0){
				throw new Error("Range must be positive.");
			}
			this.img=img;
			this.map=new long[this.img.length][this.img[0].length];
			final HashMap<Long, ArrayList<Long>> sym=new HashMap<>();
			long gen=0;
			sym.put(gen, new ArrayList<>());
			for(int row=0; row<this.img.length; row++){
				for(int col=0; col<this.img[row].length; col++){
					if(this.map[row][col]==0){
						this.map[row][col]=gen++;
						sym.put(gen, new ArrayList<>());
					}
					final int _sCol=Math.min(col+range-1, this.img[row].length);
					for(int sCol=col+1; sCol<_sCol; sCol++){
						if(
							Detect.equal(
								this.img[row][col], this.img[row][sCol],
								tolerance
							)
						){
							if(this.map[row][sCol]!=0){
								//Add synonym
								sym.get(this.map[row][col])
									.add(this.map[row][sCol]);
								sym.get(this.map[row][sCol])
									.add(this.map[row][col]);
							}
							else this.map[row][sCol]=this.map[row][col];
						}
					}
					final int _sRow=Math.min(row+range-1, this.img.length);
					for(int sRow=row+1; sRow<_sRow; sRow++){
						for(int sCol=col-range; sCol<_sCol; sCol++){
							if(
								Detect.equal(
									this.img[row][col], this.img[row][sCol],
									tolerance
								)
							){
								if(this.map[row][sCol]!=0){
									//Add synonym
									sym.get(this.map[row][col])
										.add(this.map[row][sCol]);
									sym.get(this.map[row][sCol])
										.add(this.map[row][col]);
								}
								else this.map[row][sCol]=this.map[row][col];
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
					Detect.fixSynonyms(
						sym, entry.getKey(), entry.getValue(), set
					);
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
			this.keys=new HashMap<>();
			for(int row=0; row<this.map.length; row++){
				for(int col=0; col<this.map[row].length; col++){
					this.map[row][col]=mapset.get(this.map[row][col]);
					final byte[][] key=this.keys.get(this.map[row][col]);
					if(key!=null){
						//Min
						for(int i=0; i<key.length; i++){
							if(this.img[row][col][i]<key[0][i]){
								key[0][i]=this.img[row][col][i];
							}
						}
						//Max
						for(int i=0; i<key.length; i++){
							if(this.img[row][col][i]>key[1][i]){
								key[1][i]=this.img[row][col][i];
							}
						}
						this.keys.put(this.map[row][col], key);
					}
					else{
						this.keys.put(
							this.map[row][col],
							new byte[][]{Arrays.copyOf(
								this.img[row][col], this.img[row][col].length
							), Arrays.copyOf(
								this.img[row][col], this.img[row][col].length
							)}
						);
					}
				}
			}
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

	private static int[] innerFindIgnoreColor(
		final Map map, final Map query, final int mapRow, final int mapCol
	){
		final HashMap<Long, Long> transfer=new HashMap<>();
		for(int queryRow=0; queryRow<query.map.length; queryRow++){
			for(
				int queryCol=0; queryCol<query.map[queryRow].length; queryCol++
			){
				if(query.map[queryRow][queryCol]==0) continue;
				final Long key=transfer.get(query.map[queryRow][queryCol]);
				if(key==null){
					transfer
						.put(key, map.map[mapRow+queryRow][mapCol+queryCol]);
				}
				else if(map.map[mapRow+queryRow][mapCol+queryCol]!=key){
					return new int[]{mapCol, mapRow};
				}
			}
		}
		return null;
	}
}
