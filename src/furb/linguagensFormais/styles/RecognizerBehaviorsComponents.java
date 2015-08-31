package furb.linguagensFormais.styles;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import furb.linguagensFormais.reconhecedor.Interpretador;
import furb.linguagensFormais.reconhecedor.Palavra;

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
	private JScrollPane tabelaScroll;
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

			//ImageIcon icone = getResizedIcon(new ImageIcon("./src/analisar.png"), 15, 15);
			ImageIcon icone = getResizedIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/analisar2.png"))), 15, 15);
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
			//ImageIcon icone = getResizedIcon(new ImageIcon("./src/limpar.png"), 15, 15);
			ImageIcon icone = getResizedIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/limpar2.png"))), 15, 15);
			
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
			ImageIcon icone = getResizedIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/grupo2.png"))), 15, 15);
			//ImageIcon icone = getResizedIcon(new ImageIcon("./src/grupo.png"), 15, 15);
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
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabela.setEnabled(false);
			tabela.setPreferredSize(new Dimension(864, 173));
			tabela.setMaximumSize(new Dimension(864, 173));

			DefaultTableColumnModel colModel = (DefaultTableColumnModel) tabela.getColumnModel();
			colModel.getColumn(0).setPreferredWidth(80);
			colModel.getColumn(1).setPreferredWidth(200);
			colModel.getColumn(2).setPreferredWidth(150);
			colModel.getColumn(3).setPreferredWidth(434);
		}

		return tabela;
	}

	public JTable getTableClear() {
		model = getModel();

		tabela.setModel(model);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setEnabled(false);

		DefaultTableColumnModel colModel = (DefaultTableColumnModel) tabela.getColumnModel();
		colModel.getColumn(0).setPreferredWidth(80);
		colModel.getColumn(1).setPreferredWidth(200);
		colModel.getColumn(2).setPreferredWidth(150);
		colModel.getColumn(3).setPreferredWidth(434);

		return tabela;
	}

	public JScrollPane getTableScroll() {
		if (tabelaScroll == null) {
			tabelaScroll = new JScrollPane(getTable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}

		return tabelaScroll;
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
		if (textAreaRecognizer.getText() != null) {
			List<Palavra> textoAvaliado = getTextoAvaliado(textAreaRecognizer.getText().toString());
			for (Palavra palavra : textoAvaliado) {
				String[] resultados = new String[3];
				resultados[0] = palavra.getResultado();
				resultados[1] = palavra.getSequencia();
				resultados[2] = palavra.getReconhecimento();
				setResultado(resultados);
			}
		}

	}

	private void showInfo() {
		StringBuilder msg = new StringBuilder();
		msg.append("Trabalho desenvolvido por ");
		msg.append("Héliton Steffens e ");
		msg.append("Matheus Navarro Nienow");
		msg.append("\nna disciplina de Linguagens Formais, lecionada pela professora Joyce Martins,");
		msg.append("\nno curso Bacharelado em Ciência da Computação da Universidade Regional de Blumenau - FURB.");

		JOptionPane.showMessageDialog(this, msg.toString());
	}

	private void limpar() {
		textAreaRecognizer.setText("");
		tabela = getTableClear();
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

	private void setResultado(String[] resultado) {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

		for (int i = 0; i < modelo.getRowCount(); i++) {
			if (modelo.getValueAt(i, 0).equals("")) {
				modelo.insertRow(i, new Object[] { linha, resultado[0], resultado[1], resultado[2] });
				linha++;
				return;
			}
		}

		modelo.addRow(new Object[] { linha, resultado[0], resultado[1], resultado[2] });
		linha++;
	}

	private List<Palavra> getTextoAvaliado(String textoAvaliado) {
		ArrayList<Palavra> lPalavra = new ArrayList<>();
		String palavra = "";
		for (char caracter : textoAvaliado.toCharArray()) {
			if (caracter != ' ' && caracter != '\n') {
				palavra = palavra + caracter;
			} else if (caracter == '\n' || caracter == ' ') {
				if (!palavra.isEmpty()) {
					lPalavra.add(getPalavraAvaliada(palavra, linha));
				}
				palavra = "";
			}
		}
		if (!palavra.isEmpty()) {
			lPalavra.add(getPalavraAvaliada(palavra, linha));
		}
		return lPalavra;
	}

	private Palavra getPalavraAvaliada(String palavra, int linha) {
		Palavra objeto = new Palavra();
		objeto.setSequencia(palavra);
		String[] avaliaPalavra = Interpretador.avaliaPalavra(palavra);
		objeto.setResultado(avaliaPalavra[0]);
		objeto.setReconhecimento(avaliaPalavra[1]);
		return objeto;
	}
}
