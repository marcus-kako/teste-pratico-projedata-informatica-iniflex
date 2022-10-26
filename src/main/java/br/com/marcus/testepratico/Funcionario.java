package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import java.math.BigDecimal;

/**
 * 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário
 * (BigDecimal) função (String).
 * 
 */
public class Funcionario extends Pessoa {

  // Atributos.

  private BigDecimal salario;
  private String funcao;

  // Métodos.

  /**
   * Construtor da classe Funcionario.
   * 
   * @param nome           Nome da pessoa funcionária.
   * @param dataNascimento String, no formato dd/MM/yyyy, refere-se à data de
   *                       nascimento da pessoa funcionária.
   * @param salario        Refere-se ao salário da pessoa funcionária.
   * @param funcao         Refere-se ao cargo/função da pessoa funcionária.
   * @throws InvalidDateFormatException caso a data seja inválida.
   * @throws FutureDateException        caso a data seja uma data futura.
   */
  public Funcionario(String nome, String dataNascimento, double salario, String funcao)
      throws InvalidDateFormatException, FutureDateException {
    super(nome, dataNascimento);
    this.salario = this.toBigDecimal(salario);
    this.funcao = funcao;
  }

  /** Retorna o valor do tipo BigDecimal referente ao atributo salario. */
  public BigDecimal getSalario() {
    return salario;
  }

  /**
   * Recebe um valor do tipo double, utiliza método auxiliar toBigDecimal para
   * transformar em um valor do tipo BigDecimal atualiza o atributo salario.
   */
  public void setSalario(double salario) {
    this.salario = this.toBigDecimal(salario);
  }

  /** Retorna o valor do tipo String referente ao atributo funcao. */
  public String getFuncao() {
    return funcao;
  }

  /** Recebe um valor do tipo String e atualiza o atributo funcao. */
  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  /**
   * Recebe um valor do tipo double e retorna o valor convertido em BigDecimal.
   */
  private BigDecimal toBigDecimal(double salario) {
    String strSalario = String.valueOf(salario);
    BigDecimal converterSalario = new BigDecimal(strSalario);
    return converterSalario;
  }

}
