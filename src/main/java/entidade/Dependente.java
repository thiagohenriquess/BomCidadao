package entidade;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;

public class Dependente {

	private String nome;
	private DateTime dataNascimento;
	private BigDecimal valor;
	private Titular titular;

	public Dependente(String nome, DateTime dataNascimento) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		setValor();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.length() < 3)
			throw new IllegalArgumentException("Nome inv�lido");
		this.nome = nome;
	}

	public DateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DateTime dataNascimento) {
		if (dataNascimento == null || dataNascimento.isAfterNow())
			throw new IllegalArgumentException("Data nascimento inv�lida");
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		Period period = new Period(dataNascimento, DateTime.now());
		return period.get(DurationFieldType.years());
	}

	public BigDecimal getValor() {
		return valor;
	}

	private void setValor() {
		valor = TipoValor.cria(getIdade());
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
}