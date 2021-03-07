package Models.Consts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Info {
	
	private static String savingDirectory = "./src/main/resources";
	private static String resDirectory = "./src/main/resources";

	public static String getResDirectory() {
		return resDirectory;
	}

	public static String getSavingDirectory() {
		return savingDirectory;
	}

	public static void setSavingDirectory(String savingDirectory) {
		Info.savingDirectory = savingDirectory;
	}
	
	public static String getSavedDirectoryFromFile() {
		
		String filename = resDirectory + "/.info/info.txt";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			String line;
			while((line = reader.readLine()) != null) {
				return line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return savingDirectory;
		
	}
	

}
