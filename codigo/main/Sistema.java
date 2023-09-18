import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Sistema {
    public static void main(String[] args) throws ParseException {
        Equipamento equipamento1 = new Equipamento("E001", "Escavadeira");
        Equipamento equipamento2 = new Equipamento("E002", "Betoneira");

        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        Date dataInicio1 = formatoData.parse("01-09-2023");
        Date dataFim1 = formatoData.parse("10-09-2023");
        Date dataInicio2 = formatoData.parse("05-09-2023");
        Date dataFim2 = formatoData.parse("15-09-2023");

        Cliente cliente1 = new Cliente("ClienteA", "1234567890");
        Cliente cliente2 = new Cliente("ClienteB", "9876543210");

        RegistroAluguel registro1 = new RegistroAluguel(cliente1, equipamento1, dataInicio1, dataFim1, 50.0);
        RegistroAluguel registro2 = new RegistroAluguel(cliente2, equipamento2, dataInicio2, dataFim2, 40.0);

        SistemaAluguel sistemaAluguel = new SistemaAluguel();
        sistemaAluguel.adicionarRegistroAluguel(registro1);
        sistemaAluguel.adicionarRegistroAluguel(registro2);
        sistemaAluguel.adicionarCliente(cliente1);
        sistemaAluguel.adicionarCliente(cliente2);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Controle de Aluguéis");
            System.out.println("1. Registrar novo aluguel");
            System.out.println("2. Cadastrar novo cliente");
            System.out.println("3. Consultar aluguéis por cliente");
            System.out.println("4. Gerar relatório mensal");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha após a entrada do número.

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = null;
                    for (Cliente c : sistemaAluguel.getClientes()) {
                        if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                            cliente = c;
                            break;
                        }
                    }
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Código do equipamento (E001 ou E002): ");
                    String codigoEquipamento = scanner.nextLine();
                    System.out.print("Data de início (dd-MM-yyyy): ");
                    Date dataInicio = formatoData.parse(scanner.nextLine());
                    System.out.print("Data de término (dd-MM-yyyy): ");
                    Date dataFim = formatoData.parse(scanner.nextLine());
                    System.out.print("Valor diário do equipamento: ");
                    double valorDiario = scanner.nextDouble();
                    Equipamento equipamentoSelecionado = null;
                    for (Equipamento equipamento : new Equipamento[]{equipamento1, equipamento2}) {
                        if (equipamento.getCodigo().equals(codigoEquipamento)) {
                            equipamentoSelecionado = equipamento;
                            break;
                        }
                    }
                    if (equipamentoSelecionado != null) {
                        RegistroAluguel novoRegistro = new RegistroAluguel(cliente, equipamentoSelecionado, dataInicio, dataFim, valorDiario);
                        sistemaAluguel.adicionarRegistroAluguel(novoRegistro);
                        System.out.println("Aluguel registrado com sucesso!");
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Nome do cliente: ");
                    String novoNomeCliente = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String novoTelefoneCliente = scanner.nextLine();
                    Cliente novoCliente = new Cliente(novoNomeCliente, novoTelefoneCliente);
                    sistemaAluguel.adicionarCliente(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeClienteConsulta = scanner.nextLine();
                    Cliente clienteConsulta = null;
                    for (Cliente c : sistemaAluguel.getClientes()) {
                        if (c.getNome().equalsIgnoreCase(nomeClienteConsulta)) {
                            clienteConsulta = c;
                            break;
                        }
                    }
                    if (clienteConsulta == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    List<RegistroAluguel> alugueisCliente = sistemaAluguel.consultarAlugueisPorCliente(clienteConsulta);
                    if (alugueisCliente.isEmpty()) {
                        System.out.println("Nenhum aluguel encontrado para o cliente " + nomeClienteConsulta);
                    } else {
                        System.out.println("Aluguéis para o cliente " + nomeClienteConsulta + ":");
                        for (RegistroAluguel registro : alugueisCliente) {
                            System.out.println("Equipamento: " + registro.getEquipamento().getDescricao());
                            System.out.println("Data de Início: " + formatoData.format(registro.getDataInicio()));
                            System.out.println("Data de Término: " + formatoData.format(registro.getDataFim()));
                            System.out.println("Valor Total: R$" + registro.calcularCustoTotal());
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o ano (yyyy): ");
                    int anoRelatorio = scanner.nextInt();
                    System.out.print("Digite o mês (1-12): ");
                    int mesRelatorio = scanner.nextInt();
                    double receitaMensal = sistemaAluguel.calcularReceitaMensal(anoRelatorio, mesRelatorio);
                    System.out.println("Receita total para " + mesRelatorio + "-" + anoRelatorio + ": R$" + receitaMensal);
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }
}
