package model;

public class Jogador{
	private String nome;
	private int tentativas;
	
	public Jogador(String nome){
		this.nome=nome;
		if(nome.equals(""))
			this.nome="Jogador";
		this.tentativas=0;
	}

	public String getNome() {
		return nome;
	}

	public int getTentativas() {
		return tentativas;
	}
	
	public void incrementaTentavias(){
		this.tentativas++;
	}
	
	
}
