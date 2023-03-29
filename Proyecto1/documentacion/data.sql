/*PRODUCTOS*/
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Licuadora',1,50);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Lavadora',1,500);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Extractor de Jugos',1,180);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Televisor HD',1,450);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Cafetera',1,125);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Horno Pequeño',1,110);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Lampara',2,85);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Monitor',2,230);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Equipo de Sonido',1,350);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Bocinas',1,100);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Cañonera',2,250);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Lavavajillas',1,400);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Hervidor Electrico',2,100);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Ventilador',2,80);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('aire acondicionador',1,330);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Dispensador de agua electrico',1,200);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Radio',1,100);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Secadora de pelo',1,150);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Impresora',2,175);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('aspiradora',1,225);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Batidora',1,125);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Podadora',1,275);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Calentador de bañera',1,230);
INSERT INTO producto (nombre,categoria,precio_venta) VALUES ('Telefono estático',1,200);


/*INSERTAR EMPLEADOS EN CADA SUCURSAL*/
/* SUCURSAL NORTE */
/*vendedores*/
INSERT INTO empleado VALUES ('3137','Diego','Estrada','04-18-1999',56642114,1,3500,1);
INSERT INTO empleado VALUES ('3138','José','Avila','05-15-1998',56582114,1,3500,1);
INSERT INTO empleado VALUES ('3239','Irma','Xicará','01-11-1990',56122114,1,3500,1);
/*inventario*/
INSERT INTO empleado VALUES ('5689','Pedro','Estrada','01-11-1990',54412114,1,4500,2);
/*administrador*/
INSERT INTO empleado VALUES ('5258','Helen Marisol','Batz Quixtan','12-07-1999',58512114,1,6500,4);


/* SUCURSAL SUR  */
/*vendedores*/
INSERT INTO empleado VALUES ('9854','Juan','Muñoz','12-06-1997',47885412,2,3500,1);
INSERT INTO empleado VALUES ('8579','Alejandro','Sajquim','01-09-1996',51548774,2,3500,1);
INSERT INTO empleado VALUES ('4598','Javier','Estacuy','04-02-1990',45982136,2,3500,1);
/*inventario*/
INSERT INTO empleado VALUES ('8721','Mariela','Estacuy','06-21-1989',56691475,2,4500,2);
/*administrador*/
INSERT INTO empleado VALUES ('7432','Camila','Vargas','03-05-1990',41987663,2,6500,4);


/* SUCURSAL CENTRAL  */
/*vendedores*/
INSERT INTO empleado VALUES ('2146','Manuel','Estacuy','07-06-1998',47621412,3,3500,1);
INSERT INTO empleado VALUES ('45649','Genesis','Leiva','12-29-1997',45148774,3,3500,1);
INSERT INTO empleado VALUES ('6845','Alvaro','Estrada','05-21-1995',45354836,3,3500,1);
/*inventario*/
INSERT INTO empleado VALUES ('7987','Belen','Sajquim','03-05-1995',56691354,3,4500,2);
/*administrador*/
INSERT INTO empleado VALUES ('17898','Rosita','Estacuy','10-28-1990',41981963,3,6500,4);


/* BODEGA */
INSERT INTO empleado VALUES ('1687','Jorge','Gonzales','02-06-1998',47411412,4,3000,3);
INSERT INTO empleado VALUES ('9178','Francisco','Gomez','11-29-1997',45238774,4,3000,3);
INSERT INTO empleado VALUES ('9846','Estuardo','Rodas','04-21-1995',45894836,4,3000,3);
INSERT INTO empleado VALUES ('0798','José','Menchú','09-28-1990',41121964,4,3000,3);



/* CREACION DE USUARIOS */

INSERT INTO usuario VALUES ('5258','admin1');