package dev.tilerpg.gfx;

public class SpriteSheet extends Image {
	private final int CROPSIZE;
	private Image image;
	
	public SpriteSheet(String path, int cropsize){
		super(1, 1);
		CROPSIZE = cropsize;
		load(path);
	}
	
	public void load(String path){
		ExternalImageLoader loader = new ExternalImageLoader();
		image = loader.load(path);
		pixels = image.pixels;
		w = loader.w;
		h = loader.h;
	}
	
	public Image crop(int xt, int yt){
		Image i = new Image(CROPSIZE, CROPSIZE);
		
		int xa = xt * CROPSIZE;
		int ya = yt * CROPSIZE;
		int xl = 0, yl = 0;
		
		for(int y = ya; y < ya + CROPSIZE;y++){
			xl = 0;
			for(int x = xa;x < xa + CROPSIZE;x++){
				i.pixels[xl + yl * CROPSIZE] = pixels[x + y * w];
				xl++;
			}
			yl++;
		}
		
		return i;
	}
	
}
