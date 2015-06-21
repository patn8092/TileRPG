package dev.tilerpg.gfx;

public class Image {
	
	public int w, h;
	public int[] pixels;
	
	public Image(int w, int h){
		this.w = w;
		this.h = h;
		pixels = new int[w * h];
	}
	
	public Image(int[] p, int w, int h) {
		this.w = w;
		this.h = h;
		pixels = p;
	}
	
	public void display(Image image, int xp, int yp){
		int x0 = xp;
		int x1 = xp + image.w;
		int y0 = yp;
		int y1 = yp + image.h;
		if(x0 < 0)
			x0 = 0;
		if(x1 > w)
			x1 = w;
		if(y0 < 0)
			y0 = 0;
		if(y1 > h)
			y1 = h;
		int ww = x1 - x0;
		
		for(int y = y0;y < y1;y++){
			int tp = y * w + x0;
			int sp = (y - yp) * image.w + (x0 - xp);
			tp -= sp;
			for(int x = sp;x < sp + ww;x++){
				if(image.pixels[x] != 0xFFFF00DC)
					//IGNORE FOR TRANSPARENCY FF00DC COLOR PINK
					pixels[tp + x] = image.pixels[x];
			}
		}
	}
	
	public void clear(int color){
		for(int i = 0;i < pixels.length;i++)
			pixels[i] = color;
	}
	
	public static int getRGB(int red, int green, int blue) {
		int rgb = red;
		rgb = (rgb << 8) + green;
		rgb = (rgb << 8) + blue;
		return rgb;
	}
}
