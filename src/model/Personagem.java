package model;

import java.io.IOException;

public class Personagem {
	private int posX;
	private int posY;
	private Sprite sprite;
	
	public Personagem(int posX, int posY,int aparencia,int larg,int alt,int col, int lin){
		try {
			this.sprite = new Sprite(aparencia,larg,alt,col,lin);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		this.posX=posX;
		this.posY=posY;		
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}	
	
	public Sprite getSprite(){
		return sprite;
	}
}
