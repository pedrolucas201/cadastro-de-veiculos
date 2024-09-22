package interfaces;

import entities.Veiculo;

import java.util.List;

public interface IVeiculosRepositorio {
    void adicionarVeiculo(Veiculo veiculo);
    List<Veiculo> listarVeiculos();
}
