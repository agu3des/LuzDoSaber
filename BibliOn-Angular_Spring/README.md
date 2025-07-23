# 📱 BibliOn – Livraria Virtual 📚✨

### Título do Aplicativo: **BibliOn**  
**Descrição:** Aplicativo Android que simula uma livraria virtual. Permite o cadastro de livros, gerenciamento de pedidos, clientes, editoras, funcionários e muito mais, utilizando Firebase como backend.

---

## 🚀 Instalações Necessárias

- ✅ **Android Studio** ([Baixar aqui](https://developer.android.com/studio))  
- ✅ SDK Android atualizado (mínimo recomendado: API 26 ou superior)  
- ✅ Conta no [Firebase](https://console.firebase.google.com/) configurada  

---

## 🔥 Configuração do Firebase

1. Acesse o [Firebase Console](https://console.firebase.google.com/).  
2. Crie um projeto chamado `BibliOn`.  
3. Adicione um aplicativo Android ao projeto (insira o nome do pacote do seu app).  
4. Baixe o arquivo `google-services.json` e coloque na pasta:  
```

app/google-services.json

````
5. Ative os seguintes serviços no Firebase:  
- **Firebase Authentication** (opcional para login de usuários)  
- **Cloud Firestore** (banco de dados em nuvem)  
- **Firebase Storage** (opcional, para imagens de livros, etc.)  

6. No arquivo `build.gradle (Project)`, adicione:  
```gradle
dependencies {
    classpath 'com.google.gms:google-services:4.3.15'
}
````

7. No arquivo `build.gradle (App)`, adicione no final:

   ```gradle
   apply plugin: 'com.google.gms.google-services'
   ```

---

## ▶️ Como Rodar o Projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/biblion-android.git
   ```

2. Abra no **Android Studio**:

   * `File` → `Open` → Selecione a pasta do projeto.

3. Verifique se o arquivo `google-services.json` está na pasta `/app`.

4. Clique em **Run ▶️** no Android Studio e escolha um emulador ou dispositivo físico.

---

## 📖 Descrição do Projeto

### 🎯 Temática

**BibliOn – Sistema de Gerenciamento de Livraria Virtual (Mobile)**

### 🏷️ Problema

Livrarias precisam de soluções modernas que permitam o gerenciamento eficiente do catálogo de livros, estoque, pedidos, editoras, clientes e funcionários. O app BibliOn oferece uma interface intuitiva e prática para isso.

### 💡 Solução

Aplicativo Android, conectado ao Firebase, que permite:

* 📚 Cadastro e gerenciamento de livros, editoras e estoque.
* 👥 Cadastro de clientes.
* 🛒 Criação e gerenciamento de pedidos.
* 👨‍💼 Gerenciamento de funcionários (vendedores e caixas).
* 🧾 Emissão de dados simulados de notas fiscais.

---

## 🗂️ Requisitos de Dados (Coleções no Firestore)

* **Livros**
* **Editoras**
* **Filiais**
* **Clientes**
* **Funcionários** (vendedores e caixas)
* **Pedidos** e **Itens do Pedido**
* **Notas Fiscais**

---

## ✅ Requisitos Funcionais (RF)

* **RF1:** Cadastro e gerenciamento de livros.
* **RF2:** Cadastro de clientes e gerenciamento de informações.
* **RF3:** Criação de pedidos com seleção de livros e cálculo total.
* **RF4:** Controle de estoque e atualização após vendas.
* **RF5:** Cadastro de funcionários com distinção entre vendedores e caixas.
* **RF6:** Registro de notas fiscais associadas aos pedidos.
* **RF7:** Cadastro e manutenção de editoras e suas informações.

---

## 🚩 Requisitos Não Funcionais (RNF)

* **RNF1:** Desempenho: Aplicativo leve e eficiente em redes móveis.
* **RNF2:** Segurança: Dados armazenados de forma segura no Firebase.
* **RNF3:** Usabilidade: Design responsivo e acessível (Material Design).
* **RNF4:** Disponibilidade: Dados sincronizados em tempo real com Firestore.
* **RNF5:** Escalabilidade: Suporte para múltiplos usuários e filiais.
* **RNF6:** Portabilidade: Suporte a dispositivos Android 8 (Oreo) ou superior.
* **RNF7:** Manutenibilidade: Código modular, utilizando arquitetura MVVM.
* **RNF8:** Acessibilidade: Interface preparada para TalkBack e acessibilidade Android.

---

## 🏗️ Tecnologias Utilizadas

* 🛠️ **Linguagem:** Kotlin
* 🔥 **Backend:** Firebase (Cloud Firestore, Authentication, Storage)
* 🎨 **UI:** Material Design
* 📦 **Arquitetura:** MVVM + LiveData + ViewModel
* 🌐 **Dependências:**

  * Firebase SDK
  * Glide (para imagens)
  * Material Components
  * Coroutines
  * Navigation Component

---

## 🎨 Telas do Aplicativo

1. **Tela Inicial:** Destaques e busca de livros.
2. **Tela de Cadastro de Livros:** Formulário completo com dados e imagem do livro.
3. **Tela de Clientes:** Listagem, cadastro e gerenciamento.
4. **Tela de Pedidos:** Criação de pedidos, seleção de livros e finalização.
5. **Tela de Funcionários:** Cadastro e listagem de vendedores e caixas.
6. **Tela de Estoque:** Consulta do estoque por filial.
7. **Tela de Editoras:** Cadastro e edição de editoras.

---

## 👩‍💻 Desenvolvedora

* [Ananda Guedes](https://github.com/agu3des)

---

## 💡 Observações Finais

> Este projeto é acadêmico, com fins didáticos, mas pode ser facilmente expandido para produção real com Firebase. A arquitetura modular e o uso de práticas modernas de desenvolvimento garantem facilidade de manutenção e escalabilidade.

