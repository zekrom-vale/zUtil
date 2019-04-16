package zUtil;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * @author Zekrom
 *
 */
public final class ArrayUtil{
	/**
	 * Converts ArrayLists into arrays
	 *
	 * @author Zekrom
	 *
	 */
	public static class to{
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


	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static byte average(final byte[] array){
		return (byte)(ArrayUtil.reduce(array, (a, c)->a+c)/(byte)array.length);
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static double average(final double[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c)/array.length;
	}


	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static int average(final int[] array){
		return (int)(ArrayUtil.reduce(array, (a, c)->a+c)/array.length);
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long average(final long[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c)/array.length;
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",");
	 */
	public static String join(final byte[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();
		for(int i=0; i<arr.length-1; i++){
			builder.append(arr[i]);
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",");
	 */
	public static String join(final double[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();
		for(int i=0; i<arr.length-1; i++){
			builder.append(arr[i]);
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",");
	 */
	public static String join(final int[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();
		for(int i=0; i<arr.length-1; i++){
			builder.append(arr[i]);
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",");
	 */
	public static String join(final long[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();
		for(int i=0; i<arr.length-1; i++){
			builder.append(arr[i]);
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
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
			builder.append(arr[i].toString());
			builder.append(delimiter);
		}
		return builder.append(arr[arr.length-1]).toString();
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static byte max(final byte[] array){
		return (byte)ArrayUtil.reduce(array, (a, c)->Math.max(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static double max(final double[] array){
		return ArrayUtil.reduce(array, (a, c)->Math.max(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static int max(final int[] array){
		return (int)ArrayUtil.reduce(array, (a, c)->Math.max(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long max(final long[] array){
		return ArrayUtil.reduce(array, (a, c)->Math.max(a, c));
	}


	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static byte min(final byte[] array){
		return (byte)ArrayUtil.reduce(array, (a, c)->Math.min(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static double min(final double[] array){
		return ArrayUtil.reduce(array, (a, c)->Math.min(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static int min(final int[] array){
		return (int)ArrayUtil.reduce(array, (a, c)->Math.min(a, c));
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long min(final long[] array){
		return ArrayUtil.reduce(array, (a, c)->Math.min(a, c));
	}


	/**
	 * Reduces an array into one value
	 *
	 * @param  array
	 *                   The array to reduce
	 * @param  op
	 *                   The operation to perform as <code>(collector, element)-></code>
	 * @return       The collected value
	 */
	public static long reduce(final byte[] array, final LongBinaryOperator op){
		final long collector=array[0];
		for(int i=1; i<array.length; i++){
			op.applyAsLong(collector, array[i]);
		}
		return collector;
	}

	/**
	 * Reduces an array into one value
	 *
	 * @param  array
	 *                   The array to reduce
	 * @param  op
	 *                   The operation to perform as <code>(collector, element)-></code>
	 * @return       The collected value
	 */
	public static double
		reduce(final double[] array, final DoubleBinaryOperator op){
		final double collector=array[0];
		for(int i=1; i<array.length; i++){
			op.applyAsDouble(collector, array[i]);
		}
		return collector;
	}

	/**
	 * Reduces an array into one value
	 *
	 * @param  array
	 *                   The array to reduce
	 * @param  op
	 *                   The operation to perform as <code>(collector, element)-></code>
	 * @return       The collected value
	 */
	public static <E> E reduce(final E[] array, final BinaryOperator<E> op){
		final E collector=array[0];
		for(int i=1; i<array.length; i++){
			op.apply(collector, array[i]);
		}
		return collector;
	}

	/**
	 * Reduces an array into one value
	 *
	 * @param  array
	 *                   The array to reduce
	 * @param  op
	 *                   The operation to perform as <code>(collector, element)-></code>
	 * @return       The collected value
	 */
	public static long reduce(final int[] array, final LongBinaryOperator op){
		final long collector=array[0];
		for(int i=1; i<array.length; i++){
			op.applyAsLong(collector, array[i]);
		}
		return collector;
	}

	/**
	 * Reduces an array into one value
	 *
	 * @param  array
	 *                   The array to reduce
	 * @param  op
	 *                   The operation to perform as <code>(collector, element)-></code>
	 * @return       The collected value
	 */
	public static long reduce(final long[] array, final LongBinaryOperator op){
		final long collector=array[0];
		for(int i=1; i<array.length; i++){
			op.applyAsLong(collector, array[i]);
		}
		return collector;
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long sum(final byte[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c);
	}

	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static double sum(final double[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c);
	}


	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long sum(final int[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c);
	}


	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static long sum(final long[] array){
		return ArrayUtil.reduce(array, (a, c)->a+c);
	}

	private ArrayUtil(){}
}
