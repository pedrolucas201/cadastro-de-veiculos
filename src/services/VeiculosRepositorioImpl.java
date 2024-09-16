package services;

import entities.Veiculo;
import interfaces.RepositorioVeiculos;

import java.util.ArrayList;
import java.util.List;

public class VeiculosRepositorioImpl implements RepositorioVeiculos {
    private List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
}
