package ba.ctcs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

	static List<String> filePaths = new ArrayList<String>();
	private static void findFile(File directory, String name) {
		  File[] dirlist  = directory.listFiles();
		  for(int i = 0; i < dirlist.length; i++) { 
		    if(dirlist[i].isDirectory()) {
		       findFile(dirlist[i], name);
		    } else if(dirlist[i].getName().matches(name)) {
		    	filePaths.add(dirlist[i].getAbsolutePath());
		    }
		  }
		}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directory = "D://JSF_Workspace//O2Project//AvatarCode";
		File file = new File(directory);
		findFile(file,"pom.xml");
	    System.out.println(filePaths.size());
	}

}
