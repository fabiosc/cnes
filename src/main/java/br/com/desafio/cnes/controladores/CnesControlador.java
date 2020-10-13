package br.com.desafio.cnes.controladores;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.cnes.controladores.utils.PaginadorDeListas;
import br.com.desafio.cnes.enumeradores.TipoEstabelecimento;
import br.com.desafio.cnes.enumeradores.UnidadeFederativa;
import br.com.desafio.cnes.modelos.Cnes;
import br.com.desafio.cnes.servicos.CnesServicos;
import br.com.desafio.cnes.utilitarios.TipoEstabelecimentoConversor;
import br.com.desafio.cnes.utilitarios.UnidadeFederativaConversor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * Classe responsavel por prover as APIs REST da aplicacao
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */

@RestController
@RequestMapping(value = "/api/cnes")
@RequiredArgsConstructor
@Api(value = "CNES")
public class CnesControlador {

	@Autowired
	private CnesServicos cnesServicos;

	
	@GetMapping
	@ApiOperation(value = "Lista todos os CNES")
	public ResponseEntity<Page<Cnes>> listarCnes(@PageableDefault(sort = { "uf",
            "municipio", "nomeFantasia" }, value = 100) Pageable pageable) throws IOException {
		
		PaginadorDeListas<Cnes> paginador = new PaginadorDeListas<Cnes>();
		
		return new ResponseEntity<Page<Cnes>>(paginador.getListaPaginada(pageable, this.cnesServicos.listarCnes()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{uf}")
	@ApiOperation(value = "Lista todos os CNES por unidade federativa")
	public ResponseEntity<Page<Cnes>> listarCnesPorEstado(@PageableDefault(sort = { "uf",
            "municipio", "nomeFantasia" }, value = 100) Pageable pageable, @PathVariable(name = "uf") UnidadeFederativa uf) throws IOException {
		
		PaginadorDeListas<Cnes> paginador = new PaginadorDeListas<Cnes>();
		
		return new ResponseEntity<Page<Cnes>>(paginador.getListaPaginada(pageable, this.cnesServicos.listarCnesPorEstado(uf.getValor())), HttpStatus.OK);
	}
	
	@GetMapping(value = "/tipo-estabelecimento/{codigoTipoEstabelecimento}")
	@ApiOperation(value = "Lista todos os CNES por tipo de estabelecimento")
	public ResponseEntity<Page<Cnes>> listarCnesTipoEstabelecimento(@PageableDefault(sort = { "uf",
            "municipio", "nomeFantasia" }, value = 100) Pageable pageable, @PathVariable(name = "codigoTipoEstabelecimento") TipoEstabelecimento te) throws IOException {
		
		PaginadorDeListas<Cnes> paginador = new PaginadorDeListas<Cnes>();
		
		return new ResponseEntity<Page<Cnes>>(paginador.getListaPaginada(pageable, this.cnesServicos.listarCnesPorTipoEstabelecimento(te.getDescricao())), HttpStatus.OK);
	}
	
	
	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(UnidadeFederativa.class, new UnidadeFederativaConversor());
		webdataBinder.registerCustomEditor(TipoEstabelecimento.class, new TipoEstabelecimentoConversor());
	}	
	
}
