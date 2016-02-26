package features;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

import java.io.File;
import java.io.IOException;

public class HSV {
	ReadImage readimage;
	WriteImage writeImage;
	
	private int[][] blue;
	private int[][] green;
	private int[][] red;
	//start constructor
	public HSV(File file) throws IOException{
		readimage=new ReadImage(file);
		writeImage=new WriteImage(readimage);
		blue= new int[readimage.getHeight()][readimage.getWidth()];
		green=new int[readimage.getHeight()][readimage.getWidth()];
		red=new int[readimage.getHeight()][readimage.getWidth()];
		HSVMethod();
	}//end constructor
	
	
	public void Formulation() throws IOException
	{

		for(int y = 0; y < readimage.getHeight(); y++) 
		    for(int x = 0; x < readimage.getWidth(); x++) 
		    { 
		    	
		    	double r,g,b,rgb_max,rgb_min,H,S,V;
		    	//integer find min and max RGB value
		    	r=readimage.getRed(y, x);
		    	g=readimage.getGreen(y, x);
		    	b=readimage.getBlue(y, x);
		    	rgb_max= Math.max(r, g);
		    	rgb_max=Math.max(rgb_max, b);
		        
		        rgb_min= Math.min(r, g);
		        rgb_min=Math.min(rgb_min, b);
		       
		        //compute Value
		        V=rgb_max;
		        if(V==0.0)
		        {
		        	 writeImage.write(0, 0, 0);
		        	 return;
		        }
		      
		        
		     /* r=r/V;
		        g=g/V;
		        b=b/V;
		        
		        rgb_max= Math.max(r, g);
			    rgb_max=Math.max(rgb_max, b);
			       
			    rgb_min= Math.min(r, g);
			    rgb_min=Math.min(rgb_min, b);*/
			        
			    S=255*(rgb_max-rgb_min)/V;
			      
			    if(S==0.0)
			       H=0.0;
			    else
			    {
				    if (rgb_max == r) 
				         H = 0 + 43*(g - b)/(rgb_max - rgb_min);
				   
				    else if (rgb_max == g)
				         H = 85 + 43*(b - r)/(rgb_max - rgb_min);
				   
				    else 
				         H = 171 + 43*(r - g)/(rgb_max - rgb_min);
				   
			    }
			    System.out.println("HSV: "+H+" , "+S+" , "+V);
		        writeImage.write((int)H, (int)S, (int)V); 
		        }
	 }
		    
	/*	    double r1 = 0.0, g1 = 0.0, b1 = 0.0,cmax=0.0,cmin=0.0,d,H,S,V;
		    	
		    for(int y = 0; y < readimage.getHeight(); y++) 
			   for(int x = 0; x < readimage.getWidth(); x++) {
		    	
		    	r1 = readimage.getRed(y, x)/255;
		    	g1 = readimage.getGreen(y, x)/255;
		    	b1 = readimage.getBlue(y, x)/255;
		    	System.out.println(readimage.getRed(y, x)+","+readimage.getGreen(y, x)+","+readimage.getBlue(y, x));
		        //truncate values smaller than zero and larger than 255 
		        b1 = Math.min((Math.max(b1 , 0)), 255); 
		        g1 = Math.min((Math.max(g1 , 0)), 255);  
		        r1 = Math.min((Math.max(r1 , 0)), 255); 
		      //  System.out.printf("%f",r1);
		    	//System.out.printf("%f\n",r1);
		        
		    //   System.out.println(r1+","+g1+","+b1);
		        cmax= Math.max(r1, g1);
		        cmax=Math.max(cmax, b1);
		        
		        V=cmax;
		        if(V==0.0){
		        	writeImage.write(0, 0, 0); 
		        	return;
		        }
		        cmin= Math.min(r1, g1);
		        cmin=Math.min(cmin, b1);
		      //  System.out.println(cmin);
		        d=cmax-cmin;
		      //  System.out.println(cmax+","+cmin+","+"d: "+d);
		        if(d==0)
		        	H=0;
		        
		        else{
		        	if (cmax == r1)
		        
		        		H = 0 + 43*(g1 - b1)/(cmax - cmin);
					
		        	else if (cmax == g1) 
				
		        		H = 85 + 43*(b1 - r1)/(cmax - cmin);
				
		        	else 
		        		H = 171 + 43*(r1 - g1)/(cmax - cmin);
		        
		        }
		       // if(cmax==r1) H=(60* (g1-b1)/d)%6;
		       // else if(cmax==g1) H=(60* (b1-r1)/d)+2;
		       // else H=(60* (r1-g1)/d)+4;
		        
		        if(cmax==0)
		        	S=0;
		        else
		        	S=d/cmax;
		        
		      //  System.out.println("RGB: "+readimage.getRed(y, x)+","+readimage.getGreen(y, x)+","+readimage.getBlue(y, x));
		        System.out.println("HSV: "+H+","+S+","+V);
		        writeImage.write((int)H, (int)S, (int)V); 
		    }
		
	}*/
	public void HSVMethod() throws IOException
	{
		YIQ();
		HUE();
		Saturation();
		Value();
		BackToRGB();
	} 
	
