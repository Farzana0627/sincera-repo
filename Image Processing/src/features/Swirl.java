package features;

import java.io.File;
import java.io.IOException;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

public class Swirl {
	ReadImage readImage;
	WriteImage writeImage;
	
	public Swirl(File file) throws IOException{
		readImage = new ReadImage(file);
		writeImage = new WriteImage(readImage);
		swirl();
	}
	
	private void swirl() throws IOException{
		double x0 = 0.5 * (readImage.getHeight() -1);
		double y0 = 0.5 *(readImage.getWidth() -1);
		
		int blue = 0;
		int green = 0;
		int red = 0;
		
		for(int i = 0; i < readImage.getHeight(); i++){
			for(int j = 0; j < readImage.getWidth(); j++){
				double dx = i - x0;
				double  dy = j - y0;
				double r = Math.sqrt(dx*dx + dy*dy);
				double angle = Math.PI/256 * r;
				
				int tx = (int) (dx * Math.cos(angle) - dy*Math.sin(angle) + x0);
				int ty = (int) (dx * Math.sin(angle) + dy*Math.cos(angle) + y0);
				
				//replace color if tx and ty in range
				if((tx >= 0 && tx < readImage.getHeight()) && (ty >= 0 && ty < readImage.getWidth())){
					blue = readImage.getBlue(tx, ty);
					green = readImage.getGreen(tx, ty);
					red = readImage.getRed(tx, ty);
				}
				else{
					blue = readImage.getBlue(i, j);
					green = readImage.getGreen(i, j);
					red = readImage.getRed(i, j);
				}
				
				writeImage.write(blue, green, red);
			}
		}
	}
}
