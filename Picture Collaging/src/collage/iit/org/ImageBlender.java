package collage.iit.org;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageBlender  {
	int newHeight, newWidth;
	
	int BlendedImagePixels[][];

	public ImageBlender( )  {
	
		// TODO Auto-generated constructor stub
	
	}
	
	public int blendPixels(int rgb1, int rgb2, double a)
	{
		double b=(100-a);
		Color c1= new Color(rgb1);
		Color c2= new Color(rgb2);
		float Blue=(float)((c1.getBlue()*a)+ (c2.getBlue()*b))/100;
		float Green=(float)((c1.getGreen()*a)+ (c2.getGreen()*b))/100;
		float Red=(float)((c1.getRed()*a)+ (c2.getRed()*b))/100;
		Color c= new Color(Red, Green, Blue);
		return c.getRGB();
		
	}
	public BufferedImage blendImages(ImageReader img1, ImageReader img2 )
	{
		newWidth= 700;
		newHeight=300;
		BufferedImage image1=img1.resizeMethod(400, 300);
		Color c= new Color(image1.getRGB(2, 3));
		System.out.println(""+image1.getHeight()+" "+ c.getRGB());
		
		BufferedImage image2=img2.resizeMethod(400,300);
		int w1=300,w2=400;
		
		BufferedImage bi= new BufferedImage(newWidth, newHeight, img1.type);
		for(int i=0; i< w1; i++)
			for(int j=0; j< newHeight; j++)
			{
				BlendedImagePixels[i][j]=image1.getRGB(i, j);
				bi.setRGB(i, j,BlendedImagePixels[i][j]);
			}
		
		double a=100;
		for(int i= w1; i< w2; i++)
		{
			
			for(int j=0; j< newHeight; j++)
			{	

				BlendedImagePixels[i][j]= blendPixels(image1.getRGB(i, j), image2.getRGB(i-300,j),a);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
				
			}
			a=a-1;
		}
		for(int i= w2; i< newWidth; i++)
			for(int j=0; j< newHeight; j++)
			{
				BlendedImagePixels[i][j]=(int) image2.getRGB(i-100, j);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
			}
		return bi;
	}
	/*public BufferedImage blendImages(ImageReader img1,ImageReader img2,ImageReader img3,ImageReader img4)
	{
	
		newHeight=500;
		newWidth= 700;
		BufferedImage image1=img1.resizeMethod(400,300);
		image1.readImage(image1.getBufferedImage());
		BufferedImage image2=img2.resizeMethod(400,300);
		BufferedImage image3=img3.resizeMethod(400,300);
		BufferedImage image4=img4.resizeMethod(400,300);
		//System.out.println(""+ image1.height+" "+image3.width);
		int w1=300;
		int w2=400;
		int h1=200;
		int h2=300;
		BlendedImagePixels= new int[newWidth][newHeight];
		
		BufferedImage bi= new BufferedImage(newWidth, newHeight, img1.type);
		for(int i=0; i<w1 ; i++)
			for(int j=0; j< h1; j++)
			{
				BlendedImagePixels[i][j]=image1.getRGB(i, j);
				bi.setRGB(i, j,BlendedImagePixels[i][j]);
			}
		
		for(int i=w2; i< newWidth; i++)
			for(int j=0; j< h1; j++)
			{
				BlendedImagePixels[i][j]=image2.getRGB(i-300, j);
				bi.setRGB(i, j,BlendedImagePixels[i][j]);
			}
		
		for(int i=0; i<w1 ; i++)
			for(int j=h2; j< newHeight; j++)
			{
				BlendedImagePixels[i][j]=image3.getRGB(i, j-200);
				bi.setRGB(i, j,BlendedImagePixels[i][j]);
			}
		for(int i=w2; i<newWidth ; i++)
			for(int j=h2; j<newHeight; j++)
			{
				BlendedImagePixels[i][j]=(int)image4.getRGB(i-300, j-200);
				bi.setRGB(i, j,BlendedImagePixels[i][j]);
			}
		//blending of image1 and image2
		double a1=100;
		for(int i=w1; i< w2; i++)
		{
			for(int j=0; j<h1; j++)
			{	

				BlendedImagePixels[i][j]=(int) blendPixels(image1.getRGB(i, j), image2.getRGB(i-300,j),a1);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
				
			}
			a1=a1-1;
		}
		
		// blending of image1 and image3
		double a2=100;
		for(int i=0; i< w1; i++)
		{
			for(int j=h1; j< h2; j++)
			{	

				BlendedImagePixels[i][j]= (int)blendPixels(image1.getRGB(i, j), image3.getRGB(i,j-200),a2);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
				
			}
			a2=a2-1;
		}
		//blending of image3 and image4
		double a3=100;
		for(int i=w1; i< w2; i++)
		{
			for(int j=h2; j<newHeight; j++)
			{	

				BlendedImagePixels[i][j]=(int) blendPixels(image3.getRGB(i, j-200), image4.getRGB(i-300,j-200),a3);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
				
			}
			a3=a3-1;
		}
		//blending of image2 and image4 
		double a4=100;
		for(int i=w2; i< newWidth; i++)
		{
			for(int j=h1; j< h2; j++)
			{	

				BlendedImagePixels[i][j]=(int) blendPixels(image4.getRGB(i-300, j-200), image2.getRGB(i-300,j-100),a4);
				bi.setRGB(i, j, BlendedImagePixels[i][j]);
				
			}
			a4=a4-1;
		}
		
		
		return bi;
	}
	*/
}