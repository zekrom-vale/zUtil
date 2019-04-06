package zUtil;

import java.util.ArrayList;

/**
 * @author Zekrom
 *
 */
public final class Arrays{
	/**
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",");
	 */
	public static <T> String join(final T[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();
		for(int i=0; i<arr.length-1; i++){
			builder.append(arr[i]);
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}
	public static<T> T[] toArray(Class<T> class1,ArrayList<T> list) {
		T[] arr=java.lang::Array.newIn;
		for(i=0; i<list.size(); i++) {
			
		}
	}

	/**
	 * Converts ArrayList&lt;Double&gt; to double[]
	 *
	 * @param  list The list to convert
	 * @return      array
	 */
	public static double[] toDouble(final ArrayList<Double> list){
		return list.stream().mapToDouble(i->i).toArray();
	}

	/**
	 * Converts ArrayList<Integer> to int[]
	 *
	 * @param  list
	 * @return      array
	 */
	public static int[] toInt(final ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}

	/**
	 * Converts ArrayList<Integer> to int[]
	 *
	 * @param  list
	 * @return      array
	 */
	public static int[] toIntager(final ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}

	/**
	 * Converts ArrayList<Long> to long[]
	 *
	 * @param  list
	 * @return      array
	 */
	public static long[] toLong(final ArrayList<Long> list){
		return list.stream().mapToLong(i->i).toArray();
	}

	/**
	 * Converts ArrayList<String> to String[]
	 *
	 * @param  list
	 * @return      array
	 */
	public static String[] toString(final ArrayList<String> list){
		return list.toArray(new String[0]);
	}

	private Arrays(){

	}
}
