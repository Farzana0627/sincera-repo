package features;

import java.io.File;
import java.io.IOException;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;


public class MirrorImage  {
	ReadImage readimage;
	WriteImage writeImage;//start constructor
	public MirrorImage(File file) throws IOException {
		readimage=
				new ReadImage(file);
		writeImage=new WriteImage(readimage);

	
	}//end constructor
	
	
	
	public void getHorizontalMirrorImage() throws IOException
	{
		double b=0, g=0, r=0;
		
		for (int i =0  ; i<readimage.getHeight() ;i++)
		   for(int j=0; j<readimage.getWidth(); j++) 
		         {
		           b = readimage.getBlue(i,readimage.getWidth()- j-1);   //get the pixel above the horizontal axis
		           g = readimage.getGreen(i, readimage.getWidth()- j-1);
		           r = readimage.getRed(i, readimage.getWidth()- j-1);
		           	
		           writeImage.write((int)b,(int) g,(int) r); 
			   	   
		        }	        
	}
	public void getVerticalMirrorImage() throws IOException
	{
		//  double b1,g1,r1;
		  for (int i = readimage.getHeight()-1; i>=0;i--)
		   for( int j=readimage.getWidth()-1 ; j >=0 ; j--) {
		       {      
		    	   
		    	   double b1 = readimage.getBlue(i, j);   //get the pixel above the horizontal axis
		    	   double g1 = readimage.getGreen(i, j);
		    	   double r1 = readimage.getRed(i, j);
		           	
		         writeImage.write((int)b1, (int)g1, (int)r1); 
			   	   
		        }	        
		   }
	
	}
}//end class GreyScale