package collage.iit.org;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageReader {
	
	int width=200, height=200,type;
	int[][] Pixels ;
	byte [] arrayOfImageData;
	byte[] headerBytes= new byte[54];
	BufferedImage image;
	public ImageReader() {
		// TODO Auto-generated constructor stub
	
	}
	
	public ImageReader(BufferedImage bi)
	{
		image=bi;
		type= image.getType();
		this.readImage(image);
	}

	public ImageReader(String fileName)throws IOException
	{	
		
		File imgPath= new File (fileName);
		image= ImageIO.read(imgPath);
		type= image.getType();
		
		width=image.getWidth(); height= image.getHeight();
		this.arrayOfImageData= TakeByte(image);
		for(int i=0; i< 54; i++)
		{
			headerBytes[i]= arrayOfImageData[i];
		}
		this.Pixels= new int[width][height];
		for(int i=0; i<width;i++)
			for(int j=0; j<height; j++)
			{
				Color c= new Color(image.getRGB(i, j));
				Pixels[i][j]= c.getRGB();
			}
		
	}
			
	
	public void readImage(BufferedImage image)
	{
		width=image.getWidth(); height= image.getHeight();
		this.arrayOfImageData= TakeByte(image);
		for(int i=0; i< 54; i++)
		{
			headerBytes[i]= arrayOfImageData[i];
		}
		this.Pixels= new int[width][height];
		for(int i=0; i<width;i++)
			for(int j=0; j<height; j++)
			{
				Color c= new Color(image.getRGB(i, j));
				Pixels[i][j]= c.getRGB();
			}
		this.image= image;
	}
	public byte[] TakeByte(BufferedImage image)
	{
		WritableRaster raster= image.getRaster();
		DataBufferByte data= (DataBufferByte) raster.getDataBuffer();
		return data.getData();
	}
	
	public BufferedImage resizeMethod(int width, int height)
	{
	
		BufferedImage resized= new BufferedImage(width,height,this.image.getType());
		Graphics2D g= resized.createGraphics();
		g.drawImage(this.image, 0, 0, width, height, null);
		g.dispose();
	
		return resized;
	}
	
	public BufferedImage getBufferedImage()
	{
		BufferedImage image= new BufferedImage(this.width, this.height, this.type);
		Graphics2D g= image.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		return image;
	}
	
	public BufferedImage getBlankImage(int Width, int Height) 
	{
		BufferedImage bi= new BufferedImage(Width, Height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g= bi.createGraphics();
	//	g.create();
		g.setBackground(Color.BLACK);
		g.dispose();
		return bi;
	}
	
	public int getBlue(int rgb)
	{
		Color c= new Color(rgb);
		return c.getBlue();
	}
	
	public int getGreen(int rgb)
	{
		Color c= new Color(rgb);
		return c.getGreen();
	}
	
	public int getRed(int rgb)
	{
		Color c= new Color(rgb);
		return c.getRed();
	}

	/*public int getRGB(int red, int green, int blue)
	{
		Color c= new Color(red, green, blue);
		return c.getRGB();
	}*/
	
	public int getPixelvalue(int x, int y)
	{
		return Pixels[x][y];
	}
	
	public List<Integer> getOneDimensionalArrayList()
	{
		List<Integer> pixels= new ArrayList<>();
		for(int i=0; i<width; i++ )
			for(int j=0; j<height; j++)
				pixels.add(Pixels[i][j]);
		return pixels;
	}
	
	public int getMin(int...r)
	{
		List<Integer> pixels= new ArrayList<>();
		for(int a: r)
			pixels.add(a);
			
		return Collections.min(pixels);
	}
	
	public int getMax(int...r)
	{
		List<Integer> pixels= new ArrayList<>();
		for(int a: r)
			pixels.add(a);
		return Collections.max(pixels);
	}
	public BufferedImage getBorderedImage(ImageReader image)
	{
		ImageReader BlankImage= new ImageReader();
		int newWidth=image.width+40;
		int newHeight= image.height+40;
		BufferedImage bi= BlankImage.getBlankImage(newWidth, newHeight);
		for(int i=0; i<image.width; i++)
			for(int j=0; j<image.height; j++)
			{
				bi.setRGB(i+20, j+20, image.getPixelvalue(i, j));
			}
		return bi;
		
	}
	
}

