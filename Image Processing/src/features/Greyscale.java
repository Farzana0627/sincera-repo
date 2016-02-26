/*
 * FILE: Greyscale.java
 * Description: Class Greyscale extends ReadImage class. Converts the color values to blue * 0.114
 * 				green*0.587 and red*0.299 basing on the percentage of colors in the image
 * 
 * Last Modified: 31.03.15
 */

package features;
import ioRelatedClasses.*;

import java.io.File;
import java.io.IOException;

public class Greyscale {
	
	ReadImage readimage;
	WriteImage writeImage;
	private int[][] blueComponent;
	private int[][] greenComponent;
	private int[][] redComponent;
	public int height,width;
	//start constructor
	public Greyscale(File file) throws IOException{
		
		readimage=new ReadImage(file);
		height=readimage.getHeight();
	    width=readimage.getWidth();
		blueComponent = new int[height][width];
		greenComponent = new int[height][width];
		redComponent = new int[height][width];
		
		writeImage=new WriteImage(readimage);
		greyScale();
	
	}//end constructor
	
	public void greyScale() throws IOException{
	
		for (int i = 0; i < readimage.getHeight(); i++) {
			for (int j = 0; j < readimage.getWidth() ; j++) {
				blueComponent[i][j] = (int)(readimage.getBlue(i, j)* 0.114);
				
				greenComponent[i][j]= (int)(readimage.getGreen(i, j) *0.587);
				redComponent[i][j]= (int)(readimage.getRed(i, j)*0.299);
				int sum=blueComponent[i][j]+greenComponent[i][j]+redComponent[i][j];
				writeImage.write(sum, sum, sum) ;
			}	
		}
	}
	
	public int[][] getblueComponent(){
		return blueComponent;
	}
	
	public int[][] getgreenComponent(){
		return greenComponent;
	}
	
	public int[][] getredComponent(){
		return redComponent;
	}
	
}//end class GreyScale