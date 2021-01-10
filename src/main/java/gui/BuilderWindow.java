package gui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class BuilderWindow extends JFrame {
	
	private List<JPanel> itemsInfo;
	
	public BuilderWindow() {
		super("Invoice Builder");
		this.itemsInfo = new ArrayList<JPanel>();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		
	}
	
	public void createNewItemTag() {
		
		JPanel jp = new JPanel();
		
		jp.setBounds(5, 100+71*itemsInfo.size(), 790, 70);
		jp.setLayout(null);
		jp.setBackground(Color.LIGHT_GRAY);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		itemsInfo.add(jp);
		this.add(jp);
		
		JButton delButt = new JButton("Del");
		delButt.setBounds(735, 10, 50, 50);
		delButt.setBackground(Color.RED);
		delButt.setFocusable(false);
		delButt.setVisible(false);
		delButt.setMargin(new Insets(1,1,1,1));
		
		jp.add(delButt);
		
		delButt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				delButt.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				itemsInfo.remove(jp);
				remove(jp);
				repaintItemsInfo();
			}
			
		});
		
		jp.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				delButt.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseEntered(e);
				delButt.setVisible(false);
			}
			
		});
		
		JLabel number = new JLabel(itemsInfo.size()+"");
		number.setName("number");
		number.setBounds(10, 10, 60, 60);
		
		jp.add(number);
		
	}
	
	private void repaintItemsInfo() {
		
		for(int i = 0; i < itemsInfo.size(); i++) {
			itemsInfo.get(i).setBounds(5, 100+71*i, 790, 70);
			var l = (JLabel)itemsInfo.get(i).getComponentAt(10, 10);
			l.setText((i+1)+"");
		}
		
		repaint();
		
	}

}
