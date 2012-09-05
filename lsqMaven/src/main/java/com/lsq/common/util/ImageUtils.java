package com.lsq.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtils {
	private Image   srcImage    = null;   
    private int imageWidth = 0;  
    private int imageHeight = 0;
		/**  
		 * ǿ��ѹ��/�Ŵ�ͼƬ���̶��Ĵ�С  
		 * @param w int �¿��?  
		 * @param h int �¸߶�  
		 * @throws IOException  
		 */  
       public void resize(int w, int h,String uploadPath,File _file) throws IOException {  
    	       int maxW = w;
    	       int maxh = h;
	           _file.setReadOnly(); 
	    	   srcImage = javax.imageio.ImageIO.read(_file);
	    	   //�õ�ͼƬ��ԭʼ��С�� �Ա㰴����ѹ��   
	    	   imageWidth = srcImage.getWidth(null);   
	    	   imageHeight = srcImage.getHeight(null); 
	            //�õ����ʵ�ѹ���С��������?   
	           if ( imageWidth >= imageHeight) {   
	               //w = w;   
	               h = (int)Math.round((imageHeight * w * 1.0 / imageWidth));   
	           } else  {   
	               //h = h;   
	               w = (int)Math.round((imageWidth * h * 1.0 / imageHeight));   
	           }
	           
	           if (w < maxW) {
	        	   w = maxW;
	           }
	           if (h < maxh) {
	        	   h = maxh;
	           }
	           //����ͼƬ����
	           BufferedImage _image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);   
	           //������С����?
	           _image.getGraphics().drawImage(srcImage, 0, 0, w, h, null);
	           //����ļ���?
	           FileOutputStream out = new FileOutputStream(uploadPath);   
	           JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
	           encoder.encode(_image);
	           encoder.getOutputStream();
	           out.flush(); 
	           out.close(); 
	       
      }    
      public boolean checkImageType(String fileType) {
		if (!".jpg".equals(fileType) && !".jpeg".equals(fileType)
				&& !".gif".equals(fileType) && !".png".equals(fileType)
				&& !".JPG".equals(fileType) && !".JPEG".equals(fileType)
				&& !".GIF".equals(fileType) && !".PNG".equals(fileType)
				&& !".BMP".equals(fileType) && !".bmp".equals(fileType)) {
			return false;
		} else {
   			return true;
   		}
   	}
}