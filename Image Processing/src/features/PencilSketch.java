package features;


import java.io.File;
import java.io.IOException;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

public class PencilSketch {
	ReadImage readimage;
	int[][] blueComponent;
	int[][] greenComponent;
	int[][] redComponent;
	int[][] gaussian_blue;
	int[][] gaussian_green;
	int[][] gaussian_red;
	int[][] inv_blue;
	int[][] inv_green;
	int[][] inv_red;
	int height,width=0;
	WriteImage writeImage;
	
	public PencilSketch(File file) throws IOException{
		readimage= new ReadImage(file);
		height=readimage.getHeight();
		width= readimage.getWidth();
		blueComponent = new int[height][width];
		greenComponent = new int[height][width];
		redComponent = new int[height][width];
		inv_blue = new int[height][width];
		inv_green = new int[height][width];
		inv_red = new int[height][width];
		gaussian_blue = new int[height][width];
		gaussian_green = new int[height][width];
		gaussian_red = new int[height][width];
		
		writeImage = new WriteImage(readimage);
		pencilSketch();
	}//end constructor
	
	private void greyScale(){
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width ; j++) {
				int sum=(int)((readimage.getBlue(i, j)* 0.114)+(readimage.getGreen(i, j) *0.587)+(readimage.getRed(i, j)*0.299));

				blueComponent[i][j] = sum;	
				greenComponent[i][j]= sum;
				redComponent[i][j]= sum;
				
			}	
		}
	}
	private void invertImage(){
		//perform greyscale
		greyScale();
		//copy converted greyscale values
		

		
		for(int i = 0; i <height; i++){
			for(int j = 0; j < width; j++){
				inv_blue[i][j] = 255-blueComponent[i][j];
				inv_green[i][j] = 255 -greenComponent[i][j];
				inv_red[i][j] = 255 - redComponent[i][j];
			}//end inner for
		}//end for
	}//end method invertImage
	
	//apply Gaussian Blur
	private void applyGaussian(){
		final double[][] filter = {{0.026, 0.035, 0.039, 0.035, 0.026},
									{0.035, 0.047, 0.053, 0.047, 0.035},
									{0.039, 0.053, 0.058, 0.052, 0.039},
									{0.035, 0.047, 0.053, 0.047, 0.035},
									{0.026, 0.035, 0.039, 0.035, 0.026}};
		
		int filterHeight=5,filterWidth= 5;
		double factor = 1.0,bias = 0.0;
		  for(int y = 0; y <height; y++) 
			    for(int x = 0; x < width; x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + height) % width; 
			            int imageY = (y - filterHeight / 2 + filterY + height) % width; 
			            r += inv_red[imageY][imageX] * filter[filterX][filterY]; 
			            g += inv_green[imageY][imageX]* filter[filterX][filterY]; 
			            b += inv_blue[imageY][imageX] * filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        gaussian_blue[y][x] = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        gaussian_green[y][x] = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        gaussian_red[y][x] = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        
			    } 
	}//end method gaussian filter
	
	private void colorDodgeBlend() throws IOException{
		
		for(int i = 0; i <height; i++){
			for(int j = 0; j < width; j++){
				int blue = colorDodge( blueComponent[i][j],gaussian_blue[i][j]);
				int green = colorDodge(greenComponent[i][j],gaussian_green[i][j]);
				int red = colorDodge(redComponent[i][j],gaussian_red[i][j]);
				
				writeImage.write(blue, green, red);
			}
		}
	}
	
	private int colorDodge(int in1, int in2){
		double image = (double) in2;
		double mask = (double) in1;
		
		return (int)((image==255) ? image: Math.min(((long)mask << 8)/(255-image), 255));
	}
	
	private void pencilSketch() throws IOException{
		invertImage();
		applyGaussian();
		colorDodgeBlend();
	}
}

