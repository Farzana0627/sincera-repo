package features;


import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;





	public class Solarize {
		ReadImage readimage;
		WriteImage writeImage;//start constructor
		public Solarize(File file) throws IOException{
			readimage=new ReadImage(file);
			writeImage=new WriteImage(readimage);
			
		
		}//end constructor
		
		
		public void solarizeMethod(int bthreshold, int gthreshold, int rthreshold) throws IOException
		{
			double b, g, r;
			
			for (int i =0  ; i<readimage.getHeight() ;i++)
			   for(int j=0; j<readimage.getWidth(); j++) 
			   {
			       b = readimage.getBlue(i,j);   //get the pixel above the horizontal axis
			       g = readimage.getGreen(i, j);
			       r = readimage.getRed(i, j);
			           
			       if(b<bthreshold) b=255-b;
			       if(g<gthreshold) g=255-g;
			       if(r<rthreshold) r=255-r;
			           
			       writeImage.write((int)b,(int) g,(int) r); 
				   	   
			   }	
		}
	}//end class GreyScale