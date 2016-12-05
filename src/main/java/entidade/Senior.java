package entidade;

import java.math.BigDecimal;

public class Senior extends TipoValor {

	BigDecimal valor = new BigDecimal("320.00");
	
	@Override
	public void setValor(BigDecimal valor) {
		super.valor = valor;
		
	}
	

}
