package matrix;

import java.lang.reflect.Array;
import java.util.function.*;


/**
 * Provides core implementation to {@link Matrix}
 *
 * @author Zekrom
 *
 */
public class Core extends Inner{
	/**
	 * Performs an operation on a matrix and returns a new byte matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new byte matrix
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
	 * Performs an operation on a matrix and returns a new double matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new double matrix
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
	 * Performs an operation on a matrix and returns a new matrix of type class1
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
				Inner.matrixInner(
					A, B, C, row, op, onNA_A, onNA_B, class1
				);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
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
	 * Performs an operation on a matrix and returns a new matrix of type class1
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
				Inner.matrixInner(
					A, B, C, row, op, onNA_A, onNA_B, class1
				);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B, class1);
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
	 * Performs an operation on a matrix and returns a new matrix of class1
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new int matrix
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
	 * Performs an operation on a matrix and returns a new long matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new long matrix
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
	 * Performs an operation on a matrix and returns a new byte matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new byte matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new double matrix
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
	 * Performs an operation on a matrix and returns a new double matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new double matrix
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
	 * Performs an operation on a matrix and returns a new double matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
	 * Performs an operation on a matrix and returns a new double matrix
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
				Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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
			Inner.matrixInner(A, B, C, row, op, onNA_A, onNA_B);
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

	@SuppressWarnings("javadoc")
	protected Core(){}

}