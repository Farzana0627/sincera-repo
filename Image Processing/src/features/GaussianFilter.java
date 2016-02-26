package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.io.File;
import java.io.IOException;

public class GaussianFilter {

	ReadImage readimage;
	WriteImage writeImage;
	//start constructor
	public GaussianFilter(File file)	throws IOException {
		// TODO Auto-generated constructor stub

		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		Gaussian();
	}//end constructor
	
	private void Gaussian() throws IOException
	{
		
			double filter [][]=	{
				     {2, 4, 5, 4, 2},
				     {4, 9, 12,9, 4},
				     {5, 12, 15,12,5},
				     {4, 9, 12,9,4},
				     {2, 4, 5,4,2},
				};
			int filterHeight=5,filterWidth= 5;
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
			            double value=filter[filterY][filterX]/115;
			            r += readimage.getRed(imageY, imageX)*value; 
			            g += readimage.getGreen(imageY, imageX)*value; 
			            b += readimage.getBlue(imageY, imageX)*value; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        b = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        g = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        r = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        writeImage.write((int)b, (int)g, (int)r);
			    } 
				
	
				
	}
}
