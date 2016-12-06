package entidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class DependenteTest {
	
	DateTime niver1 = new DateTime(1993, 04, 18, 00, 00);
	DateTime niver2 = new DateTime(1998, 12, 01, 00, 00);
	
	Dependente d1 = new Dependente("Ana", niver1);
	Dependente d2 = new Dependente("Jose", niver2);
	
	@Test
	public void TestaDataTime1(){
				
		assertEquals("1993-04-18", niver1.toString("YYYY-MM-dd"));
		assertEquals("Abril", niver1.monthOfYear().getAsText());		
	}
	
	@Test
	public void TestaDataTime2(){

		assertNotEquals("Janeiro", niver1.monthOfYear().getAsText());
		assertNotEquals("ABRIL", niver1.monthOfYear().getAsText());
	}
	
	@Test
	public void TestaDataDependente(){
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-YYYY");
		
		assertEquals("18-04-1993", d1.getDataNascimento().toString(fmt));
	}
	
	@Test
	public void TestaIdadeDependente(){
		
		assertEquals(23, d1.getIdade());
	}
	
	@Test
	public void TestaValorDependente(){
		BigDecimal valorMedio = new BigDecimal("50.00"); 
		BigDecimal valorJovem = new BigDecimal("22.00");
		
		assertEquals(valorMedio, d1.getValor());
		assertEquals(valorJovem, d2.getValor());
	}

}
