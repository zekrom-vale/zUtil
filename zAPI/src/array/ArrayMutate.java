/**
 *
 */
package array;

import java.lang.reflect.Array;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import matrix.MatrixMutate;

/**
 * Converts arrays into different data-types<br>
 * This was modified from {@link MatrixMutate}
 *
 * @author Zekrom
 *
 */
public class ArrayMutate{
	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static byte[]
		toByte(final double[] array, final DoubleFunction<Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static <E> byte[]
		toByte(final E[] array, final Function<E, Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static byte[]
		toByte(final float[] array, final Function<Float, Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static byte[] toByte(final int[] array, final IntFunction<Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static byte[]
		toByte(final long[] array, final LongFunction<Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}


	/**
	 * Mutates a array to a new byte array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static byte[]
		toByte(final short[] array, final Function<Short, Byte> op){
		final byte[] mutated=new byte[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final byte[] array, final Function<Byte, E> op, final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final double[] array, final DoubleFunction<E> op,
		final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final float[] array, final Function<Float, E> op,
		final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final int[] array, final IntFunction<E> op, final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final long[] array, final LongFunction<E> op, final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] toE(
		final short[] array, final Function<Short, E> op,
		final Class<E[]> class1
	){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}


	/**
	 * Mutates a array to a new array of type E
	 *
	 * @param  array
	 *                    The array to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new array
	 * @return        A new mutated array
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> E[]
		toE(final T[] array, final Function<T, E> op, final Class<E[]> class1){
		final E[] mutated=(E[])Array.newInstance(class1, array.length);
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static float[]
		toFloat(final byte[] array, final Function<Byte, Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static float[]
		toFloat(final double[] array, final DoubleFunction<Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static <E> float[]
		toFloat(final E[] array, final Function<E, Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static float[]
		toFloat(final int[] array, final IntFunction<Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static float[]
		toFloat(final long[] array, final LongFunction<Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}


	/**
	 * Mutates a array to a new float array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static float[]
		toFloat(final short[] array, final Function<Short, Float> op){
		final float[] mutated=new float[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static int[] toInt(final byte[] array, final ToIntFunction<Byte> op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static int[]
		toInt(final double[] array, final DoubleToIntFunction op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static <E> int[] toInt(final E[] array, final ToIntFunction<E> op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static int[]
		toInt(final float[] array, final ToIntFunction<Float> op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static int[] toInt(final long[] array, final LongToIntFunction op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}


	/**
	 * Mutates a array to a new int array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static int[]
		toInt(final short[] array, final ToIntFunction<Short> op){
		final int[] mutated=new int[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsInt(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static long[]
		toLong(final byte[] array, final ToLongFunction<Byte> op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static long[]
		toLong(final double[] array, final DoubleToLongFunction op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static <E> long[]
		toLong(final E[] array, final ToLongFunction<E> op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static long[]
		toLong(final float[] array, final ToLongFunction<Float> op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static long[] toLong(final int[] array, final IntToLongFunction op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}


	/**
	 * Mutates a array to a new long array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static long[]
		toLong(final short[] array, final ToLongFunction<Short> op){
		final long[] mutated=new long[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.applyAsLong(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static short[]
		toShort(final byte[] array, final Function<Byte, Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static short[]
		toShort(final double[] array, final DoubleFunction<Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static <E> short[]
		toShort(final E[] array, final Function<E, Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static short[]
		toShort(final float[] array, final Function<Float, Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static short[]
		toShort(final int[] array, final IntFunction<Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}

	/**
	 * Mutates a array to a new short array
	 *
	 * @param  array
	 *                   The array to mutate
	 * @param  op
	 *                   The operation to perform
	 * @return       A new mutated array
	 */
	public static short[]
		toShort(final long[] array, final LongFunction<Short> op){
		final short[] mutated=new short[array.length];//Create a new array
		for(int i=0; i<array.length; i++){//Loop for each i
			mutated[i]=op.apply(array[i]);//Apply the given lambda
		}
		return mutated;
	}
}
