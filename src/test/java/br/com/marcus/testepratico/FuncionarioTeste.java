package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTeste {

  @Test
  @DisplayName("É possivel criar uma nova instância da classe Funcionario")
  public void testaConstrutorFuncionario() throws InvalidDateFormatException, FutureDateException {
    Funcionario funcionario = new Funcionario("funcionario1", "25/08/1998", 25.47, "operador");
    assertNotNull(funcionario);
  }

  @Test
  @DisplayName("Verifica se a classe Funcionario herdou métodos e atributos da classe Pessoa. ")
  public void testaFuncionarioEstendePessoa()
      throws InvalidDateFormatException, FutureDateException {
    String nome = "Me Contrata Please";
    String data = "22/08/2000";
    double salario = 3500.00;
    String funcao = "Desenvolvedor Java Jr";

    Funcionario funcionario = new Funcionario(nome, data, salario, funcao);
    assertNotNull(funcionario);

    assertNotNull(funcionario.getNome());
    assertEquals(nome, funcionario.getNome());
    assertNotNull(funcionario.getDataNascimento());
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    assertEquals(data, dtf.format(funcionario.getDataNascimento()));

    funcionario.setNome("Miranha");
    funcionario.setDataNascimento("20/10/1990");
    assertEquals("Miranha", funcionario.getNome());
    assertEquals("20/10/1990", dtf.format(funcionario.getDataNascimento()));

  }

  @Test
  @DisplayName("A Classe Funcionario possui atributos salario do tipo BigDecimal e funcao do tipo String. ")
  public void testaAtributosFuncionario() throws InvalidDateFormatException, FutureDateException {
    String nome = "Me Contrata Please";
    String data = "22/08/2000";
    double salario = 3500.00;
    String funcao = "Desenvolvedor Java Jr";

    Funcionario funcionario = new Funcionario(nome, data, salario, funcao);
    assertNotNull(funcionario);

    assertEquals(BigDecimal.class, funcionario.getSalario().getClass());
    assertEquals(String.class, funcionario.getFuncao().getClass());
  }

  @Test
  @DisplayName("É Possível setar os atributos da classe Funcionario. ")
  public void testaSetters() throws InvalidDateFormatException, FutureDateException {
    String nome = "Me Contrata Please";
    String data = "22/08/2000";
    double salario = 3500.00;
    String funcao = "Desenvolvedor Java Jr";

    Funcionario funcionario = new Funcionario(nome, data, salario, funcao);
    assertNotNull(funcionario);
    assertEquals(new BigDecimal(String.valueOf(salario)), funcionario.getSalario());
    assertEquals(funcao, funcionario.getFuncao());

    double novoSalario = 5000.00;
    String novaFuncao = "Desenvolvedor Java Senior";

    funcionario.setSalario(novoSalario);
    funcionario.setFuncao(novaFuncao);

    assertEquals(new BigDecimal(String.valueOf(novoSalario)), funcionario.getSalario());
    assertEquals(novaFuncao, funcionario.getFuncao());

  }
}
