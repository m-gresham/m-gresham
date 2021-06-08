package javacheck;

public class CheckVersion {
	public static void main(String[] args) {
		if(cse247Version.isCompilerVersionGood() == false) {
			System.out.println("You definitely need to upgrade your version of Java!!!");
		} else {
			System.out.println("Looks ok!");
		}
	}
}
