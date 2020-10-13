package br.com.desafio.cnes.modelos;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.desafio.cnes.CnesApplication;
import br.com.desafio.cnes.utilitarios.ConverterLinhasArquivoEmCnes;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CnesApplication.class, Cnes.class})
public class CnesTest {

	@Test
	public void testeCnes() {
		
		List<Cnes> lista = Lists.newArrayList();
		ConverterLinhasArquivoEmCnes c = new ConverterLinhasArquivoEmCnes(Lists.newArrayList());
		c = new ConverterLinhasArquivoEmCnes(lista);
		c.converterLinha("6577687,292240,SECRETARIA DE SAUDE DE MUTUIPE,CENTRAL DE GESTAO EM SAUDE,M,RUA RUY BARBOSA,S/N,CENTRO,45480000,BA,Mutuípe, ");  
		
		Cnes cnes = new Cnes(0L, 0L, "", "", "", "", "", "", "", "", "", "");

		cnes.setCodCnes(6577687L);
		cnes.setCodIbge(292240L);
		cnes.setNomeFantasia("SECRETARIA DE SAUDE DE MUTUIPE");
		cnes.setDescriaoTipoUnidade("CENTRAL DE GESTAO EM SAUDE");
		cnes.setTipoGestao("M");
		cnes.setNomeLogradouro("RUA RUY BARBOSA");
		cnes.setNumeroEndereco("S/N");
		cnes.setNomeBairro("CENTRO");
		cnes.setCodigoCep("45480000");
		cnes.setUf("BA");
		cnes.setMunicipio("Mutuípe");
		cnes.setNumeroTelefone(" ");
		
		cnes.hashCode();
				
		Assert.assertEquals(cnes.getCodCnes().longValue(), 6577687L);
		Assert.assertEquals(cnes.getCodIbge().longValue(), 292240L);
		Assert.assertEquals(cnes.getNomeFantasia(), "SECRETARIA DE SAUDE DE MUTUIPE");
		Assert.assertEquals(cnes.getDescriaoTipoUnidade(), "CENTRAL DE GESTAO EM SAUDE");
		Assert.assertEquals(cnes.getTipoGestao(), "M");
		Assert.assertEquals(cnes.getNomeLogradouro(), "RUA RUY BARBOSA");
		Assert.assertEquals(cnes.getNumeroEndereco(), "S/N");
		Assert.assertEquals(cnes.getNomeBairro(), "CENTRO");
		Assert.assertEquals(cnes.getCodigoCep(), "45480000");
		Assert.assertEquals(cnes.getUf(), "BA");
		Assert.assertEquals(cnes.getMunicipio(), "Mutuípe");
		Assert.assertEquals(cnes.getNumeroTelefone(), " ");
		
		Assert.assertEquals(cnes.toString(), "Cnes(codCnes=6577687, nomeFantasia=SECRETARIA DE SAUDE DE MUTUIPE, codigoCep=45480000, uf=BA, municipio=Mutuípe)");
		
		Assert.assertTrue(cnes.equals(cnes));
		
		Assert.assertFalse(cnes.equals(new Cnes()));
		
		Assert.assertTrue(cnes.hashCode() != 0);
		
		Assert.assertTrue(cnes.hashCode() > 0);
		
		Assert.assertFalse(cnes.hashCode() < 0);
		
	}
	
}
