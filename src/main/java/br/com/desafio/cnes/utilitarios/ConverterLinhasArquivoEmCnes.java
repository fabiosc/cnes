package br.com.desafio.cnes.utilitarios;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import br.com.desafio.cnes.modelos.Cnes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe responsavel por por converter as linhas do arquivo em Objetos CNES
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
@Slf4j
public class ConverterLinhasArquivoEmCnes {

	@Setter
	private List<Cnes> listaCnes = Lists.newArrayList();
	
	public void converterLinha(String linha) {
		
		String[] dividirDadoLinha = linha.split(",");
		
		try {
			listaCnes.add(
					new Cnes(
							Long.valueOf(dividirDadoLinha[0]), 
							Long.valueOf(dividirDadoLinha[1]), 
							dividirDadoLinha[2], 
							dividirDadoLinha[3], 
							dividirDadoLinha[4], 
							dividirDadoLinha[5], 
							dividirDadoLinha[6], 
							dividirDadoLinha[7], 
							dividirDadoLinha[8], 
							dividirDadoLinha[9], 
							dividirDadoLinha[10], 
							dividirDadoLinha[11])
					);
			
		} catch (NumberFormatException e) {
			
			String mensagem = String.format("Nao foi possivel converter a linha: %s", linha);
			log.error(mensagem, e);
			throw e;
		} catch (ArrayIndexOutOfBoundsException e) {
			
			String mensagem = String.format("Nao foi possivel encontrar o indice informado na linha: %s", linha);
			log.error(mensagem, e);
			throw e;
		}
	}
	
}
