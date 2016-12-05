package entidade;

import java.math.BigDecimal;
import java.util.List;

public class Titular {

	private List<Dependente> dependentes;
	private Integer matricula;
	private String nome;

	public Titular(Integer matricula, String nome) {
		super();
		setMatricula(matricula);
		setNome(nome);
		dependentes = null;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		if (matricula == null)
			throw new IllegalArgumentException("Matrícula não pode ser nula.");
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.length() < 3)
			throw new IllegalArgumentException("Nome inválido");
		this.nome = nome;
	}

	public BigDecimal calcularCustoDependentes() {
		BigDecimal total = BigDecimal.ZERO;
		if (dependentes != null) {			
			for (Dependente dependente : dependentes) {
				total.add( dependente.getValor());
			}
		}
		return total;
	}

}