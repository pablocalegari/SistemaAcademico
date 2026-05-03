# 🎓 Sistema Acadêmico (Java + MySQL)

## 📌 Descrição
Projeto desenvolvido para a disciplina de Programação Orientada a Objetos, com o objetivo de implementar um sistema acadêmico completo utilizando Java (Swing) integrado a um banco de dados MySQL.

O sistema permite o gerenciamento de alunos, cursos, notas e faltas, seguindo os requisitos propostos na atividade.

---

## ⚙️ Tecnologias utilizadas
- Java (JDK 8+)
- Swing (Interface gráfica)
- MySQL
- JDBC (conexão com banco)
- Eclipse IDE

---

## 🗄️ Banco de Dados

O banco utilizado chama-se:

sql sistema_academico 

### 📋 Estrutura:
- curso
- aluno
- nota

### ✔ Requisitos implementados:
- Chaves primárias (PK)
- Chaves estrangeiras (FK)
- Relacionamentos entre tabelas
- ON DELETE CASCADE (para notas)
- RGM único por aluno
- CPF único

---

## 🚀 Como executar o projeto

### 1. Criar o banco de dados

Execute o arquivo:

01_banco.sql

em seu MySQL para criar toda a estrutura e dados de teste.

---

### 2. Configurar conexão com o banco

No arquivo ConnectionFactory.java, ajuste conforme seu ambiente:

java String url = "jdbc:mysql://localhost:3306/sistema_academico"; String user = "root"; String password = "root"; 

---

### 3. Executar o projeto

- Importar o projeto no Eclipse
- Executar a classe principal

---

## 🖥️ Funcionalidades

- Cadastro de alunos
- Associação com curso
- Registro de notas e faltas
- Visualização de boletim
- Exclusão de aluno com remoção automática de notas

---

## 🧩 Interface

O sistema utiliza:
- JTabbedPane para organização das telas
- JFormattedTextField para campos formatados (CPF, data, celular)

---

## ⚠️ Observações

- O sistema não permite RGM duplicado
- O banco deve estar em execução localmente
- Pode ser necessário ajustar usuário e senha do MySQL

---

## 📁 Estrutura do projeto

sistema-academico/ ├── 01_banco.sql ├── README.md └── src/

---

## 👨‍💻 Autores

- Douglas Leal  
- Felipe Furlan  
- Luiz Guilherme Romão  
- Pablo Antonio Calegari  
- Rafael Borges  

---

## 📅 Disciplina

Programação Orientada a Objetos  
Professor Jadir Custodio Mendonça - UNICID

---

## 🎥 Vídeos de Referência

Canal: Jadir Mendonça

- https://youtu.be/tpEdzNX0rxg  
- https://youtu.be/q19rkHiFwc8  
- https://youtu.be/7lIa9MZiVrA  
- https://youtu.be/HEDq-WGl