package entidade;

import java.math.BigDecimal;
import java.util.List;

public class Titular {

	private static final BigDecimal JOVEM = new BigDecimal("22.00");
	private static final BigDecimal MEDIO = new BigDecimal("50.00");
	private static final BigDecimal ADULTO = new BigDecimal("150.00");
	private static final BigDecimal SENIOR = new BigDecimal("320.00");

	private List<Dependente> dependentes;
	private Integer matricula;
	private String nome;

	public Titular(Integer matricula, String nome) {
		super();
		setMatricula(matricula);
		setNome(nome);
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
				if (dependente.getIdade() < 21) {
					total = total.add(JOVEM);
				} else if (dependente.getIdade() < 35) {
					total = total.add(MEDIO);
				} else if (dependente.getIdade() < 65) {
					total = total.add(ADULTO);
				} else {
					total = total.add(SENIOR);
				}
			}
		}
		return total;
	}

}