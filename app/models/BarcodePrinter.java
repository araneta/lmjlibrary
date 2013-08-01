package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.java2d.Java2DCanvasProvider;

import play.Logger;

import javax.imageio.ImageIO;

public class BarcodePrinter {
	public static void print(String code,String filePath){
		Save_image(getBarcode(code, new Code128Bean()),filePath);
	}
	private static void Save_image(Image image,String filePath)
	{
	    try 
	    {
	        BufferedImage bi = (BufferedImage) image;
	        File outputfile = new File(filePath);
	        ImageIO.write(bi, "png", outputfile);
	    } catch (IOException e) 
	    {
	    	Logger.info(e.getMessage());
	    }
	}
	private static Image getBarcode(String value, AbstractBarcodeBean barcode) {	       
        barcode.setModuleWidth(1.0); 
        barcode.setBarHeight(40.0);
        barcode.setFontSize(10.0);
        barcode.setQuietZone(10.0);
        barcode.doQuietZone(true);                
        BarcodeDimension dim = barcode.calcDimensions(value);
        int width = (int) dim.getWidth(0) + 20;
        int height = (int) dim.getHeight(0);        
        
        BufferedImage imgtext = new BufferedImage(width, height,  BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgtext.createGraphics();
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        g2d.setColor(Color.BLACK);
        
        try {
            barcode.generateBarcode(new Java2DCanvasProvider(g2d, 0), value);
        } catch (IllegalArgumentException e) {
            g2d.drawRect(0, 0, width - 1, height - 1);
            g2d.drawString(value, 2, height - 3);
        }
        
        g2d.dispose();
        
        return imgtext;  
    }
}
