package entidade;

import java.math.BigDecimal;

public abstract class TipoValor {
	
	public BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public abstract void setValor(BigDecimal valor);
	
	


}
