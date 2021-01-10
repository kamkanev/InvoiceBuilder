package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import Models.Content;
import Models.Item;
import gui.BuilderWindow;

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
		
		BuilderWindow win = new BuilderWindow();
		
		win.setVisible(true);
		
		final JButton jb = new JButton("Create");
		
		jb.setBounds(0, 0, 100, 60);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				win.createNewItemTag();
				win.repaint();
				
				
				
			}
		});
		
		win.add(jb);

	}

}
