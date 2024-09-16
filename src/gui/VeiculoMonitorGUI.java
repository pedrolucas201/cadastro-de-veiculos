package gui;

import entities.*;
import services.VeiculosRepositorioImpl;
import services.VendasService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoMonitorGUI extends JFrame {
    private VeiculosRepositorioImpl repositorio;
    private VendasService vendasService;

    private JTextField modeloField;
    private JTextField nomeProprietarioField;
    private JTextField documentoProprietarioField;
    private JComboBox<String> tipoVeiculoComboBox;
    private JTable veiculosTable;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;

    public VeiculoMonitorGUI() {
        repositorio = new VeiculosRepositorioImpl();
        vendasService = new VendasService(repositorio);

        setTitle("Cadastro de Veículos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Entrada de Dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        inputPanel.add(modeloField);

        inputPanel.add(new JLabel("Proprietário (Nome):"));
        nomeProprietarioField = new JTextField();
        inputPanel.add(nomeProprietarioField);

        inputPanel.add(new JLabel("Proprietário (Documento):"));
        documentoProprietarioField = new JTextField();
        inputPanel.add(documentoProprietarioField);

        inputPanel.add(new JLabel("Tipo de Veículo:"));
        tipoVeiculoComboBox = new JComboBox<>(new String[]{"Carro", "Moto", "Caminhão"});
        inputPanel.add(tipoVeiculoComboBox);

        // Botões de ação
        JButton adicionarButton = new JButton("Adicionar Veículo");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });

        JButton atualizarButton = new JButton("Atualizar Veículo");
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarVeiculo();
            }
        });

        JButton deletarButton = new JButton("Deletar Veículo");
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarVeiculo();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(deletarButton);

        // Tabela para listar veículos
        String[] colunas = {"Modelo", "Proprietário", "Documento", "Tipo"};
        tableModel = new DefaultTableModel(colunas, 0);
        veiculosTable = new JTable(tableModel);
        veiculosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        veiculosTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && veiculosTable.getSelectedRow() != -1) {
                preencherCamposParaEdicao(veiculosTable.getSelectedRow());
            }
        });
        JScrollPane scrollPane = new JScrollPane(veiculosTable);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void adicionarVeiculo() {
        String modelo = modeloField.getText();
        String nomeProprietario = nomeProprietarioField.getText();
        String documentoProprietario = documentoProprietarioField.getText();
        String tipoVeiculo = (String) tipoVeiculoComboBox.getSelectedItem();

        Proprietario proprietario = new Proprietario(nomeProprietario, documentoProprietario);
        Veiculo veiculo;

        if (tipoVeiculo.equals("Carro")) {
            veiculo = new Carro(modelo, proprietario);
        } else if (tipoVeiculo.equals("Moto")) {
            veiculo = new Moto(modelo, proprietario);
        } else {
            veiculo = new Caminhao(modelo, proprietario);
        }

        vendasService.registrarVenda(veiculo);
        JOptionPane.showMessageDialog(this, "Veículo adicionado com sucesso!");
        limparCampos();
        listarVeiculos();
    }

    private void atualizarVeiculo() {
        if (selectedRow != -1) {
            String modelo = modeloField.getText();
            String nomeProprietario = nomeProprietarioField.getText();
            String documentoProprietario = documentoProprietarioField.getText();
            String tipoVeiculo = (String) tipoVeiculoComboBox.getSelectedItem();

            List<Veiculo> veiculos = vendasService.listarVeiculos();
            Veiculo veiculo = veiculos.get(selectedRow);
            veiculo.setModelo(modelo);
            veiculo.getProprietario().setNome(nomeProprietario);
            veiculo.getProprietario().setDocumento(documentoProprietario);

            JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
            limparCampos();
            listarVeiculos();
        }
    }

    private void deletarVeiculo() {
        if (selectedRow != -1) {
            List<Veiculo> veiculos = vendasService.listarVeiculos();
            veiculos.remove(selectedRow);
            JOptionPane.showMessageDialog(this, "Veículo deletado com sucesso!");
            limparCampos();
            listarVeiculos();
        }
    }

    private void listarVeiculos() {
        List<Veiculo> veiculos = vendasService.listarVeiculos();
        tableModel.setRowCount(0);  // Limpa a tabela antes de listar novamente

        for (Veiculo veiculo : veiculos) {
            Object[] rowData = {
                    veiculo.getModelo(),
                    veiculo.getProprietario().getNome(),
                    veiculo.getProprietario().getDocumento(),
                    veiculo.getTipo()
            };
            tableModel.addRow(rowData);
        }
    }

    private void preencherCamposParaEdicao(int rowIndex) {
        selectedRow = rowIndex;

        List<Veiculo> veiculos = vendasService.listarVeiculos();
        Veiculo veiculo = veiculos.get(rowIndex);

        modeloField.setText(veiculo.getModelo());
        nomeProprietarioField.setText(veiculo.getProprietario().getNome());
        documentoProprietarioField.setText(veiculo.getProprietario().getDocumento());
        tipoVeiculoComboBox.setSelectedItem(veiculo.getTipo());
    }

    private void limparCampos() {
        modeloField.setText("");
        nomeProprietarioField.setText("");
        documentoProprietarioField.setText("");
        tipoVeiculoComboBox.setSelectedIndex(0);
        selectedRow = -1;
    }

    public static void main(String[] args) {
        new VeiculoMonitorGUI();
    }
}
