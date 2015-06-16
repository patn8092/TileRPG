package dev.tilerpg.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExternalImageLoader {
	
	public int w, h;
	
	public int[] loadExternalImage(String path){
		try {
			BufferedImage image = ImageIO.read(getClass().getResource(path));
			w = image.getWidth();
			h = image.getHeight();
			int[] pixels = new int[w * h];
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			return pixels;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
