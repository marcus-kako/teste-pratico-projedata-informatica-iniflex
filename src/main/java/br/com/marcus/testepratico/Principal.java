package br.com.marcus.testepratico;

import br.com.marcus.testepratico.error.FutureDateException;
import br.com.marcus.testepratico.error.InvalidDateFormatException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Classe referente ao requisito 3. */
public class Principal {

  /** Lista de funcionários. */
  private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

  /** Main da classe: Local onde Executamos os exercícios. */
  public static void main(String[] args) throws InvalidDateFormatException, FutureDateException {
    // Requisitos.

    // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela.
    System.out
        .println("[Requisito 3.1] ___________________________________________________________");
    addToArray();

    // 3.2 – Remover o funcionário “João” da lista.
    System.out
        .println("\n [Requisito 3.2] ___________________________________________________________");
    removeByName("João");

    // 3.3 – Imprimir todos os funcionários com todas suas informações.
    System.out
        .println("\n [Requisito 3.3] ___________________________________________________________");
    showTable();

    // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
    // de funcionários com novo valor.
    System.out
        .println("\n [Requisito 3.4] ___________________________________________________________");
    salaryIncrease(10);

    // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
    // e o valor a “lista de funcionários”.
    // 3.6 – Imprimir os funcionários, agrupados por função.
    System.out.println(
        "\n [Requisito 3.5, 3.6] ___________________________________________________________");
    groupOfEmployees();

    // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    System.out
        .println("\n [Requisito 3.8] ___________________________________________________________");
    birthdayMonth(10);
    birthdayMonth(12);

    // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
    // idade.
    System.out
        .println("\n [Requisito 3.9] ___________________________________________________________");
    olderEmployee();

    // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
    System.out
        .println("\n [Requisito 3.10] ___________________________________________________________");
    alphabeticalOrder();

    // 3.11 – Imprimir o total dos salários dos funcionários.
    System.out
        .println("\n [Requisito 3.11] ___________________________________________________________");
    totalSalary();

    // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
    // que o salário mínimo é R$1212.00.
    System.out
        .println("\n [Requisito 3.12] ___________________________________________________________");
    qtyMinimunWage(1212.00);
  }

  /** Cria Funcionários e adiciona à Lista de funcionários: funcionarios. */
  public static void addToArray() throws InvalidDateFormatException, FutureDateException {
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

  /**
   * Remove um funcionário da lista de funcionários.
   * 
   * @param nome refere-se ao nome do funcionário que será removido da lista.
   */
  public static void removeByName(String nome) {
    System.out.println("========+========== Removendo funcionário da lista. ======+============");
    System.out.printf("==== Tamanho da lista de funcionários atual: [%s] \n", funcionarios.size());
    Funcionario funcionarioRemove = null;
    System.out.printf(">>Verificando se o funcionário de nome: %s, se encontra na lista.\n", nome);
    for (Funcionario fun : funcionarios) {
      if (fun.getNome().equals(nome)) {
        funcionarioRemove = fun;
        System.out.printf(">> Funcionário de nome: %s, encontrado. iniciando remoção.\n", nome);
        System.out.println("\n>>> Detalhes: [" + fun.toString() + "]\n");
      }
    }

    if (funcionarioRemove.equals(null)) {
      System.out.println(">> Funcionário não encontrado.");
    } else {
      funcionarios.remove(funcionarioRemove);
      System.out.printf(">> Funcionário de nome: %s, removido com sucesso!\n", nome);
      System.out.printf("==== Tamanho da lista de funcionários atualizada: [%s] \n\n",
          funcionarios.size());
    }
  }

  /**
   * Imprime na tela uma tabela de todos os funcionários com todas as informações.
   */
  public static void showTable() {
    System.out
        .println("===+====== Imprimindo todos funcionários com todas informações ======+===\n");
    System.out.println("*************************************************************************");
    System.out.printf("%7s %20s %15s %17s", "NOME", "DATA NASCIMENTO", "SALÁRIO", "FUNÇÃO");
    System.out.println();
    System.out.println("*************************************************************************");
    for (Funcionario funcionario : funcionarios) {
      System.out.printf("%7s %20s %15s %17s", funcionario.getNome(),
          formatarData(funcionario.getDataNascimento()), formatarSalario(funcionario.getSalario()),
          funcionario.getFuncao());
      System.out
          .println("\n-------------------------------------------------------------------------");
//      System.out.println();
    }
  }

  /**
   * Retorna uma String referente ao salário transformado com separador de milhar
   * como ponto, e decimal como vírgula.
   * 
   * @param do tipo BigDecimal, refere-se ao salário a ser transformado.
   */
  private static String formatarSalario(BigDecimal salario) {
    try {
      String salarioStr = String.valueOf(salario);
      double salarioLong = Double.valueOf(salarioStr);
      DecimalFormat df = new DecimalFormat(",###.##");
      return df.format(salarioLong);
    } catch (Exception e) {
      return null;
    }

  }

  /**
   * Retorna uma String referente à uma data, transformada para o formato
   * dd/MM/yyyy.
   * 
   * @param data refere-se à data a ser transformada.
   */
  private static String formatarData(LocalDate data) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    formato.format(data);
    return formato.format(data);
  }

