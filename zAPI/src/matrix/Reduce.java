package matrix;

import java.lang.reflect.Array;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongBinaryOperator;

import array.ArrayUtil;
import functions.BiIndex;

/**
 * Condenses a matrix into an array of values, use {@link ReduceIndex} for collecting indexes
 *
 * @author Zekrom
 *
 */
public class Reduce{
	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final byte[][] matrix, final BiIndex.Long<Byte> op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduce(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)
			);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final byte[][] matrix, final LongBinaryOperator op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			condensed[row]=ArrayUtil.reduce(matrix[row], op);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static double[]
		horizontal(final double[][] matrix, final BiIndex.Double<Double> op){
		final double[] condensed=new double[matrix.length];
		for(int row=0; row<matrix.length; row++){
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduce(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)
			);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @return        A new array contain the condensed values
	 */
	public static double[]
		horizontal(final double[][] matrix, final DoubleBinaryOperator op){
		final double[] condensed=new double[matrix.length];
		for(int row=0; row<matrix.length; row++){
			condensed[row]=ArrayUtil.reduce(matrix[row], op);
		}
		return condensed;
	}


	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value, index)</code>
	 * @param  class1
	 *                    The class of the object
	 * @return        A new array contain the condensed values
	 */
	public static <E> E[] horizontal(
		final E[][] matrix, final BiIndex.E<E> op, final Class<E> class1
	){
		@SuppressWarnings("unchecked")
		final E[] condensed=(E[])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduce(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)
			);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @param  class1
	 *                    The class of the object
	 * @return        A new array contain the condensed values
	 */
	public static <E> E[] horizontal(
		final E[][] matrix, final BinaryOperator<E> op, final Class<E> class1
	){
		@SuppressWarnings("unchecked")
		final E[] condensed=(E[])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			condensed[row]=ArrayUtil.reduce(matrix[row], op);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final int[][] matrix, final BiIndex.Long<Integer> op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduce(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)
			);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final int[][] matrix, final LongBinaryOperator op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			condensed[row]=ArrayUtil.reduce(matrix[row], op);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final long[][] matrix, final BiIndex.Long<Long> op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduce(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)
			);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		horizontal(final long[][] matrix, final LongBinaryOperator op){
		final long[] condensed=new long[matrix.length];
		for(int row=0; row<matrix.length; row++){
			condensed[row]=ArrayUtil.reduce(matrix[row], op);
		}
		return condensed;
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static String[]
		horizontal(final String[][] matrix, final BiIndex.E<String> op){
		return Reduce.horizontal(matrix, op, String.class);
	}

	/**
	 * Condenses each row of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row as <code>(collector, value)</code>
	 * @return        A new array contain the condensed values
	 */
	public static String[]
		horizontal(final String[][] matrix, final BinaryOperator<String> op){
		return Reduce.horizontal(matrix, op, String.class);
	}


	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		vertical(final byte[][] matrix, final LongBinaryOperator op){
		int _length=0;
		for(int row=0; row<matrix.length; row++){
			_length=Math.max(_length, matrix[row].length);
		}
		final long[] condensed=new long[_length];
		final boolean[] flags=new boolean[_length];
		for(int col=0; col<_length; col++){
			for(int row=0; row<matrix.length; row++){
				if(col<matrix[row].length){
					if(!flags[col]) condensed[col]=matrix[row][col];
					else condensed[col]=op.applyAsLong(
						condensed[col], matrix[row][col]
					);
					flags[col]=true;
				}
			}
		}
		return condensed;
	}

	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @return        A new array contain the condensed values
	 */
	public static double[]
		vertical(final double[][] matrix, final DoubleBinaryOperator op){
		int _length=0;
		for(int row=0; row<matrix.length; row++){
			_length=Math.max(_length, matrix[row].length);
		}
		final double[] condensed=new double[_length];
		final boolean[] flags=new boolean[_length];
		for(int col=0; col<_length; col++){
			for(int row=0; row<matrix.length; row++){
				if(col<matrix[row].length){
					if(!flags[col]) condensed[col]=matrix[row][col];
					else condensed[col]=op.applyAsDouble(
						condensed[col], matrix[row][col]
					);
					flags[col]=true;
				}
			}
		}
		return condensed;
	}

	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @param  class1
	 *                    The type of the matrix
	 * @return        A new array contain the condensed values
	 */
	public static <E> E[] vertical(
		final E[][] matrix, final BinaryOperator<E> op, final Class<E> class1
	){
		int _length=0;
		for(int row=0; row<matrix.length; row++){
			_length=Math.max(_length, matrix[row].length);
		}
		@SuppressWarnings("unchecked")
		final E[] condensed=(E[])Array.newInstance(class1, _length);
		final boolean[] flags=new boolean[_length];
		for(int col=0; col<_length; col++){
			for(int row=0; row<matrix.length; row++){
				if(col<matrix[row].length){
					if(!flags[col]) condensed[col]=matrix[row][col];
					else condensed[col]=op.apply(
						condensed[col], matrix[row][col]
					);
					flags[col]=true;
				}
			}
		}
		return condensed;
	}


	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		vertical(final int[][] matrix, final LongBinaryOperator op){
		int _length=0;
		for(int row=0; row<matrix.length; row++){
			_length=Math.max(_length, matrix[row].length);
		}
		final long[] condensed=new long[_length];
		final boolean[] flags=new boolean[_length];
		for(int col=0; col<_length; col++){
			for(int row=0; row<matrix.length; row++){
				if(col<matrix[row].length){
					if(!flags[col]) condensed[col]=matrix[row][col];
					else condensed[col]=op.applyAsLong(
						condensed[col], matrix[row][col]
					);
					flags[col]=true;
				}
			}
		}
		return condensed;
	}


	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @return        A new array contain the condensed values
	 */
	public static long[]
		vertical(final long[][] matrix, final LongBinaryOperator op){
		int _length=0;
		for(int row=0; row<matrix.length; row++){
			_length=Math.max(_length, matrix[row].length);
		}
		final long[] condensed=new long[_length];
		final boolean[] flags=new boolean[_length];
		for(int col=0; col<_length; col++){
			for(int row=0; row<matrix.length; row++){
				if(col<matrix[row].length){
					if(!flags[col]) condensed[col]=matrix[row][col];
					else condensed[col]=op.applyAsLong(
						condensed[col], matrix[row][col]
					);
					flags[col]=true;
				}
			}
		}
		return condensed;
	}

	/**
	 * Condenses each column of a matrix into a single value
	 *
	 * @param  matrix
	 *                    The matrix to condense
	 * @param  op
	 *                    The function to reduce each row
	 * @return        A new array contain the condensed values
	 */
	public static String[]
		vertical(final String[][] matrix, final BinaryOperator<String> op){
		return Reduce.vertical(matrix, op, String.class);
	}

	private Reduce(){}
}