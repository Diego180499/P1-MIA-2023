const nombreUsuario = document.querySelector("#n-usuario");
const nombreSucursal = document.querySelector("#nameSucursal");
const linkProductoNuevo = document.querySelector("#ingresar");
const linkProductBranch = document.querySelector("#productBranch");
const linkEnviar = document.querySelector("#enviar"); 
const linkProductos = document.querySelector("#productos");
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpi = arrayData[0][1];
const sucursal = arrayData[1][1];
//-------------------------------- 
const queryParamIngresar = "?dpi="+dpi+"&sucursal="+sucursal;
linkProductoNuevo.href="./nuevo-producto.html"+queryParamIngresar;
linkProductos.href="./productos.html?idSucursal="+sucursal+"&dpi="+dpi;
linkProductBranch.href= "./producto-sucursal.html"+queryParamIngresar;
linkEnviar.href="./enviar-producto.html"+queryParamIngresar;

//*---------PETICION PARA TRAER AL EMPLEADO
const request = new Request("http://localhost:8080/employee/find/"+dpi);
fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    const empleado = response;
    nombreUsuario.innerHTML = "Bienvenido "+empleado.name+" "+empleado.lastName;
    nombreSucursal.innerHTML ="Área de Inventario "+empleado.branchDTO.name;
});