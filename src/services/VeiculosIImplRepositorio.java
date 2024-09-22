package services;

import entities.Veiculo;
import interfaces.IVeiculosRepositorio;

import java.util.ArrayList;
import java.util.List;

public class VeiculosIImplRepositorio implements IVeiculosRepositorio {
    private List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo");
        }
        veiculos.add(veiculo);
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos); // Retorna uma cópia da lista
    }
}
