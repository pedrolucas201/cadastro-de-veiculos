package interfaces;

import entities.Veiculo;

import java.util.List;

public interface RepositorioVeiculos {
    void adicionarVeiculo(Veiculo veiculo);
    List<Veiculo> listarVeiculos();
}
