public class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Pessoa() {
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.endereco = "";
    }

    // getters e setters
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
