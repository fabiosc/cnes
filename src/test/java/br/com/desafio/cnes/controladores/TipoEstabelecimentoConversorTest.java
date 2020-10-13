package br.com.desafio.cnes.controladores;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.cnes.CnesApplication;
import br.com.desafio.cnes.utilitarios.TipoEstabelecimentoConversor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CnesApplication.class, TipoEstabelecimentoConversor.class})
public class TipoEstabelecimentoConversorTest {

	@Test
	public void conversorTest() {
		TipoEstabelecimentoConversor conversor = new TipoEstabelecimentoConversor();
		conversor.setAsText("TE_9");
		Assert.assertNotNull(conversor.getValue());
		
	}
}
