const linkRegresar = document.querySelector("#regresar");
const linkModificar = document.querySelector("#modificar");
const tabla =document.querySelector("#table-clients");
const request = new Request("http://localhost:8080/client/all",{
    method:"GET"
});


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
const queryModificar="&dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href="./index.html"+queryRegresar;
//---------------------------------



fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    mostrarClientes(response);


}).catch(error => console.log(error));


const mostrarClientes = (data)=>{
    console.log(data);
    let body = '';
    let contenidoTabla = "<tr><th>Nit</th><th>Nombre</th><th>Apellido</th><th>Direccion</th><th>Teléfono</th><th>Accion</th></tr>";
    for(let i=0; i<data.length; i++){
        body += "<tr><td>"+data[i].nit+"</td><td>"+data[i].name+"</td><td>"+data[i].lastName+"</td><td>"+data[i].address+"</td><td>"+data[i].phone+"</td><td><a href='./modificarCliente.html?nit="+data[i].nit+queryModificar+"' id='modificar'>Modificar</a></td></tr>";
    }
    contenidoTabla+= body;
    tabla.innerHTML = contenidoTabla;
    console.log(body);
}
