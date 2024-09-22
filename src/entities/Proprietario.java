package entities;

public class Proprietario {
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;

    public Proprietario(String nome, String documento, String endereco, String telefone) {
        setNome(nome);
        setDocumento(documento);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento não pode ser vazio");
        }
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Proprietario: " +
                "Nome: " + nome + '\n' +
                " | Documento: " + documento + '\n' +
                " | Endereco: " + endereco + '\n' +
                " | Telefone: " + telefone + '\n';
    }
}
