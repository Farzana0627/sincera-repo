/*package collage.iit.org;

import java.awt.image.BufferedImage;

public class SuperImposition extends ImageReader {
	int newHeight, newWidth;
	
	int SuperImagePixels[][];
	public SuperImposition(int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		newHeight= height;
		newWidth= width;
		SuperImagePixels = new int[newWidth][newHeight];
	}
	
	public int getRGBmax(int rgb1, int rgb2)
	{
		if(rgb1>rgb2) return rgb1;
		return rgb2;
	}
	public int getRGBmin(int rgb1, int rgb2)
	{
		if(rgb1<rgb2) return rgb1;
		return rgb2;
	}
	public BufferedImage superImpositionMethod(ImageReader image1, ImageReader image2)
	{
		BufferedImage bi=new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		for(int i=0; i< newWidth; i++)
			for(int j=0; j< newHeight; j++)
				if(image1.getPixelvalue(i, j)>image2.getPixelvalue(i, j));
					bi.setRGB(i,j, image1.getPixelvalue(i, j));
	}

}
*/