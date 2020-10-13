package br.com.desafio.cnes.modelos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Classe responsavel por representar uma CNES (Cadastro Nacional de Estabelecimento de Saude)
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@EqualsAndHashCode(of = {"codCnes"})
@ToString(of = {"codCnes", "nomeFantasia", "codigoCep", "uf", "municipio"})
@NoArgsConstructor
@AllArgsConstructor
public class Cnes {

	@Getter @Setter
	private Long codCnes;
	
	@Getter @Setter
	private Long codIbge;
	
	@Getter @Setter
	private String nomeFantasia;
	
	@Getter @Setter
	private String descriaoTipoUnidade;
	
	@Getter @Setter
	private String tipoGestao;
	
	@Getter @Setter
	private String nomeLogradouro;
	
	@Getter @Setter
	private String numeroEndereco;
	
	@Getter @Setter
	private String nomeBairro;
	
	@Getter @Setter
	private String codigoCep;
	
	@Getter @Setter
	private String uf;
	
	@Getter @Setter
	private String municipio;
	
	@Getter @Setter
	private String numeroTelefone;
	
}
