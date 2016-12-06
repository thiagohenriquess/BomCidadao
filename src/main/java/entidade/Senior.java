package entidade;

import java.math.BigDecimal;

public class Senior extends TipoValor {

	@Override
	public BigDecimal getValor() {
		return new BigDecimal("320.00");
	}
	

}
