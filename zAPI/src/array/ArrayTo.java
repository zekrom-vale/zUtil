package array;

import java.util.ArrayList;

/**
 * Converts ArrayLists into arrays
 *
 * @author Zekrom
 *
 */
public class ArrayTo{
	/**
	 * Converts ArrayList&lt;Double&gt; to double[]
	 *
	 * @param  list
	 *                  The list to convert
	 * @return      array
	 */
	public static double[] Double(final ArrayList<Double> list){
		return list.stream().mapToDouble(i->i).toArray();
	}

	/**
	 * Converts ArrayList<Integer> to int[]
	 *
	 * @param  list
	 *                  The list to convert
	 * @return      array
	 */
	public static int[] Int(final ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}

	/**
	 * Converts ArrayList<Integer> to int[]
	 *
	 * @param  list
	 *                  The list to convert
	 * @return      array
	 */
	public static int[] Intager(final ArrayList<Integer> list){
		return list.stream().mapToInt(i->i).toArray();
	}


	/**
	 * Converts ArrayList<Long> to long[]
	 *
	 * @param  list
	 *                  The list to convert
	 * @return      array
	 */
	public static long[] Long(final ArrayList<Long> list){
		return list.stream().mapToLong(i->i).toArray();
	}


	/**
	 * Converts ArrayList<String> to String[]
	 *
	 * @param  list
	 *                  The list to convert
	 * @return      array
	 */
	public static String[] String(final ArrayList<String> list){
		return list.toArray(new String[0]);
	}
}