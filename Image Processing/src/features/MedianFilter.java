package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFilter {
	ReadImage readimage;
	WriteImage writeImage;
	//start constructor
	public MedianFilter(File file)	throws IOException {
		// TODO Auto-generated constructor stub

		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		Median();
	
	}//end constructor
	
	private void Median() throws IOException
	{
		
		int filterHeight=5,filterWidth= 5;
			
		for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        int r = 0, g = 0, b = 0; 
			        List<Integer> Rlist= new ArrayList<Integer>();
			        List<Integer> Glist= new ArrayList<Integer>();
			        List<Integer> Blist= new ArrayList<Integer>();
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
			            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
			            
			            r = (int)readimage.getRed(imageY, imageX); 
			            g = (int)readimage.getGreen(imageY, imageX); 
			            b = (int)readimage.getBlue(imageY, imageX); 
			          //  System.out.println(r+" "+g+" "+b);
			            Rlist.add(r);
			            Glist.add(g);
			            Blist.add(b);
			        } 
			        Collections.sort(Rlist);
			        Collections.sort(Glist);
			        Collections.sort(Blist);
			        //truncate values smaller than zero and larger than 255 
			        b =Blist.get((int)(Blist.size()-1)/2); 
			        g =Glist.get((int)(Glist.size()-1)/2);  
			        r =Rlist.get((int)(Rlist.size()-1)/2); 
			     //   System.out.println(r+" "+g+" "+b);
			        writeImage.write((int)b, (int)g, (int)r);
			    } 
				
		}
}


