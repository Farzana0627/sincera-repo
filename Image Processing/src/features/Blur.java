package features;

import java.io.File;
import java.io.IOException;
import ioRelatedClasses.*;
public class Blur  {
	
			
			ReadImage readimage;
			WriteImage writeImage;
			//start constructor
			public Blur(File file) throws IOException{
				readimage=new ReadImage(file);
				writeImage=new WriteImage(readimage);
			
			}//end constructor
			
			public void SoftBlur() throws IOException
			{
				double filter [][]=	{
					     {0.0, 0.2,  0.0},
					     {0.2, 0.2,  0.2},
					     {0.0, 0.2,  0.0}
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
			
			public void StrongBlur() throws IOException
			{
				double filter [][]=	{
						  	{0, 0, 1, 0, 0},
						    {0, 1, 1, 1, 0},
						    {1, 1, 1, 1, 1},
						    {0, 1, 1, 1, 0},
						    {0, 0, 1, 0, 0},
					};
				
				int filterHeight=5,filterWidth= 5;
				double factor = 1.0/13.0,bias = 0.0;
					
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
			public void MotionBlur() throws IOException
			{
				double filter [][]=	{
							{1, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 1, 0, 0, 0, 0, 0, 0, 0},
						    {0, 0, 1, 0, 0, 0, 0, 0, 0},
						    {0, 0, 0, 1, 0, 0, 0, 0, 0},
						    {0, 0, 0, 0, 1, 0, 0, 0, 0},
						    {0, 0, 0, 0, 0, 1, 0, 0, 0},
						    {0, 0, 0, 0, 0, 0, 1, 0, 0},
						    {0, 0, 0, 0, 0, 0, 0, 1, 0},
						    {0, 0, 0, 0, 0, 0, 0, 0, 1},
					};
				
				int filterHeight=9,filterWidth= 9;
				double factor = 1.0/9.0,bias = 0.0;
					
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



