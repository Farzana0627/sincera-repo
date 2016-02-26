/*
 /** FILE: WriteImage.java
 * Description: Takes the child class extending ReadImage class and writes the image at the destination
 * 
 * Last Modified: 31.03.15
 */
package ioRelatedClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class WriteImage {
	
	File file;
	FileOutputStream imgout;
	
	//start constructor to write image
	public WriteImage(ReadImage readImage) throws IOException{
		
		file = new File("output.bmp");
		imgout = new FileOutputStream(file);
		
		
		for(int h: readImage.head)
			imgout.write(h);
		
	}//end constructor
	
	public void write(int blue , int green, int red) throws IOException{
		
		imgout.write(blue);
		imgout.write(green);
		imgout.write(red);
		
	}
	
}//end class WriteImage