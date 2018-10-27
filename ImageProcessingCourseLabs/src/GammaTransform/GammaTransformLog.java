package GammaTransform;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GammaTransformLog {
	public static BufferedImage bi;
	public static double c=100;
	public static double gamma=2.5;
		
	public static void main(String[] args) throws IOException {
		File file= new File("gammaorg.png");
		bi= ImageIO.read(file);
		gammaTransMethod();
		ImageIO.write(bi, "png", new File("gammalog.png"));
	}
		
		//Make the gamma transformation
		public static void gammaTransMethod() throws IOException{
			
			for(int i = 0; i <bi.getHeight(); i++){
				for (int j = 0; j < bi.getWidth(); j++) {
					Color color= new Color(bi.getRGB(i, j));
					int blue = (int)(c*Math.log10(color.getBlue()+1));
					int green = (int)(c*Math.log10(color.getGreen()+1));
					int red = (int)(c*Math.log10(color.getRed()+1));
					color= new Color(red, green, blue);
					bi.setRGB(i, j,color.getRGB());
					
				}
			}
		}
}
