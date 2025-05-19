import java.sql.*;

public class PedidosDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/doceria_db";
    private static final String USUARIO = "leticia";
    private static final String SENHA = "88597960";

    // Salva apenas o pedido (cliente) e retorna o ID gerado
    public int salvarPedido(String cliente) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido) VALUES (?, NOW())";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Pedido criado com ID: " + id);
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
        return -1; // erro
    }

    // Salva os itens do pedido
    public void salvarItemPedido(int pedidoId, String produto, int quantidade, double valor, double valorTotal) {
        String sql = "INSERT INTO itens_pedido (pedido_id, produto, quantidade, valor,  valor_total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedidoId);
            stmt.setString(2, produto);
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, valor);
            stmt.setDouble(5, valorTotal);

            stmt.executeUpdate();
            System.out.println("Item do pedido salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar item do pedido: " + e.getMessage());
        }
    }
}
