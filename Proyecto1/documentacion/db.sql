CREATE DATABASE electronic_homes;



/* ENTIDADES FUERTES */

CREATE TABLE sucursal(
    id_sucursal  INT NOT NULL,
    nombre  VARCHAR(50) NOT NULL,
    cantidad_productos   INT NOT NULL,
    PRIMARY KEY (id_sucursal)
);


CREATE TABLE categoria_producto(
    id_categoria   SERIAL NOT NULL,
    descripcion   VARCHAR(50),
    PRIMARY KEY (id_categoria)
);


CREATE TABLE rol_empleado(
    id_rol   INT NOT NULL,
    cargo   VARCHAR(40),
    PRIMARY KEY (id_rol)
);


CREATE TABLE cliente(
    nit   VARCHAR(50) NOT NULL,
    nombre   VARCHAR(25),
    apellido  VARCHAR(25),
    direccion VARCHAR(40),
    telefono   INT NULL,
    PRIMARY KEY (nit)
);


/* ENTIDADES DEBILES */

CREATE TABLE producto(
    id_producto   SERIAL NOT NULL,
    nombre     VARCHAR(40),
    categoria  INT NOT NULL,
    precio_venta  INT NOT NULL,
    PRIMARY KEY (id_producto),
    FOREIGN KEY (categoria)  REFERENCES  categoria_producto(id_categoria)
);


CREATE TABLE producto_sucursal(
    id_producto_sucursal  VARCHAR(50) NOT NULL,
    producto   INT NOT NULL,
    sucursal   INT NOT NULL,
    cantidad_stock   INT NOT NULL,
    PRIMARY KEY (id_producto_sucursal),
    FOREIGN KEY (producto)  REFERENCES  producto(id_producto),
    FOREIGN KEY (sucursal) REFERENCES sucursal(id_sucursal)
);


CREATE TABLE empleado(
    dpi    VARCHAR(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NULL,
    telefono INT NULL,
    sucursal   INT NOT NULL,
    salario   INT NULL,
    rol     INT NOT NULL,
    PRIMARY KEY (dpi),
    FOREIGN KEY (sucursal) REFERENCES sucursal (id_sucursal),
    FOREIGN KEY (rol) REFERENCES rol_empleado(id_rol)
);


CREATE TABLE venta(
    id_venta   SERIAL NOT NULL,
    empleado   VARCHAR(20) NOT NULL,
    cliente    VARCHAR(40) NOT NULL,
    fecha_venta  DATE NOT NULL,
    sucursal   INT NOT NULL,
    total     INT NULL,
    PRIMARY KEY (id_venta),
    FOREIGN KEY (empleado)  REFERENCES  empleado(dpi),
    FOREIGN KEY (cliente)   REFERENCES cliente(nit),
    FOREIGN KEY (sucursal)  REFERENCES  sucursal(id_sucursal)
);



CREATE TABLE detalle_venta(
    id_detalle  SERIAL NOT NULL,
    venta   INT NOT NULL,
    producto  INT NOT NULL,
    cantidad  INT NOT NULL,
    total_detalle  INT NULL,
    PRIMARY KEY (id_detalle),
    FOREIGN KEY (venta) REFERENCES venta(id_venta),
    FOREIGN KEY (producto)  REFERENCES producto(id_producto)
);









