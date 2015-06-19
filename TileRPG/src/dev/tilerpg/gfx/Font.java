package dev.tilerpg.gfx;

public class Font {
	
	public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ! 1234567890/:";
	
	public static final SpriteSheet FONT1 = new SpriteSheet("/font.png", 8);
	public static final SpriteSheet FONT2 = new SpriteSheet("/font2.png", 8);
	//public static final SpriteSheet FONT3 = new SpriteSheet("/font3.png", 8);
	
	private static SpriteSheet currentSheet = FONT1;
	
	public static void display(Screen screen, String message, int x, int y){
		message = message.toUpperCase();
		int length = message.length();
		
		for(int i = 0;i < length;i++){
			int c = letters.indexOf(message.charAt(i));
			if(c < 0) continue;
			
			screen.display(currentSheet.crop(c, 0), x, y);
			
			x += 8;
		}
	}
	
	public static void setFont(SpriteSheet sheet) {
		currentSheet = sheet;
	}
}
