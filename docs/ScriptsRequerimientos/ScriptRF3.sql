--�Por convenci�n para una empresa el nombre es su raz�n social y el apellido el tipo de sociedad.

-- Creamos 3 clientes de tipo persona natural
INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('CC','1234567');
INSERT INTO PERSONANATURAL (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO) VALUES ('CC','1234567', 'Sandra','sandra@gmail.com');

INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('CC','8765');
INSERT INTO PERSONANATURAL (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO) VALUES ('CC','8765', 'Carlos','carlos@gmail.com');

INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('CC','9876543');
INSERT INTO PERSONANATURAL (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO) VALUES ('CC','9876543', 'Juan','juan@gmail.com');


-- Creamos 3 clientes de tipo persona jur�dica

INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('NIT','89765456');
INSERT INTO PERSONAJURIDICA (TIPODOCUMENTO, NUMDOCUMENTO, DIRECCION ) VALUES('NIT','89765456','Calle 2');

INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('NIT','7654');
INSERT INTO PERSONAJURIDICA (TIPODOCUMENTO, NUMDOCUMENTO, DIRECCION ) VALUES('NIT','7654','Calle 26');

INSERT INTO CLIENTE (TIPODOCUMENTO, NUMDOCUMENTO) VALUES ('NIT','856473');
INSERT INTO PERSONAJURIDICA (TIPODOCUMENTO, NUMDOCUMENTO, DIRECCION ) VALUES('NIT','856473','Calle 23');

commit;