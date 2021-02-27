package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Models.Content;
import Models.Item;

public class BuilderWindow extends JFrame {
	
	private List<JPanel> itemsInfo;
	private JScrollPane itemsView = null;
	private JPanel receiverInfo;
	private JTextField vatProzentGL;
	
	public BuilderWindow() {
		super("Invoice Builder");
		this.itemsInfo = new ArrayList<JPanel>();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		addReceiverInfo();
		addButtons();
		addImeMenu();
		addVatProzentFields();
		this.setVisible(true);
		
	}
	
	private void addReceiverInfo() {
		
		receiverInfo = new JPanel();
		
		receiverInfo.setBounds(110, 10, 170, 150);
		
		receiverInfo.setLayout(null);
		receiverInfo.setBorder(BorderFactory.createEtchedBorder(1));
		
		JTextField nameField = new JTextField();
		
		nameField.setBounds(10, 5, 150, 20);
		nameField.setName("nameField");
		
		receiverInfo.add(nameField);

		JTextField addressField = new JTextField();
		
		addressField.setBounds(10, nameField.getY()+nameField.getHeight()+10, 150, 20);
		addressField.setName("addressField");
		
		receiverInfo.add(addressField);
		
		JTextField eikField = new JTextField();
		
		eikField.setBounds(10, addressField.getY()+addressField.getHeight()+10, 150, 20);
		eikField.setName("eikField");
		
		receiverInfo.add(eikField);
		
		JTextField vatField = new JTextField();
		
		vatField.setBounds(10, eikField.getY()+eikField.getHeight()+10, 150, 20);
		vatField.setName("vatField");
		
		receiverInfo.add(vatField);
		
		JTextField molField = new JTextField();
		
		molField.setBounds(10, vatField.getY()+vatField.getHeight()+10, 150, 20);
		molField.setName("molField");
		
		receiverInfo.add(molField);
		
		addJLabelsToRec();
		
		this.add(receiverInfo);
		
	}
	
	private void addJLabelsToRec() {
		
		JPanel receiverLabels = new JPanel();
		
		receiverLabels.setBounds(10, 10, 100, 150);
		
		receiverLabels.setLayout(null);
		receiverLabels.setBorder(BorderFactory.createEtchedBorder(1));
		
		JLabel nameField = new JLabel("Name:");
		
		nameField.setBounds(10, 5, 150, 20);
		
		receiverLabels.add(nameField);

		JLabel addressField = new JLabel("Adress:");
		
		addressField.setBounds(10, nameField.getY()+nameField.getHeight()+10, 150, 20);
		
		receiverLabels.add(addressField);
		
		JLabel eikField = new JLabel("EIK:");
		
		eikField.setBounds(10, addressField.getY()+addressField.getHeight()+10, 150, 20);
		
		receiverLabels.add(eikField);
		
		JLabel vatField = new JLabel("VAT:");
		
		vatField.setBounds(10, eikField.getY()+eikField.getHeight()+10, 150, 20);
		
		receiverLabels.add(vatField);
		
		JLabel molField = new JLabel("MOL:");
		
		molField.setBounds(10, vatField.getY()+vatField.getHeight()+10, 150, 20);
		
		receiverLabels.add(molField);
		
		this.add(receiverLabels);
		
	}
	
	private void addVatProzentFields() {
		
		JPanel vatPan = new JPanel();
		
		vatPan.setBounds(600, 470, 200, 30);
		vatPan.setName("vatPan");
		
		vatPan.setLayout(null);
		vatPan.setBorder(BorderFactory.createEtchedBorder(1));
		
		JLabel nameField = new JLabel("VAT Prozent:");
		
		nameField.setBounds(10, 5, 100, 20);
		
		vatPan.add(nameField);
		
		JTextField vatField = new JTextField();
		
		vatField.setBounds(120, 5, 50, 20);
		vatField.setName("vatPrField");
		vatField.setText("20");
		
		vatProzentGL = vatField;
		
		vatPan.add(vatField);
		
		add(vatPan);
		
	}
	
