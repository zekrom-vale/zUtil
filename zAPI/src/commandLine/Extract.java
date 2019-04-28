/**
 *
 */
package commandLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zekrom
 *
 */
public class Extract extends HashMap<String, String>{
	/**
	 *
	 */
	private static final long serialVersionUID=1L;
	/**
	 * The arrayList containing the unkeyed values
	 */
	public final List<String> unkeyed=new ArrayList<>();


	/**
	 * @param cla
	 *                  The command line arguments
	 * @param delim
	 *                  The delimiter to use
	 * @param map
	 *                  The key-default values pairs<br>
	 *                  use <code>null</code> if no default
	 */
	public Extract(
		final String[] cla, final String delim, final String[]... map
	){
		final ArrayList<String[]> arrayList=new ArrayList<>(map.length);
		//Add elements
		for(final String[] element : map) arrayList.add(element);

		//Extract key-value pairs
		for(final String element : cla){
			final String[] args=element.split(delim, 2);
			if(args.length>1){
				final int _a=arrayList.size();
				for(int i=0; i<_a; i++){
					final String[] now=arrayList.get(i);
					if(now[0].equals(args[0])){
						this.put(now[0], args[1]);//Put the key-value into map
						arrayList.remove(i);//Remove from arrayList
						break;//End the loop
					}
				}
			}
			else this.unkeyed.add(cla[0]);//Add unkeyed values
		}
		//Catch defaults
		for(final String[] element : arrayList){
			this.put(element[0], element[1]);
		}
	}

	/**
	 * @param cla
	 *                The command line arguments
	 * @param map
	 *                The key-default values pairs<br>
	 *                use <code>null</code> if no default
	 */
	public Extract(final String[] cla, final String[]... map){
		this(cla, "=", map);
	}

	/**
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj){
		if(this==obj){
			return true;
		}
		if(!super.equals(obj)){
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		final Extract other=(Extract)obj;
		return this.unkeyed.equals(other.unkeyed);
	}

	/**
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime=31;
		int result=super.hashCode();
		result=prime*result+this.unkeyed.hashCode();
		return result;
	}
}
