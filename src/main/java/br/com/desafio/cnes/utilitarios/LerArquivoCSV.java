package br.com.desafio.cnes.utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe responsavel por ler o arquivo ".csv" de CNES
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@NoArgsConstructor
@Component
@Scope("prototype")
public class LerArquivoCSV {
	
	@Getter @Setter @Value("${arquivo.caminho}")
	private String caminhoNomeArquivo;

	public List<String> getLinhasArquivo() throws IOException {

		List<String> linhas = Lists.newArrayList();
		
		File arquivo = new File(caminhoNomeArquivo);
				
		FileReader leitorDeArquivo = new FileReader(arquivo);
		@Cleanup BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
		
		String linha = leitorDeBuffer.readLine();
		
		while (linha != null) {
			
			linha = leitorDeBuffer.readLine();
			inserirLinha(linhas, linha);
		}
		
		return linhas;
	}

	private void inserirLinha(List<String> linhas, String linha) {
		
		if (linha != null && !linha.isBlank()) {
			linhas.add(linha.replaceAll("\"\"", " ").replaceAll("\"", ""));
		}
	}
}
