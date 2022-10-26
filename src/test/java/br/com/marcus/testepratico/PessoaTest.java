package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {

  @Test
  @DisplayName("É possivel criar uma nova instância da classe Pessoa")
  public void testaConstrutorPessoa() throws InvalidDateFormatException {
    Pessoa pessoa = new Pessoa("Pessoa1", "31/12/1998");
    assertNotNull(pessoa);
  }

  @Test
  @DisplayName("InvalidDateFormatException é lançada caso o formato da data seja inválida.")
  public void testaInvalidDateFormatException() throws InvalidDateFormatException {
    final String message = "Data inválida! a data precisa ser no formato dd/MM/yyyy .";

    assertThrows(InvalidDateFormatException.class,
        () -> new Pessoa("PessoaDataInvalida", "aaaaaaaaaa"), message);
    assertThrows(InvalidDateFormatException.class,
        () -> new Pessoa("PessoaDataInvalida", "1111111111"), message);
    assertThrows(InvalidDateFormatException.class,
        () -> new Pessoa("PessoaDataInvalida", "10-03-1980"), message);
  }

  @Test
  @DisplayName("FutureDateException é lançada caso a data seja uma data futura.")
  public void testaFutureDateExceptionException() throws FutureDateException {
    final String message = "Data inválida! a data está no futuro.";

    assertThrows(FutureDateException.class, () -> new Pessoa("PessoaDataFutura", "31/12/3020"),
        message);
  }

  @Test
  @DisplayName("A Classe Pessoa possui Getters e Setters")
  public void possuiGettersAndSetters() throws InvalidDateFormatException {
    // Ao criar Pessoa.
    String nome1 = "Antônio";
    String data1 = "25/08/1998";
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate1 = LocalDate.parse(data1, formato);
    Pessoa pessoa1 = new Pessoa(nome1, data1);

    assertTrue(pessoa1.getNome().equals(nome1));
    assertTrue(pessoa1.getDataNascimento().equals(localDate1));

    String nomeAtt = "Antônio Nunes";
    String dataAtt = "22/10/1998";
    LocalDate localDateAtt = LocalDate.parse(dataAtt, formato);

    pessoa1.setNome(nomeAtt);
    pessoa1.setDataNascimento(dataAtt);

    assertTrue(pessoa1.getNome().equals(nomeAtt));
    assertTrue(pessoa1.getDataNascimento().equals(localDateAtt));
  }
}
