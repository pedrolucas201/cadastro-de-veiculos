package gui;

import entities.*;
import services.VeiculosIImplRepositorio;
import services.VendasService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoMonitorGUI extends JFrame {
    private VeiculosIImplRepositorio repositorio;
    private VendasService vendasService;

    private JTextField modeloField, assentosField, potenciaMotorField, numEixosField;
    private JTextField nomeProprietarioField, documentoProprietarioField, enderecoProprietarioField, telefoneProprietarioField;
    private JComboBox<String> tipoVeiculoComboBox, tipoMotoComboBox;
    private JTable veiculosTable;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;

    public VeiculoMonitorGUI() {
        repositorio = new VeiculosIImplRepositorio();
        vendasService = new VendasService(repositorio);

        setTitle("Cadastro de Veículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Entrada de Dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2));

        inputPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        inputPanel.add(modeloField);

        inputPanel.add(new JLabel("Proprietário (Nome):"));
        nomeProprietarioField = new JTextField();
        inputPanel.add(nomeProprietarioField);

        inputPanel.add(new JLabel("Proprietário (Documento):"));
        documentoProprietarioField = new JTextField();
        inputPanel.add(documentoProprietarioField);

        inputPanel.add(new JLabel("Proprietário (Endereço):"));
        enderecoProprietarioField = new JTextField();
        inputPanel.add(enderecoProprietarioField);

        inputPanel.add(new JLabel("Proprietário (Telefone):"));
        telefoneProprietarioField = new JTextField();
        inputPanel.add(telefoneProprietarioField);

        inputPanel.add(new JLabel("Tipo de Veículo:"));
        tipoVeiculoComboBox = new JComboBox<>(new String[]{"Carro", "Moto", "Caminhão"});
        tipoVeiculoComboBox.addActionListener(e -> atualizarCamposVeiculo());
        inputPanel.add(tipoVeiculoComboBox);

        // Campos dinâmicos de acordo com o tipo de veículo
        inputPanel.add(new JLabel("Número de Assentos (Carro):"));
        assentosField = new JTextField();
        inputPanel.add(assentosField);

        inputPanel.add(new JLabel("Potência do Motor (Carro):"));
        potenciaMotorField = new JTextField();
        inputPanel.add(potenciaMotorField);

        inputPanel.add(new JLabel("Tipo de Moto:"));
        tipoMotoComboBox = new JComboBox<>(new String[]{"NAKED", "TRAIL", "BIGTRAIL", "OFFROAD"});
        inputPanel.add(tipoMotoComboBox);

        inputPanel.add(new JLabel("Número de Eixos (Caminhão):"));
        numEixosField = new JTextField();
        inputPanel.add(numEixosField);

        // Botões de ação
        JButton adicionarButton = new JButton("Adicionar Veículo");
        adicionarButton.addActionListener(e -> adicionarVeiculo());

        JButton atualizarButton = new JButton("Atualizar Veículo");
        atualizarButton.addActionListener(e -> atualizarVeiculo());

        JButton deletarButton = new JButton("Deletar Veículo");
        deletarButton.addActionListener(e -> deletarVeiculo());

        JButton visualizarUltimoButton = new JButton("Visualizar Último Veículo");
        visualizarUltimoButton.addActionListener(e -> visualizarUltimoVeiculo());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(deletarButton);
        buttonPanel.add(visualizarUltimoButton);

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

        // Adiciona os painéis ao layout
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
        atualizarCamposVeiculo(); // Atualizar os campos inicialmente
    }

    private void adicionarVeiculo() {
        String modelo = modeloField.getText();
        String nomeProprietario = nomeProprietarioField.getText();
        String documentoProprietario = documentoProprietarioField.getText();
        String endereco = enderecoProprietarioField.getText();
        String telefone = telefoneProprietarioField.getText();
        String tipoVeiculo = (String) tipoVeiculoComboBox.getSelectedItem();

        Proprietario proprietario = new Proprietario(nomeProprietario, documentoProprietario, endereco, telefone);
        Veiculo veiculo;

        if (tipoVeiculo.equals("Carro")) {
            int assentos = Integer.parseInt(assentosField.getText());
            double potenciaMotor = Double.parseDouble(potenciaMotorField.getText());
            veiculo = new Carro(modelo, proprietario, assentos, potenciaMotor);
        } else if (tipoVeiculo.equals("Moto")) {
            Moto.TipoMoto tipoMoto = Moto.TipoMoto.valueOf((String) tipoMotoComboBox.getSelectedItem());
            veiculo = new Moto(modelo, proprietario, tipoMoto);
        } else {
            int numEixos = Integer.parseInt(numEixosField.getText());
            veiculo = new Caminhao(modelo, proprietario, numEixos);
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
            String endereco = enderecoProprietarioField.getText();
            String telefone = telefoneProprietarioField.getText();
            String tipoVeiculo = (String) tipoVeiculoComboBox.getSelectedItem();

            List<Veiculo> veiculos = vendasService.listarVeiculos();
            Veiculo veiculo = veiculos.get(selectedRow);
            veiculo.setModelo(modelo);
            veiculo.getProprietario().setNome(nomeProprietario);
            veiculo.getProprietario().setDocumento(documentoProprietario);
            veiculo.getProprietario().setEndereco(endereco);
            veiculo.getProprietario().setTelefone(telefone);

            if (tipoVeiculo.equals("Carro")) {
                ((Carro) veiculo).setAssentos(Integer.parseInt(assentosField.getText()));
                ((Carro) veiculo).setPotenciaMotor(Double.parseDouble(potenciaMotorField.getText()));
            } else if (tipoVeiculo.equals("Moto")) {
                ((Moto) veiculo).setTipoMoto(Moto.TipoMoto.valueOf((String) tipoMotoComboBox.getSelectedItem()));
            } else {
                ((Caminhao) veiculo).setNumEixos(Integer.parseInt(numEixosField.getText()));
            }

            JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
            limparCampos();
            listarVeiculos();
        }
    }

    private void deletarVeiculo() {
        if (selectedRow != -1) {
            List<Veiculo> veiculos = vendasService.listarVeiculos();
            veiculos.remove(selectedRow); // Remover da lista
            repositorio.desempilharVeiculo(); // Remover da pilha
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

    private void visualizarUltimoVeiculo() {
        try {
            Veiculo ultimoVeiculo = repositorio.visualizarUltimoVeiculo();
            JOptionPane.showMessageDialog(this, "Último veículo adicionado: " + ultimoVeiculo.getModelo());
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preencherCamposParaEdicao(int rowIndex) {
        selectedRow = rowIndex;

        List<Veiculo> veiculos = vendasService.listarVeiculos();
        Veiculo veiculo = veiculos.get(rowIndex);

        modeloField.setText(veiculo.getModelo());
        nomeProprietarioField.setText(veiculo.getProprietario().getNome());
        documentoProprietarioField.setText(veiculo.getProprietario().getDocumento());
        enderecoProprietarioField.setText(veiculo.getProprietario().getEndereco());
        telefoneProprietarioField.setText(veiculo.getProprietario().getTelefone());

        if (veiculo instanceof Carro) {
            tipoVeiculoComboBox.setSelectedItem("Carro");
            assentosField.setText(String.valueOf(((Carro) veiculo).getAssentos()));
            potenciaMotorField.setText(String.valueOf(((Carro) veiculo).getPotenciaMotor()));
            numEixosField.setText("");
            tipoMotoComboBox.setSelectedItem("NAKED");
        } else if (veiculo instanceof Moto) {
            tipoVeiculoComboBox.setSelectedItem("Moto");
            tipoMotoComboBox.setSelectedItem(((Moto) veiculo).getTipoMoto().name());
            assentosField.setText("");
            potenciaMotorField.setText("");
            numEixosField.setText("");
        } else {
            tipoVeiculoComboBox.setSelectedItem("Caminhão");
            numEixosField.setText(String.valueOf(((Caminhao) veiculo).getNumEixos()));
            assentosField.setText("");
            potenciaMotorField.setText("");
            tipoMotoComboBox.setSelectedItem("NAKED");
        }
    }

    private void limparCampos() {
        modeloField.setText("");
        nomeProprietarioField.setText("");
        documentoProprietarioField.setText("");
        enderecoProprietarioField.setText("");
        telefoneProprietarioField.setText("");
        tipoVeiculoComboBox.setSelectedIndex(0);
        assentosField.setText("");
        potenciaMotorField.setText("");
        numEixosField.setText("");
        tipoMotoComboBox.setSelectedIndex(0);
        selectedRow = -1; // Reseta a seleção
    }

    private void atualizarCamposVeiculo() {
        String tipoSelecionado = (String) tipoVeiculoComboBox.getSelectedItem();
        if ("Carro".equals(tipoSelecionado)) {
            assentosField.setVisible(true);
            potenciaMotorField.setVisible(true);
            tipoMotoComboBox.setVisible(false);
            numEixosField.setVisible(false);
        } else if ("Moto".equals(tipoSelecionado)) {
            assentosField.setVisible(false);
            potenciaMotorField.setVisible(false);
            tipoMotoComboBox.setVisible(true);
            numEixosField.setVisible(false);
        } else {
            assentosField.setVisible(false);
            potenciaMotorField.setVisible(false);
            tipoMotoComboBox.setVisible(false);
            numEixosField.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new VeiculoMonitorGUI();
    }
}
