package entidade;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

public class TestaTitular {
	
	DateTime niver1 = new DateTime(1993, 04, 18, 00, 00);
	DateTime niver2 = new DateTime(1998, 12, 01, 00, 00);
	DateTime niver3 = new DateTime(1972, 03, 11, 00, 00);
	DateTime niver4 = new DateTime(1930, 11, 11, 00, 00);
	
	Dependente d1 = new Dependente("Ana", niver1);
	Dependente d2 = new Dependente("Jose", niver2);
	Dependente d3 = new Dependente("Bruna", niver3);
	Dependente d4 = new Dependente("Seu Jose", niver4);
		
	@Test
	public void TestaBomCidadao() {
		
		Titular titular = new Titular(1,"Ana");		
		titular.calcularCustoDependentes();
		
	}
	
	@Test
	public void TestaSemDependente() {		
		
		Titular titular1 = new Titular(1,"Zulu");				
		assertNull(titular1.getDependentes());		
	}
	
	@Test
	public void TestaAddDependente() {		
		
		Titular titular1 = new Titular(1,"Zulu");				
		assertTrue(titular1.addDependente(d1));		
	}

}