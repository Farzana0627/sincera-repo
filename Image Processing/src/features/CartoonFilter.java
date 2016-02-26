package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartoonFilter {
	ReadImage readimage;
	WriteImage writeImage;
	int height, width;
	private double[][] blue;
	private double[][] green;
	private double[][] red;
	//start constructor
	public CartoonFilter(File file)	throws IOException {
		// TODO Auto-generated constructor stub

		readimage=new ReadImage(file);
		height=readimage.getHeight();
		width= readimage.getWidth();
		blue= new double[height][width];
		green=new double[height][width];
		red=new double[height][width];
		writeImage=new WriteImage(readimage);
	
	}//end constructor
	
	public void Median() throws IOException 
	{
		
		int filterHeight=5,filterWidth= 5;
			
		for(int y = 0; y < height; y++) 
			    for(int x = 0; x < width; x++) 
			    { 
			        int r = 0, g = 0, b = 0; 
			        List<Integer> Rlist= new ArrayList<Integer>();
			        List<Integer> Glist= new ArrayList<Integer>();
			        List<Integer> Blist= new ArrayList<Integer>();
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + width) % width; 
			            int imageY = (y - filterHeight / 2 + filterY + height) % height; 
			            
			            r = (int)readimage.getRed(imageY, imageX); 
			            g = (int)readimage.getGreen(imageY, imageX); 
			            b = (int)readimage.getBlue(imageY, imageX); 
			            System.out.println(r+" "+g+" "+b);
			            Rlist.add(r);
			            Glist.add(g);
			            Blist.add(b);
			        } 
			        Collections.sort(Rlist);
			        Collections.sort(Glist);
			        Collections.sort(Blist);
			        //truncate values smaller than zero and larger than 255 
			        blue[y][x] =Blist.get((int)(Blist.size()-1)/2); 
			        green[y][x] =Glist.get((int)(Glist.size()-1)/2);  
			        red[y][x] =Rlist.get((int)(Rlist.size()-1)/2); 
			        System.out.println(r+" "+g+" "+b);
			        writeImage.write((int)blue[y][x],(int) green[y][x], (int)red[y][x]);
			    } 
				
		}
	public void Sobel()throws IOException
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

		int filterHeight=3,filterWidth= 3;
		
		
			  for(int y = 0; y < height; y++) {
				    for(int x = 0; x < width; x++) 
				    { 
				    	int r = 0, g = 0, b = 0,Gx=0,Gy=0,G=0;  
				    
				        //multiply every value of the filter with corresponding image pixel 
				        for(int filterY = 0; filterY < filterHeight; filterY++) {
				        	for(int filterX = 0; filterX < filterWidth ; filterX++) 
				        	{ 
				        		int imageX = (x - filterWidth / 2 + filterX + width) % width; 
				        		int imageY = (y - filterHeight / 2 + filterY + height) % height; 
				        		Color c= new Color((int)red[imageY][imageX],(int) green[imageY][imageX],(int) blue[imageY][imageX]);
				            	Gx += c.getRGB() * filterx[filterX][filterY]; 
				         
				        	}   
				        }
				    
				        for(int filterY = 0; filterY < filterHeight; filterY++) {
					        for(int filterX = 0; filterX < filterWidth ; filterX++) 
					        { 
					            int imageX = (x - filterWidth / 2 + filterX + width) % width; 
					            int imageY = (y - filterHeight / 2 + filterY + height) % height; 
					            Color c= new Color((int)red[imageY][imageX], (int)green[imageY][imageX], (int)blue[imageY][imageX]);
					            Gy +=  c.getRGB() * filtery[filterX][filterY]; 
					         
					        }
				        }
			        	
				       if(Gx!=0) {
				    	   G=(int) (Math.abs(Gx)+Math.abs(Gy));
				    	   System.out.println(G);
				       }
				    		 
	        	
					   Color c= new Color(G);
					  
					   blue[y][x]=c.getBlue();
					   green[y][x]=c.getGreen();
					   red[y][x]=c.getRed();
					   System.out.println(b+" "+g+" "+r);
					  // writeImage.write((int)blue[y][x],(int) green[y][x], (int)red[y][x]);
				    }
			    
			 }
		}
		public void DilationMethod() throws IOException {
			double filter [][]=	{ 
					{0, 1},
					{1, 1}
			};
			int filterHeight=2,filterWidth= 2;
			/*double filter [][]=	{ 
			        {0,0,1,0,0},
			        {0,1,1,1,0},
			        {1,1,1,1,1},
			        {0,1,1,1,0},
			        {0,0,1,0,0}
			};
				int filterHeight=5,filterWidth= 5;
			*/
				
			  for(int y = 0; y < height; y++) 
				    for(int x = 0; x < width; x++) 
				    { 
				        int v=0; 
				        List<Integer> list= new ArrayList<>();
				        //multiply every value of the filter with corresponding image pixel 
				        for(int filterY = 0; filterY < filterHeight; filterY++) 
				        for(int filterX = 0; filterX < filterWidth ; filterX++) 
				        { 
				            int imageX = (x - filterWidth / 2 + filterX + width) % width; 
				            int imageY = (y - filterHeight / 2 + filterY + height) % height; 
				  
				            if(filter[filterX][filterY]==1)
				            {
				            	Color c= new Color((int)red[imageY][imageX], (int)green[imageY][imageX],(int) blue[imageY][imageX]);
				            	list.add(c.getRGB());
				            }
				        } 
				         v=Collections.max(list);
				         Color c= new Color(v);
				         blue[y][x]=c.getBlue();
				         green[y][x]=c.getGreen();
				         red[y][x]=c.getRed();
				         writeImage.write((int)blue[y][x],(int) green[y][x], (int)red[y][x]);
				    } 
					
		}
		public void Quantize() throws IOException
		{
			
			int a=24;
				
			for(int y = 0; y < height; y++) 
				    for(int x = 0; x < width; x++) 
				    { 
				        int r = 0, g = 0, b = 0; 
				   
				            red[y][x] = (int)(red[y][x]/24)*24; 
				            green[y][x] = (int)(green[y][x]/24)*24; 
				            blue[y][x] = (int)(blue[y][x]/24)*24; 
				            //truncate values smaller than zero and larger than 255 
							blue[y][x] = Math.min((Math.max((int) b  , 0)), 255); 
							green[y][x] = Math.min((Math.max((int)g , 0)), 255);  
							red[y][x] = Math.min((Math.max((int) r  , 0)), 255);
						    System.out.println(r+" "+g+" "+b);
						    writeImage.write((int)blue[y][x],(int) green[y][x], (int)red[y][x]);
				        } 
				
				   
				      
			 } 
		
		public void cartoon() throws IOException{
			Median();
			Sobel();
			DilationMethod();
			Quantize();
		}
			
			

}
