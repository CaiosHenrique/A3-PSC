CREATE TABLE carta (
	numero int PRIMARY KEY,
    nome VARCHAR(255),
    tipo VARCHAR(255),
    atributo VARCHAR(255),
    efeito VARCHAR(255),
    nivel INT,
    ataque INT,
    defesa INT
);

CREATE TABLE usuario (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    user VARCHAR(60) NOT NULL,
    pass TEXT NOT NULL,
    EMAIL VARCHAR(255) NOT NULL UNIQUE
);

create table cartadousuario(
	ID_USUARIO INT,
    numero_carta INT,
    PRIMARY KEY (id_usuario, numero_carta),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (numero_carta) REFERENCES carta(numero)
);

Select * From usuario;


