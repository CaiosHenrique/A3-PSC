create database colecao;
use colecao;

CREATE TABLE CARTA (
	NUMERO VARCHAR(255) PRIMARY KEY auto_increment,
    NOME VARCHAR(255),
    TIPO VARCHAR(255),
    ATRIBUTO VARCHAR(255),
    EFEITO VARCHAR(255),
    NIVEL INT,
    ATAQUE INT,
    DEFESA INT
);

create table USUARIO(
ID INT PRIMARY KEY auto_increment,
USER VARCHAR(60) NOT NULL,
PASS VARCHAR(60) NOT NULL
);

create table carta_usuario(
	ID_USUARIO INT,
    NUMERO_CARTA INT,
    PRIMARY KEY (ID_USUARIO, NUMERO_CARTA),
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
    FOREIGN KEY (NUMERO_CARTA) REFERENCES CARTA(NUMERO)
);