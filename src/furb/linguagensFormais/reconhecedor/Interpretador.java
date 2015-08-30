package furb.linguagensFormais.reconhecedor;

public class Interpretador {
	public static final String CARACTER_INVALIDO= "erro: símbolo(s) inválidos";
	public static final String PALAVRA_INVALIDA= "palavra inválida";
	public static final String PALAVRA_VALIDA= "palavra válida";
	private static boolean isAvaliable = false;
	private static String caminhoPercorrido = "";
	private static String sequenciaLetras = "";

	public static String[] avaliaPalavra(String palavra){
		caminhoPercorrido = "";
		sequenciaLetras = "";
		
		TabelaAFN tabelaPopulada = BOTabelaAFN.getTabelaPopulada();
		if (isSomenteCaracteresValidados(palavra, tabelaPopulada.getUniverso())) {
			avaliaPalavra(tabelaPopulada, palavra, 0, 0);
			if (isAvaliable) {
				isAvaliable = false;
				return new String[]{PALAVRA_VALIDA, caminhoPercorrido, getSequenciaLetras()};
			}else{
				return new String[]{PALAVRA_INVALIDA, caminhoPercorrido, getSequenciaLetras()};
			}
		}
		caminhoPercorrido = caminhoPercorrido + "qErro";
		return new String[]{CARACTER_INVALIDO, caminhoPercorrido, getSequenciaLetras()};
	}

	private static String getSequenciaLetras(){
		if (sequenciaLetras.length() > 0){
			return sequenciaLetras.substring(0, sequenciaLetras.length()-1);
		}
		
		return "";
	}
	
	private static boolean isSomenteCaracteresValidados(String palavra, char[] letrasAceitas){
		for (char caracter : letrasAceitas) {
			palavra = palavra.replaceAll(String.valueOf(caracter),"");
		}
		return palavra.length() == 0;
	}

	private static void avaliaPalavra(TabelaAFN tab, String palavra,int indicePalavra, int indiceTabela){
		if (palavra.length()  > indicePalavra) {
			char caracter = palavra.charAt(indicePalavra);
			sequenciaLetras += caracter+",";
			indicePalavra ++;
			int[] posicoes = null;
			switch (caracter) {
			case 'a':
				posicoes = tab.getA().get(indiceTabela);
				carregaCaminho(indiceTabela);
				break;
			case 'b':
				posicoes = tab.getB().get(indiceTabela);
				carregaCaminho(indiceTabela);
				break;
			case 'c':
				posicoes = tab.getC().get(indiceTabela);
				carregaCaminho(indiceTabela);
				break;

			default:
				break;
			}
			if (posicoes == null) {
				carregaCaminho(0);
				return;
			}
			for (int posicao : posicoes) {
				avaliaPalavra(tab, palavra, indicePalavra, posicao);
			}
		}else{
			for (int posicao : tab.getPosicoesFinais()) {
				if (posicao == indiceTabela) {
					isAvaliable =  true;
				}
			}
		}
	}

	private static void carregaCaminho(int indiceTabela) {
		if (caminhoPercorrido.isEmpty()) {
			caminhoPercorrido = caminhoPercorrido+ "q"+indiceTabela;
		}else{
			caminhoPercorrido = caminhoPercorrido+ ",q"+indiceTabela;
		}
	}
}
