package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import Models.Content;
import Models.Item;
import Models.Consts.Info;
import gui.BuilderWindow;
import gui.SetupWindow;

public class MainLoop {

	public static void main(String[] args) {
		
//		List<Item> items = new ArrayList<Item>();
//		double prozent = 20;
//		
//		items.add(new Item("Gold ingot", "g.", 2, 210));
//		items.add(new Item("Silver penny", "g.", 1, 110));
//		
//		Content content = new Content(items, prozent);
//		
//		System.out.println(content);
//		System.out.println("base sum : " + content.getSummaryWithOutVat());
//
//		System.out.println("vat "+ prozent +"% summary : " + content.getVatSummary());
//
//		System.out.println("overall sum : " + content.getSummaryWithVat());
		
		//setup window
		
		File infoFile = new File(Info.getResDirectory()+"/.info/info.txt");
		
		if(!infoFile.exists()) {
			SetupWindow sWin = new SetupWindow();
			
			sWin.setVisible(true);
		}
		
		

		if(infoFile.exists()){
			//builder window
			
			BuilderWindow win = new BuilderWindow();
			
			win.setVisible(true);
			
			JButton jb = new JButton("Create");
			
			jb.setBounds(0, 0, 100, 60);
			
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					win.createNewItemTag();
					win.repaint();
					
					
					
				}
			});
			
			JButton save = new JButton("Save");
			
			save.setBounds(110, 0, 100, 60);
			
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					List<Item> items = win.generateItemsUsingGui();
					double prozent = 20;
					
					Content content = new Content(items, prozent);
					
					System.out.println(content);
					System.out.println("base sum : " + content.getSummaryWithOutVat());
			
					System.out.println("vat "+ prozent +"% summary : " + content.getVatSummary());
			
					System.out.println("overall sum : " + content.getSummaryWithVat());
					
					
					win.repaint();
					
				}
			});
			
			win.add(save);
			win.add(jb);
		}

		

	}

}
