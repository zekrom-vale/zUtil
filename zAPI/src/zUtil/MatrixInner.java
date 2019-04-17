package zUtil;

import java.lang.reflect.Array;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;


class MatrixInner{

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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
	static <E> void matrixInner(
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
	static <E, T> void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	static void matrixInner(
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

	protected MatrixInner(){}
}