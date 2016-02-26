package features;

import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;

public class PhotoNegative{
	ReadImage readImage;
	WriteImage imgout;
	int height, width;
	public PhotoNegative(File file) throws IOException{
		
		readImage= new ReadImage(file);
		 height=readImage.getHeight();
		 width=readImage.getWidth();
		imgout = new  WriteImage(readImage);
		photoNegMethod();
	}//end constructor
	
	private void photoNegMethod() throws IOException{
		double blue,green,red;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				blue = 255- readImage.getBlue(i, j);
				green = 255 - readImage.getGreen(i, j);
				red = 255 - readImage.getRed(i, j);
				
				imgout.write((int)blue, (int)green, (int)red);
			}//end inner for
		}//end outer for
	}//end method photoNegMethod
}//end class PhotoNegative