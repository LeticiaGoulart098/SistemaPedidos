import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op;

        Pessoa cliente1 = null;
        Pedidos pedido1 = new Pedidos(); // Inicializa fora do loop para manter os dados

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
                    System.out.println("Cardápio:\n- Bolo de Brigadeiro - R$ 25,99\n- Bolo Vulcão de Leite Ninho R$ 39,99\n- " +
                            "Brownie Fatia R$ 12,00\n- Cupcake Unidade R$ 7,99\n- Copo da Felicidade - R$ 18,99\n- Pudim - R$ 45,00");
                    break;

                case "2":
                    if (cliente1 == null) {
                        cliente1 = new Pessoa(); // cria novo cliente

                        System.out.print("Digite seu nome: ");
                        cliente1.setNome(scanner.nextLine());
                        System.out.print("Digite o seu telefone: ");
                        cliente1.setTelefone(scanner.nextLine());
                        System.out.print("Digite o seu email: ");
                        cliente1.setEmail(scanner.nextLine());
                        System.out.print("Digite o seu endereço: ");
                        cliente1.setEndereco(scanner.nextLine());
                    }

                    System.out.println("Escolha o seu pedido!!");
                    System.out.println(" 1 - Bolo de Brigadeiro");
                    System.out.println(" 2 - Bolo Vulcão de Leite Ninho");
                    System.out.println(" 3 - Brownie Fatia");
                    System.out.println(" 4 - Cupcake Unidade");
                    System.out.println(" 5 - Copo da Felicidade");
                    System.out.println(" 6 - Pudim");
                    System.out.print("Opção: ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // limpa buffer

                    String pedido = "";
                    switch (opcao) {
                        case 1:
                            pedido = "Bolo de Brigadeiro";
                            break;
                        case 2:
                            pedido = "Bolo Vulcão de Leite Ninho";
                            break;
                        case 3:
                            pedido = "Brownie Fatia";
                            break;
                        case 4:
                            pedido = "Cupcake Unidade";
                            break;
                        case 5:
                            pedido = "Copo da Felicidade";
                            break;
                        case 6:
                            pedido = "Pudim";
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            continue;
                    }

                    pedido1.setPedido(pedido);
                    pedido1.realizarPedido();
                    pedido1.valorPedido();
                    break;

                case "3":
                    System.out.println("Nosso delivery funciona das 10h às 18h.");
                    break;

                case "4":
                    System.out.printf("Total do pedido: R$ %.2f\n", pedido1.getTotal());
                    break;


                case "5":
                    System.out.println("Atendimento finalizado. Obrigada!");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }


        }


    }

}
