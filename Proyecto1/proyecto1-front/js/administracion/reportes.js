const linkRegresar = document.querySelector("#regresar");
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpiEmpleado = arrayData[0][1];
const sucursal = arrayData[1][1];
//----------------------CONFIGURAR LINK
const queryParam = "?dpi="+dpiEmpleado+"&sucursal="+sucursal;
linkRegresar.href="http://127.0.0.1:5500/vistas/administracion/index.html"+queryParam;