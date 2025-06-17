# BibliOn 📚✨

- Título do Aplicativo: BibliOn
- Aplicação que simula um sistema de uma livraria virtual.
---

## 🚀 Instalações necessárias

- Caso não tenha o Node.js, instale com:
  1. `winget install Schniz.fnm`
  2. `fnm install 22`
- Instale os módulos do projeto:
  ```bash
  npm install

* Instale o Angular CLI globalmente:

  ```bash
  npm install -g @angular/cli
  ```
* Instale o JSON Server (simula a API backend):

  ```bash
  npm install -g json-server
  ```

---

## ▶️ Rodar o projeto

1. Acesse a pasta do projeto:

   ```bash
   cd biblion
   ```
2. Em um terminal, execute o frontend:

   ```bash
   ng serve
   ```
3. Em outro terminal, execute o backend simulado:

   ```bash
   json-server --watch db.json
   ```

---

## 🌐 Link do Stackblitz

[🔗 Acessar o projeto no Stackblitz]()

---

## 📖 Descrição do Projeto

### 🎯 Temática

**Sistema de Gerenciamento de Livraria Virtual – BibliOn**

### 🏷️ Descrição do Problema

Livrarias modernas precisam de um sistema que permita gerenciar de forma eficiente seu catálogo de livros, cadastro de clientes, controle de pedidos, estoque e transações. Com o crescimento das vendas online, a informatização é essencial para otimizar processos, garantir agilidade no atendimento e melhorar a experiência dos clientes.

### 💡 Solução a ser Implementada

Desenvolvimento de uma aplicação web para o gerenciamento de uma livraria virtual. O sistema permitirá:

* Cadastro de livros, autores e editoras.
* Gerenciamento de estoque por filial.
* Registro de clientes e seus pedidos.
* Geração de notas fiscais eletrônicas.
* Controle de funcionários, separando vendedores e caixas.
* Histórico de compras e relacionamento com o cliente.

---

## 🗂️ Requisitos de Dados

* 📚 Livros
* 🏢 Editoras
* 🏬 Filiais
* 👥 Clientes
* 👨‍💼 Funcionários (vendedores e caixas)
* 🛒 Pedidos e Itens do Pedido
* 🧾 Notas Fiscais

---

## ✅ Requisitos Funcionais (RF)

* **RF1:** Cadastro e gerenciamento de livros, incluindo título, autor, preço, código e editora.
* **RF2:** Cadastro de clientes com dados pessoais e contato.
* **RF3:** Registro de pedidos, com seleção de livros e cálculo automático do valor total.
* **RF4:** Controle de estoque, com atualização após cada venda.
* **RF5:** Cadastro de funcionários, diferenciando entre vendedor (categoria) e caixa (escolaridade).
* **RF6:** Emissão de notas fiscais, incluindo CNPJ, data, número e valor.
* **RF7:** Gerenciamento de editoras e suas informações comerciais.

---

## 🚩 Requisitos Não Funcionais (RNF)

* **RNF1:** Desempenho: Suporte para até 100 acessos simultâneos.
* **RNF2:** Segurança: Dados sensíveis protegidos, autenticação de usuários administrativos.
* **RNF3:** Usabilidade: Interface intuitiva e responsiva (mobile e desktop).
* **RNF4:** Disponibilidade: Tempo de atividade superior a 99% mensal. Backup diário dos dados.
* **RNF5:** Escalabilidade: Suporte para múltiplas filiais e expansão do catálogo.
* **RNF6:** Portabilidade: Compatível com Chrome, Firefox, Edge e Safari.
* **RNF7:** Manutenibilidade: Código modular, reutilizável e bem documentado. Logs e monitoramento de erros.
* **RNF8:** Acessibilidade: Adequação às diretrizes WCAG 2.1.

---

## 🎨 Possíveis Telas (Templates/Layout)

1. **Tela Inicial:** Destaques, promoções e busca de livros.
2. **Tela de Cadastro de Livros:** Formulário para inserir ou editar informações dos livros.
3. **Tela de Clientes:** Listagem e gerenciamento dos clientes cadastrados.
4. **Tela de Pedidos:** Criação de pedidos, adição de livros e emissão de notas fiscais.
5. **Tela de Funcionários:** Cadastro e controle de vendedores e caixas.
6. **Tela de Estoque:** Monitoramento do estoque por filial.
7. **Tela de Editoras:** Cadastro e atualização de informações das editoras.

---

## 👩‍💻 Dev

* [Ananda Guedes](https://github.com/agu3des)