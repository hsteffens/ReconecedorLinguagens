package furb.linguagensFormais.reconhecedor;

import java.util.HashMap;
import java.util.Map;

public class BOTabelaAFN {
	
	public static TabelaAFN getTabelaPopulada(){
		TabelaAFN tabelaAFN = new TabelaAFN();
		tabelaAFN.setUniverso(new char[]{'a','b','c'});
		tabelaAFN.setPosicoesFinais(new Integer[]{6,10,11,14});
		tabelaAFN.setA(getTabelaA());
		tabelaAFN.setB(getTabelaB());
		tabelaAFN.setC(getTabelaC());
		return tabelaAFN;
	}

	private static Map<Integer, int[]> getTabelaA() {
		Map<Integer, int[]> tabelaA = new HashMap<Integer, int[]>();
		tabelaA.put(0, new int[]{1,3,8,11});
		tabelaA.put(1, new int[]{2});
		tabelaA.put(2, new int[]{1,3});
		tabelaA.put(3, null);
		tabelaA.put(4, null);
		tabelaA.put(5, null);
		tabelaA.put(6, null);
		tabelaA.put(7, null);
		tabelaA.put(8, new int[]{9});
		tabelaA.put(9, new int[]{8,11});
		tabelaA.put(10, null);
		tabelaA.put(11, null);
		tabelaA.put(12, null);
		tabelaA.put(13, null);
		tabelaA.put(14, null);
		return tabelaA;
	}
	private static Map<Integer, int[]> getTabelaB() {
		Map<Integer, int[]> tabelaB = new HashMap<Integer, int[]>();
		tabelaB.put(0, new int[]{4,10});
		tabelaB.put(1, null);
		tabelaB.put(2, new int[]{4});
		tabelaB.put(3, new int[]{5});
		tabelaB.put(4, new int[]{5});
		tabelaB.put(5, new int[]{4});
		tabelaB.put(6, null);
		tabelaB.put(7, null);
		tabelaB.put(8, null);
		tabelaB.put(9, new int[]{10});
		tabelaB.put(10, new int[]{12});
		tabelaB.put(11, new int[]{12});
		tabelaB.put(12, new int[]{10});
		tabelaB.put(13, null);
		tabelaB.put(14, null);
		return tabelaB;
	}
	private static Map<Integer, int[]> getTabelaC() {
		Map<Integer, int[]> tabelaC = new HashMap<Integer, int[]>();
		tabelaC.put(0, new int[]{6});
		tabelaC.put(1, null);
		tabelaC.put(2, new int[]{6});
		tabelaC.put(3, null);
		tabelaC.put(4, null);
		tabelaC.put(5, new int[]{6});
		tabelaC.put(6, new int[]{7});
		tabelaC.put(7, new int[]{6});
		tabelaC.put(8, null);
		tabelaC.put(9, null);
		tabelaC.put(10, new int[]{13});
		tabelaC.put(11, new int[]{13});
		tabelaC.put(12, null);
		tabelaC.put(13, new int[]{14});
		tabelaC.put(14, new int[]{13});
		return tabelaC;
	}
	
}
