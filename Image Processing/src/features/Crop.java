package features;

import java.io.IOException;
import java.util.Arrays;

import ioRelatedClasses.ReadImage;
import ioRelatedClasses.WriteImage;

public class Crop {
	
	ReadImage readImage;
	WriteImage writeImage;
	
	public Crop() throws IOException{
		readImage = new ReadImage();
	}
	
	public void setDimension( int index, int value){
		 String dimension = String.format("%32s",Integer.toBinaryString(value));
		 
		dimension = dimension.replaceAll(" ", "0");
		char ch[] = dimension.toCharArray();
		
		int count = index;
		for(int i = ch.length-1; i >= 0; i-= 8){
			char[] ch2 = Arrays.copyOfRange(ch, i-7, i);
			//char[] ch3 = new char[ch2.length];
			String str = "";
			//int k = 0;
			for(int j = 0; j < ch2.length; j++){
				//ch3[k++]= ch2[j];
				//System.out.println(ch[j]);
				str += ch2[j];
			}
			readImage.head[count++] = Integer.parseInt(str);
		}
		
	}
	
	public void crop(int x, int y, int h, int w) throws IOException{
		
		int size = h*w;
		
		//set width
		setDimension(18, h);
		//set height
		setDimension(22, w);
		
		//set size
		setDimension(34, size);
		
		//initiate Write Image
		writeImage = new WriteImage(readImage);
		
		for(int i = y; i < h; i++){
			for(int j = x; j < w; j++){
				int blue = readImage.getBlue(i, j);
				int green = readImage.getGreen(i, j);
				int red = readImage.getRed(i, j);
				
				writeImage.write(blue, green, red);
			}
		}
	}
	
}
