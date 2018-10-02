package zUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import zUtil.Index;

public final class Array{
	/**
	 * Converts ArrayList< Integer> to int[]
	 * @param list
	 * @return array
	 */
	public static final int[] toInt(ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}
	/**
	 * Converts ArrayList< Integer> to int[]
	 * @param list
	 * @return array
	 */
	public static final int[] toIntager(ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}
	/**
	 * Converts ArrayList< Long> to long[]
	 * @param list
	 * @return array
	 */
	public static final long[] toLong(ArrayList<Long> list){
		return list.stream().mapToLong(i->i).toArray();
	}
	/**
	 * Converts ArrayList< Double> to double[]
	 * @param list
	 * @return array
	 */
	public static final double[] toDouble(ArrayList<Double> list){
		return list.stream().mapToDouble(i->i).toArray();
	}
	/**
	 * Converts ArrayList< String> to String[]
	 * @param list
	 * @return array
	 */
	public static final String[] toString(ArrayList<String> list){
		return list.toArray(new String[0]);
	}
	public static final String replace(String sIn, String RegExp, String sToReplace,
	  String sReplaceWith){
		return replace(sIn, Pattern.compile(RegExp), sToReplace, sReplaceWith);
	}
	/**
	 * Advanced replacement
	 * @param sIn
	 * @param pattern
	 * @param sToReplace
	 * @param sReplaceWith
	 * @return String
	 */
	public static final String replace(String sIn, Pattern pattern, String sToReplace,
	  String sReplaceWith){
		ArrayList<String> liOut=new ArrayList<>();
		Boolean startWithMatch;
		{
			int index=Index.indexOf(sIn, pattern);//First character
			if(index==-1)return sIn;
			if(index!=0){
				liOut.add(sIn.substring(0, index-1));
				sIn=sIn.substring(index);
				startWithMatch=false;
			}
			else startWithMatch=true;
			int endIndex=Index.endIndexOf(sIn, pattern);
			liOut.add(sIn.substring(0, endIndex));
			sIn=sIn.substring(endIndex+1);
		}
		while(true){
			int index=Index.indexOf(sIn, pattern);//First character
			if(index==-1)break;
			if(index!=0){
				liOut.add(sIn.substring(0, index-1));
				sIn=sIn.substring(index);
			}
			int endIndex=Index.endIndexOf(sIn, pattern);
			liOut.add(sIn.substring(0, endIndex));
			sIn=sIn.substring(endIndex+1);
		}
		Iterator<String> itr=liOut.iterator();
		if(!startWithMatch)itr.next();
		iterate(itr, sReplaceWith, sReplaceWith);
		while(itr.hasNext()){
			itr.next();
			if(itr.hasNext())iterate(itr, sToReplace, sReplaceWith);
		}
		itr.remove();
		return String.join("", liOut);
	}
	private static final void iterate(Iterator<String> itr, String sToReplace, String sReplaceWith){
		String item=itr.next();
		item=item.replaceAll(sToReplace, sReplaceWith);
	}
}
