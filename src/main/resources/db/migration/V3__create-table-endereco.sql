CREATE TABLE endereco (
     cep TEXT PRIMARY KEY UNIQUE NOT NULL,
  
    pais TEXT NOT NULL,
    estado  TEXT NOT NULL, 
    cidade  TEXT  NOT NULL,
    bairro TEXT  NOT NULL,
    rua TEXT  NOT NULL,
    complemento TEXT  NOT NULL,
    numero INT NOT NULL
);

	
