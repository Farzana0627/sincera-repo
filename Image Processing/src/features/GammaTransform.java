package features;



import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;

public class GammaTransform{
	
	ReadImage readimage;
	WriteImage writeImage;
	//constructor begins
	public GammaTransform(File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		gammaTransMethod(.5); //user input
	}//end constructor
	
	//Make the gamma transformation
	public void gammaTransMethod( double ginv) throws IOException{
		
		for(int i = 0; i <readimage.getHeight(); i++){
			for (int j = 0; j < readimage.getWidth(); j++) {
				
				int blue = (int)(255* Math.pow(readimage.getBlue(i, j)/255.0, ginv));
				int green = (int) (255* Math.pow(readimage.getGreen(i, j)/255.0, ginv));
				int red = (int)(255 *Math.pow(readimage.getRed(i, j)/255.0, ginv));
				
				writeImage.write(blue, green, red);
			}//end inner for
		}//end outer for
	}//end method gammaTransMethod
}//end class GammaTransformation
