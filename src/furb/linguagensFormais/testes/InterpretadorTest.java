package furb.linguagensFormais.testes;

import junit.framework.Assert;

import org.junit.Test;

import furb.linguagensFormais.reconhecedor.Interpretador;
public class InterpretadorTest {

	@Test
	public void testInterpretarPalavra001(){
		Assert.assertEquals(Interpretador.CARACTER_INVALIDO, Interpretador.avaliaPalavra("eaabbc")[0]);
	}
	@Test
	public void testInterpretarPalavra002(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("aabbc")[0]);
	}

	@Test
	public void testInterpretarPalavra003(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("abccc")[0]);
	}
	
	@Test
	public void testInterpretarPalavra004(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("aaabb")[0]);
	}
	
	@Test
	public void testInterpretarPalavra005(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("abbcc")[0]);
	}

	@Test
	public void testInterpretarPalavra006(){
		Assert.assertEquals(Interpretador.PALAVRA_INVALIDA, Interpretador.avaliaPalavra("bbbb")[0]);
	}

	@Test
	public void testInterpretarPalavra007(){
		Assert.assertEquals(Interpretador.PALAVRA_INVALIDA, Interpretador.avaliaPalavra("ac")[0]);
	}

	@Test
	public void testInterpretarPalavra008(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("a")[0]);
	}

	@Test
	public void testInterpretarPalavra009(){
		Assert.assertEquals(Interpretador.PALAVRA_VALIDA, Interpretador.avaliaPalavra("c")[0]);
	}
}
