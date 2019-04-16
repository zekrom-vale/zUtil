/**
 *
 */
package zUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.*;

/**
 * Utility functions regarding matrixes, two dimensional arrays.<br>
 * All methods create a new array instead of modifying the original<br>
 * <br>
 * Most genetic methods require a class argument. For example, <code>Object.class</code><br>
 * Generic methods accept arrays as arrays are Objects. For example, rotating an image:<br>
 * <code><pre>
 * final byte[][][] img=new byte[20][20][4];//Assume it is filled
 * Matrix.rotate(img, byte[].class);
 * </pre></code> Note, for matrixes of arrays you should use
 * {@link #toString(Object[][], BiConsumer, String, String)} instead of
 * {@link #toString(Object[][], String, String)} to override the default toString
 *
 * @author Zekrom
 */
public class Matrix{
	/**
	 * Condenses a matrix into an array
	 *
	 * @author Zekrom
	 *
	 */
	public static class condense{
		/**
		 * Condenses each row of a matrix into a single value
		 *
		 * @param  matrix
		 *                    The matrix to condense
		 * @param  op
		 *                    The function to reduce each row
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
		 *                    The function to reduce each row
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
		 *                    The function to reduce each row
		 * @param  class1
		 *                    The class of the object
		 * @return        A new array contain the condensed values
		 */
		public static <E> E[] horizontal(
			final E[][] matrix, final BinaryOperator<E> op,
			final Class<E> class1
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
		 *                    The function to reduce each row
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
		 *                    The function to reduce each row
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
		 *                    The function to reduce each row
		 * @return        A new array contain the condensed values
		 */
		public static String[] horizontal(
			final String[][] matrix, final BinaryOperator<String> op
		){
			return Matrix.condense.horizontal(matrix, op, String.class);
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
			final E[][] matrix, final BinaryOperator<E> op,
			final Class<E> class1
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
			return Matrix.condense.vertical(matrix, op, String.class);
		}

		private condense(){}
	}


	/**
	 * Adds a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static byte[][] add(final byte scalar, final byte[][] matrix){
		return Matrix.matrix(matrix, a->(byte)(scalar+a));
	}

	/**
	 * Adds a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static double[][] add(final double scalar, final double[][] matrix){
		return Matrix.matrix(matrix, a->scalar+a);
	}


	/**
	 * Adds two double matrixes together
	 *
	 * @param  A
	 *               The first matrix to add
	 * @param  B
	 *               The second matrix to add
	 * @return   A new double matrix of sums
	 */
	public static double[][] add(final double[][] A, final double[][] B){
		return Matrix.matrix(A, B, (a, b)->a+b, 0, 0);
	}

	/**
	 * Adds a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static int[][] add(final int scalar, final int[][] matrix){
		return Matrix.matrix(matrix, a->scalar+a);
	}

	/**
	 * Adds two int matrixes together
	 *
	 * @param  A
	 *               The first matrix to add
	 * @param  B
	 *               The second matrix to add
	 * @return   A new double matrix of sums
	 */
	public static int[][] add(final int[][] A, final int[][] B){
		return Matrix.matrix(A, B, (a, b)->a+b, 0, 0);
	}

	/**
	 * Adds a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static long[][] add(final long scalar, final long[][] matrix){
		return Matrix.matrix(matrix, a->scalar+a);
	}

	/**
	 * Concatenates two String matrixes together
	 *
	 * @param  A
	 *               The first matrix to add
	 * @param  B
	 *               The second matrix to add
	 * @return   A new double matrix of sums
	 */
	public static String[][] add(final String[][] A, final String[][] B){
		return Matrix.matrix(A, B, (a, b)->a+b, "", "", String.class);
	}

	/**
	 * Divides the values of each cell
	 *
	 * @param  A
	 *               The matrix to divide
	 * @param  B
	 *               The matrix to divide A by
	 * @return   A new divided matrix
	 */
	public static double[][] divide(final byte[][] A, final byte[][] B){
		return Matrix.matrixDouble(
			A, B, (a, b)->a/((double)b), (byte)1, (byte)1
		);
	}

	/**
	 * Divides the values of each cell
	 *
	 * @param  A
	 *               The matrix to divide
	 * @param  B
	 *               The matrix to divide A by
	 * @return   A new divided matrix
	 */
	public static double[][] divide(final double[][] A, final double[][] B){
		return Matrix.matrix(A, B, (a, b)->a/b, 1D, 1D);
	}

	/**
	 * Divides the values of each cell
	 *
	 * @param  A
	 *               The matrix to divide
	 * @param  B
	 *               The matrix to divide A by
	 * @return   A new divided matrix
	 */
	public static double[][] divide(final int[][] A, final int[][] B){
		return Matrix.matrixDouble(A, B, (a, b)->a/((double)b), 1, 1);
	}

	/**
	 * Divides the values of each cell
	 *
	 * @param  A
	 *               The matrix to divide
	 * @param  B
	 *               The matrix to divide A by
	 * @return   A new divided matrix
	 */
	public static double[][] divide(final long[][] A, final long[][] B){
		return Matrix.matrixDouble(A, B, (a, b)->a/((double)b), 1L, 1L);
	}

