/**
 *
 */
package zUtil;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zekrom
 *
 */
class MatrixTest{


	protected static final class dot{

		/**
		 * An example matrix for matrix multiplication<br>
		 * The amount sold of each item per day
		 */
		protected static final int[][] dot={{83, 63, 37, 75}};
		/**
		 * An example matrix for matrix multiplication<br>
		 * The amount sold of each item per day
		 */
		protected static final int[][] pies={{13, 9, 7, 15}, {8, 7, 4, 6},
			{6, 4, 0, 3}};
		/**
		 * An example matrix for matrix multiplication<br>
		 * The prices of the items
		 */
		protected static final int[][] price={{3, 4, 2}};
	}

	protected static final class negate{
		protected static final int[][] intMatrix=new int[][]{{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};

		protected static final int[][] intNeg=new int[][]{{-1, -2, -3, -4, -5},
			{-6, -7, -8, -9, -10}, {-11, -12, -13, -14, -15},
			{-16, -17, -18, -19, -20}};
	}

	protected static final class rotate{
		/**
		 * An example matrix for rotation
		 */
		protected static final int[][] intMatrix=new int[][]{{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};

		/**
		 * An example matrix for rotation
		 */
		protected static final int[][] intRotated=new int[][]{{16, 11, 6, 1},
			{17, 12, 7, 2}, {18, 13, 8, 3}, {19, 14, 9, 4}, {20, 15, 10, 5}};

		/**
		 * An example string matrix
		 */
		protected static final String[][] stringMatrix=new String[][]{
			{"1", "2", "3", "4", "5"}, {"A", "B", "C", "D", "E"},
			{"a", "b", "c", "d", "e"}};
	}


