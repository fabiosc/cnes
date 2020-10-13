package br.com.desafio.cnes.utilitarios;

import java.beans.PropertyEditorSupport;

import br.com.desafio.cnes.enumeradores.UnidadeFederativa;

/**
 * Classe responsavel por realizar a conversao da unidade federativa informado no swagger
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
public class UnidadeFederativaConversor extends PropertyEditorSupport {

	public void setAsText(final String text) throws IllegalArgumentException {

		setValue(UnidadeFederativa.porValor(text));
	}
}
