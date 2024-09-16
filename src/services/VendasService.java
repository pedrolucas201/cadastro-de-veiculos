package services;

import entities.Veiculo;
import interfaces.ServicoVendas;
import interfaces.RepositorioVeiculos;

import java.util.List;

public class VendasService implements ServicoVendas {
    private RepositorioVeiculos repositorio;

    public VendasService(RepositorioVeiculos repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void registrarVenda(Veiculo veiculo) {
        repositorio.adicionarVeiculo(veiculo);
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return repositorio.listarVeiculos();
    }
}
