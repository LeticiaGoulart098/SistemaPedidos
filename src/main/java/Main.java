import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op;

        Pessoa cliente1 = null;
        ArrayList<Pedidos> listapedidos = new ArrayList<>();
        PedidosDAO dao = new PedidosDAO();

        System.out.println("------------ Mel&Maya Doces --------------");

        while (true) {
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cardápio");
            System.out.println("2 - Fazer pedido");
            System.out.println("3 - Delivery");
            System.out.println("4 - Finalizar o pedido");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            op = scanner.nextLine();

            switch (op) {
                case "1":
                    System.out.println("Cardápio:\n" +
                            "- Bolo de Brigadeiro - R$ 25,99\n" +
                            "- Bolo Vulcão de Leite Ninho - R$ 39,99\n" +
                            "- Brownie Fatia - R$ 12,00\n" +
                            "- Cupcake Unidade - R$ 7,99\n" +
                            "- Copo da Felicidade - R$ 18,99\n" +
                            "- Pudim - R$ 45,00");
                    break;

                case "2":
                    if (cliente1 == null) {
                        cliente1 = new Pessoa();

                        System.out.print("Digite seu nome: ");
                        cliente1.setNome(scanner.nextLine());
                        System.out.print("Digite o seu telefone: ");
                        cliente1.setTelefone(scanner.nextLine());
                        System.out.print("Digite o seu email: ");
                        cliente1.setEmail(scanner.nextLine());
                        System.out.print("Digite o seu endereço: ");
                        cliente1.setEndereco(scanner.nextLine());
                    }

                    // Salvar o pedido (geral) e obter o ID
                    int pedidoId = dao.salvarPedido(cliente1.getNome());

                    boolean continuar = true;
                    do {
                        System.out.println("Escolha o seu pedido:");
                        System.out.println("1 - Bolo de Brigadeiro (R$ 25.99)");
                        System.out.println("2 - Bolo Vulcão de Leite Ninho (R$ 39.99)");
                        System.out.println("3 - Brownie Fatia (R$ 12.00)");
                        System.out.println("4 - Cupcake Unidade (R$ 7.99)");
                        System.out.println("5 - Copo da Felicidade (R$ 18.99)");
                        System.out.println("6 - Pudim (R$ 45.00)");
                        System.out.print("Opção: ");

                        int opcao = 0;
                        try {
                            opcao = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Opção inválida.");
                            continue;
                        }

                        String item;
                        double preco;

                        switch (opcao) {
                            case 1 -> {
                                item = "Bolo de Brigadeiro";
                                preco = 25.99;
                            }
                            case 2 -> {
                                item = "Bolo Vulcão de Leite Ninho";
                                preco = 39.99;
                            }
                            case 3 -> {
                                item = "Brownie Fatia";
                                preco = 12.00;
                            }
                            case 4 -> {
                                item = "Cupcake Unidade";
                                preco = 7.99;
                            }
                            case 5 -> {
                                item = "Copo da Felicidade";
                                preco = 18.99;
                            }
                            case 6 -> {
                                item = "Pudim";
                                preco = 45.00;
                            }
                            default -> {
                                System.out.println("Opção inválida.");
                                continue;
                            }
                        }

                        System.out.print("Quantidade: ");
                        int qtd = 0;
                        try {
                            qtd = Integer.parseInt(scanner.nextLine());
                            if (qtd <= 0) {
                                System.out.println("Quantidade deve ser maior que zero.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida.");
                            continue;
                        }

                        Pedidos novoPedido = new Pedidos();
                        novoPedido.setPessoa(cliente1.getNome());
                        novoPedido.setPedido(item);
                        novoPedido.setValor(preco);
                        novoPedido.setQuantidade(qtd);

                        listapedidos.add(novoPedido);

                        // Salvar item do pedido
                        dao.salvarItemPedido(pedidoId, item, qtd, preco, qtd * preco);

                        System.out.println("Pedido adicionado com sucesso!");

                        System.out.print("Deseja adicionar mais itens? (s/n): ");
                        String resposta = scanner.nextLine();
                        continuar = resposta.equalsIgnoreCase("s");

                    } while (continuar);
                    break;

                case "3":
                    System.out.println("Nosso delivery funciona das 10h às 18h.");
                    break;

                case "4":
                    if (listapedidos.isEmpty()) {
                        System.out.println("Nenhum pedido foi feito ainda.");
                        break;
                    }

                    double total = 0;
                    System.out.println("\n--- Resumo do Pedido ---");
                    for (Pedidos p : listapedidos) {
                        double subtotal = p.getQuantidade() * p.getValor();
                        total += subtotal;
                        System.out.printf("%dx %s - R$ %.2f (Subtotal: R$ %.2f)\n",
                                p.getQuantidade(), p.getPedido(), p.getValor(), subtotal);
                    }
                    System.out.printf("Total: R$ %.2f\n", total);

                    System.out.println("\nEscolha a forma de pagamento: ");
                    System.out.println("1 - Crédito");
                    System.out.println("2 - Débito");
                    System.out.println("3 - Pix");
                    System.out.print("Opção: ");
                    String pagamento = scanner.nextLine();

                    String formaPagamento = switch (pagamento) {
                        case "1" -> "Crédito";
                        case "2" -> "Débito";
                        case "3" -> "Pix";
                        default -> "Forma inválida";
                    };

                    System.out.println("Pagamento realizado via " + formaPagamento + ". Pedido finalizado!");
                    break;

                case "5":
                    System.out.println("Atendimento finalizado. Obrigada!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
