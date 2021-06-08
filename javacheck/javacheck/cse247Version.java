package javacheck;

public class cse247Version {
	public static boolean isCompilerVersionGood() {
		// Partly based on: https://stackoverflow.com/questions/2591083/getting-java-version-at-runtime
		
		String version = System.getProperty("java.version");
		// Check 1.X.Y.Z numbering scheme
		System.out.println("Java Version is: " + version + " (Needs to be >= 1.8. Here are examples of things that are good: 1.8.0, 9.0.1, 11.0.4, etc.)");
		boolean good = false;
		
		if(version.substring(0,2).equals("1.")) {
			char subversion = version.charAt(2);  // Get X
			if(subversion>='8') {
				good = true;
			}			
		} else {
			// Newer version are suitable for 131
			good = true;
		}
		return good;
	}
}
