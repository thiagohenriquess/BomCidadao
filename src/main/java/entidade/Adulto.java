package entidade;

import java.math.BigDecimal;

public class Adulto extends TipoValor {
	
	BigDecimal valor = new BigDecimal("150.00");
	
	@Override
	public void setValor(BigDecimal valor) {
		super.valor = valor;
		
	}
	
	
}
