import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op;

        Pessoa cliente1 = null;
        Pedidos pedido1 = new Pedidos();
        ArrayList<Pedidos> listapedidos = new ArrayList<Pedidos>();

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
                    System.out.println("Cardápio:\n- Bolo de Brigadeiro - R$ 25,99\n- Bolo Vulcão de Leite Ninho R$ 39,99\n" +
                            "- Brownie Fatia R$ 12,00\n- Cupcake Unidade R$ 7,99\n- Copo da Felicidade - R$ 18,99\n- Pudim - R$ 45,00");
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

                        pedido1.setPessoa(cliente1.getNome()); // associa cliente ao pedido
                    }

                    System.out.println("Escolha o seu pedido:");
                    System.out.println("1 - Bolo de Brigadeiro");
                    System.out.println("2 - Bolo Vulcão de Leite Ninho");
                    System.out.println("3 - Brownie Fatia");
                    System.out.println("4 - Cupcake Unidade");
                    System.out.println("5 - Copo da Felicidade");
                    System.out.println("6 - Pudim");
                    System.out.print("Opção: ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // limpa buffer

                    String pedido = switch (opcao) {
                        case 1 -> "Bolo de Brigadeiro";
                        case 2 -> "Bolo Vulcão de Leite Ninho";
                        case 3 -> "Brownie Fatia";
                        case 4 -> "Cupcake Unidade";
                        case 5 -> "Copo da Felicidade";
                        case 6 -> "Pudim";
                        default -> "";
                    };

                    if (pedido.isEmpty()) {
                        System.out.println("Opção inválida.");
                        break;
                    }


                    pedido1.setPedido(pedido);
                    listapedidos.add(pedido1);
                    System.out.print("Quantidade: ");
                    pedido1.setQuantidade(scanner.nextInt());
                    scanner.nextLine(); // limpa buffer

                    System.out.println("Pedido adicionado com sucesso!");
                    break;

                case "3":
                    System.out.println("Nosso delivery funciona das 10h às 18h.");
                    break;

                case "4":
                    if (!pedido1.realizarPedido()) {
                        System.out.println("Nenhum pedido foi feito ainda.");
                        break;
                    }

                    System.out.print("O valor total do seu pedido: " + pedido1.getTotal());
                    System.out.println("Escolha a forma de pagamento: ");
                    System.out.println("1 - Crédito");
                    System.out.println("2 - Débito");
                    System.out.println("3 - Pix");
                    System.out.print("Opção: ");
                    String fp = scanner.nextLine();


                    pedido1.setPagamento(fp);
                    pedido1.finalizarPedido();
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
