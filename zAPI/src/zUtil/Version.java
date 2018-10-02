package zUtil;

public class Version{
	public static void error(int ... minVersion){
		String[] version=System.getProperty("java.version").split(".");
		int[] required={
			minVersion[0],
			minVersion.length>=2?minVersion[1]:0,
			minVersion.length>=3?minVersion[2]:0
		},
		curentVersion={
			Integer.parseInt(version[0]),
			version.length>=2?Integer.parseInt(version[1]):0,
			version.length>=3?Integer.parseInt(version[2]):0
		};
		if(
			required[0]>curentVersion[0]||
			required[0]==curentVersion[0]&&(
					required[1]>curentVersion[1]||
					required[1]==curentVersion[1]&&required[2]>curentVersion[2]
				)
		)System.out.println(
				"Your Java version is out of date, "
				+ "functionality may be comprimised as this is intended for Java "+zUtil.Numbers.join(".", minVersion)
			);
	}
}
