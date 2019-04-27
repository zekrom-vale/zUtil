package array;

import java.util.Formatter;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;

import functions.Index;

/**
 * A utility containing various array methods.
 *
 * @author Zekrom
 *
 */
public final class ArrayUtil{//Don't name a class Array, it masks java.lang.reflect.Array
	/**
	 * Returns the max value of an array
	 *
	 * @param  array
	 *                   The array to get the max value
	 * @return       Max value
	 */
	public static byte average(final byte[] array){
		return (byte)(ArrayUtil.reduce(array, (a, c)->a+c)/array.length);
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
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 *
	 */
	public static String join(final byte[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(arr[i]);//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(arr[arr.length-1]).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @param  op
	 *                       The function to convert the element to a String
	 * @return           A String of the entries
	 *
	 */
	public static String join(
		final byte[] arr, final String delimiter,
		final Function<Byte, String> op
	){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(op.apply(arr[i]));//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(op.apply(arr[arr.length-1])).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 *
	 */
	public static String join(final double[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(arr[i]);//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(arr[arr.length-1]).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 * @param  op
	 *                       The function to convert the element to a String
	 *
	 */
	public static String join(
		final double[] arr, final String delimiter,
		final DoubleFunction<String> op
	){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(op.apply(arr[i]));//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(op.apply(arr[arr.length-1])).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param   arr
	 *                        The array to join
	 * @param   delimiter
	 *                        The spacer to place between the values
	 * @param   length
	 *                        How many decimals to keep
	 * @return            A String of the entries
	 * @example           Array.join(new Integer[]{1, 2, 3, 4, 5}, ",", 2);
	 */
	public static String
		join(final double[] arr, final String delimiter, final int length){
		final Formatter formatter=new Formatter();//Create a new Formatter to collect formated strings
		final String format="%."+length+"f";
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			formatter.format(format, arr[i]);//Append the element
			formatter.format(delimiter);//Append the delimiter
		}
		final String string=formatter.format(
			format, arr[arr.length-1]
		).toString();
		formatter.close();
		return string;//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 *
	 */
	public static String join(final int[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(arr[i]);//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(arr[arr.length-1]).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @param  op
	 *                       The function to convert the element to a String
	 * @return           A String of the entries
	 *
	 */
	public static String join(
		final int[] arr, final String delimiter, final IntFunction<String> op
	){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(op.apply(arr[i]));//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(op.apply(arr[arr.length-1])).toString();//Append the last element then return the builder string
	}


	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 *
	 */
	public static String join(final long[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(arr[i]);//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(arr[arr.length-1]).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @param  op
	 *                       The function to convert the element to a String
	 * @return           A String of the entries
	 *
	 */
	public static String join(
		final long[] arr, final String delimiter, final LongFunction<String> op
	){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(op.apply(arr[i]));//Append the element
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(op.apply(arr[arr.length-1])).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @return           A String of the entries
	 *
	 */
	public static <T> String join(final T[] arr, final String delimiter){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(arr[i].toString());//Append the element as a string
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(arr[arr.length-1].toString()).toString();//Append the last element then return the builder string
	}

	/**
	 * Joins an array together with the defined delimiter
	 *
	 * @param  arr
	 *                       The array to join
	 * @param  delimiter
	 *                       The spacer to place between the values
	 * @param  op
	 *                       Operation to perform when converting to a String
	 * @return           A String of the entries
	 *
	 */
	public static <T> String join(
		final T[] arr, final String delimiter, final Function<T, String> op
	){
		final StringBuilder builder=new StringBuilder();//Create a new StringBuilder to collect strings
		for(int i=0; i<arr.length-1; i++){//Loop for each element in the array except the last one
			builder.append(op.apply(arr[i]));//Append the element as a string
			builder.append(delimiter);//Append the delimiter
		}
		return builder.append(op.apply(arr[arr.length-1])).toString();//Append the last element then return the builder string
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
	public static long reduce(final byte[] array, final Index.Long<Byte> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
		for(int i=1; i<array.length; i++){//Loop for each element in the array
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
		for(int i=1; i<array.length; i++){//Loop for each element in the array
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
		reduce(final double[] array, final Index.Double<Double> op){
		double collector=array[0];
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
		for(int i=1; i<array.length; i++){//Loop for each element in the array
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
	public static <E> E reduce(final E[] array, final Index.E<E> op){
		E collector=array[0];
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
	public static long reduce(final int[] array, final Index.Long<Integer> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
		for(int i=1; i<array.length; i++){//Loop for each element in the array
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
	public static long reduce(final long[] array, final Index.Long<Long> op){
		long collector=array[0];
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
		for(int i=1; i<array.length; i++){//Loop for each element in the array
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
	public static int reduceIdex(final byte[] array, final Index.Int<Byte> op){
		int collector=0;
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
	public static int
		reduceIdex(final double[] array, final Index.Int<Double> op){
		int collector=0;
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
	public static <E> int reduceIdex(final E[] array, final Index.Int<E> op){
		int collector=0;
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
	public static int
		reduceIdex(final int[] array, final Index.Int<Integer> op){
		int collector=0;
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
	public static int reduceIdex(final long[] array, final Index.Int<Long> op){
		int collector=0;
		for(int i=1; i<array.length; i++){//Loop for each element in the array
			collector=op.apply(collector, array[i], i);//Apply the given lambda
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
