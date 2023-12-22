create database Livraria;

use Livraria;

create table editora
(
	cnpj char(14) not null,
    numero int not null,
    rua varchar(45) not null,
    cep char(8) not null, 
    bairro varchar(45) not null,
    cidade varchar(45) not null,
    estado char(2) not null default "PB",
    constraint PK_editora primary key (cnpj),
    constraint CK_editora_cnpj check (char_length(cnpj)=14)
);

create table filial
(
	idFilial int not null,
    cnpj char(14) not null,
    rua varchar(45) not null,
    cep char(8) not null,
    numero int not null,
    bairro varchar(45) not null,
    cidade varchar(45) not null,
    estado char(2) not null,
    constraint PK_filial primary key (idFilial, cnpj),
    constraint FK_PK_filial_editora foreign key(cnpj) references editora (cnpj)
);


create table contato
(
	contato varchar(45) not null,
    cnpj char(14) not null,
    constraint PK_contato primary key (contato, cnpj),
    constraint FK_PK_contato_editora foreign key(cnpj) references editora (cnpj)
);

create table livro
(
	codigo int not null,
    cnpj char(14) not null,
    nome varchar(45) not null,
    autor varchar(150) not null,
    nacionalidade varchar(45) not null,
    qtd_paginas int not null,
    idioma varchar(20) not null,
    preço decimal not null,
    constraint PK_livro primary key (codigo),
    constraint FK_editora foreign key(cnpj) references editora (cnpj),
    constraint CK_livro_qtd_paginas check (qtd_paginas > 0)
);

create table genero
(
	genero varchar(45) not null,
    codigo int not null,
    constraint PK_genero primary key (genero, codigo),
    constraint FK_PK_genero_livro foreign key(codigo) references livro (codigo)
);

create table cliente
(
	cpf char(11) not null,
    nome varchar(145) not null,
    endereço varchar(45), 
    email varchar(100) not null,
    constraint PK_cliente primary key (cpf),
    constraint UQ_cliente unique (email),
    constraint CK_cliente_cpf check (char_length(cpf) = 11)
);

create table telefone
(
	telefone int not null,
    cpf char(11) not null,
    constraint PK_cliente primary key (telefone, cpf),
    constraint FK_PK_telefone_cliente foreign key(cpf) references cliente (cpf)
);

create table funcionario 
(
	cpf char(11) not null,
    nome varchar(145) not null,
    endereço varchar(45) not null, 
    telefone varchar(45) not null,
    constraint PK_funcionario primary key (cpf),
    constraint CK_funcionario_cpf check (char_length(cpf) = 11)
);

create table vendedor
(
	cpf char(11) not null,
	categoria varchar(40) not null,
    constraint PK_cpf primary key (cpf),
    constraint FK_PK_vendedor_funcionario foreign key (cpf) references funcionario (cpf)
);

create table caixa
(
	cpf char(11) not null,
    escolaridade varchar(40) not null,
    constraint PK_cpf primary key (escolaridade),
    constraint FK_PK_escolaridade_funcionario foreign key (cpf) references funcionario (cpf)
);

create table venda
(
	data_hora datetime not null,
    cnpj_empresa char(14) not null,
    codigo int not null, 
    cpf_cliente char(11) not null,
    cpf_vendedor char(11) not null,
    valor decimal not null,
    numero int not null,
    data_emissão date not null,
    constraint FK_venda_funcionario_vendedor foreign key(cpf_vendedor) references funcionario (cpf),
	constraint FK_PK_venda_livro foreign key(codigo) references livro (codigo),
	constraint FK_PK_venda_cliente foreign key(cpf_cliente) references cliente (cpf),
    constraint CK_venda_valor check(valor > 0)
);

use livraria;

#Inserção de dados na tabela 'editora'

