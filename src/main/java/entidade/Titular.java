package entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Titular {

    private List<Dependente> dependentes;
    private Integer matricula;
    private String nome;

    public Titular(Integer matricula, String nome) {
        super();
        setMatricula(matricula);
        setNome(nome);
        dependentes = new ArrayList<Dependente>();
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

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public BigDecimal calcularCustoDependentes() {
        BigDecimal total = BigDecimal.ZERO;
        if (!dependentes.isEmpty()) {
            for (Dependente dependente : dependentes) {
                total = total.add(dependente.getValor());
            }
        }
        return total;
    }

    public Boolean addDependente(Dependente d1) {
        if (!dependentes.contains(d1)) {
            try {
                dependentes.add(d1);
                d1.setTitular(this);
            } catch (NullPointerException e) {
                return false;
            }
            return true;
        } else
            return false;
    }

}