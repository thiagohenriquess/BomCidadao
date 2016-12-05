package entidade;

import java.math.BigDecimal;

public class Medio extends TipoValor {
	
	BigDecimal valor = new BigDecimal("50.00");
	
	@Override
	public void setValor(BigDecimal valor) {
		super.valor = valor ;

	}

}
