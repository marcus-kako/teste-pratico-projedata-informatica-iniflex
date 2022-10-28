package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import java.util.ArrayList;

/** Classe referente ao requisito 3. */
public class Principal {

  private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

  public static void main(String[] args) throws InvalidDateFormatException, FutureDateException {
    // Requisitos.

    /**
     * 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
     * acima.
     */
    adicionaAoArray();
  }

  public static void adicionaAoArray() throws InvalidDateFormatException, FutureDateException {
    System.out
        .println("[Requisito 3.1] ___________________________________________________________");
    System.out.println(
        "========+========== Iniciando insersão de todos os funcionários ======+============ \n");

    /** Array de nomes (Seguindo ordem da tabela). */
    String[] nomes = { "Maria", "João", "Caio", "Miguel", "Alice", "Heitor", "Arthur", "Laura",
        "Heloísa", "Helena" };

    /** Array de datas (Seguindo ordem da tabela). */
    String[] datas = { "18/10/2000", "12/05/1990", "02/05/1961", "14/10/1988", "05/01/1995",
        "19/11/1999", "31/03/1993", "08/07/1994", "24/05/2003", "02/09/1996" };

    /** Array de salarios (Seguindo ordem da tabela). */
    double[] salarios = { 2_009.44, 2_284.38, 9_836.14, 19_119.88, 2_234.68, 1_582.72, 4_071.84,
        3_017.45, 1_606.85, 2_799.93 };

    /** Array de funcoes (Seguindo ordem da tabela). */
    String[] funcoes = { "Operador", "Operador", "Coordenador", "Diretor", "Recepcionista",
        "Operador", "Contador", "Gerente", "Eletricista", "Gerente" };

    /**
     * Realiza um loop for para adicionar as instancias no array de funcionarios.
     */
    try {
      for (int index = 0; index < nomes.length; index += 1) {
        Funcionario funcionario = new Funcionario(nomes[index], datas[index], salarios[index],
            funcoes[index]);
        funcionarios.add(funcionario);
        System.out.println(funcionario.toString());
      }

      System.out.println(
          "\n=============================== Insersão Concluida! ===============================");

    } catch (Exception e) {
      System.out.println(
          "=============================== A Insersão  Falhou! ===============================");
      System.out.println(e);
    }

  }
}