	/**
	 * Performs the dot operator on two matrixes<br>
	 * The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
	 *
	 * @param  A
	 *               The first matrix to multiply
	 * @param  B
	 *               The second matrix to multiply
	 * @return   The dot product of AxB as a new matrix
	 * @see      <a href="https://www.mathsisfun.com/algebra/matrix-multiplying.html">How to Multiply
	 *           Matrices</a>
	 */
	public static double[][] dotProduct(final double[][] A, final double[][] B){
		final double[][] C=new double[A.length][B[0].length];
		for(int row=0; row<C.length; row++){
			for(int col=0; col<C[row].length; col++){
				C[row][col]=0;
				for(int i=0; i<B.length; i++){
					C[row][col]+=A[row][i]*B[i][col];
				}

			}
		}
		return C;
	}

	/**
	 * Performs the dot operator on two matrixes<br>
	 * The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
	 *
	 * @param  A
	 *               The first matrix to multiply
	 * @param  B
	 *               The second matrix to multiply
	 * @return   The dot product of AxB as a new matrix
	 * @see      <a href="https://www.mathsisfun.com/algebra/matrix-multiplying.html">How to Multiply
	 *           Matrices</a>
	 */
	public static int[][] dotProduct(final int[][] A, final int[][] B){
		final int[][] C=new int[A.length][B[0].length];
		for(int row=0; row<C.length; row++){
			for(int col=0; col<C[row].length; col++){
				C[row][col]=0;
				for(int i=0; i<B.length; i++){
					C[row][col]+=A[row][i]*B[i][col];
				}

			}
		}
		return C;
	}


	/**
	 * Performs the dot operator on two matrixes<br>
	 * The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
	 *
	 * @param  A
	 *               The first matrix to multiply
	 * @param  B
	 *               The second matrix to multiply
	 * @return   The dot product of AxB as a new matrix
	 * @see      <a href="https://www.mathsisfun.com/algebra/matrix-multiplying.html">How to Multiply
	 *           Matrices</a>
	 */
	public static long[][] dotProduct(final long[][] A, final long[][] B){
		final long[][] C=new long[A.length][B[0].length];
		for(int row=0; row<C.length; row++){
			for(int col=0; col<C[row].length; col++){
				C[row][col]=0;
				for(int i=0; i<B.length; i++){
					C[row][col]+=A[row][i]*B[i][col];
				}

			}
		}
		return C;
	}

	/**
	 * Tests if two matrixes are equal
	 *
	 * @param  obj1
	 *                  The first object to test
	 * @param  obj2
	 *                  The second object to test
	 * @return      A boolean indicating if they are equal
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static <E, T> boolean equals(final E[][] obj1, final T[][] obj2){
		if(obj1.getClass().equals(obj2.getClass())||obj1.length!=obj2.length){
			return false;
		}
		for(int row=0; row<obj1.length; row++){
			if(obj1[row].length!=obj2[row].length) return false;
			for(int col=0; col<obj1[row].length; col++){
				if(obj1[row][col].equals(obj2[row][col])) return false;
			}
		}

		return true;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix
	 */
	public static byte[][] flipHorizontal(final byte[][] matrix){
		final byte[][] flipped=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[row]=new byte[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				flipped[col][matrix.length-col-1]=matrix[row][col];
			}
		}
		return flipped;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix
	 */
	public static double[][] flipHorizontal(final double[][] matrix){
		final double[][] flipped=new double[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[row]=new double[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				flipped[col][matrix.length-col-1]=matrix[row][col];
			}
		}
		return flipped;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @param  class1
	 *                    The class of the matrix
	 * @return        The flipped matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][]
		flipHorizontal(final E[][] matrix, final Class<E> class1){
		final E[][] flipped=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			flipped[row]=(E[])Array.newInstance(class1, matrix[row].length);
			for(int col=0; col<matrix[row].length; col++){
				flipped[col][matrix.length-col-1]=matrix[row][col];
			}
		}
		return flipped;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix
	 */
	public static int[][] flipHorizontal(final int[][] matrix){
		final int[][] flipped=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[row]=new int[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				flipped[col][matrix.length-col-1]=matrix[row][col];
			}
		}
		return flipped;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix
	 */
	public static long[][] flipHorizontal(final long[][] matrix){
		final long[][] flipped=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[row]=new long[matrix[row].length];
			for(int col=0; col<matrix[row].length; col++){
				flipped[col][matrix.length-col-1]=matrix[row][col];
			}
		}
		return flipped;
	}

