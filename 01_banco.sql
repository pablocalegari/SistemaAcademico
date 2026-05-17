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
-- ADS
('Banco de Dados', 80, 1),
('Programação Orientada a Objetos', 80, 1),
('Desenvolvimento Web', 60, 1),

-- Engenharia
('Cálculo I', 100, 2),
('Física Geral', 80, 2),
('Resistência dos Materiais', 90, 2),

-- Direito
('Direito Civil', 70, 3),
('Direito Penal', 70, 3),
('Direito Constitucional', 80, 3),

-- Medicina
('Anatomia Humana', 120, 4),
('Fisiologia', 100, 4),
('Bioquímica', 90, 4),

-- Arquitetura
('Desenho Técnico', 80, 5),
('Urbanismo', 70, 5),
('Projetos Arquitetônicos', 100, 5);


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

-- ALUNO 1 - JOAO (ADS)

(1, 1, '2025-1', 8.5, 2),
(1, 2, '2025-1', 7.8, 1),
(1, 3, '2025-1', 9.0, 0),

(1, 1, '2025-2', 8.0, 1),
(1, 2, '2025-2', 7.5, 3),
(1, 3, '2025-2', 8.7, 2),

(1, 1, '2026-1', 8.5, 2),
(1, 2, '2026-1', 7.8, 1),
(1, 3, '2026-1', 9.0, 0),

(1, 1, '2026-2', 8.0, 1),
(1, 2, '2026-2', 7.5, 3),
(1, 3, '2026-2', 8.7, 2),


-- ALUNO 2 - MARIA (ENGENHARIA)

(2, 4, '2025-1', 9.1, 0),
(2, 5, '2025-1', 8.3, 2),
(2, 6, '2025-1', 7.9, 1),

(2, 4, '2025-2', 8.7, 1),
(2, 5, '2025-2', 9.0, 0),
(2, 6, '2025-2', 8.1, 2),

(2, 4, '2026-1', 9.1, 0),
(2, 5, '2026-1', 8.3, 2),
(2, 6, '2026-1', 7.9, 1),

(2, 4, '2026-2', 8.7, 1),
(2, 5, '2026-2', 9.0, 0),
(2, 6, '2026-2', 8.1, 2),

-- ALUNO 3 - BIA (ADS)

(3, 1, '2025-1', 7.5, 4),
(3, 2, '2025-1', 8.2, 2),
(3, 3, '2025-1', 7.9, 1),

(3, 1, '2025-2', 8.0, 3),
(3, 2, '2025-2', 8.5, 1),
(3, 3, '2025-2', 9.0, 0),

(3, 1, '2026-1', 7.5, 4),
(3, 2, '2026-1', 8.2, 2),
(3, 3, '2026-1', 7.9, 1),

(3, 1, '2026-2', 8.0, 3),
(3, 2, '2026-2', 8.5, 1),
(3, 3, '2026-2', 9.0, 0),


-- ALUNO 4 - HARRY (DIREITO)

(4, 7, '2025-1', 6.8, 5),
(4, 8, '2025-1', 7.2, 3),
(4, 9, '2025-1', 8.0, 2),

(4, 7, '2025-2', 7.5, 1),
(4, 8, '2025-2', 8.1, 0),
(4, 9, '2025-2', 7.9, 2),

(4, 7, '2026-1', 6.8, 5),
(4, 8, '2026-1', 7.2, 3),
(4, 9, '2026-1', 8.0, 2),

(4, 7, '2026-2', 7.5, 1),
(4, 8, '2026-2', 8.1, 0),
(4, 9, '2026-2', 7.9, 2),

-- ALUNO 5 - MICHAEL (ENGENHARIA)

(5, 4, '2025-1', 8.9, 1),
(5, 5, '2025-1', 7.8, 3),
(5, 6, '2025-1', 8.2, 2),

