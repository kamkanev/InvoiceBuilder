package Models.Consts;

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
	

}
