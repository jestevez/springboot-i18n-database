
INSERT INTO languages (language,parent,description,is_default) values ('es',null,'Castellano',1);
INSERT INTO languages (language,parent,description,is_default) values ('en','es','English',0);

INSERT INTO resources (language,reference,value) values ('es','i18n.products.name.printer-paper', 'papel de impresora');
INSERT INTO resources (language,reference,value) values ('en','i18n.products.name.printer-paper', 'printer paper');

INSERT INTO resources (language,reference,value) values ('es','i18n.products.name.security-camera', 'cámara de seguridad');
INSERT INTO resources (language,reference,value) values ('en','i18n.products.name.security-camera', 'security camera');

INSERT INTO products (name, price, create_at) VALUES('i18n.products.name.printer-paper', 800, NOW());
INSERT INTO products (name, price, create_at) VALUES('i18n.products.name.security-camera', 700, NOW());