INSERT INTO editora (cnpj, numero, rua, cep, bairro, cidade, estado)
VALUES 
('31305106000127', 123, 'Rua Serra de Bragança', '03318000', 'Vila Gomes Cardim', 'São Paulo', 'SP'),
('34826672000172', 106, 'Rodovia Raposo Tavares', '06709015', 'Lageadinho', 'Cutia', 'SP'),
('76338239000138', 206, 'Rua Tenente-Coronel Cardoso', '28035042', 'Vila Gomes Cardim', 'Campos dos Goytacazes', 'SP'),
('05334752000102', 203, 'Rua Cristiano Olsen', '16015244', 'Jardim Sumaré', 'Araçatuba', 'SP'),
('86234140000140', 405, 'Rua Pereira Estéfano', '04144070', 'Vila da Saúde', 'São Paulo', 'SP');

# Inserção de dados na tabela 'filial'

INSERT INTO filial (idFilial, cnpj, rua, cep, numero, bairro, cidade, estado)
VALUES 
(1, '31305106000127', 'Avenida Governador José Malcher', '66055260', 456, 'Nazaré', 'Belém', 'PA'),
(2, '31305106000127', 'Rua Paracatu', '04302021', 456, 'Parque Imperial', 'São Paulo', 'SP'),
(3, '76338239000138', 'Avenida Desembargador Moreira', '60170001', 456, 'Aldeota', 'Fortaleza', 'CE'),
(4, '76338239000138', 'Rua Arlindo Nogueira', '64000290', 456, 'Centro', 'Teresina', 'PI'),
(5, '86234140000140', 'Avenida São João', '88113350', 456, 'Vila Joana', 'Jundiaí', 'SP');

# Inserção de dados na tabela 'contato'

INSERT INTO contato (contato, cnpj)
VALUES
('editora@melo.com.br', '76338239000138'),
('editora@record.com.br', '76338239000138'),
('arte@livros.com.br', '86234140000140'),
('editora@alves.com.br', '05334752000102'),
('contato@aeditora.com.br', '86234140000140');

# Inserção de dados na tabela 'livro'

INSERT INTO livro (codigo, cnpj, nome, autor, nacionalidade, qtd_paginas, idioma, preço)
VALUES
(11, '31305106000127', 'A biblioteca da meia-noite', 'Matt Haig', 'Britânico', 308, 'Português', 39),
(18, '34826672000172', 'O morro dos ventos uivantes', 'Emily Brontë', 'Britânica', 368, 'Português', 23),
(19, '76338239000138', 'Matéria Escura', 'Blake Crouch', 'Americano', 352, 'Português', 63),
(21, '05334752000102', 'E assim que acaba', 'Lily Blossom', 'Brasileiro', 207, 'Português', 39),
(23, '86234140000140', 'Sol da meia noite', 'Emerson Andrade', 'Brasileiro', 250, 'Português', 39);

# Inserção de dados na tabela 'genero'

INSERT INTO genero (genero, codigo)
VALUES
('Ficção', 11),
('Romance', 18),
('Drama', 21),
('Fantasia', 19),
('Mistério', 23);

# Inserção de dados na tabela 'cliente'

INSERT INTO cliente (cpf, nome, endereço, email)
VALUES
('15062123011', 'Lurdes Garcia', 'Endereço 1', 'lurdes.garcia@gmail.com'),
('13654796095', 'Jéssica Marques', 'Endereço 2', 'jessi.marques@gmail.com'),
('03864958075', 'Luan Marcelo', 'Endereço 3', 'luan.marcelo@gmail.com'),
('88896420091', 'Marcos Andrade', 'Endereço 4', 'Andrade.m@gmail.com'),
('35301570072', 'Amanda Kaylane', 'Endereço 5', 'Amanda.kay@gmail.com');

# Inserção de dados na tabela 'telefone'

INSERT INTO telefone (telefone, cpf)
VALUES
(123456787, '15062123011'),
(453456789, '13654796095'),
(167456789, '03864958075'),
(129856789, '88896420091'),
(456456789, '35301570072');

# Inserção de dados na tabela 'funcionario'

