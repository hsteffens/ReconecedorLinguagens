package furb.linguagensFormais.executavel;

import furb.linguagensFormais.reconhecedor.Interpretador;
import furb.linguagensFormais.styles.Recognize;

public class Executavel {
	 public static void main(String[] args){
	        new Recognize().setVisible(true);
		 
	        String[] avaliaPalavra = Interpretador.avaliaPalavra("act");
			System.out.println(avaliaPalavra[0]);
			System.out.println(avaliaPalavra[1]);
	    }
}
