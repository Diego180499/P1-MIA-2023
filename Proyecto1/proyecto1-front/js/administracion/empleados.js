const linkRegresar = document.querySelector("#regresar");
const tabla =document.querySelector("#table-empleados");
const url = "http://localhost:8080/employee/all";
const request = new Request(url);
//------------CAPTURAMOS EL QUERY PARAM
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpiEmpleado = arrayData[0][1];
const sucursal = arrayData[1][1];
//----------------------CONFIGURAR LINK
const queryParamModificar = "&dpi="+dpiEmpleado+"&sucursal="+sucursal;
const queryParam = "?dpi="+dpiEmpleado+"&sucursal="+sucursal;
linkRegresar.href="http://127.0.0.1:5500/vistas/administracion/index.html"+queryParam;

//---------------------
fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    mostrarEmpleados(response);
});

function mostrarEmpleados(data){
    console.log(data);
    let body = '';
    let contenidoTabla = "<tr><th>DPI</th><th>Nombre</th><th>Apellido</th><th>Telefono</th><th>Sucursal</th><th>Salario</th><th>Rol</th><th>Accion</th></tr>";
    for(let i=0; i<data.length; i++){
        body += "<tr><td>"+data[i].dpi+"</td><td>"+data[i].name+"</td><td>"+data[i].lastName+"</td><td>"+data[i].phone+"</td><td>"+data[i].branchDTO.name+"<td>"+data[i].salary+"</td><td>"+data[i].roleEmployeeDTO.jobPosition+"</td><td><a href='./modificarEmpleado.html?dpiEmpleado="+data[i].dpi+queryParamModificar+"'>Modificar</a></td></tr>";
    }
    contenidoTabla+= body;
    tabla.innerHTML = contenidoTabla;
    console.log(body);
}

