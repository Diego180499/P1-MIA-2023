const linkVenta = document.querySelector("#ingresar-venta");
const linkCliente = document.querySelector("#ingresar-cliente");
const linkClientes = document.querySelector("#clientes");
const nombreUsuario = document.querySelector("#n-usuario");
const nombreSucursal = document.querySelector("#nameSucursal");
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpi = arrayData[0][1];
const sucursal = arrayData[1][1];
console.log(dpi);
console.log(sucursal);
//*---------PETICION PARA TRAER AL EMPLEADO
const request = new Request("http://localhost:8080/employee/find/"+dpi);
fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    const empleado = response;
    nombreUsuario.innerHTML = "Bienvenido "+empleado.name+" "+empleado.lastName;
    nombreSucursal.innerHTML="Area de Venta "+empleado.branchDTO.name;
});

//------------------------------------Configuracion de links
const queryRegresar = "?dpi="+dpi+"&sucursal="+sucursal;

linkCliente.href = "./ingresarCliente.html"+queryRegresar;
linkClientes.href="./clientes.html"+queryRegresar;
linkVenta.href="./ingresar-venta.html"+queryRegresar;
