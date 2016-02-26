/*
 * FILE: ReadImage.java
 * Description: Reads a BMP image File with the help of FileInputStream and calculates height, width, size; sets
 * 				individual color components in three 2D arrays.
 * Last Modified: 31.03.2015
 * 
 */

package ioRelatedClasses;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadImage {
	
	//instances of class
	File file;
	FileInputStream imgin;
	public int[] head;
	protected int height;
	protected int width;
	protected int size;
	protected int[][] blueComponent;
	protected int[][] greenComponent;
	protected int[][] redComponent;
	protected int[][] Pixels;
	WriteImage writeImage;
	
	//start constructor
	public ReadImage() throws IOException{
		file = new File("input.bmp");
		
		imgin = new FileInputStream(file);
		
		head = new int[54];
		readHeader();
		width = getDimension(18);
		height = getDimension(22);
		size = getDimension(34);
		blueComponent = new int[height][width];
		greenComponent = new int[height][width];
		redComponent = new int[height][width];
		Pixels= new int[height][width];
		//writeImage = new WriteImage(this);
		getColorComponents();
		imgin.close();
	}//end constructor
	
	public ReadImage(File file) throws IOException{

		imgin = new FileInputStream(file);
		
		head = new int[54];
		readHeader();
		width = getDimension(18);
		height = getDimension(22);
		size = getDimension(34);
		blueComponent = new int[height][width];
		greenComponent = new int[height][width];
		redComponent = new int[height][width];
		Pixels= new int[height][width];
		getColorComponents();
		imgin.close();
	}//end constructor
	
	
	//read the header bytes of the BMP file
	private void readHeader() throws IOException{
		for(int i = 0; i < 54; i++)
			head[i] = imgin.read();
		
	}//end method readHeader
	
	//calculate image width, height, size
	private int getDimension(int index){
		
		return	(int)((head[index] & 0xff) << 0 )
				|(int)((head[index + 1] & 0xff) << 8)
				|(int)((head[index + 2] & 0xff) << 16)
				|(int)((head[index + 3] & 0xff) << 24);
				
	}//end method getDimension
	
	//read the individual color values in each pixel
	private void getColorComponents() throws IOException{
	
		for(int i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				blueComponent [i][j] = imgin.read();
				greenComponent [i][j] = imgin.read();
				redComponent [i][j] = imgin.read();
				Color c= new Color (redComponent [i][j],greenComponent [i][j],blueComponent [i][j]);
				Pixels[i][j]=c.getRGB();
		
			}//end inner for
		}//end outer for
	}//end method getColorComponents
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getRGB(int red, int green, int blue)
	{
		Color c= new Color(red, green, blue);
		return c.getRGB();
	}
	
	public int getRGB(int x, int y)
	{
		 return Pixels[x][y];
	}
	
	public int getRed(int x, int y)
	{
		return redComponent[x][y];
	}
	
	public int getGreen(int x, int y)
	{
		return greenComponent[x][y];
	}
	
	public int getBlue(int x, int y)
	{
		return blueComponent[x][y];
	}
	
	
	

	public void setblueComponent(int x, int y, int value){
		blueComponent[x][y]=value;
	}
	
	public void setgreenComponent(int x, int y, int value){
		greenComponent[x][y]=value;
	}
	
	public void setredComponent(int x, int y, int value){
		redComponent[x][y]=value;
	}
	
	
}//end class 