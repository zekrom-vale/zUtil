package zUtil;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongBinaryOperator;

import functions.IndexDoubleFunction;
import functions.IndexEFunction;
import functions.IndexFunction;

/**
 * @author Zekrom
 *
 */
public final class ArrayUtil{
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
	public static long reduce(final byte[] array, final IndexFunction<Byte> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i], i);
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
	public static long reduce(final byte[] array, final LongBinaryOperator op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.applyAsLong(collector, array[i]);
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
		double collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.applyAsDouble(collector, array[i]);
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
		reduce(final double[] array, final IndexDoubleFunction<Double> op){
		double collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i], i);
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
		E collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i]);
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
	public static <E> E reduce(final E[] array, final IndexEFunction<E> op){
		E collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i], i);
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
	public static long
		reduce(final int[] array, final IndexFunction<Integer> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i], i);
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
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.applyAsLong(collector, array[i]);
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
	public static long reduce(final long[] array, final IndexFunction<Long> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.apply(collector, array[i], i);
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
		long collector=array[0];
		for(int i=1; i<array.length; i++){
			collector=op.applyAsLong(collector, array[i]);
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

	@SuppressWarnings("javadoc")
	protected ArrayUtil(){}
}
