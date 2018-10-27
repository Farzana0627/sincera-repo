import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;


public class GUI {
	 private static String folder_chosen="Choose a folder";
	public static void main( String[] args )
	   {
		   //adding panel to jframe
		
	      JPanel panel = new JPanel();  
	      JFrame application = new JFrame();
	      JButton button_choose_folder=new JButton(folder_chosen);
	      JButton button_open= new JButton("Open");
	      button_choose_folder.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent ae) {
	              JFileChooser fileChooser = new JFileChooser();
	              fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	              int returnValue = fileChooser.showOpenDialog(null);
	              if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                folder_chosen=fileChooser.getSelectedFile().getAbsolutePath();
	                button_choose_folder.setText(folder_chosen);
	              }
	            }
	          });
	      
	      
	       
	      button_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			File folder = new File(folder_chosen);
			ArrayList<ImageProxy> list_of_proxy_pictures= new ArrayList<>();
		      
			for (final File fileEntry : folder.listFiles()) {
			     
					if(fileEntry.getName().endsWith(".jpg") || fileEntry.getName().endsWith(".png") ||fileEntry.getName().endsWith(".bmp")||fileEntry.getName().endsWith(".gif"))
			          System.out.println(folder_chosen+"\\"+fileEntry.getName());
					list_of_proxy_pictures.add(new ImageProxy(folder_chosen+"\\"+fileEntry.getName()));
					openProxyImages(list_of_proxy_pictures);
				}
				
				
			}
		});
	      
	      
	    
	      
	      
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	      application.setSize( 300, 300 );
	      application.setVisible( true );
	      application.setLayout(new FlowLayout());
	
	      application.add( panel );
	      application.add(button_choose_folder);
	      application.add(button_open);
	     

	   } 
	
	 static final String[] EXTENSIONS = new String[]{
	        "gif", "png", "bmp","jpg" // and other formats you need
	    };
	 static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

	        @Override
	        public boolean accept(final File dir, final String name) {
	            for (final String ext : EXTENSIONS) {
	                if (name.endsWith("." + ext)) {
	                    return (true);
	                }
	            }
	            return (false);
	        }
	    };
	 
	 
	 static class ClickAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		
			
			JFileChooser fc= new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Desktop"));
			fc.setDialogTitle("Image Chooser");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
			     
			
		}
	 }
	 

		 

		 public static void openProxyImages(ArrayList<ImageProxy> list_of_proxy_pictures) {
			 
			 
/*
		      JPanel panel = new JPanel();  
		      
			  
		      panel.setLayout(new GridLayout(list_of_proxy_pictures.size(),0,3,3));
		      for(int i=0;i<list_of_proxy_pictures.size();i++){
		    	  panel.add(new Button(list_of_proxy_pictures.get(i).getImagePath()));
		      }
		      JFrame application = new JFrame();
		      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		      
		      application.add( panel );
		     application.pack();
		     application.setSize( 500, 500 );
		      application.setVisible( true );*/
			 
			 JFrame frame = new JFrame();
             frame.setLayout(new BorderLayout());

             JPanel buttonPane = new JPanel(new GridLayout(list_of_proxy_pictures.size(),0));
             for (int i = 0; i < list_of_proxy_pictures.size(); i++) {
                 JButton b = new JButton(list_of_proxy_pictures.get(i).getImagePath());
                 b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String path=b.getText().toString();
						for(int i=0;i<list_of_proxy_pictures.size();i++){
							if(list_of_proxy_pictures.get(i).getImagePath()==path){
								list_of_proxy_pictures.get(i).showImage();
							}
						}
					}
				});
                 buttonPane.add(b);
             }

             frame.add(buttonPane);

             frame.pack();
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
		     
		}

		 
		 
		 
	 



}



/*	
* 

public void listFilesForFolder(final File folder) {
for (final File fileEntry : folder.listFiles()) {
if (fileEntry.isDirectory()) {
listFilesForFolder(fileEntry);
} else {
System.out.println(fileEntry.getName());
}
}
}

final File folder = new File("/home/you/Desktop");
listFilesForFolder(folder);

* 
* 
* try {
		Files.walk(Paths.get(folder_chosen)).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		        System.out.println(filePath);
		    }
		});
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
*/




