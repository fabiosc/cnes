package br.com.desafio.cnaes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.desafio.cnes.controladores.CnesControladorTest;
import br.com.desafio.cnes.controladores.TipoEstabelecimentoConversorTest;
import br.com.desafio.cnes.utilitarios.ConverterLinhasArquivoEmCnesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	SpringContextTest.class,
	CnesControladorTest.class,
	ConverterLinhasArquivoEmCnesTest.class,
	TipoEstabelecimentoConversorTest.class
})
public class TestSuite {

}


