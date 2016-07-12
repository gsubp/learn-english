package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;
import view.Jogo;
import view.ModoDeJogo;

public class ModoHandler implements ActionListener {
	private ModoDeJogo modo;
	public ModoHandler(ModoDeJogo modo) {
		this.modo=modo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arquivo="";
		if(e.getSource()==modo.getAnimalButton()){
			arquivo=""+"animais";
		}
		if(e.getSource()==modo.getCorButton())
			arquivo=""+"cores";
		if(e.getSource()==modo.getNumeroButton())
			arquivo=""+"numeros";
		Jogo jogo = new Jogo(arquivo);
		App.jogo.trocaPanel(jogo);
		Thread t = new Thread(jogo);
		t.start();
	}

}
