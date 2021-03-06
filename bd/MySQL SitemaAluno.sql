CREATE TABLE DADOSPESSOAIS (
RGM_ALUNO INT NOT NULL AUTO_INCREMENT,
NOME_ALUNO VARCHAR(80) NULL,
NASC_ALUNO DATE NOT NULL,
CPF_ALUNO VARCHAR(16) NOT NULL,
EMAIL_ALUNO VARCHAR(80) NULL,
END_ALUNO VARCHAR(100) NULL,
MUN_RESIDE VARCHAR (20),
UF_ALUNO CHAR(2) NULL,
CEL_ALUNO CHAR(15),
CURSO_ALUNO VARCHAR(30) NOT NULL,
CAMPUS_CURSO VARCHAR(10) NOT NULL,
PERIODO_CURSO VARCHAR(15) NOT NULL,
CONSTRAINT PK_DADOSPESSOAIS PRIMARY KEY(RGM_ALUNO),
CONSTRAINT UQ_DADOSPESSOAIS_CPF_ALUNO UNIQUE(CPF_ALUNO)
)ENGINE = INNODB;


CREATE TABLE NOTASFALTAS (
COD_NF INT NOT NULL AUTO_INCREMENT,
DISC_NF VARCHAR(60) NOT NULL,
SEMESTRE_NF VARCHAR(15) NOT NULL,
NOTA_NF FLOAT NOT NULL,
FALTAS_NF INT NULL,
RGM_ALUNO INT NOT NULL,
CONSTRAINT PK_NOTASFALTAS PRIMARY KEY(COD_NF),
CONSTRAINT FK_NOTASFALTAS_DADOSPESSOAIS FOREIGN KEY(RGM_ALUNO) REFERENCES DADOSPESSOAIS(RGM_ALUNO)
)ENGINE = INNODB;






ALTER TABLE NOTASFALTAS MODIFY COLUMN NOTA_NF VARCHAR(5);

SELECT * FROM DADOSPESSOAIS;
SELECT * FROM NOTASFALTAS;

DELETE FROM DADOSPESSOAIS WHERE RGM_ALUNO = 1;

INSERT INTO DADOSPESSOAIS (
NOME_ALUNO,
NASC_ALUNO,
CPF_ALUNO,
EMAIL_ALUNO,
END_ALUNO,
MUN_RESIDE,
UF_ALUNO,
CEL_ALUNO,
CURSO_ALUNO,
CAMPUS_CURSO,
PERIODO_CURSO
) VALUES (
'VINICIUS',
'1998-02-21',
'123-213-123/66',
'VINICIUS@HOTMAIL.COM',
'AV AGUIA DE HAIA',
'SAO PAULO',
'SP',
'(11)91234-1234',
'Marketing',
'Pinheiros',
'Noturno'
);
