/**
 *
 */
package zUtil;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

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
public class Matrix extends MatrixCore{
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
		return MatrixCore.matrix(matrix, a->(byte)(scalar+a));
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
		return MatrixCore.matrix(matrix, a->scalar+a);
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
		return MatrixCore.matrix(A, B, (a, b)->a+b, 0, 0);
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
		return MatrixCore.matrix(matrix, a->scalar+a);
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
		return MatrixCore.matrix(A, B, (a, b)->a+b, 0, 0);
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
		return MatrixCore.matrix(matrix, a->scalar+a);
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
		return MatrixCore.matrix(A, B, (a, b)->a+b, "", "", String.class);
	}

	/**
	 * Clones the elements of a matrix into a new matrix
	 *
	 * @param  matrix
	 *                    The matrix to clone
	 * @return        A cloned matrix (Elements are not cloned)
	 */
	public static byte[][] clone(final byte[][] matrix){
		return MatrixCore.matrix(matrix, a->a);
	}

	/**
	 * Clones the elements of a matrix into a new matrix
	 *
	 * @param  matrix
	 *                    The matrix to clone
	 * @return        A cloned matrix (Elements are not cloned)
	 */
	public static double[][] clone(final double[][] matrix){
		return MatrixCore.matrix(matrix, a->a);
	}


	/**
	 * Clones the elements of a matrix into a new matrix
	 *
	 * @param  matrix
	 *                    The matrix to clone
	 * @param  class1
	 *                    The type of the matrix
	 * @return        A cloned matrix (Elements are not cloned)
	 */
	public static <E> E[][] clone(final E[][] matrix, final Class<E> class1){
		return MatrixCore.matrix(matrix, a->a, class1);
	}


	/**
	 * Clones the elements of a matrix into a new matrix
	 *
	 * @param  matrix
	 *                    The matrix to clone
	 * @return        A cloned matrix (Elements are not cloned)
	 */
	public static int[][] clone(final int[][] matrix){
		return MatrixCore.matrix(matrix, a->a);
	}


	/**
	 * Clones the elements of a matrix into a new matrix
	 *
	 * @param  matrix
	 *                    The matrix to clone
	 * @return        A cloned matrix (Elements are not cloned)
	 */
	public static long[][] clone(final long[][] matrix){
		return MatrixCore.matrix(matrix, a->a);
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
		return MatrixCore.matrixDouble(
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
		return MatrixCore.matrix(A, B, (a, b)->a/b, 1D, 1D);
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
		return MatrixCore.matrixDouble(A, B, (a, b)->a/((double)b), 1, 1);
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
		return MatrixCore.matrixDouble(A, B, (a, b)->a/((double)b), 1L, 1L);
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

	@SuppressWarnings("javadoc")
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
	 * Multiples a scalar to all cells
	 *
	 * @param  scalar
	 *                    The number to add
	 * @param  matrix
	 *                    The matrix to modify
	 * @return        A new scaled matrix
	 */
	public static byte[][] multiply(final byte scalar, final byte[][] matrix){
		return MatrixCore.matrix(matrix, a->(byte)(scalar*a));
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
		return MatrixCore.matrix(matrix, a->scalar*a);
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
		return MatrixCore.matrix(A, B, (a, b)->a*b, 1, 1);
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
		return MatrixCore.matrix(A, B, (a, b)->a*b, 1, 1);
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
		return MatrixCore.matrix(matrix, a->scalar*a);
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
		return MatrixCore.matrix(matrix, a->scalar*a);
	}

	/**
	 * Negates the values of a double matrix
	 *
	 * @param  A
	 *               The matrix to negate
	 * @return   A new negated matrix
	 */
	public static double[][] negate(final double[][] A){
		return MatrixCore.matrix(A, a->-a);
	}


	/**
	 * Negates the values of an int matrix
	 *
	 * @param  A
	 *               The matrix to negate
	 * @return   A new negated matrix
	 */
	public static int[][] negate(final int[][] A){
		return MatrixCore.matrix(A, a->-a);
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
		return MatrixCore.matrix(A, B, (a, b)->a-b, 0, 0);
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
		return MatrixCore.matrix(A, B, (a, b)->a-b, 0, 0);
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
