const linkRegresar = document.querySelector("#regresar");
const tabla =document.querySelector("#table-empleados");
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

/*--------------------------------------------------------------------*/
//llenar tabla
let contenidoTabla = "<tr><th>Nombre</th><th>Apellido</th><th>Usuario</th><th>Contraseña</th><th>Sucursal</th><th>Cargo</th></tr>";

/*-------------------------SOLICITUD DE USUARIOS A LA API----------------------------*/
obtenerUsuarios();
function obtenerUsuarios(){
    const request = new Request("http://localhost:8080/user/getUsers");
    fetch(request)
        .then(res => res.json())
        .then(response => {
            console.log(response);
            llenarTabla(response);
        });
}


function llenarTabla(data){
    for(let i=0; i<data.length;i++){
        contenidoTabla += "<tr><td>"+data[i].nombre+"</td><td>"+data[i].apellido+"</td><td>"+data[i].usuario+"</td><td>"+data[i].password+"</td><td>"+data[i].sucursal+"</td><td>"+data[i].cargo+"</td></tr>";
    }

    tabla.innerHTML = contenidoTabla;
}