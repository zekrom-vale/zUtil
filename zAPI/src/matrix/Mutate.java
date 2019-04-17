package matrix;

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

/**
 * @author Zekrom
 *
 */
public class Mutate{

	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static byte[][]
		toByte(final double[][] matrix, final DoubleFunction<Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static <E> byte[][]
		toByte(final E[][] matrix, final Function<E, Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static byte[][]
		toByte(final float[][] matrix, final Function<Float, Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static byte[][]
		toByte(final int[][] matrix, final IntFunction<Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static byte[][]
		toByte(final long[][] matrix, final LongFunction<Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}


	/**
	 * Mutates a matrix to a new byte matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static byte[][]
		toByte(final short[][] matrix, final Function<Short, Byte> op){
		final byte[][] mutated=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final byte[][] matrix, final Function<Byte, E> op,
		final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final double[][] matrix, final DoubleFunction<E> op,
		final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final float[][] matrix, final Function<Float, E> op,
		final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final int[][] matrix, final IntFunction<E> op, final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final long[][] matrix, final LongFunction<E> op, final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] toE(
		final short[][] matrix, final Function<Short, E> op,
		final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}


	/**
	 * Mutates a matrix to a new matrix of type E
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @param  class1
	 *                    The class of the new matrix
	 * @return        A new mutated matrix
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> E[][] toE(
		final T[][] matrix, final Function<T, E> op, final Class<E[]> class1
	){
		final E[][] mutated=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			mutated[row]=(E[])Array.newInstance(
				class1.getComponentType(), matrix[row].length
			);
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static float[][]
		toFloat(final byte[][] matrix, final Function<Byte, Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static float[][]
		toFloat(final double[][] matrix, final DoubleFunction<Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static <E> float[][]
		toFloat(final E[][] matrix, final Function<E, Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static float[][]
		toFloat(final int[][] matrix, final IntFunction<Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static float[][]
		toFloat(final long[][] matrix, final LongFunction<Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}


	/**
	 * Mutates a matrix to a new float matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static float[][]
		toFloat(final short[][] matrix, final Function<Short, Float> op){
		final float[][] mutated=new float[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new float[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static int[][]
		toInt(final byte[][] matrix, final ToIntFunction<Byte> op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static int[][]
		toInt(final double[][] matrix, final DoubleToIntFunction op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static <E> int[][]
		toInt(final E[][] matrix, final ToIntFunction<E> op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static int[][]
		toInt(final float[][] matrix, final ToIntFunction<Float> op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static int[][]
		toInt(final long[][] matrix, final LongToIntFunction op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}


	/**
	 * Mutates a matrix to a new int matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static int[][]
		toInt(final short[][] matrix, final ToIntFunction<Short> op){
		final int[][] mutated=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsInt(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static long[][]
		toLong(final byte[][] matrix, final ToLongFunction<Byte> op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static long[][]
		toLong(final double[][] matrix, final DoubleToLongFunction op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static <E> long[][]
		toLong(final E[][] matrix, final ToLongFunction<E> op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static long[][]
		toLong(final float[][] matrix, final ToLongFunction<Float> op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static long[][]
		toLong(final int[][] matrix, final IntToLongFunction op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}


	/**
	 * Mutates a matrix to a new long matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static long[][]
		toLong(final short[][] matrix, final ToLongFunction<Short> op){
		final long[][] mutated=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.applyAsLong(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static short[][]
		toShort(final byte[][] matrix, final Function<Byte, Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static short[][]
		toShort(final double[][] matrix, final DoubleFunction<Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static <E> short[][]
		toShort(final E[][] matrix, final Function<E, Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static short[][]
		toShort(final float[][] matrix, final Function<Float, Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static short[][]
		toShort(final int[][] matrix, final IntFunction<Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}

	/**
	 * Mutates a matrix to a new short matrix
	 *
	 * @param  matrix
	 *                    The matrix to mutate
	 * @param  op
	 *                    The operation to perform
	 * @return        A new mutated matrix
	 */
	public static short[][]
		toShort(final long[][] matrix, final LongFunction<Short> op){
		final short[][] mutated=new short[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			mutated[row]=new short[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				mutated[row][col]=op.apply(matrix[row][col]);
			}
		}
		return mutated;
	}
}
