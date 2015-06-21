package dev.tilerpg.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.tilerpg.main.Game;

public class ExternalImageLoader {
	
	public static int w, h;
	
	public static Image load(String path){
		try {
			BufferedImage image = ImageIO.read(Game.class.getResource(path));
			w = image.getWidth();
			h = image.getHeight();
			int[] pixels = new int[w * h];
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			return new Image(pixels, w, h);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
