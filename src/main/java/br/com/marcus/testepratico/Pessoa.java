package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 1– Classe Pessoa com os atributos: nome (String) data nascimento (LocalDate).
 */
public class Pessoa {

  // Aributos.
  private String nome;
  private LocalDate dataNascimento;

  /** Formato de data válido. */
  private final static String formatoDate = "dd/MM/yyyy";

  // Métodos.

  /**
   * Construtor da classe Pessoa.
   * 
   * @param nome           do tipo String, refere-se ao nome da pessoa.
   * @param dataNascimento do tipo String, refere-se à data de nascimento da
   *                       pessoa, é necessário que seja no formato dd/MM/yyyy .
   * @throws InvalidDateFormatException lançada caso a dataNascimento esteja no
   *                                    formato inválido.
   * @throws FutureDateException        lançada caso a dataNascimento seja uma
   *                                    data futura.
   */
  public Pessoa(String nome, String dataNascimento)
      throws InvalidDateFormatException, FutureDateException {
    this.nome = nome;
    this.dataNascimento = this.converterDate(dataNascimento);
  }

  /** Getter do atributo nome. retorna valor do tipo String. */
  public String getNome() {
    return nome;
  }

  /**
   * Setter do atributo nome. atualiza o atributo nome.
   * 
   * @param nome do tipo String, será o novo valor do atributo.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /** Getter do atributo dataNascimento. retorna valor do tipo LocalDate. */
  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  /**
   * Ao receber uma String com formáto válido, atualiza o atributo dataNascimento
   * do tipo LocalDate. Este método utiliza o método privado converterDate para
   * auxiliar nas validações.
   * 
   * @param stringDate refere-se à data que será criada. precisa ser no formato
   *                   dd/MM/yyyy.
   */
  public void setDataNascimento(String dataNascimento)
      throws InvalidDateFormatException, FutureDateException {
    this.dataNascimento = this.converterDate(dataNascimento);
  }

  /**
   * Ao receber uma String com formáto válido, retorna uma data do tipo LocalDate.
   * 
   * @param stringDate refere-se à data que será criada. precisa ser no formato
   *                   dd/MM/yyyy.
   * @throws InvalidDateFormatException Será lançada caso stringDate tenha um
   *                                    formato inválido.
   * @throws FutureDateException        Será lançada em caso da data recebida for
   *                                    uma data futura.
   */
  private LocalDate converterDate(String stringDate)
      throws InvalidDateFormatException, FutureDateException {
    this.isValidDate(stringDate);
    try {
      DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoDate);
      LocalDate data = LocalDate.parse(stringDate, formato);
      this.isFutureDate(data);
      return data;
    } catch (Exception e) {
      throw new FutureDateException();
    }
  }

  /**
   * Verifica se o formato da data é válido.
   * 
   * @param stringDate String, com precisa ser no formato dd/MM/yyyy.
   * 
   * @throws InvalidDateFormatException Será lançada caso stringDate tenha um
   *                                    formato inválido.
   */
  private void isValidDate(String stringDate) throws InvalidDateFormatException {
    if (!stringDate.contains("/")) {
      throw new InvalidDateFormatException();
    }

    String[] dma = stringDate.split("/");
    String dia = dma[0];
    String mes = dma[1];
    String ano = dma[2];

    if (dia.length() != 2 | mes.length() != 2 | ano.length() != 4) {
      throw new InvalidDateFormatException();
    }

    try {
      Integer.valueOf(dia);
      Integer.valueOf(mes);
      Integer.valueOf(ano);

    } catch (Exception e) {
      throw new InvalidDateFormatException();
    }
  }

  /**
   * Recebe uma data e verifica se está no futuro.
   * 
   * @param data Do tipo LocaDate correspondente à data de nascimento >> Não pode
   *             ser data futura.
   * 
   * @throws FutureDateException Será lançada em caso da data recebida for uma
   *                             data futura.
   */
  private void isFutureDate(LocalDate data) throws FutureDateException {
    LocalDate agora = LocalDate.now();
    if (agora.isBefore(data)) {
      throw new FutureDateException();
    }
  }
}
