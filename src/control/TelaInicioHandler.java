package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




import view.TelaInicio;
import view.TelaTutorial;

public class TelaInicioHandler implements ActionListener{
	private TelaInicio tela;
	
	public TelaInicioHandler(TelaInicio tela){
		this.tela=tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tela.getPlayButton()){
			tela.setVisible(false);
			TelaTutorial tutorial = new TelaTutorial();
			tutorial.run();
			tela=null;
			System.gc();
		}
		else if(e.getSource()==tela.getSairButton())
			System.exit(0);		
	}
	
	

}
