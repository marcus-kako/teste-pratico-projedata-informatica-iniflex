package br.com.marcus.testepratico.error;

@SuppressWarnings("serial")
public class InvalidDateFormatException extends Exception {
  public InvalidDateFormatException() {
    super("Data inválida! a data precisa ser no formato dd/MM/yyyy .");
  }
}
