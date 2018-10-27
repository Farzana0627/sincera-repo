package Lab1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;

public class Coins_Connectivity {
	static BufferedImage bufferedImage = null;
	static BufferedImage binaryImage=null;
	static int height=0, width=0;
	static int connectivity=8;
	
	public static void main(String[] args) throws IOException {

		try {
			bufferedImage = ImageIO.read(new File("coins.png"));
		} catch (IOException e) {
		}
		height= bufferedImage.getHeight();
		width= bufferedImage.getWidth();
		binaryImage=new BufferedImage(width+2, height+2, bufferedImage.getType());
		convertToBinary();		
		System.out.println("No of coins:"+getConnectedComponents());
		
	}
	
	public static void convertToBinary() throws IOException{
		
		for(int i=-1; i<width+1; i++){
			for(int j=-1; j<height+1; j++){
				if(i==-1 || j==-1 || i==width || j==height ){
					Color color= new Color( 0,0,0);
					binaryImage.setRGB(i+1, j+1,color.getRGB());
					continue;
				}
				int red=0, blue=0, green=0;
				
				Color c= new Color(bufferedImage.getRGB(i, j));
				
				if(c.getRed()<100 || c.getBlue()<100 ||c.getGreen()<100){
					red=0;
					blue=0;
					green=0;
				}else{
					red=255;
					blue=255;
					green=255;
				}
				
				Color c1= new Color(red,blue,green);
				binaryImage.setRGB(i, j,c1.getRGB());
				
				
			}
			}
		ImageIO.write(binaryImage, "jpg", new File("output.jpg"));

		}
	
	public static int getConnectedComponents() throws IOException{

		Stack<Point> stackOfConncetedPoints= null;
		int[][] visitedPoints= new int[width+2][height+2];
		int components=0;
		for( int i=0; i<width+2 ; i++){
			for (int j=0; j<height+2; j++){
		
				
					if(visitedPoints[i][j]==1){
						continue;
					}
					
					Color c= new Color(binaryImage.getRGB(i, j));
					
					
					if(c.getRed()==255){
						int maxX=0,maxY=0;
						int minX=width, minY=height;
						//System.out.println(i+" "+j);
						stackOfConncetedPoints= new Stack<Point> ();
						
						Point p= new Point(i,j);
						stackOfConncetedPoints.push(p);
						visitedPoints[i][j]=1;
						

						while(!stackOfConncetedPoints.isEmpty()){
			
						
							Point newP=stackOfConncetedPoints.pop();
							
							
							int X=newP.getX();
							int Y=newP.getY();
							if(minX>X){
								minX=X;
							}
							if(minY>Y){
								minY=Y;
							}
							if(maxX<X){
								maxX=X;
							}
							if(maxY<Y){
								maxY=Y;
							}
							//System.out.println(X+" "+Y);
							if(X!=0 && Y!=width+1 && Y!= 0 && Y!=height+1){
								for(int n=X-1; n<=X+1; n++){
									for(int m=Y-1; m<=Y+1; m++){
						
										p= new Point(n,m);					
										c= new Color(binaryImage.getRGB(n, m));																				
										if(c.getRed()==255 && visitedPoints[n][m]==0){																				
											
											visitedPoints[n][m]=1;
											stackOfConncetedPoints.push(p);														
										}
									}
								}
							}						
					
							}
					
					
							components++;
						
							
								cropImage("G://EclipseWorkspace//ConnectivityAlgorithm//output_words//"+components+".jpg", minX, minY, maxX, maxY);
			
						
					}		
				
							
			}
		}
		return components;
	}
	public static void cropImage(String outputImagePath, int minX, int minY,int maxX,int maxY) throws IOException{
       

       // BufferedImage resized= new BufferedImage(maxX-minX+1,maxY-minY+1,binaryImage.getType());
		
       // BufferedImage resized=bufferedImage.getSubimage(minX+1, minY+1, maxX-minX, maxY-minY);
       /* Graphics2D g= resized.createGraphics();
		g.drawImage(binaryImage, minY,minX,  maxY-minY+1,maxX-minX+1, null);
		g.dispose();
		ImageIO.write(resized, "jpg", outputStream);*/
        BufferedImage subimage = binaryImage.getSubimage(minX+1, minY+1, maxX-minX, maxY-minY);
        ImageIO.write(subimage, "jpg", new File(outputImagePath));

	}
}


