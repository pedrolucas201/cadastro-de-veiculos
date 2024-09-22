package interfaces;

import entities.Veiculo;

import java.util.List;

public interface IVeiculosRepositorio {
    void adicionarVeiculo(Veiculo veiculo);
    List<Veiculo> listarVeiculos();

    // Novos métodos para pilha de veículos
    Veiculo desempilharVeiculo();
    Veiculo visualizarUltimoVeiculo();
    boolean isPilhaVazia();
}
