package entidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;

public class TestaTitular {
	
	DateTime niver1 = new DateTime(1993, 04, 18, 00, 00);
	DateTime niver2 = new DateTime(1998, 12, 01, 00, 00);
	DateTime niver3 = new DateTime(1972, 03, 11, 00, 00);
	DateTime niver4 = new DateTime(1930, 11, 11, 00, 00);
	
	Titular titular1 = new Titular(1,"Pelé");
	Titular titular2 = new Titular(1,"Garrincha");
	
	Dependente d1 = new Dependente("Ana", niver1);
	Dependente d2 = new Dependente("Jose", niver2);
	Dependente d3 = new Dependente("Bruna", niver3);
	Dependente d4 = new Dependente("Seu Jose", niver4);
	
	BigDecimal JOVEM = new BigDecimal("22.00");
	BigDecimal MEDIO = new BigDecimal("50.00");
	BigDecimal ADULTO = new BigDecimal("150.00");
	BigDecimal SENIOR = new BigDecimal("320.00");
	
	@Test
	public void TestaBomCidadao() {
		
		Titular titular = new Titular(1,"Ana");		
		titular.calcularCustoDependentes();
		
	}
	
	@Test
	public void TestaSemDependente() {		
					
		assertTrue(titular1.getDependentes().isEmpty());		
	}
	
	@Test
	public void TestaAddDependente() {		
								
		assertTrue(titular1.addDependente(d1));		
	}
	
	@Test
	public void TestaDependenteMedioValor() {		
				
		titular1.addDependente(d1);
		assertEquals(MEDIO, titular1.calcularCustoDependentes());
	}
	
	@Test
	public void TestaDependenteJovemValor() {		
				
		titular1.addDependente(d2);
		assertEquals(JOVEM, titular1.calcularCustoDependentes());
	}
	
	@Test
	public void TestaDependenteAdultoValor() {		
				
		titular1.addDependente(d3);
		assertEquals(ADULTO, titular1.calcularCustoDependentes());
	}
	
	@Test
	public void TestaDependenteSeniorValor() {		
				
		titular1.addDependente(d4);
		assertEquals(SENIOR, titular1.calcularCustoDependentes());
	}
	
	@Test
	public void TestaValorGeral1() {		
		
		BigDecimal valor1 = JOVEM.add(MEDIO);
		BigDecimal valor2 = ADULTO.add(SENIOR);
		
		titular1.addDependente(d1);
		titular1.addDependente(d2);
		
		titular2.addDependente(d3);
		titular2.addDependente(d4);
		
		assertEquals(valor1, titular1.calcularCustoDependentes());
		assertEquals(valor2, titular2.calcularCustoDependentes());
	}

}