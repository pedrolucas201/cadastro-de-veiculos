package services;

import entities.Veiculo;
import interfaces.IServicoVendas;
import interfaces.IVeiculosRepositorio;

import java.util.List;

public class VendasService implements IServicoVendas {
    private IVeiculosRepositorio repositorio;

    public VendasService(IVeiculosRepositorio repositorio) {
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
