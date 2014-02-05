package com.kgrwhite.cyrene.graphics;

import java.util.Random;

public class Screen {

	public int tileAmount = 64;
	public int tileSize = 16;
	
	private int width, height;
	public int[] pixels;
	
	public int[] tiles = new int[tileAmount * tileAmount];
	
	private Random random = new Random();
	
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < tileAmount*tileAmount; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
				
		for (int y = 0; y < height; y++){
			if (y  < 0 || y >= height) break;
			for (int x = 0; x < width; x++) {
				if (x < 0 || x >= width) break;
				int tileIndex = (x / tileSize) + (y / tileSize) * tileAmount;
				
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
	
	public int getTileAmount(){
		return this.tileAmount;
	}
	
	public void setTileAmount(int tileAmt){
		this.tileAmount = tileAmt;
	}
	
	public int getTileSize(){
		return this.tileSize;
	}
	
	public void setTileSize(int tileSize){
		this.tileSize = tileSize;
	}
	
}
