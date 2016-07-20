package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Configuracao;
import view.Creditos;
import view.Inicio;

public class InicioHandler implements ActionListener {
	private Inicio inicio;
	private TelaJogoController controller;
	private Creditos cr;
	private Configuracao config;
	
	public InicioHandler(Inicio inicio, TelaJogoController controller, Creditos cr, Configuracao config) {
		super();
		this.inicio=inicio;
		this.controller=controller;
		this.cr=cr;
		this.config=config;
		inicio.getPlayButton().addActionListener(this);
		inicio.getSairButton().addActionListener(this);	
		inicio.getConfigButton().addActionListener(this);
		inicio.getCreditosButton().addActionListener(this);
		inicio.getRankingButton().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inicio.getPlayButton())
			controller.iniciaModo();
		if(e.getSource()==inicio.getSairButton())
			System.exit(0);
		if(e.getSource()==inicio.getConfigButton())
			config.setVisible(true);
		if(e.getSource()==inicio.getCreditosButton())
			cr.setVisible(true);
		
	}

}
