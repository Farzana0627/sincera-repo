package features;
import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;

public class Brightness{
	

	ReadImage readimage;
	WriteImage writeImage;
	//start constructor
	public Brightness (File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
	
	}//end constructor
	
	public void brighten(double brigthness) throws IOException{
		
		for (int i = 0; i < readimage.getHeight(); i++) {
			for (int j = 0; j < readimage.getWidth(); j++) {
				int blue = turncate (readimage.getBlue(i,j) + brigthness);
				int green = turncate (readimage.getGreen(i,j) + brigthness);
				int red = turncate (readimage.getRed(i,j) + brigthness);
				
				writeImage.write(blue, green, red);
			}
		}
	}
	
	private int turncate(double d){
		if (d < 0)
			return 0;
		if(d > 255)
			return 255;
		return (int) d;
	}
}