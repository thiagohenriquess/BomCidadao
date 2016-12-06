package entidade;

import java.math.BigDecimal;


public abstract class TipoValor {

	public static BigDecimal valor;
	
	abstract public BigDecimal getValor();

	static BigDecimal cria(int idade) {
		if (idade < 21) {
			valor = new Jovem().getValor();
		} else if (idade < 35) {
			valor = new Medio().getValor();
		} else if (idade < 65) {
			valor = new Adulto().getValor();
		} else {
			valor = new Senior().getValor();

		}
		return valor;
	}
}