  /**
   * Recebe um valor referente à porcentágem. ex: Se for 25% >> porcentagem será
   * 25.
   */
  public static void salaryIncrease(float porcentagem) {
    for (Funcionario func : funcionarios) {
      func.salaryIncrease(porcentagem);
    }
    System.out.println(
        "$$$$$$$$$$$$$$$$$$$$ Aumentando salário em " + porcentagem + "% $$$$$$$$$$$$$$$$$$$$$$\n");
    showTable();
  }

  /**
   * Imprime na tela um Map com as chaves sendo as funções, e o valor sendo os
   * funcionários que trabalham naquela função.
   */
  public static void groupOfEmployees() {
    System.out.println(
        "================= Ordenando funcionários pelos seus cargos ======================");
    Map<String, ArrayList<String>> orderByFunc = new HashMap<>();
    for (Funcionario funcionario : funcionarios) {
      if (orderByFunc.get(funcionario.getFuncao()) == null) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add(funcionario.getNome());
        orderByFunc.put(funcionario.getFuncao(), nomes);
      } else {
        ArrayList<String> nomes = orderByFunc.get(funcionario.getFuncao());
        nomes.add(funcionario.getNome());
        orderByFunc.put(funcionario.getFuncao(), nomes);
      }
    }
    System.out.println(orderByFunc);

  }

  /**
   * Imprime na tela o nome dos funcionários que fazem aniversário no mês passado
   * por parâmetro.
   * 
   * @param mes refere-se ao numero do mês correspondente. (1-12) ex: 1 é o mês de
   *            Janeiro.
   */
  public static void birthdayMonth(int mes) {
    Map<Integer, String> mesesDoAno = new HashMap<>();

    Integer[] intMes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
        "Setembro", "Outubro", "Novembro", "Dezembro" };

    for (int index = 0; index < intMes.length; index += 1) {
      mesesDoAno.put(intMes[index], meses[index]);
    }

    System.out.printf("Aniversariantes do mes %s (%s): ", mes, mesesDoAno.get(mes));

    ArrayList<String> aniversariantes = new ArrayList<>();

    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getDataNascimento().getMonthValue() == mes) {
        aniversariantes.add(funcionario.getNome());
      }
    }

    System.out.println(aniversariantes.toString());
  }

  /**
   * Imprime na tela o nome e idade da pessoa mais velha da lista de funcionários.
   */
  public static void olderEmployee() {
    Funcionario oldEmployee = funcionarios.get(0);
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getDataNascimento().isBefore(oldEmployee.getDataNascimento())) {
        oldEmployee = funcionario;
      }
    }

    String nome = oldEmployee.getNome();
    LocalDate dataNascimento = oldEmployee.getDataNascimento();

    LocalDate agora = LocalDate.now();
    int idade = agora.compareTo(dataNascimento);

    System.out.println("================ Funcionário com a maior idade ===================");
    System.out.printf("Nome: %s, Idade: %s anos.\n", nome, idade);
  }

  /** Imprime na tela os nomes dos funcionários por ordem alfabética. */
  public static void alphabeticalOrder() {
    System.out
        .println("================ Lista de funcionários em ordem alfabética ===================");

    ArrayList<String> nomes = new ArrayList<>();
    for (Funcionario f : funcionarios) {
      nomes.add(f.getNome());
    }

    nomes.sort(null);
    System.out.println(nomes);
  }

  /** Imprime na tela o valor total somando o salário de todos os funcionários. */
  public static void totalSalary() {
    System.out
        .println("================ Valor total dos salários dos funcionários ===================");

    BigDecimal salarioTotal = new BigDecimal("0");

    for (Funcionario funcionario : funcionarios) {
      salarioTotal = salarioTotal.add(funcionario.getSalario());
    }
    System.out.printf("R$ %s \n", formatarSalario(salarioTotal));
  }

  /**
   * Imprime na tela uma mensagem que contem o nome e o equivalente à quantos
   * salários mínimos cada funcionário recebe.
   */
  private static void qtyMinimunWage(double minimunWage) {
    System.out.println(
        "========+========== Quantos salários mínimos cada funcionário recebe ======+============");

    BigDecimal valorSalarioMinimo = new BigDecimal(String.valueOf(minimunWage));
    String salarioMinimo = formatarSalario(valorSalarioMinimo);
    String temVirgula = salarioMinimo.contains(",") ? "" : ",00";
    System.out.printf("Considerando que o valor do salário mínimo seja R$ %s%s : \n\n",
        salarioMinimo, temVirgula);

    for (Funcionario funcionario : funcionarios) {
      String nome = funcionario.getNome();
      double qtySalariosMinimos = funcionario.getSalario().doubleValue() / minimunWage;
      System.out.printf(
          "A pessoa funcionária %7s recebe o equivalente à %4.1f salários mínimos. \n", nome,
          qtySalariosMinimos);
    }
  }
}
