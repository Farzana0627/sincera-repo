package features;
import java.io.File;
import java.io.IOException;

import ioRelatedClasses.*;


public class Posterization {

		ReadImage readimage;
		WriteImage writeImage;//start constructor
		public Posterization(File file) throws IOException{
			readimage=new ReadImage(file);
			writeImage=new WriteImage(readimage);
			
		}//end constructor
		
		
		public void Posterize(int modValue) throws IOException{
			
			
			int factor=(int)256/modValue;
			int range=(int)256/factor;
			System.out.println(range);
			int high=range;
			int low=0;
			double b, g, r;
			
			for (int i = 0; i < readimage.getHeight(); i++) {
				for (int j = 0; j < readimage.getWidth() ; j++) {
	
					b= readimage.getBlue(i, j);
					g= readimage.getGreen(i, j);
					r= readimage.getRed(i, j);
				
					while(high<256){
						if(b>=low && b< high)
						{
							b=low;
							break;
						}
						high=high+range; low=low+range;
					}
					high=range; low=0;
					while(high<256){
						if(g>=low && g< high)
						{
							g=low;
							break;
						}
						high=high+range; low=low+range;
					}
					high=range; low=0;
					while(high<256){
						if(r>=low && r< high)
						{
							r=low;
							break;
						}
						high=high+range; low=low+range;
					}
					writeImage.write((int)b,(int) g,(int)r) ;	
					}
					
					
					
					
				}	
		}
		
}//end class GreyScale

