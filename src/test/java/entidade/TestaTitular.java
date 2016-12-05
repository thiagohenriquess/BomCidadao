package entidade;

import org.joda.time.DateTime;
import org.junit.Test;

public class TestaTitular {
	
	DateTime niver1 = new DateTime(1993, 04, 18, 00, 00);
	DateTime niver2 = new DateTime(1998, 12, 01, 00, 00);
	DateTime niver3 = new DateTime(1930, 03, 11, 00, 00);
	DateTime niver4 = new DateTime(1971, 13, 11, 00, 00);
	
	Dependente d1 = new Dependente("Ana", niver1);
	Dependente d2 = new Dependente("Jose", niver2);
	Dependente d3 = new Dependente("Bruna", niver3);
	
	@Test
	public void TestaBomCidadao() {
		Titular titular = new Titular(1,"Ana");
		titular.calcularCustoDependentes();
	}

}