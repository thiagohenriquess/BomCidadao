package entidade;

import java.math.BigDecimal;

public class Jovem extends TipoValor {

	@Override
	public BigDecimal getValor() {
		return new BigDecimal("22.00");
	}

}
