package zUtil;

public class Numbers{
	/**
	 * Joins numbers together like JavaScript
	 * @param delimiter
	 * @param array
	 * @return Joined String
	 */
	public static final String join(String delimiter, long[] array){
		String out="";
		for(long i:array)out+=(out==""?"":delimiter)+Long.toString(i);
		return out;
	}
	/**
	 * Joins numbers together like JavaScript
	 * @param delimiter
	 * @param array
	 * @return Joined String
	 */
	public static final String join(String delimiter, int[] array){
		String out="";
		for(int i:array)out+=(out==""?"":delimiter)+Integer.toString(i);
		return out;
	}

	/*static final public double reverseWord(String word){
		String[] words=word.split("illion|thousand");
		return 0;
	}*/
	/**
	 * @param long num
	 * @return Length of the number from the decimal point
	 */
	public static final short intLength(long num){
		return (short)Math.log10(num);
	}
	/**
	 * @param long num
	 * @return Length of the number from the decimal point base 2
	 */
	enum length{
		;
		public static final int intLengthBinary(long num){
			return (int)Math.log(num);
		}
		private static double ln16=1./Math.log(16.);
		/**
		 * @param long num
		 * @return Length of the number from the decimal point base 16
		 */
		public static final int intLengthHex(long num){
			return (int)(Math.log(num)*ln16);
		}
	}
	/**
	 * Joins numbers together like JavaScript
	 * @param delimiter
	 * @param array
	 * @return Joined String
	 */
	public static final String join(String delimiter, double[] array){
		String out="";
		for(double i:array)out+=(out==""?"":delimiter)+Double.toString(i);
		return out;
	}
	/**
	 * Joins numbers together like JavaScript
	 * @param delimiter
	 * @param array
	 * @return Joined String
	 */
	public static final String join(String delimiter, float[] array){
		String out="";
		for(float i:array)out+=(out==""?"":delimiter)+Float.toString(i);
		return out;
	}
}
