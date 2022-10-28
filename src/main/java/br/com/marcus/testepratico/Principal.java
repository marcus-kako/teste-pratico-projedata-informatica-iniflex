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

    /**
     * 3.2 – Remover o funcionário “João” da lista.
     */
    removeByName("João");
  }

  public static void adicionaAoArray() throws InvalidDateFormatException, FutureDateException {
    System.out
        .println("[Requisito 3.1] ___________________________________________________________");
    System.out.println(
        "========+========== Iniciando insersão de todos os funcionários ======+============");

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
      }

      System.out.println(
          "=============================== Insersão Concluida! ===============================\n");

    } catch (Exception e) {
      System.out.println(
          "=============================== A Insersão Falhou! ===============================\n");
      System.out.println(e);
    }

  }

  public static void removeByName(String nome) {
    System.out
        .println("[Requisito 3.2] ___________________________________________________________");
    System.out.println(
        "========+========== Removendo funcionário da lista. ======+============");
    System.out.printf("==== Lista de funcionários [%s]: \n\n", funcionarios.size());
    for (Funcionario fun : funcionarios) {
      System.out.println(fun.toString());
    }
    Funcionario funcionarioRemove = null;
    System.out.printf("\n___ Verificando se o funcionário de nome: %s, se encontra na lista. ___\n", nome);
    for (Funcionario fun : funcionarios) {
      if (fun.getNome().equals(nome)) {
        funcionarioRemove = fun;
        System.out.printf(">> Funcionário de nome: %s, encontrado. iniciando remoção.\n", nome);
      }
    }

    if (funcionarioRemove.equals(null)) {
      System.out.println(">> Funcionário não encontrado.");
    } else {
      funcionarios.remove(funcionarioRemove);
      System.out.printf(">> Funcionário de nome: %s, removido com sucesso!\n", nome);
      System.out.printf("==== Lista de funcionários atualizada [%s]: \n\n", funcionarios.size());
      for (Funcionario fun : funcionarios) {
        System.out.println(fun.toString());
      }
    }
  }
}
