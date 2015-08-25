package furb.linguagensFormais.styles;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Recognize extends RecognizerBehaviorsComponents implements ActionListener {

	private static final long serialVersionUID = 1L;

	public Recognize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(864, 350);
		setTitle("reconhecedor de linguagem regular");
		Container pane = getContentPane();
		// pane.setLayout(new BorderLayout(10,20));

		String[] colunas = new String[] { "linha", "resultado", "sequência", "reconhecimento" };
		String[][] dados = new String[][] { { "1", "resultado 1", "1", "reconhecimento 1" },
				{ "2", "resultado 2", "2", "reconhecimento 2" }, 
				{ "2", "resultado 2", "2", "reconhecimento 2" },
				{ "2", "resultado 2", "2", "reconhecimento 2" }, 
				{ "2", "resultado 2", "2", "reconhecimento 2" },
				{ "2", "resultado 2", "2", "reconhecimento 2" }, 
				{ "2", "resultado 2", "2", "reconhecimento 2" },
				{ "2", "resultado 2", "2", "reconhecimento 2" }, 
				{ "2", "resultado 2", "2", "reconhecimento 2" }, };


		JTable tabela = new JTable();
		DefaultTableModel model = new DefaultTableModel(dados, colunas);
		tabela.setModel(model);

		JScrollPane scroll = new JScrollPane(tabela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBar(new JScrollBar());
		scroll.setVerticalScrollBar(new JScrollBar());
		//tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 187;
		gbc.ipadx = 600;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pane.add(getTextAreaRecognizerScroll(), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 10;
		gbc.ipadx = 600;
		gbc.gridx = 0;
		gbc.gridy = 1;
		pane.add(getPanelButtons(), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 184;
		gbc.ipadx = 600;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(scroll, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}