(5, 4, '2025-2', 9.0, 0),
(5, 5, '2025-2', 8.5, 1),
(5, 6, '2025-2', 7.7, 4),

(5, 4, '2026-1', 8.9, 1),
(5, 5, '2026-1', 7.8, 3),
(5, 6, '2026-1', 8.2, 2),

(5, 4, '2026-2', 9.0, 0),
(5, 5, '2026-2', 8.5, 1),
(5, 6, '2026-2', 7.7, 4),

-- ALUNO 6 - GUSTAVO (MEDICINA)

(6, 10, '2025-1', 9.5, 0),
(6, 11, '2025-1', 8.8, 1),
(6, 12, '2025-1', 9.2, 0),

(6, 10, '2025-2', 9.1, 1),
(6, 11, '2025-2', 8.9, 2),
(6, 12, '2025-2', 9.4, 0),

(6, 10, '2026-1', 9.5, 0),
(6, 11, '2026-1', 8.8, 1),
(6, 12, '2026-1', 9.2, 0),

(6, 10, '2026-2', 9.1, 1),
(6, 11, '2026-2', 8.9, 2),
(6, 12, '2026-2', 9.4, 0),

-- ALUNO 7 - AYRTON (ADS)

(7, 1, '2025-1', 9.7, 0),
(7, 2, '2025-1', 10.0, 0),
(7, 3, '2025-1', 9.3, 1),

(7, 1, '2025-2', 9.0, 1),
(7, 2, '2025-2', 9.5, 0),
(7, 3, '2025-2', 8.8, 2),

(7, 1, '2026-1', 9.7, 0),
(7, 2, '2026-1', 10.0, 0),
(7, 3, '2026-1', 9.3, 1),

(7, 1, '2026-2', 9.0, 1),
(7, 2, '2026-2', 9.5, 0),
(7, 3, '2026-2', 8.8, 2),

-- ALUNO 8 - BABU (DIREITO)

(8, 7, '2025-1', 7.1, 3),
(8, 8, '2025-1', 6.9, 4),
(8, 9, '2025-1', 8.4, 2),

(8, 7, '2025-2', 8.0, 1),
(8, 8, '2025-2', 7.7, 2),
(8, 9, '2025-2', 8.6, 0),

(8, 7, '2026-1', 7.1, 3),
(8, 8, '2026-1', 6.9, 4),
(8, 9, '2026-1', 8.4, 2),

(8, 7, '2026-2', 8.0, 1),
(8, 8, '2026-2', 7.7, 2),
(8, 9, '2026-2', 8.6, 0),

-- ALUNO 9 - PABLO (ENGENHARIA)

(9, 4, '2025-1', 6.9, 6),
(9, 5, '2025-1', 7.5, 3),
(9, 6, '2025-1', 8.0, 2),

(9, 4, '2025-2', 7.8, 2),
(9, 5, '2025-2', 8.1, 1),
(9, 6, '2025-2', 7.4, 4),

(9, 4, '2026-1', 6.9, 6),
(9, 5, '2026-1', 7.5, 3),
(9, 6, '2026-1', 8.0, 2),

(9, 4, '2026-2', 7.8, 2),
(9, 5, '2026-2', 8.1, 1),
(9, 6, '2026-2', 7.4, 4),

-- ALUNO 10 - NEYMAR (ARQUITETURA)

(10, 13, '2025-1', 8.3, 1),
(10, 14, '2025-1', 7.9, 2),
(10, 15, '2025-1', 9.1, 0),

(10, 13, '2025-2', 8.7, 0),
(10, 14, '2025-2', 8.2, 1),
(10, 15, '2025-2', 9.4, 0),

(10, 13, '2026-1', 8.3, 1),
(10, 14, '2026-1', 7.9, 2),
(10, 15, '2026-1', 9.1, 0),

(10, 13, '2026-2', 8.7, 0),
(10, 14, '2026-2', 8.2, 1),
(10, 15, '2026-2', 9.4, 0);