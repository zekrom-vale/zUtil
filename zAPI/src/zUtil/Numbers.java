package zUtil;
//import zUtil.*

/**
* Numbers utility
* @author:		Shawn Graven
* @email:		shawn.graven@my.uwrf.edu
* @created: 		9/15/18//Estimated
* @modified: 	9/21/19 7:34a//Ignoring testing and very minor edits
* @Description:	Various number utilities including number to word
*/

public class Numbers{//Must explicitly declare it as public to import
	/**
	 * @param in The double to convert
	 * @return Written out word
	 */
	static final public String word(double in){
		return word(String.format("%f",in));//Convert double to non-exponentiated string
	}
	/**
	 * @param in The long to convert
	 * @return Written out word
	 */
	static final public String word(long in){
		return word(String.format("%.0f",(double)in));//Convert long to non-exponentiated string
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
		if(split[0]!=null&&split[0]!=""){//if i-part exists
			String[] ipart=altSplit(split[0]);//Split number by 3 places (standard) 
			short _i=(short)ipart.length;
			//System.out.println(String.join(" ", ipart));
			for(byte i=0;i<_i;i++){//For all values in ipart
				short number=(short)Integer.parseInt(ipart[i]);//Convert the string in to a number
				if(number==0)continue;//If 0 do nothing to result
				result+=subWord(number)+(i!=_i-1?" "+mag[_i-i-1]+" ":"");//Get number value and attach magnitude
				//Equivelent to `result=result+`...
			}
		}
		if(split.length>1){//if f-part exists
			String[] fpart=split[1].replaceAll("(\\d{3})","$1 ").split(" ");//Deliminate by 3 units ltr
			//More stable method of spiting rather than dealing with look behind or ahead in split(Uses RegExp)
			short _f=(short)fpart.length;
			result+="and ";
			for(byte i=0;i<_f;i++){//For all values in fpart
				//Fix values as it is not shifted correctly
				byte mod=(byte)(fpart[i].length()%3);
				if(mod==2)fpart[i]+="0";
				else if(mod==1)fpart[i]+="00";
				//Fix values END
				short number=(short)Integer.parseInt(fpart[i]);//Convert the string in to a number
				if(number==0)continue;//Skip if zero
				result+=subWord(number)+" "+mag[i+1]+"ths ";//Get number value and attach magnitude (with ths)
			}
			//System.out.println("."+String.join(" ", fpart));
		}
		return result;
	}
	private final static String subWord(short in){
		String out=in/100!=0?num[in/100]+" hundred":"";//Attach the hundreds value if it exists
		in%=100;//Remove the hundreds
		if(in!=0&&out!="")out+=" ";//Fixes spacing issue
		if(in!=0&&in<=19)out+=num[in];//one to nineteen as they follow different lexical rules
		else if(in!=0) out+=tens[in/10]+(in%10!=0?"-"+num[in%10]:"");
		//in/10 returns tens; in%10 returns ones
		return out;
	}
	/*private final static String[] altSplit(String str){
		System.out.println(str);
		int _s=str.length()/3;
		String[] arr=new String[_s];
		for(short i=0;i<_s;i++) {
			arr[i]=""+str.charAt(i*3)+str.charAt(i*3+1)+str.charAt(i*3+2);
			//char+char=adding
		}
		return arr;
	}private final static String[] altSplit(String str){
		System.out.println(str);
		int _s=str.length(),
			_s3=_s/3;
		String[] arr=new String[_s3];
		for(int i=0;i<_s3;i++) {
			_s-=3;
			arr[i]=str.substring(-3);
			str=str.substring(_s);
		}
		return arr;
	}*/

	private final static String[] altSplit(String str){//Fixes the problems occurring with split
		int mod=str.length()%3;
		if(mod==1)str="00"+str;
		else if(mod==2)str="0"+str;
		return str.replaceAll("(\\d{3})","$1 ").split(" ");
	}
	//Indexed words for pulling
	public static String[] num={null,"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","therteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"},
		tens={null,null,"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"},
		mag={null,"thousand","million","billion","trillion","quadrillion","quintillion","sextillion","septillion","octillion","nonillion","decillion"};
	/**
	 * @param iESA
	 * @deprecated
	 */
	public static final void main(String[] iESA){
		//System.out.println(Numbers.word(1000000000));
		System.out.println(Numbers.word("000,009,223,372,036,854,775,807.9,223,372,036,854,775,807"));//Input
		System.out.println(Numbers.word("-203"));//Input
	}
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
	public static final int intLengthBinary(long num){
		return (int)Math.log(num);
	}
	private static double ln16=1/Math.log(16);
	/**
	 * @param long num
	 * @return Length of the number from the decimal point base 16
	 */
	public static final int intLengthHex(long num){
		return (int)(Math.log(num)*ln16);
	}
}
