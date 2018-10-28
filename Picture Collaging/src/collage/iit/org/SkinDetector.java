package collage.iit.org;

import java.awt.Color;
import java.awt.image.BufferedImage;



public class SkinDetector extends ImageReader {
	
	public SkinDetector() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public BufferedImage Detector(ImageReader image)
	{
		BufferedImage bi= new BufferedImage(200, 200, image.type);
		for(int i=0; i< width; i++)
			for(int j=0; j< height; j++)
			{
				int rgb=image.getPixelvalue(i, j);
				Color c= new Color(rgb);
				int r=c.getRed();
				int g=c.getGreen();
				int b= c.getBlue();
				if(r>95 && g>40 && b>20 && (image.getMax(r,g,b)-image.getMin(r,g,b))>15 && Math.abs(r-g)>15 && r>g && r> b)
				{
					bi.setRGB(i, j, 255);
				}
				else bi.setRGB(i, j, 0);
			}
		return bi;
		
	}
	
	public BufferedImage getImposedPicture(ImageReader image1, ImageReader image2)
	{
		BufferedImage bi= new BufferedImage(300, 300, image1.type);
		for(int i=0; i< width; i++)
			for(int j=0; j< height; j++)
			{
				int rgb=image2.getPixelvalue(i, j);
				Color c= new Color(rgb);
				int r=c.getRed();
				int g=c.getGreen();
				int b= c.getBlue();
				if(r>95 && g>40 && b>20 && (image2.getMax(r,g,b)-image2.getMin(r,g,b))>15 && Math.abs(r-g)>15 && r>g && r> b)
				{
					bi.setRGB(i, j, image2.getPixelvalue(i, j));
				}
				else bi.setRGB(i, j, image1.getPixelvalue(i, j));
			}
		return bi;
	}

}
