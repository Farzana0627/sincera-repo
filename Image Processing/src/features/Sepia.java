/*
 * FILE: Greyscale.java
 * Description: Class Greyscale extends ReadImage class. Converts the color values to blue * 0.114
 * 				green*0.587 and red*0.299 basing on the percentage of colors in the image
 * 
 * Last Modified: 31.03.15
 */

package features;
import ioRelatedClasses.*;
import java.io.File;
import java.io.IOException;

public class Sepia {
	
	ReadImage readimage;
	WriteImage writeImage;
	
	//start constructor
	public Sepia(File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		sepia();
	}//end constructor
	
	
	
	private void sepia() throws IOException{
		double blue=0, green=0, red=0;
		double b, g, r;
		for (int i = 0; i < readimage.getHeight(); i++) {
			for (int j = 0; j < readimage.getWidth() ; j++) {
				blue=readimage.getBlue(i, j);
				green= readimage.getGreen(i, j);
				red= readimage.getRed(i, j);
				
				b = (int)((red* .272) + (green*.534) + (blue* .131));
				g = (int)((red* .349) + (green*.686) + (blue* .168));
				r= (int)((red* .393) + (green*.769) + (blue* .189));
				if(b<0) b=0;
				if(b>255) b=255;
				if(g<0) g=0;
				if(g>255) g=255;
				if(r<0) r=0;
				if(r>255) r=255;
				writeImage.write((int) b,(int) g, (int)r) ;
			}	
		}
	}
}//end class Sepia