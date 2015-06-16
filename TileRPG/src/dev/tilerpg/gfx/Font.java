package dev.tilerpg.gfx;

public class Font {
	
	public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ! 1234567890/:";
	private static SpriteSheet sheet = new SpriteSheet("/font.png", 8);

	public static void display(Screen screen, String message, int x, int y){
		message = message.toUpperCase();
		int length = message.length();
		
		for(int i = 0;i < length;i++){
			int c = letters.indexOf(message.charAt(i));
			if(c < 0) continue;
			
			screen.display(sheet.crop(c, 0), x, y);
			
			x += 10;
		}
	}
}
