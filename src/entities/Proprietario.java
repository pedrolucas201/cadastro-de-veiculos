package entities;

public class Proprietario {
    private String nome;
    private String documento;

    public Proprietario(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
