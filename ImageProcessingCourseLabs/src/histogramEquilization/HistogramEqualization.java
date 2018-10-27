package histogramEquilization;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistogramEqualization extends JFrame{
    HistogramEqualization(String in, String out){
        super("..:: Histogram Equalization ::..");
        try {
            this.setLayout(new GridLayout(2, 2, 10, 10));
            JLabel lbl1 = new JLabel("                               Input");
            JLabel lbl2 = new JLabel("                               Output");
            JPanel img1 = new JPanel();
            JPanel img2 = new JPanel();
            File f1 = new File(in);
            File f2 = new File(out);
            BufferedImage image1 = getGrayscaleImage(ImageIO.read(f1));
            img1.add(new JLabel(new ImageIcon(image1)));
            BufferedImage image2 = equalize(image1);
            ImageIO.write(image2, "png", f2);
            img2.add(new JLabel(new ImageIcon(image2)));
            this.add(lbl1);
            this.add(lbl2);
            this.add(img1);
            this.add(img2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    BufferedImage equalize(BufferedImage src){
        BufferedImage nImg = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster er = nImg.getRaster();
        int totpix= wr.getWidth()*wr.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                histogram[wr.getSample(x, y, 0)]++;
            }
        }
        
        int[] chistogram = new int[256];
        chistogram[0] = histogram[0];
        for(int i=1;i<256;i++){
            chistogram[i] = chistogram[i-1] + histogram[i];
        }
        
        float[] arr = new float[256];
        for(int i=0;i<256;i++){
            arr[i] =  (float)((chistogram[i]*255.0)/(float)totpix);
        }
        
        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                int nVal = (int) arr[wr.getSample(x, y, 0)];
                er.setSample(x, y, 0, nVal);
            }
        }
        nImg.setData(er);
        return nImg;
    }
    BufferedImage getGrayscaleImage(BufferedImage src) {
        BufferedImage gImg = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster gr = gImg.getRaster();
        for(int i=0;i<wr.getWidth();i++){
            for(int j=0;j<wr.getHeight();j++){
                gr.setSample(i, j, 0, wr.getSample(i, j, 0));
            }
        }
        gImg.setData(gr);
        return gImg;
    }

    public static void main(String[] args) {

  
            HistogramEqualization he = new HistogramEqualization("hist.jpg", "histequi.jpg");
            he.setSize(1024, 500);
            he.setVisible(true);
            he.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
