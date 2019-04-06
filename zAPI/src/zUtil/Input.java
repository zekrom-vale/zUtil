package zUtil;
import java.util.ArrayList;

/**
* Input API
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 9/07/18
* @modified 9/21/19 8:30a
* @description	Provides valid input from the user, weather it be an int, bool, or string.
*/
public final class Input{
	protected static java.util.Scanner user;//Prevent change or redundant scanners
	/**
	 * Opens a scanner, allowing user input
	 * @see Input.Close
	 */
	public final static void Open(){//Cannot reopen scanner
		user=new java.util.Scanner(System.in);
	}
	public static boolean Multiple=false;
	/**
	 * Closes the scanner
	 * @see zUtil.Input.Open
	 */
	public final static void Close(){
		user.close();
	}
	static public class get{
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @return Integer of the user's input
		 */
		public final static int Int(String sPrompt, String sErr){
			while(true){
				String sOut=get(sPrompt);
				if(sOut.matches(test.rInt))return Integer.parseInt(sOut);
				System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @param sBound Error to display when the input is out of bounds
		 * @param iMin Minimum valid integer
		 * @param iMax Maximum valid integer
		 * @return Integer of the user's input
		 */
		public final static int Int(String sPrompt, String sErr, String sBound, int iMin, int iMax){
			while(true){
				String sOut=get(sPrompt);
				if(sOut.matches(test.rInt)){
					int iOut=Integer.parseInt(sOut);
					if(iOut>=iMin&&(iOut<=iMax))return iOut;
					System.err.println(sBound + " ["+iMin+","+iMax+"]");
						//continue;
				}
				else System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @return Double of the user's input
		 */
		public final static double Double(String sPrompt, String sErr){
			while(true){
				String sOut=get(sPrompt);
				if(sOut.matches(test.rDouble))return Double.parseDouble(sOut);
				System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @param sBound Error to display when the input is out of bounds
		 * @param dMin Minimum valid double
		 * @param dMax Maximum valid double
		 * @return Double of the user's input
		 */
		public final static double Double(String sPrompt, String sErr, String sBound, double dMin, double dMax){
			while(true){
				String sOut=get(sPrompt);
				if(sOut.matches(test.rDouble)){
					double iOut=Double.parseDouble(sOut);
					if(iOut>=dMin&&iOut<=dMax)return iOut;
					System.out.println(sBound + " ["+dMin+","+dMax+"]");
					//continue;
				}
				else System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param reg The Regular Expression to validate the input
		 * @param sErr Error to display on invalid input
		 * @return String of user input
		 */
		public final static String Any(String sPrompt, String reg, String sErr){//String must match RegExp
			String sOut="";
			while(true){
				sOut=get(sPrompt);
				if(sOut.matches(reg))return sOut;
				System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @return String of user input
		 */
		public final static String Any(String sPrompt, String sErr){//String cannot be empty
			String sOut="";
			while(true){
				sOut=get(sPrompt);
				if(sOut.length()>0)return sOut;
				System.err.println(sErr);
			}
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @return String of user input
		 */
		public final static String Any(String sPrompt){
			return get(sPrompt);
		}
		/**
		 * @param sPrompt String to prompt the user (null will not prompt anything)
		 * @param sErr Error to display on invalid input
		 * @return Boolean of user input
		 */
		public final static Boolean Bool(String sPrompt, String sErr){
			String sOut="";
			while(true){
				sOut=get(sPrompt);
				if(sOut.matches(test.rBool))return test.IsTrue(sOut);
				System.out.println(sErr);
			}
		}
	}
	private static final String get(String sPrompt){//Print prompt and return input
		//Scanner user=new Scanner(System.in);
		if(sPrompt!=null)System.out.print(sPrompt);//Print prompt if it exists
		return (Multiple?user.next():user.nextLine()).replaceAll("[,_]", "");
	}
	public static class test{
		/**
		 * @param sOut String to test if "true"
		 * @return Boolean
		 */
		public final static Boolean IsTrue(String sOut) {//Returns a bool on if the string is (?i)"true"
			return sOut.matches("^\\s*(?i)true\\s*$");
		}
		/**
		 * @param sPrompt
		 * @return Contents of the string
		 */
		public final static String[] Type(String sPrompt){//Returns the contents of the string
			String[] sResult={get(sPrompt),null};
			if(sResult[0].matches(rInt)) sResult[1]="int";
			else if(sResult[0].matches(rDouble)) sResult[1]="double";
			else if(sResult[0].matches(rBool)) sResult[1]="Boolean";
			else sResult[1]="String";
			return sResult;
		}
		public static final String rInt=wrap("(\\-)?\\d*"),
		rDouble=wrap("(\\-)?\\d+(\\.\\d*)?"),
		rBool=wrap("true|false");//Deceleration for RegExp test strings
		private static final String wrap(String sReg){//Prepare RegExp for use
			return "(?i)^\\s*("+sReg+")\\s*$";
		}
	}
	public static class array{
		public final static double[] Double(String sPrompt, String err){
			while(true){
				if(sPrompt!=null)System.out.print(sPrompt);//Print prompt if it exists
				String sIn=user.nextLine();
				java.util.Scanner line=new java.util.Scanner(sIn);
				line.useDelimiter("[\\s;|, ]+");
				ArrayList<String> liItems=new ArrayList<String>();
				String test="([\"\'])[^\"\']+\\1|[^\"\',\\|;]+";
				//Skips ""
				while(line.hasNext(test)){
					String got=line.next(test).replaceAll("[,;|\\s_\"\']","");
					System.out.println(got);
					liItems.add(got);
				}
				line.close();
				String[] aItems=Arrays.toString(liItems);
				int _i=aItems.length;
				liItems.clear();
				if(_i<=0){
					System.err.println(err);
					continue;
				}
				double[] dOut=new double[_i];
				for(int i=0; i<_i; i++){
					if(aItems[i].matches(Input.test.rDouble))dOut[i]=Double.parseDouble(aItems[i]);
					else{
						System.err.print(err+": "+(i+1)+"\nnew value:\t\t");
						dOut[i]=get.Double(null, err);
					}
				}//EOF
				return dOut;
			}
		}
		
	}
	public static void main(String[] iESA){
		Input.Open();
		double[] x=array.Double("Test values", "Error not a number");
		System.out.println(Numbers.join(",", x));
	}
}
