CREATE TABLE pais(
	id	SERIAL PRIMARY KEY,
	pais	varchar(100)
);

CREATE TABLE tipo_documento(
	id		SERIAL PRIMARY KEY,
	tipo_documento	varchar(100),
	descripcion	text
);

CREATE TABLE persona (
	id			SERIAL PRIMARY KEY,
	nombres			VARCHAR(100) NOT NULL,
	apellidos		VARCHAR(100) NOT NULL,
	id_Tipo_Documento	integer,
	numero_documento	text,
	genero			varchar(50),
	edad			integer,
	id_pais			integer,
	CONSTRAINT fk_tipo_documento
		FOREIGN KEY (id_Tipo_Documento)
		REFERENCES tipo_documento(id),
	CONSTRAINT fk_pais
		FOREIGN KEY (id_pais)
		REFERENCES pais(id)
);

INSERT INTO tipo_documento
VALUES(nextval('tipo_documento_id_seq'),'CC','Cédula de Ciudadanía'),
	(nextval('tipo_documento_id_seq'),'CE','Cédula de Extranjería'),
	(nextval('tipo_documento_id_seq'),'PA','Pasaporte'),
	(nextval('tipo_documento_id_seq'),'RC','Registro Civil'),
	(nextval('tipo_documento_id_seq'),'TI','Tarjeta de Identidad');

INSERT INTO pais
VALUES(nextval('pais_id_seq'),'Argentina'),
	(nextval('pais_id_seq'),'Bolivia'),
	(nextval('pais_id_seq'),'Brasil'),
	(nextval('pais_id_seq'),'Chile'),
	(nextval('pais_id_seq'),'Colombia'),
	(nextval('pais_id_seq'),'Ecuador'),
	(nextval('pais_id_seq'),'Guyana'),
	(nextval('pais_id_seq'),'Guyana Francesa'),
	(nextval('pais_id_seq'),'Paraguay'),
	(nextval('pais_id_seq'),'Perú'),
	(nextval('pais_id_seq'),'Suriname'),
	(nextval('pais_id_seq'),'Uruguay'),
	(nextval('pais_id_seq'),'Venezuela');