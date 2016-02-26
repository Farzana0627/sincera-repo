package features;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;

import ioRelatedClasses.*;


public class ColorReduction {
	ReadImage readimage;
	WriteImage imgout;
	Color[] palatte = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE };
	List <Color> color;
	public ColorReduction(File file) throws IOException{
		
		readimage=new ReadImage(file);
		imgout=new WriteImage(readimage);
		color = new ArrayList<Color>(Arrays.asList(palatte));
		reduceColor();
	}
	
	private void reduceColor() throws IOException{
		for (int i = 0; i < readimage.getHeight(); i++) {
			for (int j = 0; j <readimage.getWidth(); j++) {
				Color color = new Color((int)readimage.getRed(i,j),(int)readimage.getGreen(i,j),(int) readimage.getBlue(i,j) );
				color = findNearestColor(color);
				
				int blue = color.getBlue();
				int green = color.getGreen();
				int red = color.getRed();
				
				imgout.write(blue, green, red);
			}
		}
	}

	private Color findNearestColor(Color actual){
		long mindistance = 255*255 + 255*255 + 255*255 + 1;
		Color nearest = actual;
		for (Color c: color){
			int bdiff = actual.getBlue() - c.getBlue();
			int gdiff = actual.getGreen() - c.getGreen();
			int rdiff = actual.getRed() - c.getRed();
			
			long distance = rdiff*rdiff + gdiff*gdiff + bdiff*bdiff;
			
			if(distance < mindistance){
				mindistance = distance;
				nearest = c;
			}//end if
		}//end for
		
		return nearest;
	}//end method findNearestColor
}
