package zUtil;

import java.util.ArrayList;

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
	public class numberFragment{
		String[] wordArr=new String[4];
		byte[] numberArr=new byte[4];
		short number;
		short exponent;
		public numberFragment(short in, int i, int _i){
			this.number=in;
			
			//100s
			byte u100=(byte)(in/100);
			this.wordArr[0]=u100!=0?parts.num[u100]+" hundred":"";//Attach the hundreds value if it exists
			this.numberArr[0]=u100;
			in%=100;
			
			//1s
			if(in!=0&&in<=19){//one to nineteen as they follow different lexical rules
				this.wordArr[1]="";
				this.numberArr[1]=0;
				this.wordArr[2]=parts.num[in];
				this.numberArr[2]=(byte)in;
			}
			
			//10s
			else if(in!=0){//in/10 returns tens; in%10 returns ones
				byte u10=(byte)(in/10);
				this.numberArr[1]=u10;
				this.wordArr[1]=parts.tens[u10];
				this.numberArr[1]=u10;
				byte u1=(byte)(in%10);
				this.wordArr[2]=u1!=0?parts.num[u1]:"";
				this.numberArr[2]=u1;
			}
			
			//Scale
			this.exponent=(short)(3*(_i-i-1));
			if(i>=0)this.wordArr[3]=i!=_i-1?extendedNumbers(this.exponent):"";
		}
		public String toString(){
			ArrayList<String> build=new ArrayList<String>();
			//100s
			if(!"".equals(this.wordArr[0]))build.add(this.wordArr[0]);
			//10s
			if(!"".equals(this.wordArr[1])){
				if(!"".equals(this.wordArr[2]))build.add(this.wordArr[1]+"-"+this.wordArr[2]);
				else build.add(this.wordArr[1]);
			}
			//1s and teens
			else build.add(this.wordArr[2]);
			if(!"".equals(this.wordArr[3]))build.add(this.wordArr[3]);
			return String.join(" ", build);
		}
		public String toTable(){
			
			ArrayList<String> wordBuild=new ArrayList<>(),
			numberBuild=new ArrayList<>();
			//100s
			if(!"".equals(this.wordArr[0])){
				wordBuild.add(this.wordArr[0]);
				numberBuild.add(""+this.numberArr[0]);
			}
			//10s
			if(!"".equals(this.wordArr[1])){
				wordBuild.add(this.wordArr[1]);
				numberBuild.add(""+this.numberArr[1]);
				if(!"".equals(this.wordArr[2])){
					wordBuild.add("-");
					numberBuild.add("");
				}
			}
			//1s and teens
			if(!"".equals(this.wordArr[2])){
				wordBuild.add(this.wordArr[2]);
				numberBuild.add(""+this.numberArr[2]);
			}
			if(!"".equals(this.wordArr[3])){
				wordBuild.add(this.wordArr[3]);
				numberBuild.add("10<sup>"+this.exponent+"</sup>");
			}
			
			
			return "<table><tr><th>"+
			String.join("</th><th>", wordBuild)+
			"</th></tr><tr><th>"+
			String.join("</th><th>", numberBuild)+
			"</th></tr></table>";
		}
	}
	
	public class word{
		Boolean isNegative=false;
		ArrayList<numberFragment> ipart=new ArrayList<>(),
			fpart=new ArrayList<>();
		public word(double doubleIn){
			this.core(String.format(doubleIn%1<=1E-6?"%.0f":"%f", doubleIn));
		}
		public word(String stringIn) {
			this.core(stringIn);
		}
		private void core(String stringIn){
			System.err.println(stringIn);
			if(stringIn.matches("^-.*"))this.isNegative=true;
			stringIn=stringIn.replaceAll("[ _,]|^-","");//Remove junk
			
			if(!stringIn.matches("\\d*(.\\d*)?"))throw new ArithmeticException("Not a number");
			String[] split=stringIn.split("\\.");//Split i-part and f-part
			if(!split[0].matches("0|^$")){//if i-part exists
				String[] ipart=altSplit(split[0]);//Split number by 3 places (standard) 
				short _i=(short)ipart.length;
				for(byte i=0;i<_i;i++){//For all values in ipart
					short number=(short)Integer.parseInt(ipart[i]);//Convert the string in to a number
					if(number==0)continue;//If 0 do nothing to result
					this.ipart.add(new numberFragment(number, i, _i));//Get number value and attach magnitude
				}
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
					this.fpart.add(new numberFragment(number, -i, 0));//Get number value and attach magnitude (with ths)
				}
			}
		}
		@Override
		public String toString(){
			String collector=this.isNegative?"negative ":"";
			for(numberFragment i:this.ipart)collector+=" "+i.toString();
			if(this.ipart.size()!=0&&this.fpart.size()!=0)collector+=" and";
			for(numberFragment i:this.fpart)collector+=" "+i.toString();
			return collector;
		}
		public String toTable(){
			String collector="<table>";
			//Negative
			if(this.isNegative)collector+="<th><table><tr><th>negative<th></tr><tr><th>-<th></tr></table></tr>";
			//Int part
			if(this.ipart.size()>0){
				for(numberFragment i:this.ipart)collector+="<th>"+i.toTable()+"</th>";
			}
			//And
			if(this.ipart.size()!=0&&this.fpart.size()!=0)collector+="<th><table><tr><th>and<th></tr><tr><th>.<th></tr></table></th>";
			//Fraction part
			if(this.fpart.size()>0){
				for(numberFragment i:this.fpart)collector+="<th>"+i.toTable()+"</th>";
			}
			return collector+"</table>";
		}
	}
	
	/**
	 * Converts double type numbers to written out numbers
	 * @param in The double to convert
	 * @return Written out word
	 */
	static final public String word(double in, Numbers x){
		double mod=in%1;
		if(mod<1E-5&&mod>-1E-5)return word((long)in, x);
		return x.new word(String.format("%f", in)).toTable();//Convert double to non-exponentiated string
	}
	/**
	 * Converts integer type numbers to written out numbers
	 * @param in The long to convert
	 * @return Written out word
	 */
	static final public String word(long in, Numbers x){
		return x.new word(String.format("%d",in)).toTable();//Convert long to non-exponentiated string
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
		if(power/3.f!=power/3)throw new ArithmeticException("number is not divisible by 3");//Throw exception if power is not divisible by 3
		power=power/3-1;
		if(power>999)throw new ArithmeticException("Number too big, maximum size 10e+3000");//Throw exception if power is too big
		if(power<0)throw new ArithmeticException("Number too low, minimum size 10e+3");//Throw exception if power is too low
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
		Numbers x=new Numbers();
		while(true){
			System.out.println(x.new word(user.next()).toTable());//word(user.nextFloat(),x)
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
