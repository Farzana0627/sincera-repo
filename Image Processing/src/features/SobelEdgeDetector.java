package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class SobelEdgeDetector {
	ReadImage readimage;
	WriteImage writeImage;
	//start constructor
	public SobelEdgeDetector(File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		getEdges();
	}//end constructor
	
	
	
	private void getEdges() throws IOException
	{
		double filterx [][]= {
							{-1, 0, 1}, 
							{-2, 0, 2}, 
							{-1, 0, 1}
							};
		double filtery [][]= {
				{1, 2, 1}, 
				{0, 0, 0}, 
				{-1, -2, -1}
				};
	/*	double filter[][]={
				{1 , 2 ,  0 , -2 , -1},
				{4 , 8 ,  0 , -8 , -4},
				{6 , 12 , 0 , -12 ,-6},
				{4 , 8 ,  0 , -8 , -4},
				{1 , 2 ,  0 , -2 , -1}
				};*/
		
		int filterHeight=3,filterWidth= 3;
		
			  for(int y = 0; y < readimage.getHeight(); y++) {
				    for(int x = 0; x < readimage.getWidth(); x++) 
				    { 
				    	int r = 0, g = 0, b = 0,sum,Gx=0,Gy=0,G=0;  
				    	
				        //multiply every value of the filter with corresponding image pixel 
				        for(int filterY = 0; filterY < filterHeight; filterY++) {
				        	for(int filterX = 0; filterX < filterWidth ; filterX++) 
				        	{ 
				        		int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
				        		int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
				        		b = (int)(readimage.getBlue(imageY, imageX)* 0.114);
								g = (int)(readimage.getGreen(imageY, imageX) *0.587);
								r = (int)(readimage.getRed(imageY, imageX)*0.299);
								sum=b+g+r;
								Color c= new Color(sum,sum,sum);
				        		Gx += c.getRGB() * filterx[filterX][filterY]; 
				         
				        	}   
				        }
				    
				        for(int filterY = 0; filterY < filterHeight; filterY++) {
					        for(int filterX = 0; filterX < filterWidth ; filterX++) 
					        { 
					            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
					            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
					    		b = (int)(readimage.getBlue(imageY, imageX)* 0.114);
								g = (int)(readimage.getGreen(imageY, imageX) *0.587);
								r = (int)(readimage.getRed(imageY, imageX)*0.299);
								sum=b+g+r;
								Color c= new Color(sum,sum,sum);
					            Gy += c.getRGB() * filtery[filterX][filterY]; 
					         
					        }
				        }
			        	
				       if(Gx!=0) {
				    	   G=(int) (Math.abs(Gx)+Math.abs(Gy));
				    	//   System.out.println(G);
				       }
				    		 
	        	
					   Color c= new Color(G);
					  
					   b=c.getBlue();
					   g=c.getGreen();
					   r=c.getRed();
					//   System.out.println(b+" "+g+" "+r);
					   writeImage.write((int)b, (int)g, (int)r);
				    }
			    
			 }
		}

	}



