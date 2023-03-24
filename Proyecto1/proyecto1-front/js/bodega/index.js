const linkIngresarProducto = document.querySelector("#ingresar");
const linkEnviarProducto = document.querySelector("#enviar");
const linkProductos = document.querySelector("#productos");
const nombreUsuario = document.querySelector("#n-usuario");
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpi = arrayData[0][1];
const sucursal = arrayData[1][1];

//-----------CONFIGURAMOS LINKS
const queryParamIngresar ="?dpi="+dpi+"&sucursal="+sucursal;
linkIngresarProducto.href= "http://127.0.0.1:5500/vistas/bodega/ingresar-producto.html"+queryParamIngresar;
linkEnviarProducto.href="http://127.0.0.1:5500/vistas/bodega/enviar-producto.html"+queryParamIngresar;
linkProductos.href="http://127.0.0.1:5500/vistas/bodega/productos.html"+queryParamIngresar;

//*---------PETICION PARA TRAER AL EMPLEADO
const request = new Request("http://localhost:8080/employee/find/"+dpi);
fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    const empleado = response;
    nombreUsuario.innerHTML = "Bienvenido "+empleado.name+" "+empleado.lastName;
});
