import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op;

        System.out.println("------------ Mel&Maya Doces --------------");

        while (true) {
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cardápio");
            System.out.println("2 - Fazer pedido");
            System.out.println("3 - Delivery");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            op = scanner.nextLine();

            switch (op) {
                case "1":
                    System.out.println("Cardápio:\n- Brigadeiro\n- Beijinho\n- Brownie\n- Cupcake");
                    break;
                case "2":
                    Pessoa cliente1 = new Pessoa();

                    System.out.print("Digite seu nome: ");
                    cliente1.setNome(scanner.nextLine());
                    System.out.print("Digite o seu telefone: ");
                    cliente1.setTelefone(scanner.nextLine());
                    System.out.print("Digite o seu email: ");
                    cliente1.setEmail(scanner.nextLine());
                    System.out.print("Digite o seu endereço: ");
                    cliente1.setEndereco(scanner.nextLine());

                    Pedidos pedido1 = new Pedidos();
                    System.out.print("Digite seu pedido: ");
                    pedido1.setPedido(scanner.nextLine());

                    System.out.println("\nPedido realizado com sucesso!");
                    System.out.println("Cliente: " + cliente1.getNome());
                    System.out.println("Pedido: " + pedido1.getPedido());
                    break;
                case "3":
                    System.out.println("Nosso delivery funciona das 10h às 18h.");
                    break;
                case "4":
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
