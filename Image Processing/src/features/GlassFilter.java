package features;
import ioRelatedClasses.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GlassFilter {
	
		ReadImage readimage;
		WriteImage writeImage;
		int[][] blueComponent;
		int[][] greenComponent;
		int[][] redComponent;
		int height,width;
		//start constructor
		public GlassFilter(File file) throws IOException{
			
			readimage=new ReadImage(file);
			 height=readimage.getHeight();
			 width=readimage.getWidth();
			 blueComponent= new int[ height][width];
			 greenComponent= new int[ height][width];
			 redComponent= new int[ height][width];
			writeImage=new WriteImage(readimage);	
		}//end constructor
		
		
		
		public void glassFilter(int percent)throws IOException
		{
			
		//	System.out.println(readimage.getHeight()+" "+readimage.getWidth());
			int distance=percent, x_random=0, y_random=0;
			for (int i =0  ; i<readimage.getHeight();i++)
				   for( int j=0; j<readimage.getWidth() ; j++)
				   {
					   	x_random= xrandom(j+distance,j-distance);
					   	y_random= yrandom(i+distance,i-distance);
					   	blueComponent[i][j]= readimage.getBlue(y_random,x_random);
					   	greenComponent[i][j]= readimage.getGreen(y_random,x_random );
					   	redComponent[i][j]= readimage.getRed(y_random,x_random);
				   }
			
			for(int i=0; i< readimage.getHeight(); i++)
				for(int j=0; j< readimage.getWidth(); j++)
				{
					writeImage.write((int)blueComponent[i][j], (int)greenComponent[i][j],(int) redComponent[i][j]);
				}
		
		}
		
		public int xrandom(int high, int low)
		{
			if(high>(readimage.getWidth()-1)) high=readimage.getWidth()-1; 
			
			if(low<0) low=0; 
		//	System.out.println(high+" "+ low);
			
			Random r= new Random();
			int  rand;
			
			if(high==low)
				rand= r.nextInt(high); 
			else rand= r.nextInt(high-low)+low;
		 
		//	System.out.println(rand);
			return rand;
		}
		
		public int yrandom(int high, int low)
		{
			
			if( high> readimage.getHeight()-1) high= readimage.getHeight()-1;
			
			if(low<0) low=0; 
			//System.out.println(high+" "+ low);
			
			Random r= new Random();
			int  rand;
			
			if(high==low)
				rand= r.nextInt(high); 
			else rand= r.nextInt(high-low)+low;
		 
			//System.out.println(rand);
			return rand;
		}
		
		
		
		
}//end class GreyScale