	/**
	 * Flips an array horizontally
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix
	 */
	public static String[][] flipHorizontal(final String[][] matrix){
		return Matrix.flipHorizontal(matrix, String.class);
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static byte[][] flipVertical(final byte[][] matrix){
		final byte[][] flipped=new byte[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[matrix.length-row-1]=matrix[row];
		}
		return flipped;
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static double[][] flipVertical(final double[][] matrix){
		final double[][] flipped=new double[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[matrix.length-row-1]=matrix[row];
		}
		return flipped;
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @param  class1
	 *                    The class of the matrix
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static <E> E[][]
		flipVertical(final E[][] matrix, final Class<E> class1){
		@SuppressWarnings("unchecked")
		final E[][] flipped=(E[][])Array.newInstance(class1, matrix.length);
		for(int row=0; row<matrix.length; row++){
			flipped[matrix.length-row-1]=matrix[row];
		}
		return flipped;
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static int[][] flipVertical(final int[][] matrix){
		final int[][] flipped=new int[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[matrix.length-row-1]=matrix[row];
		}
		return flipped;
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static long[][] flipVertical(final long[][] matrix){
		final long[][] flipped=new long[matrix.length][];
		for(int row=0; row<matrix.length; row++){
			flipped[matrix.length-row-1]=matrix[row];
		}
		return flipped;
	}

	/**
	 * Flips an array vertically
	 *
	 * @param  matrix
	 *                    The matrix to flip
	 * @return        The flipped matrix (Does not create new row arrays)
	 */
	public static String[][] flipVertical(final String[][] matrix){
		return Matrix.flipHorizontal(matrix, String.class);
	}

	public static void main(final String[] args){
		final byte[][][] img=new byte[4][4][4];
		for(int row=0; row<img.length; row++){
			for(int col=0; col<img[row].length; col++){
				for(int i=0; i<img[row][col].length; i++){
					img[row][col][i]=(byte)(Math.random()*255-128);
				}
			}
		}

		System.out.println(Matrix.toString(img, (b, c)->{
			for(int i=0; i<c.length; i++){
				b.append(
					String.format("%2s", Integer.toHexString(c[i]+128)).replace(" ", "0")
				);
			}
		}, "\t", "\n"));

		System.out.println("-".repeat(60));

		System.out.println(
			Matrix.toString(Matrix.rotate(img, byte[].class), (b, c)->{
				for(int i=0; i<c.length; i++){
					b.append(
						String.format("%2s", Integer.toHexString(c[i]+128)).replace(" ", "0")
					);
				}
			}, "\t", "\n")
		);
	}

	/**
	 * Performs an operation on a matrix and returns a byte matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static byte[][] matrix(
		final byte[][] A, final byte[][] B, final BinaryOperator<Byte> op,
		final byte onNA_A, final byte onNA_B
	){
		byte[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new byte[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new byte[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.apply(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new byte[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new byte[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a byte matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static byte[][]
		matrix(final byte[][] A, final UnaryOperator<Byte> op){
		final byte[][] B=new byte[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new byte[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.apply(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static double[][] matrix(
		final double[][] A, final double[][] B, final DoubleBinaryOperator op,
		final double onNA_A, final double onNA_B
	){
		double[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new double[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			//Get values not in B
			for(int row=B.length; row<A.length; row++){
				C[row]=new double[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
				}
			}
			return C;
		}
		//If B is the long matrix
		C=new double[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		//Get values not in A
		for(int row=A.length; row<B.length; row++){
			C[row]=new double[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a-></code>a or method
	 * @return    The modified matrix
	 */
	public static double[][]
		matrix(final double[][] A, final DoubleUnaryOperator op){
		final double[][] B=new double[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsDouble(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a matrix of type class1
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @param  class1
	 *                    The class of the matrixes
	 * @return        The condensed matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E, T> T[][] matrix(
		final E[][] A, final E[][] B, final BiFunction<E, E, T> op,
		final E onNA_A, final E onNA_B, final Class<T> class1
	){
		T[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=(T[][])Array.newInstance(class1, A.length);
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=(T[])Array.newInstance(class1, A[row].length);
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.apply(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=(T[][])Array.newInstance(class1, B.length);
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=(T[])Array.newInstance(class1, B[row].length);
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns a matrix of type class1
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @param  class1
	 *                    The class of the matrixes
	 * @return        The condensed matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] matrix(
		final E[][] A, final E[][] B, final BinaryOperator<E> op,
		final E onNA_A, final E onNA_B, final Class<E> class1
	){
		E[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=(E[][])Array.newInstance(class1, A.length);
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=(E[])Array.newInstance(class1, A[row].length);
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.apply(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=(E[][])Array.newInstance(class1, B.length);
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=(E[])Array.newInstance(class1, B[row].length);
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns a matrix of class1
	 *
	 * @param  A
	 *                    The matrix to modify
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @param  class1
	 *                    The class of the matrix
	 * @return        The modified matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][]
		matrix(final E[][] A, final UnaryOperator<E> op, final Class<E> class1){
		final E[][] B=(E[][])Array.newInstance(class1, A.length);
		for(int row=0; row<A.length; row++){
			B[row]=(E[])Array.newInstance(class1, A[row].length);
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.apply(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static int[][] matrix(
		final int[][] A, final int[][] B, final IntBinaryOperator op,
		final int onNA_A, final int onNA_B
	){
		int[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new int[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new int[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsInt(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new int[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new int[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static int[][] matrix(final int[][] A, final IntUnaryOperator op){
		final int[][] B=new int[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsInt(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static long[][] matrix(
		final long[][] A, final long[][] B, final LongBinaryOperator op,
		final long onNA_A, final long onNA_B
	){
		long[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new long[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new long[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsLong(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new long[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new long[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static long[][] matrix(final long[][] A, final LongUnaryOperator op){
		final long[][] B=new long[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsLong(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a byte matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static byte[][] matrixByte(
		final int[][] A, final int[][] B,
		final BiFunction<Integer, Integer, Byte> op, final int onNA_A,
		final int onNA_B
	){
		byte[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new byte[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new byte[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.apply(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new byte[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new byte[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a byte matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static byte[][]
		matrixByte(final int[][] A, final IntFunction<Byte> op){
		final byte[][] B=new byte[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new byte[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.apply(A[row][col]);
			}
		}
		return B;
	}


	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static double[][] matrixDouble(
		final byte[][] A, final byte[][] B,
		final ToDoubleBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		double[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new double[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new double[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new double[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new double[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static double[][]
		matrixDouble(final byte[][] A, final ToDoubleFunction<Byte> op){
		final double[][] B=new double[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsDouble(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static double[][] matrixDouble(
		final int[][] A, final int[][] B,
		final ToDoubleBiFunction<Integer, Integer> op, final int onNA_A,
		final int onNA_B
	){
		double[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new double[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new double[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new double[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new double[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static double[][]
		matrixDouble(final int[][] A, final IntToDoubleFunction op){
		final double[][] B=new double[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsDouble(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static double[][] matrixDouble(
		final long[][] A, final long[][] B,
		final ToDoubleBiFunction<Long, Long> op, final long onNA_A,
		final long onNA_B
	){
		double[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new double[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new double[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new double[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new double[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns a double matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static double[][]
		matrixDouble(final long[][] A, final LongToDoubleFunction op){
		final double[][] B=new double[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsDouble(A[row][col]);
			}
		}
		return B;
	}

	private static void matrixInner(
		final byte[][] A, final byte[][] B, final byte[][] C, final int row,
		final BinaryOperator<Byte> op, final byte onNA_A, final byte onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new byte[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new byte[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final byte[][] A, final byte[][] B, final double[][] C, final int row,
		final ToDoubleBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
	}


	private static void matrixInner(
		final byte[][] A, final byte[][] B, final int[][] C, final int row,
		final ToIntBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final byte[][] A, final byte[][] B, final long[][] C, final int row,
		final ToLongBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final double[][] A, final double[][] B, final double[][] C,
		final int row, final DoubleBinaryOperator op, final double onNA_A,
		final double onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final double[][] A, final double[][] B, final int[][] C, final int row,
		final ToIntBiFunction<Double, Double> op, final double onNA_A,
		final double onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final double[][] A, final double[][] B, final long[][] C, final int row,
		final ToLongBiFunction<Double, Double> op, final double onNA_A,
		final double onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static <E> void matrixInner(
		final E[][] A, final E[][] B, final E[][] C, final int row,
		final BinaryOperator<E> op, final E onNA_A, final E onNA_B,
		final Class<E> class1
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=(E[])Array.newInstance(class1, A[row].length);
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=(E[])Array.newInstance(class1, A[row].length);
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static <E, T> void matrixInner(
		final E[][] A, final E[][] B, final T[][] C, final int row,
		final BiFunction<E, E, T> op, final E onNA_A, final E onNA_B,
		final Class<T> class1
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=(T[])Array.newInstance(class1, A[row].length);
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], onNA_B);
			}
			return;
		}//If B is the long row
		C[row]=(T[])Array.newInstance(class1, A[row].length);
		for(int col=0; col<A[row].length; col++){
			C[row][col]=op.apply(A[row][col], B[row][col]);
		}
		//Rest of the cols not in A
		for(int col=A[row].length; col<B[row].length; col++){
			C[row][col]=op.apply(onNA_A, B[row][col]);
		}
	}

	private static void matrixInner(
		final int[][] A, final int[][] B, final byte[][] C, final int row,
		final BiFunction<Integer, Integer, Byte> op, final int onNA_A,
		final int onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new byte[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new byte[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.apply(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.apply(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final int[][] A, final int[][] B, final double[][] C, final int row,
		final ToDoubleBiFunction<Integer, Integer> op, final int onNA_A,
		final int onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final int[][] A, final int[][] B, final int[][] C, final int row,
		final IntBinaryOperator op, final int onNA_A, final int onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final int[][] A, final int[][] B, final long[][] C, final int row,
		final ToLongBiFunction<Integer, Integer> op, final int onNA_A,
		final int onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final long[][] A, final long[][] B, final double[][] C, final int row,
		final ToDoubleBiFunction<Long, Long> op, final long onNA_A,
		final long onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new double[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsDouble(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsDouble(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final long[][] A, final long[][] B, final int[][] C, final int row,
		final ToIntBiFunction<Long, Long> op, final long onNA_A,
		final long onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsInt(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
	}

	private static void matrixInner(
		final long[][] A, final long[][] B, final long[][] C, final int row,
		final LongBinaryOperator op, final long onNA_A, final long onNA_B
	){
		if(A[row].length>=B[row].length){//If A is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in B
			for(int col=B[row].length; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], onNA_B);
			}
		}
		else{//If B is the long row
			C[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				C[row][col]=op.applyAsLong(A[row][col], B[row][col]);
			}
			//Rest of the cols not in A
			for(int col=A[row].length; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
	}


	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static int[][] matrixInt(
		final byte[][] A, final byte[][] B,
		final ToIntBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		int[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new int[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new int[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsInt(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new int[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new int[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static int[][] matrixInt(
		final double[][] A, final double[][] B,
		final ToIntBiFunction<Double, Double> op, final double onNA_A,
		final double onNA_B
	){
		int[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new int[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			//Get values not in B
			for(int row=B.length; row<A.length; row++){
				C[row]=new int[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsInt(A[row][col], onNA_B);
				}
			}
			return C;
		}
		//If B is the long matrix
		C=new int[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		//Get values not in A
		for(int row=A.length; row<B.length; row++){
			C[row]=new int[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a-></code>a or method
	 * @return    The modified matrix
	 */
	public static int[][]
		matrixInt(final double[][] A, final DoubleToIntFunction op){
		final int[][] B=new int[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsInt(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static int[][] matrixInt(
		final long[][] A, final long[][] B,
		final ToIntBiFunction<Long, Long> op, final long onNA_A,
		final long onNA_B
	){
		int[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new int[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new int[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsInt(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new int[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new int[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsInt(onNA_A, B[row][col]);
			}
		}
		return C;
	}

	/**
	 * Performs an operation on a matrix and returns an int matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static int[][]
		matrixInt(final long[][] A, final LongToIntFunction op){
		final int[][] B=new int[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new int[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsInt(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static long[][] matrixLong(
		final byte[][] A, final byte[][] B,
		final ToLongBiFunction<Byte, Byte> op, final byte onNA_A,
		final byte onNA_B
	){
		long[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new long[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new long[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsLong(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new long[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new long[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static long[][] matrixLong(
		final double[][] A, final double[][] B,
		final ToLongBiFunction<Double, Double> op, final double onNA_A,
		final double onNA_B
	){
		long[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new long[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			//Get values not in B
			for(int row=B.length; row<A.length; row++){
				C[row]=new long[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsLong(A[row][col], onNA_B);
				}
			}
			return C;
		}
		//If B is the long matrix
		C=new long[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		//Get values not in A
		for(int row=A.length; row<B.length; row++){
			C[row]=new long[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a-></code>a or method
	 * @return    The modified matrix
	 */
	public static long[][]
		matrixLong(final double[][] A, final DoubleToLongFunction op){
		final long[][] B=new long[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsLong(A[row][col]);
			}
		}
		return B;
	}


	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                    The first matrix to use
	 * @param  B
	 *                    The second matrix to use
	 * @param  op
	 *                    The UnaryOperator to perform as a lambda <code>(a,b)->a+b</code> or method
	 * @param  onNA_A
	 *                    The value to use when A[row][col] is missing
	 * @param  onNA_B
	 *                    The value to use when B[row][col] is missing
	 * @return        The condensed matrix
	 */
	public static long[][] matrixLong(
		final int[][] A, final int[][] B,
		final ToLongBiFunction<Integer, Integer> op, final int onNA_A,
		final int onNA_B
	){
		long[][] C;
		if(A.length>=B.length){//If A is the long matrix
			C=new long[A.length][];
			for(int row=0; row<B.length; row++){
				Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
			}
			for(int row=B.length; row<A.length; row++){
				C[row]=new long[A[row].length];
				for(int col=0; col<A[row].length; col++){
					C[row][col]=op.applyAsLong(A[row][col], onNA_B);
				}
			}
			return C;
		}
		C=new long[B.length][];
		for(int row=0; row<A.length; row++){
			Matrix.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
		}
		for(int row=A.length; row<B.length; row++){
			C[row]=new long[B[row].length];
			for(int col=0; col<B[row].length; col++){
				C[row][col]=op.applyAsLong(onNA_A, B[row][col]);
			}
		}
		return C;
	}


	/**
	 * Performs an operation on a matrix and returns a long matrix
	 *
	 * @param  A
	 *                The matrix to modify
	 * @param  op
	 *                The UnaryOperator to perform as a lambda <code>a->a</code> or method
	 * @return    The modified matrix
	 */
	public static long[][]
		matrixLong(final int[][] A, final IntToLongFunction op){
		final long[][] B=new long[A.length][];
		for(int row=0; row<A.length; row++){
			B[row]=new long[A[row].length];
			for(int col=0; col<A[row].length; col++){
				B[row][col]=op.applyAsLong(A[row][col]);
			}
		}
		return B;
	}

	/**
	 * Multiples a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static byte[][] multiply(final byte scalar, final byte[][] matrix){
		return Matrix.matrix(matrix, a->(byte)(scalar*a));
	}

	/**
	 * Multiples a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static double[][]
		multiply(final double scalar, final double[][] matrix){
		return Matrix.matrix(matrix, a->scalar*a);
	}


	/**
	 * Multiplies the values of two double matrixes together
	 *
	 * @param  A
	 *               The first matrix to multiply
	 * @param  B
	 *               The second matrix to multiply
	 * @return   A new double matrix of products
	 */
	public static double[][] multiply(final double[][] A, final double[][] B){
		return Matrix.matrix(A, B, (a, b)->a*b, 1, 1);
	}

	/**
	 * Multiplies the values of two int matrixes together
	 *
	 * @param  A
	 *               The first matrix to multiply
	 * @param  B
	 *               The second matrix to multiply
	 * @return   A new double matrix of products
	 */
	public static int[][] multiply(final int[][] A, final int[][] B){
		return Matrix.matrix(A, B, (a, b)->a*b, 1, 1);
	}

	/**
	 * Multiples a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static long[][] multiply(final long scalar, final long[][] matrix){
		return Matrix.matrix(matrix, a->scalar*a);
	}

	/**
	 * Multiples a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static int[][] multipply(final int scalar, final int[][] matrix){
		return Matrix.matrix(matrix, a->scalar*a);
	}

	/**
	 * Negates the values of a double matrix
	 *
	 * @param  A
	 *               The matrix to negate
	 * @return   A new negated matrix
	 */
	public static double[][] negate(final double[][] A){
		return Matrix.matrix(A, a->-a);
	}

	/**
	 * Negates the values of an int matrix
	 *
	 * @param  A
	 *               The matrix to negate
	 * @return   A new negated matrix
	 */
	public static int[][] negate(final int[][] A){
		return Matrix.matrix(A, a->-a);
	}


	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @param  op
	 *                      The function to convert a sting into the object
	 * @return          A String matrix
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[][] read(
		final Scanner in, final String colDelim, final Function<String, E> op
	){
		final ArrayList<E[]> rows=new ArrayList<>();
		while(in.hasNext()){
			final ArrayList<E> cells=new ArrayList<>();
			final Scanner rowScan=new Scanner(in.next());
			rowScan.useDelimiter(colDelim);
			while(rowScan.hasNext()){
				cells.add(op.apply(rowScan.next()));
			}
			rows.add((E[])rows.toArray());
			rowScan.close();
		}
		return (E[][])rows.toArray();
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @param  op
	 *                                   The function to convert a sting into the object
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	@SuppressWarnings("resource")
	public static <E> E[][] read(
		final String in, final String rowDelim, final String colDelim,
		final Function<String, E> op
	) throws FileNotFoundException{
		final Scanner inScanner=new Scanner(new FileReader(in));
		inScanner.useDelimiter(rowDelim);
		final E[][] matrix=Matrix.read(inScanner, colDelim, op);
		inScanner.close();
		return matrix;
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @return          A String matrix
	 */
	public static byte[][] readByte(final Scanner in, final String colDelim){
		final ArrayList<byte[]> rows=new ArrayList<>();
		while(in.hasNext()){
			final ArrayList<Byte> cells=new ArrayList<>();
			final Scanner rowScan=new Scanner(in.next());
			rowScan.useDelimiter(colDelim);
			while(rowScan.hasNextInt()){
				cells.add((byte)rowScan.nextInt());
			}
			final byte[] items=new byte[cells.size()];
			for(int i=0; i<items.length; i++){
				items[i]=cells.get(i);
			}
			rows.add(items);
			rowScan.close();
		}
		return (byte[][])rows.toArray();
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	@SuppressWarnings("resource")
	public static byte[][] readByte(
		final String in, final String rowDelim, final String colDelim
	) throws FileNotFoundException{
		final Scanner inScanner=new Scanner(new FileReader(in));
		inScanner.useDelimiter(rowDelim);
		final byte[][] matrix=Matrix.readByte(inScanner, colDelim);
		inScanner.close();
		return matrix;
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @return          A String matrix
	 */
	public static double[][]
		readDouble(final Scanner in, final String colDelim){
		final ArrayList<double[]> rows=new ArrayList<>();
		while(in.hasNext()){
			final ArrayList<Double> cells=new ArrayList<>();
			final Scanner rowScan=new Scanner(in.next());
			rowScan.useDelimiter(colDelim);
			while(rowScan.hasNextDouble()){
				cells.add(rowScan.nextDouble());
			}
			final double[] items=new double[cells.size()];
			for(int i=0; i<items.length; i++){
				items[i]=cells.get(i);
			}
			rows.add(items);
			rowScan.close();
		}
		return (double[][])rows.toArray();
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	@SuppressWarnings("resource")
	public static double[][] readDouble(
		final String in, final String rowDelim, final String colDelim
	) throws FileNotFoundException{
		final Scanner inScanner=new Scanner(new FileReader(in));
		inScanner.useDelimiter(rowDelim);
		final double[][] matrix=Matrix.readDouble(inScanner, colDelim);
		inScanner.close();
		return matrix;
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @return          A String matrix
	 */
	public static int[][] readInt(final Scanner in, final String colDelim){
		final ArrayList<int[]> rows=new ArrayList<>();
		while(in.hasNext()){
			final ArrayList<Integer> cells=new ArrayList<>();
			final Scanner rowScan=new Scanner(in.next());
			rowScan.useDelimiter(colDelim);
			while(rowScan.hasNextInt()){
				cells.add(rowScan.nextInt());
			}
			final int[] items=new int[cells.size()];
			for(int i=0; i<items.length; i++){
				items[i]=cells.get(i);
			}
			rows.add(items);
			rowScan.close();
		}
		return (int[][])rows.toArray();
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	@SuppressWarnings("resource")
	public static int[][] readInt(
		final String in, final String rowDelim, final String colDelim
	) throws FileNotFoundException{
		final Scanner inScanner=new Scanner(new FileReader(in));
		inScanner.useDelimiter(rowDelim);
		final int[][] matrix=Matrix.readInt(inScanner, colDelim);
		inScanner.close();
		return matrix;
	}


	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @return          A String matrix
	 */
	public static long[][] readLong(final Scanner in, final String colDelim){
		final ArrayList<long[]> rows=new ArrayList<>();
		while(in.hasNext()){
			final ArrayList<Long> cells=new ArrayList<>();
			final Scanner rowScan=new Scanner(in.next());
			rowScan.useDelimiter(colDelim);
			while(rowScan.hasNextLong()){
				cells.add(rowScan.nextLong());
			}
			final long[] items=new long[cells.size()];
			for(int i=0; i<items.length; i++){
				items[i]=cells.get(i);
			}
			rows.add(items);
			rowScan.close();
		}
		return (long[][])rows.toArray();
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	@SuppressWarnings("resource")
	public static long[][] readLong(
		final String in, final String rowDelim, final String colDelim
	) throws FileNotFoundException{
		final Scanner inScanner=new Scanner(new FileReader(in));
		inScanner.useDelimiter(rowDelim);
		final long[][] matrix=Matrix.readLong(inScanner, colDelim);
		inScanner.close();
		return matrix;
	}

	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                      The scanner to read the matrix from
	 * @param  colDelim
	 *                      The delimiter of the column
	 * @return          A String matrix
	 */
	public static String[][]
		readString(final Scanner in, final String colDelim){
		return Matrix.read(in, colDelim, a->a);
	}


	/**
	 * Reads a scanner to create a matrix
	 *
	 * @param  in
	 *                                   The file to read the matrix from
	 * @param  rowDelim
	 *                                   The delimiter of the row
	 * @param  colDelim
	 *                                   The delimiter of the column
	 * @return                       A Object matrix matrix
	 * @throws FileNotFoundException
	 *                                   The file might not exist
	 */
	public static String[][] readString(
		final String in, final String rowDelim, final String colDelim
	) throws FileNotFoundException{
		return Matrix.read(in, rowDelim, colDelim, a->a);
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static byte[][] rotate(final byte[][] matrix){
		final byte[][] rotated=new byte[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[matrix.length-row-1][col];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static double[][] rotate(final double[][] matrix){
		final double[][] rotated=new double[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[matrix.length-row-1][col];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @param  class1
	 *                    The class of the matrix
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static <E> E[][] rotate(final E[][] matrix, final Class<E> class1){
		@SuppressWarnings("unchecked")
		final E[][] rotated=(E[][])Array.newInstance(
			class1, matrix[0].length, matrix.length
		);
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[matrix.length-row-1][col];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static int[][] rotate(final int[][] matrix){
		final int[][] rotated=new int[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[matrix.length-row-1][col];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static long[][] rotate(final long[][] matrix){
		final long[][] rotated=new long[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[matrix.length-row-1][col];
			}
		}
		return rotated;
	}


	/**
	 * @param  matrix
	 *                    The matrix to rotate
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    Z ! A a 1
	 *  a b c d e    Y @ B b 2
	 *  A B C D E -> X # C c 3
	 *  ! @ # $ %    W $ D d 4
	 *  Z Y X W V    V % E e 5
	 * </pre>
	 * </code>
	 *
	 */
	public static String[][] rotate(final String[][] matrix){
		return Matrix.rotate(matrix, String.class);
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static byte[][] rotateLeft(final byte[][] matrix){
		final byte[][] rotated=new byte[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[row][matrix[0].length-col-1];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static double[][] rotateLeft(final double[][] matrix){
		final double[][] rotated=new double[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[row][matrix[0].length-col-1];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @param  class1
	 *                    The class of the matrix
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static <E> E[][]
		rotateLeft(final E[][] matrix, final Class<E> class1){
		@SuppressWarnings("unchecked")
		final E[][] rotated=(E[][])Array.newInstance(
			class1, matrix[0].length, matrix.length
		);
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[row][matrix[0].length-col-1];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static int[][] rotateLeft(final int[][] matrix){
		final int[][] rotated=new int[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[row][matrix[0].length-col-1];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static long[][] rotateLeft(final long[][] matrix){
		final long[][] rotated=new long[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				rotated[col][row]=matrix[row][matrix[0].length-col-1];
			}
		}
		return rotated;
	}

	/**
	 * @param  matrix
	 *                    The matrix to rotate left
	 * @return        A new rotated matrix <code>
	 * <pre>
	 *  1 2 3 4 5    5 e E % V
	 *  a b c d e    4 d D S W
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    2 b B @ Y
	 *  Z Y X W V    1 a A ! Z
	 * </pre>
	 * </code>
	 *
	 */
	public static String[][] rotateLeft(final String[][] matrix){
		return Matrix.rotateLeft(matrix, String.class);
	}

	/**
	 * Subtracts int matrixes
	 *
	 * @param  A
	 *               The original matrix to modify with A
	 * @param  B
	 *               The matrix to subtract from A
	 * @return   A new double matrix of differences
	 */
	public static double[][] subtract(final double[][] A, final double[][] B){
		return Matrix.matrix(A, B, (a, b)->a-b, 0, 0);
	}

	/**
	 * Subtracts double matrixes
	 *
	 * @param  A
	 *               The original matrix to modify with A
	 * @param  B
	 *               The matrix to subtract from A
	 * @return   A new double matrix of differences
	 */
	public static int[][] subtract(final int[][] A, final int[][] B){
		return Matrix.matrix(A, B, (a, b)->a-b, 0, 0);
	}


	/**
	 * Converts a matrix of any type to a string
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @return          The string representation of the matrix
	 */
	public static String toString(
		final double[][] matrix, final String colDelim, final String rowDelim
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				builder.append(matrix[row][col]).append(colDelim);
			}
			builder.append(matrix[row][_col]);
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			builder.append(matrix[_row][col]).append(colDelim);
		}
		return builder.toString();
	}


	/**
	 * Converts a matrix of any type to a string, using a custom toString function in <code>op</code>
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  op
	 *                      The custom function (Consumer) to convert the object into a string<br>
	 *
	 *                      <pre>
	 *                      <code>(builder, cell)->builder.append(cell)</code>
	 *
	 *                      <pre>
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @return          The string representation of the matrix
	 */
	public static <E> String toString(
		final E[][] matrix, final BiConsumer<StringBuilder, E> op,
		final String colDelim, final String rowDelim
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				op.accept(builder, matrix[row][col]);
				builder.append(colDelim);
			}
			op.accept(builder, matrix[row][_col]);
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			op.accept(builder, matrix[_row][col]);
			builder.append(colDelim);
		}
		return builder.toString();
	}

	/**
	 * Converts a matrix of any type to a string
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @return          The string representation of the matrix
	 */
	public static <E> String toString(
		final E[][] matrix, final String colDelim, final String rowDelim
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				builder.append(matrix[row][col].toString()).append(colDelim);
			}
			builder.append(matrix[row][_col].toString());
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			builder.append(matrix[_row][col].toString()).append(colDelim);
		}
		return builder.toString();
	}

	/**
	 * Converts a matrix of any type to a string
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @param  format
	 *                      The string to format the cell, use <code>%s</code>
	 * @return          The string representation of the matrix
	 */
	public static <E> String toString(
		final E[][] matrix, final String colDelim, final String rowDelim,
		final String format
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				builder.append(
					String.format(format, matrix[row][col].toString())
				).append(colDelim);
			}
			builder.append(String.format(format, matrix[row][_col].toString()));
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			builder.append(
				String.format(format, matrix[_row][col].toString())
			).append(colDelim);
		}
		return builder.toString();
	}

	/**
	 * Converts a matrix of any type to a string
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @return          The string representation of the matrix
	 */
	public static String toString(
		final int[][] matrix, final String colDelim, final String rowDelim
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				builder.append(matrix[row][col]).append(colDelim);
			}
			builder.append(matrix[row][_col]);
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			builder.append(matrix[_row][col]).append(colDelim);
		}
		return builder.toString();
	}

	/**
	 * Converts a matrix of any type to a string
	 *
	 * @param  matrix
	 *                      The matrix to convert to a string
	 * @param  colDelim
	 *                      The column delimiter to use
	 * @param  rowDelim
	 *                      The row delimiter to use
	 * @return          The string representation of the matrix
	 */
	public static String toString(
		final long[][] matrix, final String colDelim, final String rowDelim
	){
		final StringBuilder builder=new StringBuilder(
			matrix.length*matrix[0].length*4
		);
		final int _row=matrix.length-1;
		for(int row=0; row<_row; row++){
			final int _col=matrix[row].length-1;
			for(int col=0; col<_col; col++){
				builder.append(matrix[row][col]).append(colDelim);
			}
			builder.append(matrix[row][_col]);
			builder.append(rowDelim);
		}
		for(int col=0; col<matrix[_row].length; col++){
			builder.append(matrix[_row][col]).append(colDelim);
		}
		return builder.toString();
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @return        A new transposed matrix
	 */
	public static byte[][] transpose(final byte[][] matrix){
		final byte[][] transposed=new byte[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				transposed[col][row]=matrix[row][col];
			}
		}
		return transposed;
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @return        A new transposed matrix
	 */
	public static double[][] transpose(final double[][] matrix){
		final double[][] transposed=new double[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				transposed[col][row]=matrix[row][col];
			}
		}
		return transposed;
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @param  class1
	 *                    The type of matrix
	 * @return        A new transposed matrix
	 */
	public static <E> E[][]
		transpose(final E[][] matrix, final Class<E> class1){
		@SuppressWarnings("unchecked")
		final E[][] transposed=(E[][])Array.newInstance(
			class1, matrix[0].length, matrix.length
		);
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				transposed[col][row]=matrix[row][col];
			}
		}
		return transposed;
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @return        A new transposed matrix
	 */
	public static int[][] transpose(final int[][] matrix){
		final int[][] transposed=new int[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				transposed[col][row]=matrix[row][col];
			}
		}
		return transposed;
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @return        A new transposed matrix
	 */
	public static long[][] transpose(final long[][] matrix){
		final long[][] transposed=new long[matrix[0].length][matrix.length];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				transposed[col][row]=matrix[row][col];
			}
		}
		return transposed;
	}

	/**
	 * Transposes a matrix<br>
	 * This swaps the rows and columns, this is not the same as rotate.<br>
	 * <code>
	 * <pre>
	 *  1 2 3 4 5    1 a A ! Z
	 *  a b c d e    2 b B @ Y
	 *  A B C D E -> 3 c C # X
	 *  ! @ # $ %    4 d D $ W
	 *  Z Y X W V    5 e E % V
	 * </pre>
	 * </code>
	 *
	 * @param  matrix
	 *                    The matrix to transpose
	 * @return        A new transposed matrix
	 */
	public static String[][] transpose(final String[][] matrix){
		return Matrix.transpose(matrix, String.class);
	}

	private Matrix(){}
}
