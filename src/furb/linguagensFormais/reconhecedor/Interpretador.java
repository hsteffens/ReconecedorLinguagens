package furb.linguagensFormais.reconhecedor;

public class Interpretador {
	public static final String CARACTER_INVALIDO= "erro: símbolo(s) inválidos";
	public static final String PALAVRA_INVALIDA= "erro: palavra inválida";
	public static final String PALAVRA_VALIDA= "palavra válida";
	private static boolean isAvaliable = false;
	private static String caminhoPercorrido = "";

	public static String[] avaliaPalavra(String palavra){
		TabelaAFN tabelaPopulada = BOTabelaAFN.getTabelaPopulada();
		if (isSomenteCaracteresValidados(palavra, tabelaPopulada.getUniverso())) {
			avaliaPalavra(tabelaPopulada, palavra, 0, 0);
			if (isAvaliable) {
				isAvaliable = false;
				return new String[]{PALAVRA_VALIDA, caminhoPercorrido};
			}else{
				return new String[]{PALAVRA_INVALIDA, caminhoPercorrido};
			}
		}
		caminhoPercorrido = caminhoPercorrido + "qErro";
		return new String[]{CARACTER_INVALIDO, caminhoPercorrido};
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
