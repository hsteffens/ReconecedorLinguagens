package furb.linguagensFormais.reconhecedor;

import java.util.Map;

public class TabelaAFN {
	private Map<Integer, int[]> a;
	private Map<Integer, int[]> b;
	private Map<Integer, int[]> c;
	private Integer[] posicoesFinais;
	private char[] universo;
	
	public Map<Integer, int[]> getA() {
		return a;
	}
	public void setA(Map<Integer, int[]> a) {
		this.a = a;
	}
	public Map<Integer, int[]> getB() {
		return b;
	}
	public void setB(Map<Integer, int[]> b) {
		this.b = b;
	}
	public Map<Integer, int[]> getC() {
		return c;
	}
	public void setC(Map<Integer, int[]> c) {
		this.c = c;
	}
	
	public Integer[] getPosicoesFinais() {
		return posicoesFinais;
	}
	public void setPosicoesFinais(Integer[] integers) {
		this.posicoesFinais = integers;
	}
	public char[] getUniverso() {
		return universo;
	}
	public void setUniverso(char[] universo) {
		this.universo = universo;
	}
}
