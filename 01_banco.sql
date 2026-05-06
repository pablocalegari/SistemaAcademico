DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

CREATE TABLE curso(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    campus VARCHAR(100),
    periodo VARCHAR(20)
 );
 
 CREATE TABLE aluno (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
    rgm VARCHAR(20) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    email VARCHAR(100),
    celular VARCHAR(16),
    endereco VARCHAR(150),
	municipio VARCHAR(100),
	uf CHAR(2),
	
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
	 ON DELETE SET NULL
   );
   
CREATE TABLE nota (
	id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    disciplina VARCHAR(100),
	semestre VARCHAR(10),
    nota DECIMAL(4, 2), CHECK (nota BETWEEN 0 AND 10)
    faltas INT,
	
    FOREIGN KEY(aluno_id) REFERENCES aluno(id)
    ON DELETE CASCADE
);

				-- dados de teste --

-- Cursos
INSERT INTO curso (nome, campus, periodo) VALUES
('ADS', 'Tatuapé', 'Noturno'),
('Engenharia', 'Mooca', 'Matutino');

-- Alunos
INSERT INTO aluno (nome, rgm, cpf, data_nascimento, email, celular, endereco, curso_id) VALUES
('joao Frango', '12345', '111.111.111-11', '2003-05-10', 'joao@email.com', '11999999999', 'Rua A', 1),
('Maria Betania', '67890', '222.222.222-22', '2002-08-15', 'maria@email.com', '11888888888', 'Rua B', 2);

-- Notas
INSERT INTO nota (aluno_id, disciplina, nota, faltas) VALUES
(1, 'POO', 8.5, 2),
(1, 'Banco de Dados', 7.0, 3),
(2, 'POO', 9.0, 1),
(2, 'Algoritmos', 8.0, 0);
