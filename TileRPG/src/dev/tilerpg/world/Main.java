package dev.tilerpg.world;

public class Main {
	
	public static void main(String[] args) {
		
		int[][] ints = new int[16][16];
		
		long first = System.nanoTime();
		for(int i = 0; i < ints.length; i++) {
			for(int j = 0; j < ints[i].length; j++)
				ints[i][j] = 1;
		}
		long last = System.nanoTime();
		
		System.out.println((long) (last - first));
	}
}
