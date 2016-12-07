package entidade;

import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TestaTitular {

	DateTime niver1 = new DateTime(1993, 04, 18, 00, 00);
	DateTime niver2 = new DateTime(1998, 12, 01, 00, 00);
	DateTime niver3 = new DateTime(1972, 03, 11, 00, 00);
	DateTime niver4 = new DateTime(1930, 11, 11, 00, 00);

	Titular titular1 = new Titular(1, "Pelé");
	Titular titular2 = new Titular(1, "Garrincha");

	Dependente depMedio = new Dependente("Ana", niver1);
	Dependente depJovem = new Dependente("Jose", niver2);
	Dependente depAdulto = new Dependente("Bruna", niver3);
	Dependente depSenior = new Dependente("Seu Jose", niver4);

	BigDecimal JOVEM = new BigDecimal("22.00");
	BigDecimal MEDIO = new BigDecimal("50.00");
	BigDecimal ADULTO = new BigDecimal("150.00");
	BigDecimal SENIOR = new BigDecimal("320.00");

	@Test
	public void TestaBomCidadao() {

		Titular titular = new Titular(1, "Ana");
		titular.calcularCustoDependentes();
	}

	@Test
	public void TestaSemDependente() {

		assertNull(depMedio.getTitular());
		assertTrue(titular1.getDependentes().isEmpty());
	}

	@Test
	public void TestaAddDependente() {

		assertTrue(titular1.addDependente(depMedio));
	}

	@Test
	public void TestaDependenteMedio() {

		titular1.addDependente(depMedio);
		assertEquals(MEDIO, titular1.calcularCustoDependentes());
		
		assertEquals("Ana", titular1.getDependentes().get(0).getNome());
	}

	@Test
	public void TestaDependenteJovem() {

		titular1.addDependente(depJovem);
		assertEquals(JOVEM, titular1.calcularCustoDependentes());
		
		assertEquals("Jose", titular1.getDependentes().get(0).getNome());
	}

	@Test
	public void TestaDependenteAdulto() {

		titular1.addDependente(depAdulto);
		assertEquals(ADULTO, titular1.calcularCustoDependentes());
		
		assertEquals("Bruna", titular1.getDependentes().get(0).getNome());
	}

	@Test
	public void TestaDependenteSenior() {

		titular1.addDependente(depSenior);
		assertEquals(SENIOR, titular1.calcularCustoDependentes());
		
		assertEquals("Seu Jose", titular1.getDependentes().get(0).getNome());
	}

	@Test
	public void TestaValorGeral1() {

		BigDecimal valor1 = JOVEM.add(MEDIO);
		BigDecimal valor2 = ADULTO.add(SENIOR);

		titular1.addDependente(depMedio);
		titular1.addDependente(depJovem);

		titular2.addDependente(depAdulto);
		titular2.addDependente(depSenior);

		assertEquals(valor1, titular1.calcularCustoDependentes());
		assertEquals(valor2, titular2.calcularCustoDependentes());
	}
	
	@Test
	public void TestaValorGeral2() {

		BigDecimal valor1 = JOVEM.add(MEDIO).add(ADULTO).add(SENIOR);
		
		titular1.addDependente(depMedio);
		titular1.addDependente(depJovem);
		titular1.addDependente(depAdulto);
		titular1.addDependente(depSenior);

		assertEquals(valor1, titular1.calcularCustoDependentes());
	}

	@Test
	public void TestaDependenteDuplicado() {

		titular1.addDependente(depMedio);
		assertFalse(titular1.addDependente(depMedio));
	}

	@Test
	public void TestaDependenteInvalido() {

		Dependente d1 = null;

		assertFalse(titular1.addDependente(d1));
	}

	@Test(expected = IllegalArgumentException.class)
    public void TestaDependenteInvalido2(){
        Dependente d1 = new Dependente("batata", null);

        assertFalse(titular1.addDependente(d1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestaDependenteInvalido3(){
        Dependente d1 = new Dependente(null, niver1);

        assertFalse(titular1.addDependente(d1));
    }
}