	private void addButtons() {
		
		var win = this;
		
		
		JButton save = new JButton("Save");
		
		save.setBounds(110, 500, 100, 60);
		
		save.setFocusable(false);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				List<Item> items = win.generateItemsUsingGui();
				double prozent = Double.parseDouble((vatProzentGL.getText().length()<=0) ? "0" : vatProzentGL.getText());
				
				Content content = new Content(items, prozent);
				
				System.out.println(content);
				System.out.println("base sum : " + content.getSummaryWithOutVat());
		
				System.out.println("vat "+ prozent +"% summary : " + content.getVatSummary());
		
				System.out.println("overall sum : " + content.getSummaryWithVat());
				
				
				win.repaint();
				
			}
		});
		
		win.add(save);
	}
	
	private void addImeMenu() {
		
		JPanel jp = new JPanel();
		
		jp.setBounds(0, 170, 800, 49);
		jp.setLayout(null);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		this.add(jp);
		
		JLabel number = new JLabel("№");
		number.setName("number");
		number.setBounds(25, 5, 50, 60);
		number.setFont(number.getFont().deriveFont(20f));
		
		jp.add(number);
		
		JLabel nameField = new JLabel("Name and description");
		
		nameField.setBounds(number.getX()+number.getWidth(), 20, 250, 30);
		
		jp.add(nameField);

		JLabel masureField = new JLabel("Masure");
		
		masureField.setBounds(nameField.getX()+nameField.getWidth()+10, 20, 70, 30);
		
		jp.add(masureField);
		
		JLabel quantityField = new JLabel("Quantity");
		
		quantityField.setBounds(masureField.getX()+masureField.getWidth()+10, 20, 120, 30);
		
		jp.add(quantityField);
		
		JLabel priceForOneField = new JLabel("Price for one");
		
		priceForOneField.setBounds(quantityField.getX()+quantityField.getWidth(), 20, 100, 30);
		
		jp.add(priceForOneField);
		
		var win = this;
		
		JButton jb = new JButton("+");
		
		jb.setBounds(jp.getWidth()-40, 10, 30, 30);
		
		jb.setFont(jb.getFont().deriveFont(15f));
		jb.setFocusable(false);
		jb.setBackground(Color.GREEN);
		
		jb.setMargin(new Insets(0,0,0,0));
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				win.createNewItemTag();
				win.repaint();
				
				
				
			}
		});
		
		jp.add(jb);
		
	}
	
	public void createNewItemTag() {
		
		JPanel jp = new JPanel();
		
		jp.setBounds(0, 0+71*itemsInfo.size(), 780, 70);
		jp.setLayout(null);
		jp.setBackground(Color.LIGHT_GRAY);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		itemsInfo.add(jp);
		//this.add(jp);
		
		
		JButton delButt = new JButton("Del");
		delButt.setName("Del");
		delButt.setBounds(725, 10, 50, 50);
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
				JPanel contnWin = (JPanel) itemsView.getViewport().getComponent(0);
				contnWin.remove(jp);
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
		number.setBounds(25, 5, 50, 60);
		number.setFont(number.getFont().deriveFont(20f));
		
		jp.add(number);
		
		JTextField nameField = new JTextField();
		
		nameField.setBounds(number.getX()+number.getWidth(), 20, 250, 30);
		nameField.setName("nameField");
		
		jp.add(nameField);

		JTextField masureField = new JTextField();
		
		masureField.setBounds(nameField.getX()+nameField.getWidth()+10, 20, 50, 30);
		masureField.setName("masureField");
		
		jp.add(masureField);
		
		JTextField quantityField = new JTextField();
		
		quantityField.setBounds(masureField.getX()+masureField.getWidth()+10, 20, 120, 30);
		quantityField.setName("quantityField");
		
		jp.add(quantityField);
		
		JTextField priceForOneField = new JTextField();
		
		priceForOneField.setBounds(quantityField.getX()+quantityField.getWidth()+10, 20, 80, 30);
		priceForOneField.setName("priceForOneField");
		
		jp.add(priceForOneField);
		
		if(itemsView == null) {
			JPanel panel = new JPanel(new BorderLayout());
			panel.setBounds(0, 0, 780, 300);
			//panel.setPreferredSize(new Dimension(780, 400));
			panel.setLayout(null);
			
			panel.add(jp);
			
			itemsView = new JScrollPane(panel);
			itemsView.createVerticalScrollBar();
			itemsView.setBounds(0, 220, 800, 250);
			itemsView.setFocusable(true);
			
		}else {
			
			JPanel panel = (JPanel) itemsView.getViewport().getComponent(0);
			panel.setPreferredSize(new Dimension(780, itemsInfo.size()*71));
			
			panel.add(jp);
			
			this.remove(itemsView);
			
			itemsView = new JScrollPane(panel);
			itemsView.setBounds(0, 220, 800, 250);
			itemsView.setFocusable(true);

		}
		this.add(itemsView);
		this.validate();
		this.repaint();
		
	}
	
	private void repaintItemsInfo() {
		
		for(int i = 0; i < itemsInfo.size(); i++) {
			itemsInfo.get(i).setBounds(0, 0+71*i, 790, 70);
			var l = (JLabel)itemsInfo.get(i).getComponentAt(25, 5);
			l.setText((i+1)+"");
		}
		
		repaint();
		
	}
	
	public List<Item> generateItemsUsingGui(){
		
		List<Item> items = new ArrayList<Item>();
		
		for(JPanel jp : this.itemsInfo) {
			
			List<String> values = new ArrayList<String>();
			
			for(int i = 0; i < jp.getComponentCount(); i++) {
				
				if(jp.getComponent(i).getName().equals("Del") || jp.getComponent(i).getName().equals("number"))
					continue;
					
				
				var el = (JTextField)jp.getComponent(i);
				
//				System.out.println(el.getName() + " " + el.getText());
				
				values.add(el.getText());
				
			}
			
			items.add(this.createItemUsingStrings(values));
			
//			System.out.println("-------------------");
		}
		
		return items;
		
	}
	
	private Item createItemUsingStrings(List<String> value){
		
		
		return new Item(value.get(0), value.get(1), Double.parseDouble(value.get(2)), Double.parseDouble(value.get(3)));
			
		
	}
	
	

}
