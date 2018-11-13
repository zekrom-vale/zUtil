package zUtil;

//import zUtil.*
/**
* Numbers utility
* @author		Shawn Graven
* @email		shawn.graven@my.uwrf.edu
* @created 		9/15/18//Estimated
* @modified 	9/24/19 8:49a//Ignoring testing and very minor edits
* @Description	Various number utilities including number to word
*/

public class Numbers{//Must explicitly declare it as public to import
	/**
	 * Converts double type numbers to written out numbers
	 * @param in The double to convert
	 * @return Written out word
	 */
	static final public String word(double in){
		double mod=in%1;
		if(mod<1E-5&&mod>-1E-5)return word(String.format("%d",(long)in));
		return word(String.format("%f", in));//Convert double to non-exponentiated string
	}
	/**
	 * Converts integer type numbers to written out numbers
	 * @param in The long to convert
	 * @return Written out word
	 */
	static final public String word(long in){
		return word(String.format("%d",in));//Convert long to non-exponentiated string
	}
	/**
	 * @param in The string to convert
	 * @return Written out word
	 */
	static final public String word(String in){
		String result=in.matches("^-.*")?"negative ":"";//Check if negative
		in=in.replaceAll("[ _,]|^-","");//Remove junk
		if(!in.matches("\\d+(.\\d*)?"))throw new ArithmeticException("Not a number");
		String[] split=in.split("\\.");//Split i-part and f-part
		if(!"0".equals(split[0])){//if i-part exists
			String[] ipart=altSplit(split[0]);//Split number by 3 places (standard) 
			short _i=(short)ipart.length;
			for(byte i=0;i<_i;i++){//For all values in ipart
				short number=(short)Integer.parseInt(ipart[i]);//Convert the string in to a number
				if(number==0)continue;//If 0 do nothing to result
				result+=subWord(number, i, _i);//Get number value and attach magnitude
				//Equivelent to `result=result+`...
			}
			if(split.length>1)result+=" and ";
		}
		if(split.length>1){//if f-part exists
			String[] fpart=split[1].replaceAll("(\\d{3})","$1 ").split(" ");//Deliminate by 3 units ltr
											  //Group 1	 //Reference to group 1
			//More stable method of spiting rather than dealing with look behind or ahead in split(Uses RegExp)
			short _f=(short)fpart.length;
			
			for(byte i=0;i<_f;i++){//For all values in fpart
				//Fix values as it is not shifted correctly
				byte mod=(byte)(fpart[i].length()%3);
				if(mod==2)fpart[i]+="0";
				else if(mod==1)fpart[i]+="00";
				//Fix values END
				short number=(short)Integer.parseInt(fpart[i]);//Convert the string in to a number
				if(number==0)continue;//Skip if zero
				result+=subWord(number, -i, 0);//Get number value and attach magnitude (with ths)
			}
		}
		return result;
	}
	/**
	 * Constructs the chunks of the numbers
	 * @param in the number to construct (Excluding any magnitudes)
	 * @return Constructed part
	 */
	private final static String subWord(short in, int i, int _i){
		String out=in/100!=0?parts.num[in/100]+" hundred":"";//Attach the hundreds value if it exists
		in%=100;//Remove the hundreds
		if(in!=0&&out!="")out+=" ";//Fixes spacing issue
		if(in!=0&&in<=19)out+=parts.num[in];//one to nineteen as they follow different lexical rules
		else if(in!=0)out+=parts.tens[in/10]+(in%10!=0?"-"+parts.num[in%10]:"");
		//in/10 returns tens; in%10 returns ones
		if(i>=0)return out+(i!=_i-1?" "+extendedNumbers(3*(_i-i-1))+" ":"");
		return out+" "+extendedNumbers(3*(i-1))+" ";
	}
	@SuppressWarnings("unused")
	private final static String[] subWordArr(short in, int i, int _i){
		String place;
		if(i>=0)place=(i!=_i-1?extendedNumbers(3*(_i-i-1)):"");
		else place=extendedNumbers(3*(i-1));
		if(in==0)return new String[]{
			place
		};
		String hundred=in/100!=0?parts.num[in/100]+" hundred":"";//Set hundreds value if it exists
		in%=100;//Remove the hundreds
		if(in==0)return new String[]{
			hundred,
			place
		};
		else if(in<=19)return new String[]{
			hundred,
			parts.num[in],//one to nineteen as they follow different lexical rules
			place
		};
		return new String[]{
			hundred,
			parts.tens[in/10],
			parts.num[in],//one to nineteen as they follow different lexical rules
			in%10!=0?"-"+parts.num[in%10]:"",
			place
		};
	}
	/**
	 * Fixes the problems occurring with split
	 * @param str
	 * @return String array
	 */
	private final static String[] altSplit(String str){
		int mod=str.length()%3;
		if(mod==1)str="00"+str;
		else if(mod==2)str="0"+str;
		return str.replaceAll("(\\d{3})","$1 ").split(" ");
	}
	//Indexed words for pulling
	/**
	 * Parts to construct dictionary numbers
	 */
	public enum parts{
		;
		/**
		 * All non-uniform numbers
		 */
		public static final String[] num={
			null,"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","therteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
		};
		/**
		 * Uniform tens places 20-90
		 */
		public static final String[] tens={
			null,null,"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"
		};
		/**
		 * An array of standard dictionary numbers
		 * @see zUtil.Numbers.extendedNumbers
		 */
		public static final String[] mag={//Standard magnitude
			null,"thousand","million","billion","trillion","quadrillion","quintillion","sextillion","septillion","octillion","nonillion","decillion","undecillion","duodecillion","tredecillion","quattuordecillion","quindecillion","sexdecillion","septendecillion","octodecillion","novemdecillion","vigintillion"
		};
		/**
		 * Parts to construct extended dictionary numbers
		 */
		public enum ext{
			;
			/**
			* Parts for the extended standard dictionary numbers syntax
			* @see zUtil.Numbers.extendedNumbers
			*/
			public static final String[] units={
				"","un","duo","tre","quattuor","quinqua","se","septe","octo","nove"
			};
			/**
			 * Parts for the extended standard dictionary numbers syntax
			 * @see zUtil.Numbers.extendedNumbers
			 */
			public static final String[][] tens={
				{null,""},{"deci","N"},{"viginti","MS"},{"triginta","NS"},{"quadraginta","NS"},
				{"quinquaginta","NS"},{"sexaginta","N"},{"septuaginta","N"},{"octoginta","MX"},
				{"nonaginta",null}
			},
			hundreds={
				{null,""},{"centi","NX"},{"ducenti","N"},{"trecenti","NS"},{"quadringenti","NS"},
				{"quingenti","NS"},{"sescenti","N"},{"septingenti","N"},{"octingenti","MX"},
				{"nongenti",null}
			};
		}
	}
	/**
	 * Constructs the magnitude up to 1+e3000 to 1-e3000
	 * @param power (e+30 would be 30, e-51 is -51)
	 * @return Magnitude 
	 */
	public static final String extendedNumbers(int power){
		//https://en.wikipedia.org/wiki/Names_of_large_numbers
		boolean reciprocal=false;
		if(power<0){//Test if it is a reciprocal
			power*=-1;
			reciprocal=true;
		}
		if(power/3.f!=power/3)throw new ArithmeticException("number is not divisable by 3");//Throw exception if power is not divisible by 3
		power=power/3-1;
		if(power>999)throw new ArithmeticException("Number too big, maxumum size 10e+3000");//Throw exception if power is too big
		if(power<0)throw new ArithmeticException("Number too low, munumum size 10e+3");//Throw exception if power is too low
		if(power<parts.mag.length)return parts.mag[power+1]+(reciprocal?"th":"");//Return standard dictionary numbers
		String out="";//init out
		byte hundred=(byte)(power/100);//Get hundreds
		power%=100;//Cut out hundreds
		byte tens=(byte)(power/10);//Get tens
		power%=10;//Cut out tens
		if(power!=0)out+=parts.ext.units[power];
		if(power==3||power==6){//Appends S/X or M/N based on the scheme
			if(parts.ext.tens[tens][1].matches(".?S")||parts.ext.hundreds[hundred][1].matches(".?S"))out+="s";
			else if(power==6&&(parts.ext.tens[tens][1].matches(".?X")||parts.ext.hundreds[hundred][1].matches(".?X")))out+="x";
		}
		else if(power==7||power==9){
			if(parts.ext.tens[tens][1].matches("M.?")||parts.ext.hundreds[hundred][1].matches("M.?"))out+="m";
			else if(parts.ext.tens[tens][1].matches("N.?")||parts.ext.hundreds[hundred][1].matches("N.?"))out+="n";
		}
		if(tens!=0)out+=parts.ext.tens[tens][0];
		if(hundred!=0)out+=parts.ext.hundreds[hundred][0];
		return out+(out.charAt(out.length()-1)=='i'?"":"i")+"llion"+(reciprocal?"th":"");
					//Prevent repeated i							//Provide reciprocal support
	}
	/**
	 * Code to automatically run
	 * @param iESA irrelevenEmptyStringArray
	 */
	public static final void main(String[] iESA){
		@SuppressWarnings("resource")
		var user=new java.util.Scanner(System.in);
		while(true){
			System.out.println(Numbers.word(user.nextFloat()));
		}
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
}
