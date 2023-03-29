const linkRegresar = document.querySelector("#regresar");
const tabla = document.querySelector("#table-empleados");
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
linkRegresar.href="http://127.0.0.1:5500/vistas/administracion/reportes.html"+queryParam;
//-----------------------------------------------------------------------------------------
//*****************************************************************************************
//llenado de tabla
let contenidoTabla = "<tr><th>DPI</th><th>Nombre</th><th>Apellido</th><th>Cantidad Ventas</th></tr>";
clientesMasVentas();


function clientesMasVentas(){
    const request = new Request("http://localhost:8080/reports/employeeWithMostSales");
    fetch(request)
        .then(res => res.json())
        .then(response => {
            console.log(response);
            llenarTabla(response);
    })
}

function llenarTabla(data){
    for(let i=0; i<data.length; i++){
        contenidoTabla += "<tr><td>"+data[i].dpi+"</td><td>"+data[i].name+"</td><td>"+data[i].lastName+"</td><td>"+data[i].salesAmount+"</td></tr>";
    }
    tabla.innerHTML = contenidoTabla;
}