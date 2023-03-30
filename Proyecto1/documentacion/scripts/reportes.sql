/*Reportes*/
/*Top 10 productos mas vendidos*/
CREATE VIEW vista_productos_mas_vendidos as SELECT producto,sum(cantidad) FROM detalle_venta  GROUP BY producto order by sum desc LIMIT 10;


CREATE VIEW reporte_productos_mas_vendidos as SELECT producto.nombre, vista_productos_mas_vendidos.sum FROM vista_productos_mas_vendidos
INNER JOIN producto
ON vista_productos_mas_vendidos.producto = producto.id_producto;

/*reporte oficial*/
SELECT * FROM reporte_productos_mas_vendidos ORDER BY sum desc;
/*-------------------------------------------------------------------------------------*/
/*Top 10 clientes que generan mas gancias */
CREATE VIEW vista_clientes_mas_ganancia as SELECT cliente, sum(total) FROM venta GROUP BY cliente order by sum desc LIMIT 10;


CREATE VIEW reporte_clientes_mas_ganancia as SELECT cliente.nit, cliente.nombre, cliente.apellido, vista_clientes_mas_ganancia.sum FROM vista_clientes_mas_ganancia 
INNER JOIN cliente
ON vista_clientes_mas_ganancia.cliente = cliente.nit;

/*reporte oficial*/
SELECT * FROM reporte_clientes_mas_ganancia;

/*--------------------------------------------------------------------------------------*/
/*Top 3 sucursales con mas ventas*/
CREATE VIEW vista_sucursales_mas_ventas as SELECT sucursal,count(sucursal) FROM venta GROUP BY sucursal ORDER BY count desc LIMIT 3;

CREATE VIEW reporte_sucursales_mas_ventas as SELECT sucursal.nombre, vista_sucursales_mas_ventas.count FROM vista_sucursales_mas_ventas 
INNER JOIN sucursal 
ON vista_sucursales_mas_ventas.sucursal = sucursal.id_sucursal; 

/*reporte oficial*/
SELECT * FROM reporte_sucursales_mas_ventas;
/*--------------------------------------------------------------------------------------*/
/*Top 3 sucursales con mas ganancias*/
CREATE VIEW vista_sucursales_mas_ganancia as  SELECT sucursal, sum(total) FROM venta GROUP BY sucursal ORDER BY sum desc LIMIT 3;

CREATE VIEW reporte_sucursales_mas_ganancia as SELECT sucursal.nombre, vista_sucursales_mas_ganancia.sum FROM vista_sucursales_mas_ganancia
INNER JOIN sucursal
ON vista_sucursales_mas_ganancia.sucursal = sucursal.id_sucursal
ORDER BY sum desc;

/*reporte oficial*/
SELECT * FROM reporte_sucursales_mas_ganancia;
/*---------------------------------------------------------------------------------------*/
/*Top 3 empleados con mas ventas*/
CREATE VIEW vista_empleados_mas_ventas as SELECT empleado,count(empleado) FROM venta GROUP BY empleado ORDER BY count desc LIMIT 3;

CREATE VIEW reporte_empleados_mas_ventas as SELECT empleado.dpi, empleado.nombre, empleado.apellido, vista_empleados_mas_ventas.count 
FROM vista_empleados_mas_ventas
INNER JOIN empleado
ON vista_empleados_mas_ventas.empleado = empleado.dpi;

/*reporte oficial*/
SELECT * FROM reporte_empleados_mas_ventas;
/*--------------------------------------------------------------------------------------*/
/*Top 3 empleados con mas ingresos*/
CREATE VIEW vista_empleados_mas_ingresos as SELECT empleado,sum(total) FROM venta GROUP BY empleado ORDER BY sum desc LIMIT 3;

CREATE VIEW reporte_empleados_mas_ingresos as SELECT empleado.dpi, empleado.nombre, empleado.apellido, vista_empleados_mas_ingresos.sum FROM vista_empleados_mas_ingresos 
INNER JOIN empleado
ON vista_empleados_mas_ingresos.empleado = empleado.dpi;