INSERT INTO funcionario (cpf, nome, endereço, telefone)
VALUES
('70918819075', 'Laura Fernandes', 'Endereço 1', '987654321'),
('77849181000', 'Alice Assunção', 'Endereço 2', '987654322'),
('28737525050', 'Carmélia Alves', 'Endereço 3', '987654323'),
('70673583023', 'Luciana Rangel', 'Endereço 4', '987654324'),
('71196774030', 'Jennifer Melo', 'Endereço 5', '987654325'),
('71196774040', 'Alex Melo', 'Endereço 6', '987654333'),
('71196774050', 'Ananda Melo', 'Endereço 7', '987654334'),
('71196774060', 'Mara Martins', 'Endereço 8', '987654344'),
('71196774070', 'Artur Rodrigues', 'Endereço 9', '987622325'),
('71196774080', 'Joelma Araújo', 'Endereço 10', '987651125'),
('71196774100', 'Angelica Araújo', 'Endereço 11', '997651125');

# Inserção de dados na tabela 'vendedor'

INSERT INTO vendedor (cpf, categoria)
VALUES
('70918819075', 'Efetivo'),
('77849181000', 'Estagiário'),
('71196774030', 'Efetivo'),
('71196774070', 'Estagiário'),
('71196774080', 'Efetivo');

# Inserção de dados na tabela 'caixa'

INSERT INTO caixa (cpf, escolaridade)
VALUES
('28737525050', 'Ensino Fundamental completo'),
('70673583023', 'Superior incompleto'),
('71196774060', 'Ensino Médio completo'),
('71196774040', 'Superior Fundametal incompleto'),
('71196774100', 'Superior completo com pós');

#Inserção de dados na tabela 'venda'

INSERT INTO venda (data_hora, cnpj_empresa, codigo, cpf_cliente, cpf_vendedor, valor, numero, data_emissão)
VALUES
('2023-04-05 08:30:00', '81627813000108', 11, '15062123011', '70918819075', 39, 1, '2023-04-05'),
('2023-05-04 10:15:00', '81627813000108', 18, '13654796095', '77849181000', 39, 2, '2023-05-04'),
('2023-06-03 13:45:00', '81627813000108', 19, '03864958075', '71196774030', 63, 3, '2023-06-03'),
('2023-07-02 15:20:00', '81627813000108', 21, '88896420091', '71196774070', 45, 4, '2023-07-02'),
('2023-08-01 17:05:00', '81627813000108', 23, '35301570072', '71196774080', 45, 5, '2023-08-01');

#Consultas

use livraria;

SELECT nome, nacionalidade FROM livro WHERE nacionalidade IN ('Brasileiro', 'Britânica');

SELECT nome, qtd_paginas FROM livro WHERE qtd_paginas BETWEEN 200 AND 300;

SELECT e.cnpj, e.rua, e.cidade
FROM editora e
LEFT JOIN filial f ON e.cnpj = f.cnpj
WHERE f.cnpj IS NULL;

SELECT nome, autor FROM livro WHERE autor LIKE 'M%';

SELECT nome, cpf FROM cliente ORDER BY nome;

SELECT cpf_vendedor, COUNT(*) as total_vendas FROM venda GROUP BY cpf_vendedor;

SELECT MAX(preço) as preço_maximo FROM livro;

SELECT genero, COUNT(*) as qtd_livros FROM genero GROUP BY genero HAVING COUNT(*) > 1;

SELECT l.nome, l.autor, e.rua, e.cidade FROM livro l JOIN editora e ON l.cnpj = e.cnpj;

SELECT nome, cpf FROM cliente WHERE cpf NOT IN (SELECT DISTINCT cpf FROM telefone);

SELECT nome, qtd_paginas FROM livro WHERE qtd_paginas NOT BETWEEN 100 AND 500;

SELECT nome, autor FROM livro WHERE autor IS NOT NULL;

SELECT nome, cpf FROM cliente WHERE nome NOT LIKE 'L%';