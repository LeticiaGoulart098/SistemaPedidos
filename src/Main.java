import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op;

        Pessoa cliente1 = null;
        ArrayList<Pedidos> listapedidos = new ArrayList<>();

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
                    System.out.println("Cardápio:\n- Bolo de Brigadeiro - R$ 25,99\n- Bolo Vulcão de Leite Ninho - R$ 39,99\n" +
                            "- Brownie Fatia - R$ 12,00\n- Cupcake Unidade - R$ 7,99\n- Copo da Felicidade - R$ 18,99\n- Pudim - R$ 45,00");
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

                    boolean continuar = true;
                    do {
                        System.out.println("Escolha o seu pedido:");
                        System.out.println("1 - Bolo de Brigadeiro");
                        System.out.println("2 - Bolo Vulcão de Leite Ninho");
                        System.out.println("3 - Brownie Fatia");
                        System.out.println("4 - Cupcake Unidade");
                        System.out.println("5 - Copo da Felicidade");
                        System.out.println("6 - Pudim");
                        System.out.print("Opção: ");
                        int opcao = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer

                        String item = switch (opcao) {
                            case 1 -> "Bolo de Brigadeiro";
                            case 2 -> "Bolo Vulcão de Leite Ninho";
                            case 3 -> "Brownie Fatia";
                            case 4 -> "Cupcake Unidade";
                            case 5 -> "Copo da Felicidade";
                            case 6 -> "Pudim";
                            default -> "";
                        };

                        if (item.isEmpty()) {
                            System.out.println("Opção inválida.");
                            continue;
                        }

                        Pedidos novoPedido = new Pedidos();
                        novoPedido.setPessoa(cliente1.getNome());
                        novoPedido.setPedido(item);
                        System.out.print("Quantidade: ");
                        novoPedido.setQuantidade(scanner.nextInt());
                        novoPedido.setValor(scanner.nextDouble());
                        scanner.nextLine(); // limpar buffer

                        listapedidos.add(novoPedido);

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
                        System.out.println(p.getQuantidade() + "x " + p.getPedido() + " - R$ " + p.getValor() + " (Subtotal: R$ " + subtotal + ")");
                    }
                    System.out.printf("Total: R$ %.2f\n", total);

                    System.out.println("\nEscolha a forma de pagamento: ");
                    System.out.println("1 - Crédito");
                    System.out.println("2 - Débito");
                    System.out.println("3 - Pix");
                    System.out.print("Opção: ");
                    String pagamento = scanner.nextLine();

                    System.out.println("Pagamento realizado via " + pagamento + ". Pedido finalizado!");
                    break;

                case "5":
                    System.out.println("Atendimento finalizado. Obrigada!");
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}


