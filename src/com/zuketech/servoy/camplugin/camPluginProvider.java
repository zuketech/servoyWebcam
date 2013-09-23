/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuketech.servoy.camplugin;


//Import for Servoy Scripting Interface
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.servoy.j2db.scripting.IScriptObject;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * @author mccourt.coridngley@googlemail.com
 * @version 1.0
 *
 */
public class camPluginProvider implements IScriptObject{
//private static Webcam webcam = Webcam.getDefault();

    public Webcam getWebcam(){
    return Webcam.getDefault();
    }
    public Boolean js_open(){
        Webcam.setHandleTermSignal(true);
        return getWebcam().open();
    }
    
    public Boolean js_close(){
        return getWebcam().close();
    } 
    
    public Dimension[] js_getDimensions(){
        return getWebcam().getViewSizes();
    }
    
    public byte[] js_captureBytes(String fileName) throws IOException{   
        if(fileName!=null){
            BufferedImage image = getWebcam().getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( image, "PNG", baos );
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        }else{
            return null;
        }
    }
    public Boolean js_showWindow(){
        JFrame window = new JFrame("Test Webcam Panel");
        window.add(new WebcamPanel(Webcam.getDefault()));
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        return true;
    }
    public String js_captureImage(String fileName) throws IOException{   
        if(fileName!=null){
            fileName = fileName+"_snap.png";
        }else{
            fileName = "tmp_snap.png";
        }
        BufferedImage image = getWebcam().getImage();
        File file = new File(fileName+"_snap.png");
        ImageIO.write(image, "PNG", file);
        return file.getAbsolutePath();
    }
    public Boolean js_setCustomDimension(int a, int b){
       
        Dimension dim;
        Dimension[] allDims;
        allDims = getWebcam().getViewSizes();
        dim = new Dimension(a,b);
        allDims[0] = dim;
        getWebcam().setCustomViewSizes(allDims);
        getWebcam().setViewSize(dim);
        return true;
    }
    @Override
    public String getSample(String string) {
       		return null;
    }

    @Override
    public String getToolTip(String string) {
        		return null;
    }

    @Override
    public String[] getParameterNames(String string) {
       		return null;
    }

    @Override
    public boolean isDeprecated(String string) {
        return false;
    }

    @Override
    public Class<?>[] getAllReturnedTypes() {
       		return null;
    }
    
}
