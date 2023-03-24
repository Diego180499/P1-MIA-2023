const linkRegresar = document.querySelector("#regresar");

/*--------OBTENER params*/
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
//------------
const dpi = arrayData[0][1];
const idSucursal = arrayData[1][1];

//-----------------configuracion link
const queryRegresar = "?dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href="./index.html"+queryRegresar;
//---------------------------------