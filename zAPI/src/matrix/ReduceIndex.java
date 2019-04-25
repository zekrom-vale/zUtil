package matrix;

import array.ArrayUtil;
import functions.BiIndex;

/**
 * Condenses a matrix into an array of indexes, see {@link Reduce} for normal reduction
 *
 * @author Zekrom
 *
 */
public class ReduceIndex{
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
	public static int[]
		horizontal(final byte[][] matrix, final BiIndex.Int<Byte> op){
		final int[] condensed=new int[matrix.length];//Create a new array
		for(int row=0; row<matrix.length; row++){//For each row
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduceIdex(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)//Apply the given lambda
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
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static int[]
		horizontal(final double[][] matrix, final BiIndex.Int<Double> op){
		final int[] condensed=new int[matrix.length];//Create a new array
		for(int row=0; row<matrix.length; row++){//For each row
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduceIdex(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)//Apply the given lambda
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
	 *                    The function to reduce each row as <code>(collector, value, index)</code>
	 * @param  class1
	 *                    The class of the object
	 * @return        A new array contain the condensed values
	 */
	public static <E> int[] horizontal(
		final E[][] matrix, final BiIndex.Int<E> op, final Class<E> class1
	){
		final int[] condensed=new int[matrix.length];//Create a new array
		for(int row=0; row<matrix.length; row++){//For each row
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduceIdex(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)//Apply the given lambda
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
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static int[]
		horizontal(final int[][] matrix, final BiIndex.Int<Integer> op){
		final int[] condensed=new int[matrix.length];//Create a new array
		for(int row=0; row<matrix.length; row++){//For each row
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduceIdex(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)//Apply the given lambda
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
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static int[]
		horizontal(final long[][] matrix, final BiIndex.Int<Long> op){
		final int[] condensed=new int[matrix.length];//Create a new array
		for(int row=0; row<matrix.length; row++){//For each row
			final int rowNow=row;//Lambdas can't have changing values
			condensed[row]=ArrayUtil.reduceIdex(
				matrix[row], (a, c, col)->op.apply(a, c, rowNow, col)//Apply the given lambda
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
	 *                    The function to reduce each row as
	 *                    <code>(collector, value, rowIndex, colIndex)</code>
	 * @return        A new array contain the condensed values
	 */
	public static int[]
		horizontal(final String[][] matrix, final BiIndex.Int<String> op){
		return ReduceIndex.horizontal(matrix, op, String.class);
	}

	private ReduceIndex(){}
}