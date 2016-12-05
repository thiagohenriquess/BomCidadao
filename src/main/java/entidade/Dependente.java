package entidade;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;

public class Dependente {
	
	private static final BigDecimal JOVEM = new BigDecimal("22.00");
	private static final BigDecimal MEDIO = new BigDecimal("50.00");
	private static final BigDecimal ADULTO = new BigDecimal("150.00");
	private static final BigDecimal SENIOR = new BigDecimal("320.00");

	private String nome;
	private DateTime dataNascimento;
	private BigDecimal valor;

	public Dependente(String nome, DateTime dataNascimento) {
		super();
		setNome(nome);
		this.dataNascimento = dataNascimento;
		valor = getValor();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome==null || nome.length()<3) throw new IllegalArgumentException("Nome inv�lido");
		this.nome = nome;
	}
	
	public DateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(DateTime dataNascimento) {
		if(dataNascimento==null || dataNascimento.isAfterNow() )
			throw new IllegalArgumentException("Data nascimento inv�lida");
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		Period period = new Period(dataNascimento,DateTime.now());
		return period.get(DurationFieldType.years());
	}

	public BigDecimal getValor() {
		if (getIdade() < 21) {
			valor = JOVEM;
		} else if (getIdade() < 35) {
			valor = MEDIO;
		} else if (getIdade() < 65) {
			valor = ADULTO;
		} else {
			valor = SENIOR;
		}
		
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}