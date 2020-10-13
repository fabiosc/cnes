package br.com.desafio.cnes.enumeradores;

import java.util.Arrays;

import lombok.Getter;

/**
 * Enumerador de Tipos de Estabelecimento
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
public enum TipoEstabelecimento {

	TE_0(0,"outros"),
	TE_1(1,"Unidade Basica de Saude"),
	TE_2(2,"Central de Gestão de Saude"),
	TE_3(3,"Central de Regulacao"),
	TE_4(4,"Central de Abastecimento"),
	TE_5(5,"Central de Transplante"),
	TE_6(6,"Hospital"),
	TE_7(7,"Centro de Assistência Obstetrica e Neonatal Normal"),
	TE_8(8,"Pronto Atendimento"),
	TE_9(9,"Farmacia"),
	TE_10(10,"Unidade de Atencao Hematologica e/ou Hemoterapica"),
	TE_11(11,"Nucleo de Telessaude"),
	TE_12(12,"Unidade de Atencao Docimiciliar"),
	TE_13(13,"Polo de Prevencao de Doencas e Agravos e Promocao da Saude"),
	TE_14(14,"Casa de Apoio a Saude"),
	TE_15(15,"Unidade de Reabilitacao"),
	TE_16(16,"Ambulatorio"),
	TE_17(17,"Unidade de Atencao Psicossocial"),
	TE_18(18,"Unidade de Apoio Disanostico"),
	TE_19(19,"Unidade de Terapias Especiais"),
	TE_20(20,"Laboratorio de Protese Dentaria"),
	TE_21(21,"Unidade de Vigilância de Saude"),
	TE_22(22,"Laboratorio de Saude Publica"),
	TE_23(23,"Centro de Referencia de Saude do Trabalhador"),
	TE_24(24,"Servico de Verificacao de Obito"),
	TE_25(25,"Centro de Imunizacao");	
	
	@Getter
	private Integer valor;
	@Getter
	private String descricao;
	
	private TipoEstabelecimento(Integer valor, String descricao) {
		
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public static TipoEstabelecimento porValor(Integer valor) {
		
		for (TipoEstabelecimento te : values()) {
			if (te.valor.intValue() == valor.intValue()) {
				return te;
			}
		}
		
		throw new IllegalArgumentException(
				"Tipo de estabelecimento não encontrado " + valor + ", o tipo de estabelecimento deve ser um dos seguintes: " + Arrays.toString(values()));
	}
	
}
