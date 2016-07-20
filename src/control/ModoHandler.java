package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;
import view.ModoDeJogo;
import view.TelaJogo;

public class ModoHandler implements ActionListener {
	private ModoDeJogo modo;
	private TelaJogoController controller;
	
	
	public ModoHandler(ModoDeJogo modo, TelaJogoController controller) {
		this.modo=modo;
		this.controller=controller;
		modo.getAnimalButton().addActionListener(this);
		modo.getCorButton().addActionListener(this);
		modo.getNumeroButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arquivo="";
		if(e.getSource()==modo.getAnimalButton())
			arquivo=""+"animais";
		if(e.getSource()==modo.getCorButton())
			arquivo=""+"cores";
		if(e.getSource()==modo.getNumeroButton())
			arquivo=""+"numeros";
		controller.iniciaJogo(arquivo);
	}

}
