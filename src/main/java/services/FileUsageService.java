package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import Models.Consts.Info;
import services.interfaces.IFileUsage;

public class FileUsageService implements IFileUsage{

	@Override
	public void createDocumnet(String name, String data) {
		
		String path = Info.getSavedDirectoryFromFile() + "/" + name + ".dat";
		
		
//		System.err.println(path);
		try {
			File newFile = new File(path);
			
			if(!newFile.exists()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				
				writer.write(data);
				
				writer.close();
			}else {
				JOptionPane.showMessageDialog(null, "FIle with this name already exits!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDocument(String name, String data) {
		
		String path = Info.getSavedDirectoryFromFile() + "/" + name + ".dat";
		
		
//		System.err.println(path);
		try {
			File newFile = new File(path);
			
			if(newFile.exists()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				
				writer.write(data);
				
				writer.close();
			}else {
				JOptionPane.showMessageDialog(null, "FIle with this name don\'t exits!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDocument(String name) {
		// TODO Auto-generated method stub
		
	}
	
	

}
