package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.*;

import Models.Consts.Info;
import services.IFileUsage;

public class SetupWindow extends JFrame implements IFileUsage{
	
	private JPanel sellerRaw = new JPanel();

	public SetupWindow(){
		super("Invoice Builder Setup");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		this.generateElements();
//		this.createDocumnet("info");
		
	}

	private void generateElements() {
		
		sellerRaw.setBounds(150, 120, 600, 400);
		sellerRaw.setLayout(null);
		sellerRaw.setBackground(Color.LIGHT_GRAY);
		sellerRaw.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		this.add(sellerRaw);
		
		JTextField nameField = new JTextField();
		
		nameField.setBounds(10, 20, 250, 30);
		nameField.setName("nameField");
		
		sellerRaw.add(nameField);

		JTextField addressField = new JTextField();
		
		addressField.setBounds(10, nameField.getY()+nameField.getHeight()+10, 250, 30);
		addressField.setName("addressField");
		
		sellerRaw.add(addressField);
		
		JTextField eikField = new JTextField();
		
		eikField.setBounds(10, addressField.getY()+addressField.getHeight()+10, 250, 30);
		eikField.setName("eikField");
		
		sellerRaw.add(eikField);
		
		JTextField molField = new JTextField();
		
		molField.setBounds(10, eikField.getY()+eikField.getHeight()+10, 250, 30);
		molField.setName("molField");
		
		sellerRaw.add(molField);
		
		JTextField vatField = new JTextField();
		
		vatField.setBounds(10, molField.getY()+molField.getHeight()+10, 250, 30);
		vatField.setName("vatField");
		
		sellerRaw.add(vatField);
		
		JTextField bankField = new JTextField();
		
		bankField.setBounds(10, vatField.getY()+vatField.getHeight()+30, 250, 30);
		bankField.setName("bankField");
		
		sellerRaw.add(bankField);
		
		JTextField ibanField = new JTextField();
		
		ibanField.setBounds(10, bankField.getY()+bankField.getHeight()+10, 250, 30);
		ibanField.setName("ibanField");
		
		sellerRaw.add(ibanField);
		
		JTextField bicField = new JTextField();
		
		bicField.setBounds(10, ibanField.getY()+ibanField.getHeight()+10, 250, 30);
		bicField.setName("bicField");
		
		sellerRaw.add(bicField);
		
		JButton setDir = new JButton("Select DIr");
		
		SetupWindow win = this;
		
		setDir.setBounds(220, 0, 150, 60);
		
		setDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser cho = new JFileChooser();
				cho.setCurrentDirectory(new File(Info.getSavingDirectory()));
				cho.setDialogTitle("Seartch for directory");
				cho.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				cho.setAcceptAllFileFilterUsed(false);
				
				if(cho.showOpenDialog(win) == JFileChooser.APPROVE_OPTION) {
					System.out.println("CurrentDir: " + cho.getCurrentDirectory());

					Info.setSavingDirectory(cho.getSelectedFile().getAbsolutePath());
					
					System.out.println("SelectedDir: " + cho.getSelectedFile());
				}else {
					System.out.println("No selection");
				}
				
				System.out.println("Directory to save to: " + Info.getSavingDirectory());
				
//				File dir = new File(Info.getSavingDirectory() +"/.info");
//				
//				if(!dir.exists()) {
//					dir.mkdir();
//				}
				
				win.repaint();
				
			}
		});
		
		JButton saveButt = new JButton("Save");
		
		saveButt.setBounds(20, 0, 150, 60);
		
		saveButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createDocumnet("info");
				win.repaint();
				win.dispose();
				
			}
		});
		
		this.add(saveButt);
		
		this.add(setDir);
		
		JPanel jpLabels = new JPanel();
		
		jpLabels.setBounds(sellerRaw.getX()-100, 120, 100, 400);
		jpLabels.setLayout(null);
		jpLabels.setBackground(Color.CYAN);
		jpLabels.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		this.add(jpLabels);
		
		JLabel nameLabel = new JLabel("Name:");
		
		nameLabel.setBounds(10, 20, 250, 30);
		nameLabel.setName("nameLabel");
		
		jpLabels.add(nameLabel);

		JLabel addressLabel = new JLabel("Address: ");
		
		addressLabel.setBounds(10, nameField.getY()+nameField.getHeight()+10, 250, 30);
		addressLabel.setName("addressLabel");
		
		jpLabels.add(addressLabel);
		
		JLabel eikLabel = new JLabel("EIK:");
		
		eikLabel.setBounds(10, addressField.getY()+addressField.getHeight()+10, 250, 30);
		eikLabel.setName("eikField");
		
		jpLabels.add(eikLabel);
		
		JLabel molLabel = new JLabel("Mol:");
		
		molLabel.setBounds(10, eikField.getY()+eikField.getHeight()+10, 250, 30);
		molLabel.setName("molLabel");
		
		jpLabels.add(molLabel);
		
		JLabel vatLabel = new JLabel("Vat number:");
		
		vatLabel.setBounds(10, molField.getY()+molField.getHeight()+10, 250, 30);
		vatLabel.setName("vatLabel");
		
		jpLabels.add(vatLabel);
		
		JLabel bankLabel = new JLabel("Bank: ");
		
		bankLabel.setBounds(10, vatField.getY()+vatField.getHeight()+30, 250, 30);
		bankLabel.setName("bankLabel");
		
		jpLabels.add(bankLabel);
		
		JLabel ibanLabel = new JLabel("IBAN: ");
		
		ibanLabel.setBounds(10, bankField.getY()+bankField.getHeight()+10, 250, 30);
		ibanLabel.setName("ibanLabel");
		
		jpLabels.add(ibanLabel);
		
		JLabel bicLabel = new JLabel("BIC:");
		
		bicLabel.setBounds(10, ibanField.getY()+ibanField.getHeight()+10, 250, 30);
		bicLabel.setName("bicLabel");
		
		jpLabels.add(bicLabel);
		
	}

	@Override
	public void createDocumnet(String name) {
		
		File infoDir = new File(Info.getResDirectory()+"/.info");
		
		if(!infoDir.exists()) {
			infoDir.mkdir();
		}
		
		File infoFile = new File(infoDir.getAbsolutePath() + "/" + name + ".txt");
		
		if(!infoFile.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(infoFile));
				writer.write(generateStringData());
				
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateDocument(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDocument(String name) {
		// TODO Auto-generated method stub
		
	}
	
	private String generateStringData() {
		
		String res = Info.getSavingDirectory()+"\n";
		
		for(int  i = 0; i < sellerRaw.getComponentCount(); i++) {
			
			var el = (JTextField) sellerRaw.getComponent(i);
			
			res+= el.getText()+"\n";
			
		}
		
		return res;
		
	}

}
