package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.io.File;
import java.io.IOException;

public class Bilateral {
	ReadImage readimage;
	WriteImage writeImage;
	int height, width;
	//start constructor
	public Bilateral(File file)	throws IOException {
		// TODO Auto-generated constructor stub

		readimage=new ReadImage(file);
		height=readimage.getHeight();
		width= readimage.getWidth();
		writeImage=new WriteImage(readimage);
	
	}//end constructor
	
	public void BilateralMethod() throws IOException
	{
		int kernelSize=7,sigma_spatial=100,sigma_Intensity=100;
		 double blue,green,red;
		
		 
		 for(int y = 0; y < height; y++) 
			    for(int x = 0; x < width; x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			        blue=readimage.getBlue(y, x);
			        green=readimage.getGreen(y, x);
			        red=readimage.getRed(y, x);
			        double sumWeight=0;
			        for(int filterY = 0; filterY < kernelSize; filterY++)
			        {
			        	int sizeY=filterY-kernelSize/2;
			        //	System.out.println(sizeY);
			        	for(int filterX = 0; filterX < kernelSize ; filterX++) 
			        	{ 
			        		
			        		int imageX = (x - kernelSize / 2 + filterX + width) % width; 
			        		int imageY = (y - kernelSize / 2 + filterY + height) % height; 
			        		
			        		int sizeX=filterX-kernelSize/2;
			        		//System.out.println(sizeX);
			        		double dist=Math.sqrt(sizeY*sizeY+sizeX*sizeX);
			        		//System.out.println(dist);
			        		double colourDist =Math.sqrt((readimage.getBlue(imageY, imageX)-blue)*(readimage.getBlue(imageY, imageX)-blue)+(readimage.getGreen(imageY, imageX)-green)*(readimage.getGreen(imageY, imageX)-green)+
			        				(readimage.getRed(imageY, imageX)-red)*(readimage.getGreen(imageY, imageX)-green));
			        		double curWeight=1/(Math.exp((dist/(sigma_spatial)*(dist/sigma_spatial)*.8)+((colourDist/sigma_Intensity)*(colourDist/sigma_Intensity)*.8)));
			        		sumWeight+=curWeight;
			        		b += curWeight*readimage.getBlue(imageY, imageX);
			        		g += curWeight*readimage.getGreen(imageY, imageX);
			        		r += curWeight*readimage.getRed(imageY, imageX);
			        	
			        	}
			        }
					b /= sumWeight;
	        		g /= sumWeight;
	        		r /= sumWeight;
	        		
	        		b = Math.min((Math.max((int)b , 0)), 255); 
				    g = Math.min((Math.max((int)g , 0)), 255);  
				    r = Math.min((Math.max((int)r , 0)), 255);
				    if(b==0) b=blue;
				    if(g==0) g=green;
				    if(r==0) r=red;
				   // System.out.println("before: "+blue+" "+green+" "+red);
				   // System.out.println(b+" "+g+" "+r);
	        		writeImage.write((int)b, (int)g, (int)r);
			    }
					        	
	}
}
