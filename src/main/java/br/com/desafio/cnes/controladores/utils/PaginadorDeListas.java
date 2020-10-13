package br.com.desafio.cnes.controladores.utils;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


/**
 * Classe responsavel por preparar a paginacao da lista de CNES
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
public class PaginadorDeListas<T> {

	public PageImpl<T> getListaPaginada(Pageable pageable, List<T> lista) {
		
		int inicio = (int) pageable.getOffset();
		int fim = (int) ((inicio + pageable.getPageSize()) > lista.size() ? 
				lista.size() : 
					(inicio + pageable.getPageSize()));
		
		return new PageImpl<T>(lista.subList(inicio, fim), pageable, lista.size());
	}
}
