package features;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import java.util.Map;

import java.util.TreeMap;




import ioRelatedClasses.*;
public class OilPaint {
	ReadImage readImage;
	WriteImage writeImage;
	int filterHeight=5,filterWidth= 5,radius = 6,intensity = 25;
	int [][] arrayOfIntensities= new int[filterHeight][filterWidth];
	List<Integer> listOfValues= new ArrayList<>();
	Map <Integer, Integer> IntensityMap= new TreeMap<>();
	
	//start constructor
	public OilPaint(File file) throws IOException{
		readImage= new ReadImage(file);
		writeImage= new WriteImage(readImage);
		oilPaintMethod();
	
	}//end constructor
	
	public void oilPaintMethod() throws IOException
	{
		int i=0;
		int r = 0, g = 0, b = 0; 
		int[] sblue= new int[intensity+1];
		int[] sgreen=new int[intensity+1];
		int[] sred=new int[intensity+1];
		int[] count=new int[intensity+1];
		for(int k=0; k<intensity+1; k++)
		{
			 sblue[k]=0;
			 sgreen[k]=0;
			 sred[k]=0;
		}
		  for(int y = 0; y < readImage.getHeight(); y++) 
			    for(int x = 0; x <readImage.getWidth(); x++) 
			    { 
			        
			    	int maxFrequency=0,currentIntensity=0, maxIndex=0;
			        //multiply every value of the filter with corresponding image pixel 
			        for(int h = 0; h < filterHeight; h++) 
			        for(int w = 0; w < filterWidth ; w++) 
			        { 
			        	
			            int imageX = (int)(x - filterWidth / 2 + w + readImage.getWidth()) % readImage.getWidth(); 
			            int imageY = (int)(y - filterHeight / 2 + h + readImage.getHeight()) % readImage.getHeight(); 
			            int sum= (int)(readImage.getBlue(imageY, imageX)+readImage.getGreen(imageY, imageX)+readImage.getRed(imageY, imageX));
			           
			            currentIntensity=(int) ((((int)(sum/3))*intensity)/255); 
			            if(currentIntensity>10) currentIntensity=10;
			          
			       //     System.out.println(currentIntensity);
			        
			            
			            sblue[currentIntensity]+=readImage.getBlue(imageY, imageX);
			            
			            sgreen[currentIntensity]+=readImage.getGreen(imageY, imageX);
			            sred[currentIntensity]+=readImage.getRed(imageY, imageX);
			            count[currentIntensity]=count[i]+1;
			            
			           if(count[currentIntensity]>maxFrequency)
			           {
			        	   maxFrequency=count[currentIntensity];
			        	   maxIndex=currentIntensity;
			           }
			        } 
			        
			      //  System.out.println(sblue[finalIntensity]);
			        //truncate values smaller than zero and larger than 255 
			        b= Math.min((Math.max((int)(sblue[ maxIndex]/maxFrequency) , 0)), 255); 
			        g = Math.min((Math.max((int)(sgreen[ maxIndex]/maxFrequency) , 0)), 255);  
			        r = Math.min((Math.max((int)(sred[  maxIndex]/maxFrequency) , 0)), 255); 
			        writeImage.write((int)b, (int)g, (int)r);
			     
			    } 
		
	}	
	
}
