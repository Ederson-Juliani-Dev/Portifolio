package Camp.Bomb.Java.Eder.Dev.modelo;

import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.MouseEvent;

public interface CampoObservador {
	
	public void eventoOcorreu(Campo campo, CampoEvento evento);

	void mousePressed(MouseEvent e);

	void mouseClicked(MouseEvent e);

	void mouseClicked(MouseInputListener e);
}