/*reporte oficial*/
SELECT * FROM reporte_empleados_mas_ingresos;
/*--------------------------------------------------------------------------------------*/
/*Top productos con mas ingresos*/
CREATE VIEW vista_productos_mas_ingresos as SELECT producto,sum(total_detalle) FROM detalle_venta GROUP BY producto ORDER BY sum desc; 


CREATE VIEW reporte_productos_mas_ingresos as SELECT producto.nombre, vista_productos_mas_ingresos.sum
FROM vista_productos_mas_ingresos
INNER JOIN producto
ON vista_productos_mas_ingresos.producto = producto.id_producto;

/*reporte oficial*/
SELECT * FROM reporte_productos_mas_ingresos ORDER BY sum DESC;
/*----------------------------------------------------------------------------------*/
/*Top 5 productos mas vendidos por sucursal*/
CREATE VIEW productos_mas_vendidos_sucursal as SELECT venta.sucursal, detalle_venta.producto,sum(detalle_venta.cantidad) 
FROM detalle_venta 
INNER JOIN venta
ON detalle_venta.venta = venta.id_venta
GROUP BY venta.sucursal , detalle_venta.producto 
ORDER BY sum desc LIMIT 5;

CREATE VIEW vista_productos_mas_vendidos_sucursal as SELECT sucursal.id_sucursal, sucursal.nombre as sucursal , producto.nombre as producto , productos_mas_vendidos_sucursal.sum 
FROM productos_mas_vendidos_sucursal
INNER JOIN sucursal
ON productos_mas_vendidos_sucursal.sucursal = sucursal.id_sucursal
INNER JOIN producto
ON productos_mas_vendidos_sucursal.producto = producto.id_producto;

/*reporte oficial*/
SELECT * FROM vista_productos_mas_vendidos_sucursal
WHERE id_sucursal = 1
ORDER BY sum DESC;


/*-----------------------------------------------------------------------------------------*/
/*Top 5 productos mas ingresos por sucursal*/
CREATE VIEW vista_productos_mas_ingresos_sucursal as SELECT venta.sucursal, detalle_venta.producto,sum(detalle_venta.total_detalle) 
FROM detalle_venta 
INNER JOIN venta
ON detalle_venta.venta = venta.id_venta
GROUP BY venta.sucursal , detalle_venta.producto 
ORDER BY sum desc LIMIT 5;

CREATE VIEW reporte_productos_mas_ingresos_sucursal as SELECT sucursal.id_sucursal, sucursal.nombre as sucursal, producto.nombre as producto, vista_productos_mas_ingresos_sucursal.sum 
FROM vista_productos_mas_ingresos_sucursal
INNER JOIN sucursal 
ON sucursal.id_sucursal = vista_productos_mas_ingresos_sucursal.sucursal
INNER JOIN producto
ON producto.id_producto = vista_productos_mas_ingresos_sucursal.producto;

/*reporte oficial*/
SELECT * FROM reporte_productos_mas_ingresos_sucursal
WHERE id_sucursal = 2
ORDER BY DESC;


/*REPORTE DE LOS USUARIOS CREADOS, UNIDOS AL EMPLEADO*/

CREATE VIEW vista_usuarios as SELECT usuario.usuario, usuario.password, empleado.nombre, empleado.apellido, empleado.sucursal, empleado.rol
 FROM usuario
INNER JOIN empleado
ON usuario.usuario = empleado.dpi;
/*--*/
CREATE VIEW reporte_usuarios as
SELECT vista_usuarios.nombre,
vista_usuarios.apellido, 
vista_usuarios.usuario,
vista_usuarios.password, 
sucursal.nombre as sucursal,
rol_empleado.cargo
FROM vista_usuarios
INNER JOIN sucursal
ON vista_usuarios.sucursal = sucursal.id_sucursal
INNER JOIN rol_empleado
ON vista_usuarios.rol = rol_empleado.id_rol;

/*reporte oficial*/
SELECT * FROM reporte_usuarios;
