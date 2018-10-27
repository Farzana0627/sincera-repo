import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.ImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HighResolutionImage implements Image {

	String imageFilePath;
	public HighResolutionImage(String imageFilePath) {
		this.imageFilePath= imageFilePath;
		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {

		// load Image from disk into memory
		// this is heavy and costly operation
	}

	@Override
	public void showImage() {

		// Actual Image rendering logic
		JFrame frame= new JFrame();
		  frame.setTitle("High Resolution Image");
		  frame.setSize(400,400);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		/*
		    One way
		    -----------------
		    setLayout(new BorderLayout());
		    JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
		    add(background);
		    background.setLayout(new FlowLayout());
		    l1=new JLabel("Here is a button");
		    b1=new JButton("I am a button");
		    background.add(l1);
		    background.add(b1);
		*/
		// Another way
		  frame.setLayout(new BorderLayout());
		  frame.setContentPane(new JLabel(new ImageIcon(imageFilePath)));
		  frame.setLayout(new FlowLayout());
		
		    // Just for refresh :) Not optional!
		

	}

}