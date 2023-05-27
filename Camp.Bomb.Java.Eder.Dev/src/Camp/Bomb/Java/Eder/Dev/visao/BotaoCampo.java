package Camp.Bomb.Java.Eder.Dev.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import Camp.Bomb.Java.Eder.Dev.modelo.Campo;
import Camp.Bomb.Java.Eder.Dev.modelo.CampoEvento;
import Camp.Bomb.Java.Eder.Dev.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseInputListener {

	private static final Color BG_PADRAO = new Color(184, 184, 184);
	private static final Color BG_MARCAR = new Color(8, 179, 247);
	private static final Color BG_EXPLODIR = new Color(189, 66, 68);
	private static final Color TEXT_VERDE = new Color(0, 100, 0);

	private Campo campo;

	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));

		addMouseListener(this);
		campo.registrarObservador(this);

	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch (evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCAR:
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
		default:
			aplicarEstiloPadrao();
		}

		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});

	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setForeground(Color.WHITE);
		setText("X");
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setText("M");
	}

	private void aplicarEstiloAbrir() {
		setBorder(BorderFactory.createLineBorder(Color.GRAY));

		if (campo.isMinado()) {
			setBackground(BG_EXPLODIR);
			return;
		}

		setBackground(BG_PADRAO);

		switch (campo.minasNaVizinhaca()) {
		case 1:
			setForeground(TEXT_VERDE);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4:
		case 5:
		case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
		}

		String valor = !campo.vizinhacaSegura() ? campo.minasNaVizinhaca() + "" : "";
		setText(valor);

	}

	// Interface dos Eventos do Mouse
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			campo.abrir();
		} else {
			campo.alternarMarcacao();
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseInputListener e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(org.w3c.dom.events.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(org.w3c.dom.events.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
