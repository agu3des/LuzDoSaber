# Estante Encantada 🎇📚

Aplicação que simula um sistema de uma livraria virtual.

## Tabela de Conteúdos
1. [Requisitos](#requisitos)
2. [Descrição do Projeto](#descrição-do-projeto)
3. [Descrição dos Arquivos](#descrição-dos-arquivos)
4. [Uso](#uso)
5. [Competências](#competências)
6. [Minimundo](#minimundo)

## Requisitos
- **SQL**
- **MySQL Workbench / PostgreSQL / SQL Server**
- **Python 3**
- **NumPy**
- **VS Code**

## Descrição do Projeto
O projeto de banco de dados *Estante Encantada* simula um sistema de gerenciamento de um banco de dados para uma livraria, visando gerenciar eficientemente o estoque de livros, clientes, pedidos e transações financeiras. Ele foi desenvolvido para proporcionar uma experiência fluida tanto para os funcionários quanto para os clientes, garantindo um controle eficaz dos recursos da livraria.

Além disso, o projeto foi desenvolvido nas disciplinas de Estrutura de Dados, Sistemas Operacionais e Protocolos de Interconexão de Redes, no curso de Sistemas para Internet no Instituto Federal da Paraíba.

## Descrição dos Arquivos

### Estante Encantada
| Nome                       | Descrição |
|----------------------------|----------|
| Comprador.py                | Classe Comprador com seus respectivos métodos. |
| CompradoresCadastrados.py   | Classe CompradoresCadastrados com seus respectivos métodos. |
| Compradores.txt             | Arquivo onde os compradores cadastrados estão armazenados. |
| ListaEncadeada.py           | Arquivo onde a estrutura de dados lista é definida. |
| ChainingHashTable.py        | Arquivo onde a estrutura de dados hash é definida. |
| EstoqueDeLivros.py          | Arquivo onde os livros são carregados. |
| Livro.py                    | Classe Livro com seus respectivos métodos. |
| Livros.txt                  | Arquivo onde os livros estão armazenados. |
| Servidor.py                 | Arquivo onde está o servidor. |
| Cliente.py                  | Arquivo onde está o Cliente. |
| Pedido.py                   | Arquivo acerca da compra e remoção de um pedido pelo cliente. |
| Documentacao.txt            | Documentação referente à disciplina de Protocolos de Rede. |

## Uso
Este projeto foi desenvolvido com o foco de aprimorar habilidades na linguagem SQL, modelagem de dados, além de técnicas de programação como listas encadeadas, tabelas hash, protocolos de rede, e manipulação de threads. Para utilizar a aplicação:

1. **Estante Encantada**:
    - O código pode ser executado após a instalação do Python 3 e NumPy.
    - O cliente e o servidor devem ser executados em paralelo para simular a comunicação entre eles.
    - O projeto utiliza conceitos de listas encadeadas, tabelas hash e protocolos TCP, além de threads e semáforos.

## Competências
- **Banco de Dados**: Modelagem e desenvolvimento de dados.
- **Estruturas de Dados**: Lista Encadeada e Hash Table.
- **Protocolos de Redes**: TCP.
- **Sistemas Operacionais**: Threads e Semáforo (Lock).

## Minimundo
A livraria *Estante Encantada* (ficcional) está em atividade há muito tempo e resolveu informatizar seu estabelecimento. A proprietária, em conversa com a equipe técnica, explicou como a livraria funciona:

- A livraria conta com dois tipos de funcionários: vendedores e caixas. Para os vendedores, é necessário armazenar categoria (estagiário ou efetivo), enquanto para os caixas, é registrada a escolaridade.
- O sistema também mantém informações sobre as editoras (CNPJ, contato, e endereço), filiais (identificador e endereço), livros (autor, código, nome, preço, editora) e clientes (nome, endereço, telefone, CPF).
- Para realizar uma compra, um cliente pode ser auxiliado por um vendedor. A data, hora e a nota fiscal eletrônica (com CNPJ da empresa, valor da compra, número e data de emissão da Receita Federal) também são registradas.

### Alunas
- [Ananda Guedes](https://github.com/agu3des)
- [Angêlica Araújo](https://github.com/araujo-angel)
- [Letícia Leite](https://github.com/l-e-t-i-c-i-a)
