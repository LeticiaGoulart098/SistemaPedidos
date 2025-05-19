public class Pedidos {
    private String pessoa;
    private String pedido;
    private double valor; // representa o total do pedido (quantidade * preço unitário)
    private int quantidade;
    private String pagamento;

    public Pedidos() {
        this.pedido = "";
        this.valor = 0.0;
        this.quantidade = 0;
        this.pagamento = "";
    }


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
        return valor; // valor já representa total calculado
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
                System.out.println("Forma de pagamento: Pix");
                break;
            default:
                System.out.println("Opção de pagamento inválida!");
                return;
        }
        System.out.println("Pagamento realizado com sucesso!");
    }

    public void valorPedido() {
        double precoUnitario = 0;
        switch (pedido) {
            case "Bolo de Brigadeiro":
                precoUnitario = 25.99;
                break;
            case "Bolo Vulcão de Leite Ninho":
                precoUnitario = 39.99;
                break;
            case "Brownie Fatia":
                precoUnitario = 12.00;
                break;
            case "Cupcake Unidade":
                precoUnitario = 7.99;
                break;
            case "Copo da Felicidade":
                precoUnitario = 18.99;
                break;
            case "Pudim":
                precoUnitario = 45.00;
                break;
            default:
                System.out.println("Pedido inválido.");
                valor = 0.0;
                return;
        }
        valor = precoUnitario * quantidade;
    }

    public void finalizarPedido() {
        if (!realizarPedido()) {
            System.out.println("Nenhum pedido foi realizado.");
            return;
        }

        valorPedido();

        System.out.println("Cliente: " + pessoa);
        System.out.println("Pedido: " + pedido);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Valor total do pedido: R$ %.2f\n", valor);

        formaPagamento(); // Exibe forma de pagamento e valida
    }
}
