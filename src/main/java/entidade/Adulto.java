package entidade;

import java.math.BigDecimal;

public class Adulto extends TipoValor {

	@Override
	public BigDecimal getValor() {
		return new BigDecimal("150.00");
	}
	
	
}
