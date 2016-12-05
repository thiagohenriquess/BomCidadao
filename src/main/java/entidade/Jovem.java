package entidade;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Jovem extends TipoValor {
	
	public Jovem(String nome, DateTime dataNascimento) {
		// TODO Auto-generated constructor stub
	}

	BigDecimal valor = new BigDecimal("22.00");
	
	@Override
	public void setValor(BigDecimal valor) {
		super.valor = valor ;
		
	}}
