Aplicação de Cadastro de Veículos

Introdução
A Aplicação de Cadastro de Veículos foi desenvolvida para gerenciar o cadastro de veículos e seus respectivos proprietários. O projeto implementa um CRUD completo com uma interface gráfica amigável, permitindo ao usuário cadastrar, visualizar, atualizar e excluir veículos. A aplicação é voltada para simplificar o controle de diferentes tipos de veículos, como carros, motos e caminhões, juntamente com as informações do proprietário.

Estrutura do Projeto

Entidades Principais:

> Veículo: Classe abstrata que serve de base para os veículos cadastrados, com atributos como modelo e proprietário.

>Proprietário: Armazena as informações do dono do veículo, como nome e documento.

Herança:

> Carro: Subclasse de Veículo, representando automóveis.

>Moto: Subclasse de Veículo, representando motocicletas.
Caminhão: Subclasse de Veículo, representando caminhões.

Interfaces:

> Repositório de Veículos: Interface para manipulação de dados dos veículos.

>Serviço de Vendas: Interface responsável por registrar e gerenciar as vendas e cadastros de veículos.

Implementação do CRUD:

> A aplicação oferece funcionalidades CRUD para o gerenciamento de veículos e proprietários, permitindo o usuário inserir, atualizar, visualizar e remover dados através de uma interface gráfica.

> A interface foi implementada utilizando Swing, com uma tabela organizada para exibição dos veículos cadastrados e campos para adicionar ou editar informações.

Funcionalidades

>Adicionar Veículos: O usuário pode inserir um novo veículo (Carro, Moto, Caminhão) com suas respectivas informações, como modelo e dados do proprietário (nome e documento).

> Listar Veículos: Todos os veículos são exibidos em uma tabela na interface gráfica, organizada por modelo, nome do proprietário, documento e tipo de veículo.

> Atualizar Veículos: Ao selecionar um veículo da tabela, os campos de edição são preenchidos automaticamente, permitindo que o usuário modifique os dados e salve as alterações.

> Deletar Veículos: O usuário pode remover um veículo selecionado da tabela com o clique de um botão.

Melhorias de Interface

> A exibição de veículos foi melhorada com o uso de uma tabela (JTable), onde cada coluna representa uma informação relevante, facilitando a leitura e a interação.

> As operações de edição e remoção foram integradas diretamente na interface, tornando a aplicação mais intuitiva e acessível.

Considerações Finais

> A Aplicação de Cadastro de Veículos apresenta uma solução eficaz para o gerenciamento de veículos e seus proprietários. Com funcionalidades completas de CRUD e uma interface gráfica interativa, o usuário pode realizar operações de cadastro, visualização, atualização e exclusão de veículos de forma simples e eficiente. A estrutura de herança facilita a adição de novos tipos de veículos, tornando o sistema escalável e flexível para futuras expansões.