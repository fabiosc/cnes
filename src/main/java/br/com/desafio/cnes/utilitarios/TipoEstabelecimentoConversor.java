package br.com.desafio.cnes.utilitarios;

import java.beans.PropertyEditorSupport;

import br.com.desafio.cnes.enumeradores.TipoEstabelecimento;

/**
 * Classe responsavel por realizar a conversao do tipo de estabelecimento informado no swagger
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
public class TipoEstabelecimentoConversor extends PropertyEditorSupport {

	public void setAsText(final String text) throws IllegalArgumentException {

		if (text.startsWith("TE")) {
			TipoEstabelecimento te = TipoEstabelecimento.valueOf(text);
			setValue(TipoEstabelecimento.porValor(te.getValor()));
		} else {

			setValue(TipoEstabelecimento.porValor(Integer.valueOf(text)));
		}
	}

}
