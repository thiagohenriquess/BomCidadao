package entidade;

import org.junit.Test;

public class TestaTitular {
	
	@Test
	public void TestaBomCidadao() {
		Titular titular = new Titular(1,"Ana");
		titular.calcularCustoDependentes();
	}

}