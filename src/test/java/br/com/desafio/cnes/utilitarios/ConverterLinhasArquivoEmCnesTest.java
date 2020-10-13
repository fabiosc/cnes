package br.com.desafio.cnes.utilitarios;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.desafio.cnes.CnesApplication;
import br.com.desafio.cnes.modelos.Cnes;

/**
 * Classe responsavel por por converter as linhas do arquivo em Objetos CNES
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CnesApplication.class, ConverterLinhasArquivoEmCnes.class})
public class ConverterLinhasArquivoEmCnesTest {

	@Test
	public void allArgsConstructorTest() {

		ConverterLinhasArquivoEmCnes c = new ConverterLinhasArquivoEmCnes(Lists.newArrayList(new Cnes()));
		Assert.assertNotNull(c);
	}
	
	@Test
	public void linhaInvalidaTest() {

		ConverterLinhasArquivoEmCnes c = new ConverterLinhasArquivoEmCnes(Lists.newArrayList());
		Exception exception = Assert.assertThrows(NumberFormatException.class, () -> {
			c.converterLinha("ABCDE,FGHIJ");  
	    });
		
		String expectedMessage = "For input string:";
	    String actualMessage = exception.getMessage();
	 
	    Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void linhaInvalida2Test() {

		ConverterLinhasArquivoEmCnes c = new ConverterLinhasArquivoEmCnes(Lists.newArrayList());
	    Exception exception2 = Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	    	c.converterLinha("123456,123456");  
	    });
	    
	    String expectedMessage2 = "Index 2 out of bounds for length 2";
	    String actualMessage2 = exception2.getMessage();
	    
	    Assert.assertTrue(actualMessage2.contains(expectedMessage2));
	}
	
	@Test
	public void linhaValidaTest() {
		
		List<Cnes> lista = Lists.newArrayList();
		ConverterLinhasArquivoEmCnes c = new ConverterLinhasArquivoEmCnes(Lists.newArrayList());
		c = new ConverterLinhasArquivoEmCnes(lista);
		c.converterLinha("6577687,292240,SECRETARIA DE SAUDE DE MUTUIPE,CENTRAL DE GESTAO EM SAUDE,M,RUA RUY BARBOSA,S/N,CENTRO,45480000,BA,Mutuípe, ");  
		
		Assert.assertTrue(lista.size() > 0);		
	}	
	
}
