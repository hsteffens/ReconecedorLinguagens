package furb.linguagensFormais.styles;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
		
		JScrollPane scr = new JScrollPane(textAreaRecognizer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		return textAreaRecognizer;
	}
	
	public JScrollPane getTextAreaRecognizerScroll() {
		if (textAreaRecognizer == null) {
			setTextAreaRecognizer(new JTextArea());
		}
		textAreaRecognizer.setBorder(new NumberedBorder());
		textAreaRecognizer.setMaximumSize(new Dimension(864,187));
		
		JScrollPane scr = new JScrollPane(textAreaRecognizer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		return scr;
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
		btnAnalyze.setSize(50, 50);
		Dimension d = btnAnalyze.getPreferredSize();
		d.width = 32767;
		btnAnalyze.setMaximumSize( d );
		
		ImageIcon icone = getResizedIcon(new ImageIcon("C:/Users/Matheus N. Nienow/Desktop/analisar.png"), 15, 15);				
		btnAnalyze.setIcon(icone);
		
		return btnAnalyze;
	}

	public void setBtnAnalyze(JButton btnAnalyze) {
		this.btnAnalyze = btnAnalyze;
	}

	public JButton getBtnClean() {
		if (btnClean == null) {
			setBtnClean(new JButton(BTN_CLEAN));
		}
		btnClean.setSize(50,50);

		ImageIcon icone = getResizedIcon(new ImageIcon("C:/Users/Matheus N. Nienow/Desktop/limpar.png"), 15, 15);	
		btnClean.setIcon(icone);
		
		return btnClean;
	}

	public void setBtnClean(JButton btnClean) {
		this.btnClean = btnClean;
	}

	public JButton getBtnTeam() {
		if (btnTeam == null) {
			setBtnTeam(new JButton(BTN_TEAM));
		}
		btnTeam.setSize(50,50);
		ImageIcon icone = getResizedIcon(new ImageIcon("C:/Users/Matheus N. Nienow/Desktop/grupo.png"), 15, 15);	
		btnTeam.setIcon(icone);
		
		return btnTeam;
	}

	public void setBtnTeam(JButton btnTeam) {
		this.btnTeam = btnTeam;
	}
	
	private ImageIcon getResizedIcon(ImageIcon icone, int widht, int height){
		Image img = icone.getImage();
		Image newimg = img.getScaledInstance(widht, height,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);
		
		return newIcon;
	}

}
