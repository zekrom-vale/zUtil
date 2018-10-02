package zUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Index{
	public static final int indexOf(String sIn, String RegExp){
		Pattern pattern=Pattern.compile(RegExp);
		Matcher match=pattern.matcher(sIn);
		return match.find()?match.start():-1;
	}
	public static final int endIndexOf(String sIn, String RegExp){
		Pattern pattern=Pattern.compile(RegExp);
		Matcher match=pattern.matcher(sIn);
		return match.find()?match.end():-1;
	}
	public static final int indexOf(String sIn, Pattern pattern){
		Matcher match=pattern.matcher(sIn);
		return match.find()?match.start():-1;
	}
	public static final int endIndexOf(String sIn, Pattern pattern){
		Matcher match=pattern.matcher(sIn);
		return match.find()?match.end():-1;
	}
}
