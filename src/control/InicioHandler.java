package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Inicio;

public class InicioHandler implements ActionListener {
	private Inicio inicio;
	private TelaJogoController controller;
	
	public InicioHandler(Inicio inicio, TelaJogoController controller) {
		super();
		this.inicio=inicio;
		this.controller=controller;
		inicio.getPlayButton().addActionListener(this);
		inicio.getSairButton().addActionListener(this);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inicio.getPlayButton()){
			controller.iniciaModo();
			System.out.println("oi");
		}
		if(e.getSource()==inicio.getSairButton())
			System.exit(0);
	}

}
