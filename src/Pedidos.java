public class Pedidos {
    String Pessoa;
    String pedido;
    double valor;
    double total;


    public String getPessoa() {
        return Pessoa;
    }

    public void setPessoa(String pessoa) {
        Pessoa = pessoa;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pedidos() {
        this.pedido = pedido;
        this.total = total;
        this.valor = valor;
    }

    public void realizarPedido() {
        pedido = pedido + valor + total;

    }


}