	/**
	 * Test method for {@link zUtil.Matrix#add(byte, byte[][])}.
	 */
	@Test
	final void testAddByteByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(double[][], double[][])}.
	 */
	@Test
	final void testAddDoubleArrayArrayDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(double, double[][])}.
	 */
	@Test
	final void testAddDoubleDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(int[][], int[][])}.
	 */
	@Test
	final void testAddIntArrayArrayIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(int, int[][])}.
	 */
	@Test
	final void testAddIntIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(long, long[][])}.
	 */
	@Test
	final void testAddLongLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#add(java.lang.String[][], java.lang.String[][])}.
	 */
	@Test
	final void testAddStringArrayArrayStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#divide(byte[][], byte[][])}.
	 */
	@Test
	final void testDivideByteArrayArrayByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#divide(double[][], double[][])}.
	 */
	@Test
	final void testDivideDoubleArrayArrayDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#divide(int[][], int[][])}.
	 */
	@Test
	final void testDivideIntArrayArrayIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#divide(long[][], long[][])}.
	 */
	@Test
	final void testDivideLongArrayArrayLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#dotProduct(double[][], double[][])}.
	 */
	@Test
	final void testDotProductDoubleArrayArrayDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#dotProduct(int[][], int[][])}.
	 */
	@Test
	final void testDotProductIntArrayArrayIntArrayArray(){
		final int[][] result=Matrix.dotProduct(
			MatrixTest.dot.price, MatrixTest.dot.pies
		);
		for(int i=0; i<result.length; i++){
			Assert.assertArrayEquals(dot.dot[i], result[i]);
		}
	}

	/**
	 * Test method for {@link zUtil.Matrix#dotProduct(long[][], long[][])}.
	 */
	@Test
	final void testDotProductLongArrayArrayLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(byte[][])}.
	 */
	@Test
	final void testFlipHorizontalByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(double[][])}.
	 */
	@Test
	final void testFlipHorizontalDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(E[][], java.lang.Class)}.
	 */
	@Test
	final void testFlipHorizontalEArrayArrayClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(int[][])}.
	 */
	@Test
	final void testFlipHorizontalIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(long[][])}.
	 */
	@Test
	final void testFlipHorizontalLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipHorizontal(java.lang.String[][])}.
	 */
	@Test
	final void testFlipHorizontalStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(byte[][])}.
	 */
	@Test
	final void testFlipVerticalByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(double[][])}.
	 */
	@Test
	final void testFlipVerticalDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(E[][], java.lang.Class)}.
	 */
	@Test
	final void testFlipVerticalEArrayArrayClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(int[][])}.
	 */
	@Test
	final void testFlipVerticalIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(long[][])}.
	 */
	@Test
	final void testFlipVerticalLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#flipVertical(java.lang.String[][])}.
	 */
	@Test
	final void testFlipVerticalStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#main(java.lang.String[])}.
	 */
	@Test
	final void testMain(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(byte[][], byte[][], java.util.function.BinaryOperator, byte, byte)}.
	 */
	@Test
	final void
		testMatrixByteArrayArrayByteArrayArrayBinaryOperatorOfByteByteByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrix(byte[][], java.util.function.UnaryOperator)}.
	 */
	@Test
	final void testMatrixByteArrayArrayUnaryOperatorOfByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixByte(int[][], int[][], java.util.function.BiFunction, int, int)}.
	 */
	@Test
	final void
		testMatrixByteIntArrayArrayIntArrayArrayBiFunctionOfIntegerIntegerByteIntInt(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrixByte(int[][], java.util.function.IntFunction)}.
	 */
	@Test
	final void testMatrixByteIntArrayArrayIntFunctionOfByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(double[][], double[][], java.util.function.DoubleBinaryOperator, double, double)}.
	 */
	@Test
	final void
		testMatrixDoubleArrayArrayDoubleArrayArrayDoubleBinaryOperatorDoubleDouble(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrix(double[][], java.util.function.DoubleUnaryOperator)}.
	 */
	@Test
	final void testMatrixDoubleArrayArrayDoubleUnaryOperator(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixDouble(byte[][], byte[][], java.util.function.ToDoubleBiFunction, byte, byte)}.
	 */
	@Test
	final void
		testMatrixDoubleByteArrayArrayByteArrayArrayToDoubleBiFunctionOfByteByteByteByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrixDouble(byte[][], java.util.function.ToDoubleFunction)}.
	 */
	@Test
	final void testMatrixDoubleByteArrayArrayToDoubleFunctionOfByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixDouble(int[][], int[][], java.util.function.ToDoubleBiFunction, int, int)}.
	 */
	@Test
	final void
		testMatrixDoubleIntArrayArrayIntArrayArrayToDoubleBiFunctionOfIntegerIntegerIntInt(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixDouble(int[][], java.util.function.IntToDoubleFunction)}.
	 */
	@Test
	final void testMatrixDoubleIntArrayArrayIntToDoubleFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixDouble(long[][], long[][], java.util.function.ToDoubleBiFunction, long, long)}.
	 */
	@Test
	final void
		testMatrixDoubleLongArrayArrayLongArrayArrayToDoubleBiFunctionOfLongLongLongLong(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixDouble(long[][], java.util.function.LongToDoubleFunction)}.
	 */
	@Test
	final void testMatrixDoubleLongArrayArrayLongToDoubleFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(E[][], E[][], java.util.function.BiFunction, java.lang.Object, java.lang.Object, java.lang.Class)}.
	 */
	@Test
	final void testMatrixEArrayArrayEArrayArrayBiFunctionOfEETEEClassOfT(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(E[][], E[][], java.util.function.BinaryOperator, java.lang.Object, java.lang.Object, java.lang.Class)}.
	 */
	@Test
	final void testMatrixEArrayArrayEArrayArrayBinaryOperatorOfEEEClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(E[][], java.util.function.UnaryOperator, java.lang.Class)}.
	 */
	@Test
	final void testMatrixEArrayArrayUnaryOperatorOfEClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(int[][], int[][], java.util.function.IntBinaryOperator, int, int)}.
	 */
	@Test
	final void testMatrixIntArrayArrayIntArrayArrayIntBinaryOperatorIntInt(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrix(int[][], java.util.function.IntUnaryOperator)}.
	 */
	@Test
	final void testMatrixIntArrayArrayIntUnaryOperator(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixInt(byte[][], byte[][], java.util.function.ToIntBiFunction, byte, byte)}.
	 */
	@Test
	final void
		testMatrixIntByteArrayArrayByteArrayArrayToIntBiFunctionOfByteByteByteByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixInt(double[][], double[][], java.util.function.ToIntBiFunction, double, double)}.
	 */
	@Test
	final void
		testMatrixIntDoubleArrayArrayDoubleArrayArrayToIntBiFunctionOfDoubleDoubleDoubleDouble(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixInt(double[][], java.util.function.DoubleToIntFunction)}.
	 */
	@Test
	final void testMatrixIntDoubleArrayArrayDoubleToIntFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixInt(long[][], long[][], java.util.function.ToIntBiFunction, long, long)}.
	 */
	@Test
	final void
		testMatrixIntLongArrayArrayLongArrayArrayToIntBiFunctionOfLongLongLongLong(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrixInt(long[][], java.util.function.LongToIntFunction)}.
	 */
	@Test
	final void testMatrixIntLongArrayArrayLongToIntFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrix(long[][], long[][], java.util.function.LongBinaryOperator, long, long)}.
	 */
	@Test
	final void
		testMatrixLongArrayArrayLongArrayArrayLongBinaryOperatorLongLong(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrix(long[][], java.util.function.LongUnaryOperator)}.
	 */
	@Test
	final void testMatrixLongArrayArrayLongUnaryOperator(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixLong(byte[][], byte[][], java.util.function.ToLongBiFunction, byte, byte)}.
	 */
	@Test
	final void
		testMatrixLongByteArrayArrayByteArrayArrayToLongBiFunctionOfByteByteByteByte(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixLong(double[][], double[][], java.util.function.ToLongBiFunction, double, double)}.
	 */
	@Test
	final void
		testMatrixLongDoubleArrayArrayDoubleArrayArrayToLongBiFunctionOfDoubleDoubleDoubleDouble(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixLong(double[][], java.util.function.DoubleToLongFunction)}.
	 */
	@Test
	final void testMatrixLongDoubleArrayArrayDoubleToLongFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#matrixLong(int[][], int[][], java.util.function.ToLongBiFunction, int, int)}.
	 */
	@Test
	final void
		testMatrixLongIntArrayArrayIntArrayArrayToLongBiFunctionOfIntegerIntegerIntInt(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#matrixLong(int[][], java.util.function.IntToLongFunction)}.
	 */
	@Test
	final void testMatrixLongIntArrayArrayIntToLongFunction(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multiply(byte, byte[][])}.
	 */
	@Test
	final void testMultiplyByteByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multiply(double[][], double[][])}.
	 */
	@Test
	final void testMultiplyDoubleArrayArrayDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multiply(double, double[][])}.
	 */
	@Test
	final void testMultiplyDoubleDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multiply(int[][], int[][])}.
	 */
	@Test
	final void testMultiplyIntArrayArrayIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multiply(long, long[][])}.
	 */
	@Test
	final void testMultiplyLongLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#multipply(int, int[][])}.
	 */
	@Test
	final void testMultipply(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#negate(double[][])}.
	 */
	@Test
	final void testNegateDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#negate(int[][])}.
	 */
	@Test
	final void testNegateIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(byte[][])}.
	 */
	@Test
	final void testRotateByteArrayArray(){
		final byte[][] result=Matrix.rotate(
			Matrix.matrixByte(rotate.intMatrix, a->(byte)a)
		);
		final byte[][] expected=Matrix.matrixByte(
			rotate.intRotated, a->(byte)a
		);
		for(int i=0; i<result.length; i++){
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(double[][])}.
	 */
	@Test
	final void testRotateDoubleArrayArray(){
		final double[][] result=Matrix.rotate(
			Matrix.matrixDouble(rotate.intMatrix, a->a)
		);
		final double[][] expected=Matrix.matrixDouble(rotate.intRotated, a->a);
		for(int i=0; i<result.length; i++){
			Assert.assertArrayEquals(expected[i], result[i], .5);
		}
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(E[][], java.lang.Class)}.
	 */
	@Test
	final void testRotateEArrayArrayClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(int[][])}.
	 */
	@Test
	final void testRotateIntArrayArray(){
		final int[][] result=Matrix.rotate(rotate.intMatrix);
		for(int i=0; i<result.length; i++){
			Assert.assertArrayEquals(rotate.intRotated[i], result[i]);
		}
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(byte[][])}.
	 */
	@Test
	final void testRotateLeftByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(double[][])}.
	 */
	@Test
	final void testRotateLeftDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(E[][], java.lang.Class)}.
	 */
	@Test
	final void testRotateLeftEArrayArrayClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(int[][])}.
	 */
	@Test
	final void testRotateLeftIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(long[][])}.
	 */
	@Test
	final void testRotateLeftLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotateLeft(java.lang.String[][])}.
	 */
	@Test
	final void testRotateLeftStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(long[][])}.
	 */
	@Test
	final void testRotateLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#rotate(java.lang.String[][])}.
	 */
	@Test
	final void testRotateStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#subtract(double[][], double[][])}.
	 */
	@Test
	final void testSubtractDoubleArrayArrayDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#subtract(int[][], int[][])}.
	 */
	@Test
	final void testSubtractIntArrayArrayIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#toString(double[][], java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testToStringDoubleArrayArrayStringString(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#toString(E[][], java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testToStringEArrayArrayStringString(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link zUtil.Matrix#toString(E[][], java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testToStringEArrayArrayStringStringString(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#toString(int[][], java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testToStringIntArrayArrayStringString(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#toString(long[][], java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testToStringLongArrayArrayStringString(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(byte[][])}.
	 */
	@Test
	final void testTransposeByteArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(double[][])}.
	 */
	@Test
	final void testTransposeDoubleArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(E[][], java.lang.Class)}.
	 */
	@Test
	final void testTransposeEArrayArrayClassOfE(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(int[][])}.
	 */
	@Test
	final void testTransposeIntArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(long[][])}.
	 */
	@Test
	final void testTransposeLongArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link zUtil.Matrix#transpose(java.lang.String[][])}.
	 */
	@Test
	final void testTransposeStringArrayArray(){
		Assertions.fail("Not yet implemented"); // TODO
	}

}
