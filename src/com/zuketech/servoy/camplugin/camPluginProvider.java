/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuketech.servoy.camplugin;


//Import for Servoy Scripting Interface
import com.github.sarxos.webcam.Webcam;
import com.servoy.j2db.scripting.IScriptObject;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author mccourt.coridngley@googlemail.com
 * @version 1.0
 *
 */
public class camPluginProvider implements IScriptObject{
private static Webcam webcam = Webcam.getDefault();

    public Boolean js_open(){
        Webcam.setHandleTermSignal(true);
        return webcam.open();
    }
    
    public Boolean js_close(){
        return webcam.close();
    } 
    
    public Dimension[] js_getDimensions(){
        return webcam.getViewSizes();
    }
    
    public byte[] js_captureBytes(String fileName) throws IOException{   
        if(fileName!=null){
            BufferedImage image = webcam.getImage();
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
    
    public String js_captureImage(String fileName) throws IOException{   
        if(fileName!=null){
            fileName = fileName+"_snap.png";
        }else{
            fileName = "tmp_snap.png";
        }
        BufferedImage image = webcam.getImage();
        File file = new File(fileName+"_snap.png");
        ImageIO.write(image, "PNG", file);
        return file.getAbsolutePath();
    }
    
    @Override
    public String getSample(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getToolTip(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getParameterNames(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isDeprecated(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class<?>[] getAllReturnedTypes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
