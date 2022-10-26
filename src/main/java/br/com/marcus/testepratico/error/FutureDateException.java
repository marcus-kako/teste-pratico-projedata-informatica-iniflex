package br.com.marcus.testepratico.error;

@SuppressWarnings("serial")
public class FutureDateException extends Exception {

  public FutureDateException() {
    super("Data inválida! a data está no futuro.");
  }
}
  