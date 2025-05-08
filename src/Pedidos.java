public class Pedidos {
    private String pessoa;
    private String pedido;
    private double valor;
    private double total;

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

    public double getTotal() {
        return total;
    }

    public Pedidos() {
        this.pedido = "";
        this.valor = 0.0;
        this.total = 0.0;
    }

    public boolean realizarPedido() {
        return pedido != null && !pedido.isEmpty();
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
                return;
        }

        total += valor;
        System.out.println("O valor do seu pedido foi: R$ " + valor);
        System.out.println("O total do seu pedido é: R$ " + total);
    }
}
