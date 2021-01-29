package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import Models.Content;
import Models.Item;
import Models.Consts.Info;
import gui.BuilderWindow;
import gui.ScrollTest;
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
		
		System.out.println(infoFile.exists());
		
		if(!infoFile.exists()) {
			SetupWindow sWin = new SetupWindow();
			
			sWin.setVisible(true);
			
//			main(args);
		}else {
			BuilderWindow win = new BuilderWindow();
		}

		
		//ScrollTest st = new ScrollTest();
		

	}

}
