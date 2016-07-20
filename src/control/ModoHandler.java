package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import app.App;
import view.ModoDeJogo;

public class ModoHandler implements ActionListener, ItemListener {
	private ModoDeJogo modo;
	private Controller controller;
	private boolean multiplayer;
	
	
	public ModoHandler(ModoDeJogo modo, Controller controller) {
		this.modo=modo;
		this.controller=controller;
		multiplayer = false;
		carregaBotoes();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arquivo="";
		if(e.getSource()==modo.getSingleButton())
			single();
		if(e.getSource()==modo.getMultiButton())
			multi();
		if(e.getSource()==modo.getPersoButton())
			modo.getPerso().setVisible(true);
		if(e.getSource()==modo.getVoltarButton()){
			modo.setVisible(false);
			controller.inicio();
		}
		if(e.getSource()==modo.getAnimalButton()){
			arquivo=""+"animais";
			modo.setVisible(false);
			controller.iniciaJogo(arquivo,multiplayer);
		}			
		if(e.getSource()==modo.getCorButton()){
			arquivo=""+"cores";
			modo.setVisible(false);
			controller.iniciaJogo(arquivo,multiplayer);
		}			
		if(e.getSource()==modo.getNumeroButton()){
			arquivo=""+"numeros";
			modo.setVisible(false);
			controller.iniciaJogo(arquivo,multiplayer);
		}			
		
	}
	
	public void carregaBotoes(){
		modo.getVoltarButton().addActionListener(this);
		modo.getSingleButton().addActionListener(this);
		modo.getMultiButton().addActionListener(this);
		modo.getPersoButton().addActionListener(this);
		modo.getPerso().addItemListener(this);
		modo.getAnimalButton().addActionListener(this);
		modo.getCorButton().addActionListener(this);
		modo.getNumeroButton().addActionListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		modo.setVisible(false);
		controller.iniciaJogo(modo.getPerso().getSelectedItem().toString(),multiplayer);
	}
	
	public void single(){
		multiplayer=false;
		modo.getPerso().setVisible(false);
		modo.getNome2label().setVisible(false);
		modo.getNome2Field().setVisible(false);
		modo.getNome1label().setVisible(true);
		modo.getNome1Field().setVisible(true);
		modo.getAnimalButton().setVisible(true);
		modo.getCorButton().setVisible(true);
		modo.getNumeroButton().setVisible(true);
		modo.getPersoButton().setVisible(true);
	}
	
	public void multi(){
		multiplayer=true;
		modo.getPerso().setVisible(false);
		modo.getNome1label().setVisible(true);
		modo.getNome1Field().setVisible(true);
		modo.getNome2label().setVisible(true);
		modo.getNome2Field().setVisible(true);
		modo.getAnimalButton().setVisible(true);
		modo.getCorButton().setVisible(true);
		modo.getNumeroButton().setVisible(true);
		modo.getPersoButton().setVisible(true);
	}
}
