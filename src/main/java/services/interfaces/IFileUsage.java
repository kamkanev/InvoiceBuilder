package services.interfaces;

public interface IFileUsage {
	
	public void createDocumnet(String name, String data);
	
	public void updateDocument(String name, String data);
	
	public void deleteDocument(String name);

}
