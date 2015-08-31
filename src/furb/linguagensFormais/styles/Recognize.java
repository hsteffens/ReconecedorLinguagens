package furb.linguagensFormais.styles;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Recognize extends RecognizerBehaviorsComponents implements ActionListener {

	private static final long serialVersionUID = 1L;
	public Recognize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(864, 350);
		setTitle("reconhecedor de linguagem regular");
		Container pane = getContentPane();
		
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
		pane.add(getTableScroll(), gbc);
		//pack();

	}

}