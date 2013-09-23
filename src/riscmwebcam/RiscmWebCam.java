package riscmwebcam;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;


/**
 *
 * @author mccourt cordingley
 */
public class RiscmWebCam {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Webcam webcam = Webcam.getDefault();
        Webcam.setHandleTermSignal(true);
        String fileName;
        try {
            fileName = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException caught");
            fileName = new Date().toString();
        }
        
        Dimension dim;
        Dimension[] allDims;
        allDims = webcam.getViewSizes();
        dim = new Dimension(2048,1536);
        System.out.println(allDims.length);
        allDims[0] = dim;
        webcam.setCustomViewSizes(allDims);
        webcam.setViewSize(dim);
        System.out.println(webcam.getViewSize().toString());
        webcam.open();
        BufferedImage image = webcam.getImage();
        ImageIO.write(image, "PNG", new File(fileName+"_snap.png"));
    }
}

