package collage.iit.org;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class CollageOperator  {
	int newHeight, newWidth;

	public CollageOperator()  {
		// TODO Auto-generated constructor stub
		
	}
	
	public int blendPixels(int rgb1, int rgb2, double a)
	{
		double b=(100-a);
		int Blue=0, Red=0, Green=0; 
		Color c1= new Color(rgb1);
		Color c2= new Color(rgb2);
		Blue=(int)((c1.getBlue()*a)+ (c2.getBlue()*b))/100;
		Green=(int)((c1.getGreen()*a)+ (c2.getGreen()*b))/100;
		Red=(int)((c1.getRed()*a)+ (c2.getRed()*b))/100;
		if(Red<0) Red=0;
		if(Red>255) Red=255;
		if(Green<0) Green=0;
		if(Green>255)Green=255;
		if(Blue<0) Blue=0;
		if(Blue>255) Blue=255;
		Color c= new Color(Red, Green, Blue);
		return c.getRGB();
	}
	public int fullblendPixels(int rgb1, int rgb2,double a)
	{
		double b=1-a;
		int Blue=0, Red=0, Green=0; 
		Color c1= new Color(rgb1);
		Color c2= new Color(rgb2);
		Blue=(int)((c1.getBlue()*b)+ (c2.getBlue()*a));
		Green=(int)((c1.getGreen()*b)+(c2.getGreen()*a));
		Red=(int)((c1.getRed()*b)+ (c2.getRed()*a));
		if(Red<0) Red=0;
		if(Red>255) Red=255;
		if(Green<0) Green=0;
		if(Green>255)Green=255;
		if(Blue<0) Blue=0;
		if(Blue>255) Blue=255;
		Color c= new Color(Red, Green, Blue);
		return c.getRGB();
	}
	
	
	public BufferedImage resizeMethod(BufferedImage image,int width, int height)
	{
	
		BufferedImage resized= new BufferedImage(width,height, image.getType());
		Graphics2D g= resized.createGraphics();
		g.drawImage(image, 0, 0, width,height, null);
		g.dispose();
		return resized;
	}

	public BufferedImage fullBlend(BufferedImage image1, BufferedImage image2, double a)
	{
		newWidth=400;
		newHeight=300;
		image1= resizeMethod(image1, 400,300);
		image2= resizeMethod(image2, 400,300);
		BufferedImage bi= new BufferedImage(newWidth, newHeight, image1.getType());
		int value;
		for(int i=0; i<newWidth ; i++)
			for(int j=0; j< newHeight; j++)
			{
				value=(int) blendPixels(image1.getRGB(i, j), image2.getRGB(i,j),a);
				bi.setRGB(i, j,value);
			}
		
		return bi;
	
	} 
	public BufferedImage blendTwoImages(BufferedImage image1,BufferedImage image2 )
	{
		newWidth=700;
		newHeight=300;
		image1= resizeMethod(image1, 400,300);
		image2= resizeMethod(image2, 400,300);
		int w1=300,w2=400;
		BufferedImage bi= new BufferedImage(newWidth, newHeight, image1.getType());
		int value;
		for(int i=0; i<w1 ; i++)
			for(int j=0; j< newHeight; j++)
			{
				value=(int)image1.getRGB(i, j);
				bi.setRGB(i, j,value);
			}
		
		double a=100;
		for(int i= w1; i<w2; i++)
		{
			
			for(int j=0; j< newHeight; j++)
			{	

				value=(int) blendPixels(image1.getRGB(i, j), image2.getRGB(i-300,j),a);
				bi.setRGB(i, j, value);
				
			}
			a=a-1;
		}
		for(int i= w2; i< newWidth; i++)
			for(int j=0; j< newHeight; j++)
			{
				value=(int) image2.getRGB(i-300, j);
				bi.setRGB(i, j, value);
			}
		bi= resizeMethod(bi, 500, 300);
		return bi;
	}
	public BufferedImage blendFourImages(BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4)
	{
		BufferedImage image1=blendTwoImages(img1, img2);
		BufferedImage image2=blendTwoImages(img3, img4);
		
		newWidth=700;
		newHeight= 500;
		int h1=200,h2=300;
		BufferedImage bi= new BufferedImage(newWidth, newHeight, image1.getType());
		image1= resizeMethod(image1, 700, 300);
		image2= resizeMethod(image2, 700, 300);
		int value;
		
		for(int i=0; i<newWidth ; i++)
			for(int j=0; j< h1; j++)
			{
				value=(int)image1.getRGB(i, j);
				bi.setRGB(i, j,value);
			}
		
		
		for(int i= 0; i<newWidth; i++)
		{
			double a=100;
			for(int j=h1; j< h2; j++)
			{	

				value=(int) blendPixels(image1.getRGB(i, j), image2.getRGB(i,j-200),a);
				bi.setRGB(i, j, value);
				a=a-1;
			}
			
		}
		
		for(int i= 0; i< newWidth; i++)
			for(int j=h2; j< newHeight; j++)
			{
				value=(int) image2.getRGB(i, j-200);
				bi.setRGB(i, j, value);
			}
	
		bi= resizeMethod(bi, 600, 500);
		return bi;
	}
	public BufferedImage getBorderedImage(BufferedImage image)
	{
		int W=image.getWidth()+30;
		int H=image.getHeight()+30;
		BufferedImage bi= new BufferedImage(W, H, image.getTransparency());
		Graphics2D g= bi.createGraphics();	
		g.drawImage(image, 15, 15, W-30, H-30, null);
		g.dispose();
		return bi;
		
	}
	/*public BufferedImage getBorderedImage(BufferedImage image)
	{
		int W=image.getWidth()+30;
		int H=image.getHeight()+30;
		image= resizeMethod(image, W, H);
		Graphics2D g= image.createGraphics();
		
		g.drawImage(image, 15, 15, image.getWidth()-15, image.getHeight()-15, null);
		g.dispose();
		return image;
		
	}*/
	
	
	public BufferedImage getCenteredImage(BufferedImage image1,BufferedImage image2,BufferedImage image3,BufferedImage image4, BufferedImage userimage)
	{
		userimage= resizeMethod(userimage, 300,300);
		BufferedImage bi=blendFourImages(image1, image2, image3, image4);
		int w1=150,h1=100, bp=30;
			
		//upper part
		for(int i=bp; i<userimage.getWidth()-bp; i++)
			{	double a=100;
				for(int j=0; j<bp; j++)
				{
					bi.setRGB(i+w1, j+h1, blendPixels(bi.getRGB(i+w1, j+h1), userimage.getRGB(i, j), a));
					a=a-3;
				}
			}
		//left side
			double a=100;
			for(int i=0; i<bp; i++)
			{	
				for(int j=0; j<userimage.getHeight(); j++)
				{
					bi.setRGB(i+w1, j+h1, blendPixels(bi.getRGB(i+w1, j+h1),userimage.getRGB(i, j), a));
					
				}
				a=a-3;
			}
		
			//right side
			double a1=100;
			for(int i=userimage.getWidth()-bp; i<userimage.getWidth(); i++)
			{	
				for(int j=0; j<userimage.getHeight(); j++)
				{
					bi.setRGB(i+w1, j+h1, blendPixels(userimage.getRGB(i, j),bi.getRGB(i+w1, j+h1), a1));
					
				}
				a1=a1-3;
			}
			//lower part
			for(int i=bp; i<userimage.getWidth()-bp; i++)
			{	
				double a2=100;
				for(int j=userimage.getHeight()-bp; j<userimage.getHeight(); j++)
				{
					bi.setRGB(i+w1, j+h1, blendPixels(userimage.getRGB(i, j),bi.getRGB(i+w1, j+h1), a2));
					a2=a2-3;
				}
			}
			
			for(int i=bp; i<userimage.getWidth()-bp;i++)
				for(int j=bp; j< userimage.getHeight()-bp; j++)
					bi.setRGB(i+w1, j+h1, userimage.getRGB(i, j));
			
			return bi;
		
	}
	
	
	
}