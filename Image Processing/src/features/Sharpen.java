package features;

import java.io.File;
import java.io.IOException;
import ioRelatedClasses.*;
public class Sharpen {
	ReadImage readimage;
	WriteImage writeImage;
	//start constructor
	public Sharpen(File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
	
	}//end constructor
	
	public void SharpeningMethod() throws IOException
	{
		double filter [][]=	{
				{-1, -1, -1},
			    {-1,  9, -1},
			    {-1, -1, -1}
			};
		
		int filterHeight=3,filterWidth= 3;
		double factor = 1.0,bias = 0.0;
			
		  for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
			            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
			            r += readimage.getRed(imageY, imageX) * filter[filterX][filterY]; 
			            g += readimage.getGreen(imageY, imageX)* filter[filterX][filterY]; 
			            b += readimage.getBlue(imageY, imageX) * filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        b = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        g = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        r = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        writeImage.write((int)b, (int)g, (int)r);
			    } 
		
	}
	public void subtleSharp() throws IOException
	{
		double filter [][]=	{

			    {-1, -1, -1, -1, -1},
			    {-1,  2,  2,  2, -1},
			    {-1,  2,  8,  2, -1},
			    {-1,  2,  2,  2, -1},
			    {-1, -1, -1, -1, -1},
			};
		
		int filterHeight=3,filterWidth= 3;
		double factor = 1.0/8.0,bias = 0.0;
			
		  for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
			            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
			            r += readimage.getRed(imageY, imageX) * filter[filterX][filterY]; 
			            g += readimage.getGreen(imageY, imageX)* filter[filterX][filterY]; 
			            b += readimage.getBlue(imageY, imageX) * filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        b = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        g = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        r = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        writeImage.write((int)b, (int)g, (int)r);
			    } 
		
	}
	public void EdgedSharpen() throws IOException
	{
		double filter [][]=	{
				{1,  1,  1},
				{1, -7,  1},
				{1,  1,  1}
			};
		
		int filterHeight=3,filterWidth= 3;
		double factor = 1.0,bias = 0.0;
			
		  for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
			            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
			            r += readimage.getRed(imageY, imageX) * filter[filterX][filterY]; 
			            g += readimage.getGreen(imageY, imageX)* filter[filterX][filterY]; 
			            b += readimage.getBlue(imageY, imageX) * filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        b = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        g = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        r = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        writeImage.write((int)b, (int)g, (int)r);
			    } 
		
	}
}
