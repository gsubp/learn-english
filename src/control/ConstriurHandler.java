package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carta;
import view.Construir;

public class ConstriurHandler implements ActionListener{
	private Construir tela;
	private ArrayList<Carta> cartas;
	private String tipo;
	public ConstriurHandler(Construir tela) {
		this.tela = tela;
		tela.getAddButton().addActionListener(this);
		tela.getSalvarButton().addActionListener(this);
		cartas = new ArrayList<>();
		tipo=null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tela.getAddButton())
			addArray();
		if(e.getSource()==tela.getSalvarButton())
			salvarXML();
		
	}
	
	public void addArray(){
		cartas.add(new Carta(tela.getNomeField().getText(), tela.getImage1Field().getText()));
		cartas.add(new Carta(tela.getNomeField().getText(), tela.getImage2Field().getText()));
		tipo=tela.getTipoField().getText();
		JOptionPane.showMessageDialog(null, "Adicionado");
		tela.getTipoField().setEditable(false);
		incrementaQnt();
		tela.getNomeField().setText(null);
		tela.getImage1Field().setText(null);
		tela.getImage2Field().setText(null);
	}
	public void salvarXML(){
		JogoXML.escreveXML(cartas, tipo);
		tela.getTipoField().setText(null);
		tela.getTipoField().setText(null);
		JOptionPane.showMessageDialog(null, "Salvo em arquivo");
		tela.setQuant(0);
		tela.getContLabel().setText("Quantidade de Cartas: "+tela.getQuant());		
	}
	
	private void incrementaQnt(){
		tela.setQuant(tela.getQuant()+2);
		tela.getContLabel().setText("Quantidade de Cartas: "+tela.getQuant());

	}
}
