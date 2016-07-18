package model;

public class Ranking {
	private String nome;
	private int tentativas;
	
	public Ranking(Jogador jogador){
		super();
		nome=jogador.getNome();
		tentativas=jogador.getTentativas();
	}

	public String getNome() {
		return nome;
	}

	public int getTentativas() {
		return tentativas;
	}

//	public String toString(){
//		return getNome()+"\t"+getTentativas();
//	}
	
}
