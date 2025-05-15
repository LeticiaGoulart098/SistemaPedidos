import java.util.Objects;

public class Pedidos {
    private String pessoa;
    private String pedido;
    private double valor;
    private int quantidade;
    private String pagamento;

    public Pedidos() {
        this.pedido = "";
        this.valor = 0.0;
        this.quantidade = 1;
        this.pagamento = "";
    }

    // Getters e Setters
    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public double getTotal() {
        return valor * quantidade;
    }

    public boolean realizarPedido() {
        return pedido != null && !pedido.isEmpty();
    }

    public void formaPagamento() {
        switch (pagamento) {
            case "1":
                System.out.println("Forma de pagamento: Crédito");
                break;
            case "2":
                System.out.println("Forma de pagamento: Débito");
                break;
            case "3":
                System.out.println("Forma de pagamento: Dinheiro");
                break;
            default:
                System.out.println("Opção de pagamento inválida!");
                return;
        }
        System.out.println("Pagamento realizado com sucesso!");
    }

    public void valorPedido() {
        switch (pedido) {
            case "Bolo de Brigadeiro":
                valor = 25.99;
                break;
            case "Bolo Vulcão de Leite Ninho":
                valor = 39.99;
                break;
            case "Brownie Fatia":
                valor = 12.00;
                break;
            case "Cupcake Unidade":
                valor = 7.99;
                break;
            case "Copo da Felicidade":
                valor = 18.99;
                break;
            case "Pudim":
                valor = 45.00;
                break;
            default:
                System.out.println("Pedido inválido.");
                valor = 0.0;
                return;
        }
    }

    public void finalizarPedido() {
        if (!realizarPedido()) {
            System.out.println("Nenhum pedido foi realizado.");
            return;
        }

        valorPedido(); // Define o valor com base no pedido
        double total = getTotal();

        System.out.println("Cliente: " + pessoa);
        System.out.println("Pedido: " + pedido);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Valor unitário: R$ %.2f\n", valor);
        System.out.printf("Total do pedido: R$ %.2f\n", total);

        formaPagamento(); // Exibe forma de pagamento e valida
    }
}
