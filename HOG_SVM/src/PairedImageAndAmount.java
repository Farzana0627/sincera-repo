import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PairedImageAndAmount {
public static void main(String[] args) throws IOException {
		
		
		String[] arrayofclasses= new File("H://Workspace//HOG_SVM//Taka").list();
		int i=0, j=0;
		
		for(i=0; i<arrayofclasses.length; i++){
			String classname= "H://Workspace//HOG_SVM//Taka//"+arrayofclasses[i];
			String[] arrayoffiles= new File(classname).list();
			
			
			for(j=0; j< arrayoffiles.length; j++){
				String inputfilepath= "H://Workspace//HOG_SVM//Taka//"+arrayofclasses[i]+"//"+arrayoffiles[j];
				
					
				File inputfile= new File(inputfilepath);
		
				BufferedImage inputImage = ImageIO.read(inputfile);
				/*int size= Math.min(inputImage.getHeight(), inputImage.getWidth());
				BufferedImage resizedImage= new BufferedImage(size,size,inputImage.getType());
			    Graphics2D g2d = resizedImage.createGraphics();
			    g2d.drawImage(inputImage, 0, 0, size, size, null);
			    g2d.dispose();*/
				if(inputImage.getHeight()>inputImage.getWidth()){
				System.out.println("error");
				}
				ImageIO.write(inputImage, "jpg", new File(""+i+"_"+j+".jpg"));
				try
				{
				    String filename= "pairedfile.txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    BufferedWriter bw= new BufferedWriter(fw);
				    float z = (float)i/ 1;
				    fw.write(""+i+"_"+j+".jpg"+" "+String.valueOf(z));	
				    bw.newLine();
				    bw.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
			
			}
		}
	}
}
