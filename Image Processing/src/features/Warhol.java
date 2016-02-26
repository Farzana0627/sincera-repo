package features;

import java.io.File;
import java.io.IOException;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

public class Warhol {

		
		ReadImage readimage;
		WriteImage writeImage;
		//start constructor
		public Warhol(File file) throws IOException{
			readimage=new ReadImage(file);
			writeImage=new WriteImage(readimage);
			
		
		}
			
			
			public void WarholEffect(int modValue) throws IOException{
				
				
				int factor=(int)256/modValue;
				int range=(int)256/factor;
				System.out.println(range);
				int high=range;
				int low=0;
				int b=0, g=0, r=0;
				
				for (int i = 0; i < readimage.getHeight(); i++) {
					for (int j = 0; j < readimage.getWidth() ; j++) {
		
						b=readimage.getBlue(i, j);
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
						writeImage.write( b, g,r) ;	
						}
						
						
						
						
					}	
			}
			
	}//end class Warhol



