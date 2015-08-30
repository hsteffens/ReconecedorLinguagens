package furb.linguagensFormais.styles;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import furb.linguagensFormais.reconhecedor.Interpretador;

public class RecognizerBehaviorsComponents extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String BTN_ANALYZER = "analisar";
	private static final String BTN_CLEAN = "limpar";
	private static final String BTN_TEAM = "equipe";

	private JTextArea textAreaRecognizer;
	private JPanel panelButtons;
	private JButton btnAnalyze;
	private JButton btnClean;
	private JButton btnTeam;
	private JTable tabela;
	private JScrollPane textAreaRecognizerScroll;
	private DefaultTableModel model;
	private int linha = 1;

	public JTextArea getTextAreaRecognizer() {
		if (textAreaRecognizer == null) {
			setTextAreaRecognizer(new JTextArea());
			textAreaRecognizer.setBorder(new NumberedBorder());
			textAreaRecognizer.setMaximumSize(new Dimension(864, 187));
		}

		return textAreaRecognizer;
	}

	public JScrollPane getTextAreaRecognizerScroll() {
		if (textAreaRecognizerScroll == null) {
			textAreaRecognizerScroll = new JScrollPane(getTextAreaRecognizer(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		}
		return textAreaRecognizerScroll;
	}

	public void setTextAreaRecognizer(JTextArea textAreaRecognizer) {
		this.textAreaRecognizer = textAreaRecognizer;
	}

	public JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setLayout(new GridLayout(1, 3, 10, 0));
			panelButtons.add(getBtnAnalyze());
			panelButtons.add(getBtnClean());
			panelButtons.add(getBtnTeam());
		}

		return panelButtons;
	}

	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}

	public JButton getBtnAnalyze() {
		if (btnAnalyze == null) {
			setBtnAnalyze(new JButton(BTN_ANALYZER, new ImageIcon("play.png")));
			btnAnalyze.setSize(50, 50);
			Dimension d = btnAnalyze.getPreferredSize();
			d.width = 32767;
			btnAnalyze.setMaximumSize(d);
			btnAnalyze.addActionListener(new ButtonListener());

			ImageIcon icone = getResizedIcon(new ImageIcon("./src/analisar.png"), 15, 15);
			btnAnalyze.setIcon(icone);
		}

		return btnAnalyze;
	}

	public void setBtnAnalyze(JButton btnAnalyze) {
		this.btnAnalyze = btnAnalyze;
	}

	public JButton getBtnClean() {
		if (btnClean == null) {
			setBtnClean(new JButton(BTN_CLEAN));

			btnClean.setSize(50, 50);
			ImageIcon icone = getResizedIcon(new ImageIcon("./src/limpar.png"), 15, 15);
			btnClean.setIcon(icone);
			btnClean.addActionListener(new ButtonListener());
		}

		return btnClean;
	}

	public void setBtnClean(JButton btnClean) {
		this.btnClean = btnClean;
	}

	public JButton getBtnTeam() {
		if (btnTeam == null) {
			setBtnTeam(new JButton(BTN_TEAM));
			btnTeam.setSize(50, 50);
			ImageIcon icone = getResizedIcon(new ImageIcon("./src/grupo.png"), 15, 15);
			btnTeam.setIcon(icone);
			btnTeam.addActionListener(new ButtonListener());
		}
		return btnTeam;
	}

	public void setBtnTeam(JButton btnTeam) {
		this.btnTeam = btnTeam;
	}

	private ImageIcon getResizedIcon(ImageIcon icone, int widht, int height) {
		Image img = icone.getImage();
		Image newimg = img.getScaledInstance(widht, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);

		return newIcon;
	}

	public JTable getTable() {
		if (tabela == null) {

			tabela = new JTable();
			model = getModel();
			tabela.setModel(model);
		}

		return tabela;
	}

	private DefaultTableModel getModel() {
		String[] colunas = new String[] { "linha", "resultado", "sequência", "reconhecimento" };
		String[][] dados = new String[][] { { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" } };

		return new DefaultTableModel(dados, colunas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAnalyze)) {
		}

	}

	private void actionInterpretar() {
		String[] resultado;
		if (textAreaRecognizer.getText() != null) {
			resultado = Interpretador.avaliaPalavra(textAreaRecognizer.getText().toString());
		} else {
			resultado = Interpretador.avaliaPalavra("");
		}

		setResultado(resultado);
	}

	private void setResultado(String[] resultado) {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

		for (int i = 0; i < modelo.getRowCount(); i++) {
			if (modelo.getValueAt(i, 0).equals("")) {
				modelo.insertRow(i, new Object[] { linha, resultado[0], resultado[2], resultado[1] });
				linha++;
				return;
			}
		}

		modelo.addRow(new Object[] { linha, resultado[0], resultado[1] });
		linha++;
	}

	private void showInfo() {
		StringBuilder msg = new StringBuilder();
		msg.append("Trabalho desenvolvido por ");
		msg.append("Héliton Steffens e ");
		msg.append("Matheus Navarro Nienow");
		msg.append("\npelo curso Bacharelado em Ciência da Computação da Universidade Regional de Blumenau - FURB.");

		JOptionPane.showMessageDialog(this, msg.toString());
	}
	
	private void limpar(){
		textAreaRecognizer.setText("");
		tabela.setModel(getModel());
	}

	class ButtonListener implements ActionListener {
		ButtonListener() {
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals(BTN_ANALYZER)) {
				actionInterpretar();
			} else if (e.getActionCommand().equals(BTN_CLEAN)) {
				limpar();
			} else if (e.getActionCommand().equals(BTN_TEAM)) {
				showInfo();
			}
		}
	}

}
