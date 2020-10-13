package br.com.desafio.cnes.enumeradores;

import java.util.Arrays;

import lombok.Getter;

/**
 * Enumerador de Unidades Federativas
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
public enum UnidadeFederativa {

	AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("VA"), CE("CE"), ES("ES"), GO("GO"), MA("MA"), MT("MT"), 
	MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), RS("RS"), 
	RO("RO"), RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO"), DF("DF");
	
	@Getter
	private String valor;
	
	private UnidadeFederativa(String valor) {
		
		this.valor = valor;
	}
	
	public static UnidadeFederativa porValor(String valor) {
		
		for (UnidadeFederativa uf : values()) {
			if (uf.valor.equalsIgnoreCase(valor)) {
				return uf;
			}
		}
		
		throw new IllegalArgumentException(
				"Unidade da federação desconhecida " + valor + ", a unidade da federação deve ser uma das seguintes: " + Arrays.toString(values()));
	}
}
