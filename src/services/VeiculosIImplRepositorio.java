package services;

import entities.Veiculo;
import interfaces.IVeiculosRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VeiculosIImplRepositorio implements IVeiculosRepositorio {
    private List<Veiculo> veiculos = new ArrayList<>();
    private Stack<Veiculo> pilhaVeiculos = new Stack<>();

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo");
        }
        veiculos.add(veiculo);
        pilhaVeiculos.push(veiculo);  // Adiciona à pilha
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos); // Retorna uma cópia da lista
    }

    @Override
    public Veiculo desempilharVeiculo() {
        if (pilhaVeiculos.isEmpty()) {
            throw new IllegalStateException("A pilha de veículos está vazia.");
        }
        return pilhaVeiculos.pop();
    }

    @Override
    public Veiculo visualizarUltimoVeiculo() {
        if (pilhaVeiculos.isEmpty()) {
            throw new IllegalStateException("A pilha de veículos está vazia.");
        }
        return pilhaVeiculos.peek();
    }

    @Override
    public boolean isPilhaVazia() {
        return pilhaVeiculos.isEmpty();
    }
}
