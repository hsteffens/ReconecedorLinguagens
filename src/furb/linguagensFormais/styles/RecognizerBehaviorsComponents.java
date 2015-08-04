package furb.linguagensFormais.styles;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RecognizerBehaviorsComponents extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String BTN_ANALYZER = "analisar";
	private static final String BTN_CLEAN = "limpar";
	private static final String BTN_TEAM = "equipe";

	private JTextArea textAreaRecognizer;
	private JPanel panelButtons;
	private JButton btnAnalyze;
	private JButton btnClean;
	private JButton btnTeam;

	public JTextArea getTextAreaRecognizer() {
		if (textAreaRecognizer == null) {
			setTextAreaRecognizer(new JTextArea());
		}
		textAreaRecognizer.setBorder(new NumberedBorder());
		textAreaRecognizer.setMaximumSize(new Dimension(864,187));
		return textAreaRecognizer;
	}

	public void setTextAreaRecognizer(JTextArea textAreaRecognizer) {
		this.textAreaRecognizer = textAreaRecognizer;
	}

	public JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
		}
		panelButtons.setLayout(new GridLayout(1, 3, 10, 0));
		panelButtons.add(getBtnAnalyze());
		panelButtons.add(getBtnClean());
		panelButtons.add(getBtnTeam());

		return panelButtons;
	}
	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}

	public JButton getBtnAnalyze() {
		if (btnAnalyze == null) {
			setBtnAnalyze(new JButton(BTN_ANALYZER,new ImageIcon("play.png")));
		}
		btnAnalyze.setSize(400,50);
		Dimension d = btnAnalyze.getPreferredSize();
		d.width = 32767;
		btnAnalyze.setMaximumSize( d );
		
		return btnAnalyze;
	}

	public void setBtnAnalyze(JButton btnAnalyze) {
		this.btnAnalyze = btnAnalyze;
	}

	public JButton getBtnClean() {
		if (btnClean == null) {
			setBtnClean(new JButton(BTN_CLEAN));
		}
		btnClean.setSize(100,50);
		return btnClean;
	}

	public void setBtnClean(JButton btnClean) {
		this.btnClean = btnClean;
	}

	public JButton getBtnTeam() {
		if (btnTeam == null) {
			setBtnTeam(new JButton(BTN_TEAM));
		}
		btnTeam.setSize(100,50);
		return btnTeam;
	}

	public void setBtnTeam(JButton btnTeam) {
		this.btnTeam = btnTeam;
	}

}
