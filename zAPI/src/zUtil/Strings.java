/**
 *
 */
package zUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * @author Zekrom
 *
 */
public class Strings{
	private static void iterate(
		final Iterator<String> itr, final String sToReplace,
		final String sReplaceWith
	){
		String item=itr.next();
		item=item.replaceAll(sToReplace, sReplaceWith);
	}

	/**
	 * Advanced replacement
	 *
	 * @param  sIn
	 *                          The String to match
	 * @param  pattern
	 *                          The pattern to find
	 * @param  sToReplace
	 * @param  sReplaceWith
	 * @return              String
	 */
	public static String replace(
		String sIn, final Pattern pattern, final String sToReplace,
		final String sReplaceWith
	){
		final ArrayList<String> liOut=new ArrayList<>();
		Boolean startWithMatch;
		{
			final int index=Index.indexOf(sIn, pattern);//First character
			if(index==-1) return sIn;
			if(index!=0){
				liOut.add(sIn.substring(0, index-1));
				sIn=sIn.substring(index);
				startWithMatch=false;
			}
			else startWithMatch=true;
			final int endIndex=Index.endIndexOf(sIn, pattern);
			liOut.add(sIn.substring(0, endIndex));
			sIn=sIn.substring(endIndex+1);
		}
		while(true){//Loop until break
			final int index=Index.indexOf(sIn, pattern);//First character
			if(index==-1) break;
			if(index!=0){
				liOut.add(sIn.substring(0, index-1));
				sIn=sIn.substring(index);
			}
			final int endIndex=Index.endIndexOf(sIn, pattern);
			liOut.add(sIn.substring(0, endIndex));
			sIn=sIn.substring(endIndex+1);
		}
		final Iterator<String> itr=liOut.iterator();
		if(!startWithMatch) itr.next();
		Strings.iterate(itr, sReplaceWith, sReplaceWith);
		while(itr.hasNext()){
			itr.next();
			if(itr.hasNext()) Strings.iterate(itr, sToReplace, sReplaceWith);
		}
		itr.remove();
		return String.join("", liOut);
	}

	public static String replace(
		final String sIn, final String RegExp, final String sToReplace,
		final String sReplaceWith
	){
		return Strings.replace(sIn, Pattern.compile(RegExp), sToReplace,
			sReplaceWith);
	}


}
