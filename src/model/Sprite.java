package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	BufferedImage spriteSheet = ImageIO.read(new File("src/sprite/character.png")); 
	int width, height;
	int rows, columns;
	public BufferedImage[] sprites;
	public int aparencia;
	
	public Sprite(int aparencia, int width, int height, int columns, int rows) throws IOException {
		this.aparencia=aparencia;
		this.width = width;
		this.height = height;
		
//		this.width = spriteSheet.getWidth()/columns;
//		this.height = spriteSheet.getHeight()/rows;

		this.rows = columns;
		this.columns = rows;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
			}
		}
	}
}