	public void YIQ() throws IOException
	{
		double filter [][]=	{
				{0.299,	0.587,	0.114},	
				{0.596,	-0.274,	-0.321},	
				{0.211,	-0.523,	0.311}
			};
		
		int filterHeight=3,filterWidth= 3;
		double factor = 1.0,bias = 0.0;
		  for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            int imageX = (x - filterWidth / 2 + filterX + readimage.getWidth()) % readimage.getWidth(); 
			            int imageY = (y - filterHeight / 2 + filterY + readimage.getHeight()) % readimage.getHeight(); 
			            r += readimage.getRed(imageY, imageX) * filter[filterX][filterY]; 
			            g += readimage.getGreen(imageY, imageX)* filter[filterX][filterY]; 
			            b += readimage.getBlue(imageY, imageX) * filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        blue[y][x] = Math.min((Math.max((int)(factor * b + bias) , 0)), 255); 
			        green[y][x] = Math.min((Math.max((int)(factor * g + bias), 0)), 255);  
			        red[y][x] = Math.min((Math.max((int)(factor * r + bias) , 0)), 255); 
			        
			    } 			
	}
		
	public void HUE() throws IOException
	{
		double H=0,π=3.1416; 
		double U=Math.cos(H*π/180);
		double W=Math.sin(H*π/180);
		
		double filter [][]=	{
				{1,	0,	0},	
				{0, U, -W},	
				{0, W,  U}
			};
		
		int filterHeight=3,filterWidth= 3;

		  for(int y = 0; y < readimage.getHeight(); y++) 
			    for(int x = 0; x < readimage.getWidth(); x++) 
			    { 
			        double r = 0.0, g = 0.0, b = 0.0; 
			         
			        //multiply every value of the filter with corresponding image pixel 
			        for(int filterY = 0; filterY < filterHeight; filterY++) 
			        for(int filterX = 0; filterX < filterWidth ; filterX++) 
			        { 
			            r += red[y][x] * filter[filterX][filterY]; 
			            g += green[y][x]* filter[filterX][filterY]; 
			            b += blue[y][x]* filter[filterX][filterY]; 
			        } 
			         
			        //truncate values smaller than zero and larger than 255 
			        blue[y][x] = Math.min((Math.max((int)b, 0)), 255); 
			        green[y][x] = Math.min((Math.max((int)g , 0)), 255);  
			        red[y][x] = Math.min((Math.max((int)r , 0)), 255); 
			       
			    } 			
	}
	public void Saturation() throws IOException{
		
		double S=1.0;
		double filter [][]=	{
			{1,	0,	0},	
			{0,	S,	0},	
			{0,	0,	S}
		};
	
		int filterHeight=3,filterWidth= 3;
		for(int y = 0; y < readimage.getHeight(); y++) 
		    for(int x = 0; x < readimage.getWidth(); x++) 
		    { 
		        double r = 0.0, g = 0.0, b = 0.0; 
		         
		        //multiply every value of the filter with corresponding image pixel 
		        for(int filterY = 0; filterY < filterHeight; filterY++) 
		        for(int filterX = 0; filterX < filterWidth ; filterX++) 
		        { 

		            r += red[y][x] * filter[filterX][filterY]; 
		            g += green[y][x]* filter[filterX][filterY]; 
		            b += blue[y][x]* filter[filterX][filterY]; 
		        } 
		         
		        //truncate values smaller than zero and larger than 255 
		        blue[y][x] = Math.min((Math.max((int)b, 0)), 255); 
		        green[y][x] = Math.min((Math.max((int)g , 0)), 255);  
		        red[y][x] = Math.min((Math.max((int)r , 0)), 255); 
		    } 			
	}
	
	public void Value() throws IOException{
		
		double V=1.0;
		double filter [][]=	{
			{V,	0,	0},	
			{0,	V,	0},	
			{0,	0,	V}
		};
	
		int filterHeight=3,filterWidth= 3;
		
		for(int y = 0; y < readimage.getHeight(); y++) 
		    for(int x = 0; x < readimage.getWidth(); x++) 
		    { 
		        double r = 0.0, g = 0.0, b = 0.0; 
		         
		        //multiply every value of the filter with corresponding image pixel 
		        for(int filterY = 0; filterY < filterHeight; filterY++) 
		        for(int filterX = 0; filterX < filterWidth ; filterX++) 
		        { 

		            r += red[y][x] * filter[filterX][filterY]; 
		            g += green[y][x]* filter[filterX][filterY]; 
		            b += blue[y][x]* filter[filterX][filterY]; 
		        } 
		         
		        //truncate values smaller than zero and larger than 255 
		        blue[y][x] = Math.min((Math.max((int)b, 0)), 255); 
		        green[y][x] = Math.min((Math.max((int)g , 0)), 255);  
		        red[y][x] = Math.min((Math.max((int)r , 0)), 255); 
		    } 			
	}
	
     public void BackToRGB() throws IOException{

		double filter [][]=	{
			{1,	 0.956,	 0.621},	
			{1,	-0.272,	-0.647},
			{1,	-1.107,	 1.705},
		};
	
		int filterHeight=3,filterWidth= 3;
		for(int y = 0; y < readimage.getHeight(); y++) 
		    for(int x = 0; x < readimage.getWidth(); x++) 
		    { 
		        double r = 0.0, g = 0.0, b = 0.0; 
		         
		        //multiply every value of the filter with corresponding image pixel 
		        for(int filterY = 0; filterY < filterHeight; filterY++) 
		        for(int filterX = 0; filterX < filterWidth ; filterX++) 
		        { 

		            r += red[y][x] * filter[filterX][filterY]; 
		            g += green[y][x]* filter[filterX][filterY]; 
		            b += blue[y][x]* filter[filterX][filterY]; 
		        } 
		         
		        //truncate values smaller than zero and larger than 255 
		        b = Math.min((Math.max((int)g , 0)), 255);  
		        g = Math.min((Math.max((int)g , 0)), 255);  
		        r = Math.min((Math.max((int)r , 0)), 255); 
		        writeImage.write((int)b, (int)g, (int)r);
		    } 			
	}
	
	


}
