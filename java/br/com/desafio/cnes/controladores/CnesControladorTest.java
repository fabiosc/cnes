package br.com.desafio.cnes.controladores;

import static io.restassured.RestAssured.with;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.desafio.cnes.CnesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = { CnesApplication.class,
		CnesControlador.class })
@AutoConfigureMockMvc
public class CnesControladorTest {

	@LocalServerPort
	private int port = 8080;
	
	@Autowired
	private MockMvc mockMvc;
	
	private final static String API_CNES = "/api/cnes"; 
	private final static String API_CNES_UF = "/api/cnes/PB"; 
	private final static String API_CNES_TIPO_ESTABELECIMENTO = "/api/cnes/tipo-estabelecimento/9"; 

	@Test
	public void listarCnesTest() throws Exception {

		with().request("GET", API_CNES).then().statusCode(200);
		
		this.mockMvc.perform(get(API_CNES)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void listarCnesPorUfTest() throws Exception {

		with().request("GET", API_CNES_UF).then().statusCode(200);

		this.mockMvc.perform(get(API_CNES_UF)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void listarCnesPorTipoEstabelecimentoTest() throws Exception {

		with().request("GET", API_CNES_TIPO_ESTABELECIMENTO).then().statusCode(200);
		
		this.mockMvc.perform(get(API_CNES_TIPO_ESTABELECIMENTO)).andDo(print()).andExpect(status().isOk());
		
	}
	
	
}
