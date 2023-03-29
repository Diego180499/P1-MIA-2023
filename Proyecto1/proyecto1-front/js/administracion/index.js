const nombreUsuario = document.querySelector("#n-usuario");
const nombreSucursal = document.querySelector("#nameSucursal");
const linkEmpleado = document.querySelector("#empleado");
const linkEmpleados = document.querySelector("#empleados");
const linkUsuario = document.querySelector("#usuario");
const linkReportes = document.querySelector("#reportes");
const linkUsuarios = document.querySelector("#usuarios");
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpi = arrayData[0][1];
const sucursal = arrayData[1][1];

//*---------PETICION PARA TRAER AL EMPLEADO
const request = new Request("http://localhost:8080/employee/find/"+dpi);
fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    const empleado = response;
    nombreUsuario.innerHTML = "Bienvenido "+empleado.name+" "+empleado.lastName;
    nombreSucursal.innerHTML = "Área de Administracion "+empleado.branchDTO.name;
});



//----------CONFIGURAR LINKS
const queryParam = "?dpi="+dpi+"&sucursal="+sucursal;
linkEmpleado.href="http://127.0.0.1:5500/vistas/administracion/ingresar-empleado.html"+queryParam;
linkEmpleados.href="http://127.0.0.1:5500/vistas/administracion/empleados.html"+queryParam;
linkUsuario.href="http://127.0.0.1:5500/vistas/administracion/asignar-usuario.html"+queryParam;
linkReportes.href="http://127.0.0.1:5500/vistas/administracion/reportes.html"+queryParam;
linkUsuarios.href = "http://127.0.0.1:5500/vistas/administracion/usuarios.html"+queryParam;