package br.com.desafio.cnes.servicos;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.desafio.cnes.modelos.Cnes;
import br.com.desafio.cnes.utilitarios.ConverterLinhasArquivoEmCnes;
import br.com.desafio.cnes.utilitarios.LerArquivoCSV;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que representa os servicos para CNES
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@Service("cnesServicos")
@Slf4j
public class CnesServicos {

	@Autowired
	private LerArquivoCSV leitorArquivo;
	
	@Autowired
	private ConverterLinhasArquivoEmCnes conversor;
	
	private List<Cnes> lista = Lists.newArrayList();
	
	@PostConstruct
	public void posConstrucao() {
		
		try {
			listarCnes();
		} catch (IOException e) {
			
			log.error("Não foi possível carregar o arquivo CSV de CNES. A aplicação será abortada.", e);
			System.exit(0);
		}
	}
	
	public List<Cnes> listarCnes() throws IOException {
		
		preencheListaAPartirDoArquivo();
		return this.lista;
		
	}
	
	public List<Cnes> listarCnesPorEstado(String uf) {
		
		return this.lista.parallelStream().filter( cnes -> 
			uf.equalsIgnoreCase(cnes.getUf())).collect(Collectors.toList());
	}
	
	public List<Cnes> listarCnesPorTipoEstabelecimento(String codigo) {
		
		return this.lista.parallelStream().filter( cnes -> 
			codigo.toLowerCase().contains(cnes.getDescriaoTipoUnidade().toLowerCase())).collect(Collectors.toList());
	}
	

	private void preencheListaAPartirDoArquivo() throws IOException {
		
		if (this.lista.isEmpty()) {
			
			List<String> linhasArquivo = this.leitorArquivo.getLinhasArquivo();
			
			this.conversor.setListaCnes(this.lista);
			linhasArquivo.stream().forEach( l-> conversor.converterLinha(l) );
			
			this.lista.sort(Comparator.comparing(Cnes::getUf)
					.thenComparing(Comparator.comparing(Cnes::getMunicipio)
							.thenComparing(Cnes::getNomeFantasia)));
			
		}
	}
	
}
