package features;
import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;

public class Contrast {
	
	int bavg = 0;
	int gavg = 0;
	int ravg = 0;
	WriteImage imgout;
	ReadImage readimage;
	public Contrast(File file) throws IOException{
		

		readimage=new ReadImage(file);
		imgout=new WriteImage(readimage);
		//user input -128 to +128
	}//end constructor
	
	

	
	public void contrastCorrection(double contrast) throws IOException{
		double factor = (259 *(contrast + 255))/(255*(259 - contrast));
		
		for (int i = 0; i < readimage.getHeight(); i++) {
			for (int j = 0; j < readimage.getWidth(); j++) {
				int blue = (int)( factor *(readimage.getBlue(i,j) - 128) + 128);
				int green = (int)( factor *(readimage.getGreen(i,j) - 128) + 128);
				int red = (int)( factor *(readimage.getRed(i,j) - 128) + 128);
				
				imgout.write(blue, green, red);
			}
		}
	}
}//end class Contrast
