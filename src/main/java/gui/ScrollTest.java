package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.*;

public class ScrollTest extends JFrame {
	
	String[] values = {"henry", "Michael","Uche","John","Ullan","Nelly",
            "Ime","Lekan","Austine","jussi","Ossi","Imam","Empo","Austine","Becky",
           "Scholar","Ruth", "Anny"};

	public ScrollTest(){
		super("the button");
	    this.setSize(400, 200);
	    this.setLayout(null);

	    // Create a panel with a borderlayout
	    JPanel jpanel = new JPanel(new BorderLayout());
	    jpanel.setBounds(0, 0, this.getWidth(), this.getHeight());

	    JLabel label = new JLabel("Output Items:");
	    label.setAlignmentX(1);
	    label.setAlignmentY(1);
	    // Add Label to top of layout
	    jpanel.add(label, BorderLayout.NORTH);

	    JList conList = new JList(values);
	    conList.setVisibleRowCount(3);
	    
	    JPanel jp = new JPanel();
	    jp.setName("container");
	    
	    jp.setLayout(new BorderLayout());
	    
	    for(int i = 0; i< values.length; i++) {
	    	JPanel li = new JPanel();
	    	li.setLayout(null);
	    	li.setBounds(0, 10+i*50, 210, 50);
	    	JLabel name = new JLabel(values[i]);
	    	name.setBounds(0, 0, 200, 50);
	    	li.add(name);
	    	jp.add(li, BorderLayout.NORTH);
	    }
	    jp.setPreferredSize(new Dimension(210, 10+values.length*50));
	    
	    
	    JScrollPane scroller = new JScrollPane(jp);
	    scroller.setBounds(0, 0, 250, 300);
	    //AddScroll to center
	    //jpanel.add(scroller);
	    
	    System.err.println(scroller.getViewport().getComponent(0).getName());

	    //Add Panel to JFrame
	    this.add(scroller);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}

}
