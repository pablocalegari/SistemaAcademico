DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

CREATE TABLE curso(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    campus VARCHAR(100)
 );
 
 CREATE TABLE disciplina(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT,
    
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
        ON DELETE CASCADE
);
 
 CREATE TABLE aluno (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
	genero VARCHAR (50),
    rgm VARCHAR(20) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    email VARCHAR(100),
    celular VARCHAR(16),
    endereco VARCHAR(150),
	municipio VARCHAR(100),
	uf CHAR(2),
	periodo VARCHAR(20),
	
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
	 ON DELETE SET NULL
   );
   
CREATE TABLE nota (
	id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    disciplina_id INT,
	semestre VARCHAR(10),
    nota DECIMAL(4, 2) CHECK (nota BETWEEN 0 AND 10),
    faltas INT,
	
    FOREIGN KEY(aluno_id) REFERENCES aluno(id)
    ON DELETE CASCADE,
    
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
		ON DELETE CASCADE
);

				-- dados de teste --

-- Cursos
INSERT INTO curso (nome, campus) VALUES
('Analise e Desenvolvimento de Sistema', 'Tatuapé'),
('Engenharia', 'Mooca'),
('Direito', 'Lapa'),     
('Medicina', 'Santana'),  
('Arquitetura', 'Centro'); 

-- Disciplinas
INSERT INTO disciplina (nome, carga_horaria, curso_id) VALUES
('Programação Orientada a Objetos', 80, 1),
('Banco de Dados', 80, 1),
('Engenharia de Software', 60, 1),
('Calculo I', 100, 2),
('Direito Penal', 70, 3);

-- Alunos
INSERT INTO aluno 
(nome, sobrenome, genero, rgm, cpf, data_nascimento, email, celular, endereco, municipio, uf, curso_id, periodo) 
VALUES
('Joao','Frango','Masculino', '12345', '111.111.111-11', '2003-05-10', 'joao@email.com', '(11)99999-9999', 'Rua A', 'São Paulo', 'SP', 1, 'Matutino'),
('Maria','Betania', 'Transgenero', '67890', '222.222.222-22', '2002-08-15', 'maria@email.com', '(11)98888-8888', 'Rua B', 'São Paulo', 'SP', 2, 'Vespertino'),
('Bia','Miranda','Feminino', '24680', '333.333.333-33', '2001-03-22', 'bimiranda@email.com', '(21)97777-7777', 'Av. Alamedas', 'Rio de Janeiro', 'RJ', 1, 'Noturno'),
('Harry','Potter', 'Masculino', '13579', '444.444.444-44', '2004-12-05', 'ehohpne@email.com', '(31)96666-6666', 'Rua dos Alfeneiros', 'Belo Horizonte', 'MG', 3, 'Noturno'),
('Michael','Jackson', 'Masculino', '11223', '555.555.555-55', '1999-07-30', 'rusbe@email.com', '(41)95555-5555', 'Rua Billie Jean', 'Curitiba', 'PR', 2, 'Noturno'),
('Gustavo','Lima', 'Masculino', '44556', '666.666.666-66', '2002-01-14', 'oembaixador@email.com', '(61)94444-4444', 'Rua Tchecherere', 'Brasília', 'DF', 4, 'Noturno'),
('Ayrton','Senna', 'Masculino', '77889', '777.777.777-77', '2003-09-18', 'monacos2@email.com', '(71)93333-3333', 'Rua do Laranjinha', 'Salvador', 'BA', 1, 'Matutino'),
('Babu','Santana', 'Masculino', '99001', '888.888.888-88', '2000-06-25', 'ahbabuuuu@email.com', '(85)92222-2222', 'Rua Branquinha', 'Fortaleza', 'CE', 3, 'Matutino'),
('Pablo','Vittar', 'Outro', '22334', '999.999.999-99', '2005-02-10', 'iledile@email.com', '(51)91111-1111', 'Rua dos Homossapiens', 'Porto Alegre', 'RS', 2, 'Matutino'),
('Neymar','da Silva', 'Prefiro não informar', '55667', '000.000.000-00', '2001-11-28', 'vemhexa@email.com', '(11)91234-5678', 'Av. Volta pro Barça', 'São Paulo', 'SP', 5, 'Matutino');

-- Notas
INSERT INTO nota (aluno_id, disciplina_id, semestre, nota, faltas) VALUES
(1, '1', '2025-1', 8.5, 2),
(1, '3', '2025-1', 7.0, 3),
(2, '2', '2026-1', 9.0, 1),
(2, '4', '2026-2', 8.0, 0);
