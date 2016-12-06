package entidade;

import java.math.BigDecimal;

public class Medio extends TipoValor {

	@Override
	public BigDecimal getValor() {
		return new BigDecimal("50.00");
	}

}
