package collage.iit.org;

import java.awt.image.BufferedImage;


public class ImageOverlapper extends ImageReader{
	
	public ImageOverlapper() {
		// TODO Auto-generated constructor stub
		super();
		
	}

	public BufferedImage OverLapperMethod(ImageReader image1, ImageReader image2,ImageReader image3)
	{
		ImageReader image= new ImageReader();
		BufferedImage bi= image.getBlankImage(800, 800);
		
		for(int i=0; i<image1.width; i++)
			for(int j=0; j<image1.height; j++)
			{
				bi.setRGB(i+150, j+150, image1.getPixelvalue(i, j));
				if(i==200 && j==200) break;
			}
		for(int i=0; i<image2.width; i++)
			for(int j=0; j<image2.height; j++)
			{
				bi.setRGB(i+350, j+350, image2.getPixelvalue(i, j));
			}
		return bi;
		
		
	}
	
	public BufferedImage getCenteredImage(ImageReader image1, ImageReader image2)
	{
		ImageReader image= new ImageReader();
		BufferedImage bi= image.getBlankImage(800, 800);
		for(int i=0; i<image1.width; i++)
			for(int j=0; j<image1.height; j++)
			{
				bi.setRGB(i+250, j+250, image1.getPixelvalue(i, j));
			}
		
		return bi;
	}
	
	public BufferedImage getBorderedImage(ImageReader image)
	{
		
		int newWidth=image.width+40;
		int newHeight= image.height+40;
		BufferedImage bi= new BufferedImage(newWidth, newHeight, image.type);
		for(int i=0; i<image.width; i++)
			for(int j=0; j<image.height; j++)
			{
				bi.setRGB(i+20, j+20, image.getPixelvalue(i, j));
			}
		return bi;
		
	}
	
	
}
