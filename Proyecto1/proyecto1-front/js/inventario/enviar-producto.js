const form = document.querySelector("#form");
const linkRegresar = document.querySelector("#regresar");
const cantidad = document.querySelector("#stock");
const selectProductos = document.querySelector("#productos"); //productos de una sucursal
const selectSucursales = document.querySelector("#sucursal");
let contenidoSelectProductos="<option>-Seleccione un Producto-</option>";
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
linkRegresar.href="http://127.0.0.1:5500/vistas/inventario/index.html"+queryParam;

//--------------LLAMADA A PRODUCTOS EN BODEGA Y A SUCURSALES --------
//productos
const request = new Request("http://localhost:8080/productBranch/find/sucursal/"+sucursal);
fetch(request)
    .then(res => res.json())
    .then(response=>{
        console.log(response);
        selectProductos.innerHTML= llenarSelectProductos(response);
    });


function llenarSelectProductos(data){
    for(let i=0 ; i<data.length; i++){
        contenidoSelectProductos += "<option value="+data[i].product.productId+">"+data[i].product.name+"</option>";
    }
    return contenidoSelectProductos;
}

//sucursales
const request2 = new Request("http://localhost:8080/branch/all");
fetch(request2)
    .then(res => res.json())
    .then(response=>{
        console.log(response)
        selectSucursales.innerHTML = llenarSelectSucursal(response);
    })

    function llenarSelectSucursal(data){
        let contenidoSucursales = "<option>-Seleccione una Sucursal-</option>";
        for(let i=0; i<data.length; i++){
            contenidoSucursales += "<option value="+data[i].branchId+">"+data[i].name+"</option>";
        }

        return contenidoSucursales
    }

//------LOGICA DE ENVIAR UN PRODUCTO A UNA SUCURSAL-------

form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const request = enviarProducto();
    fetch(request)
    .then(res => res.json())
    .then(response =>{
        console.log(response)
        alert(response.message);
        
    })
});

function enviarProducto(){
    const idProducto = parseInt(selectProductos.value);
    const idSucursalDestino = selectSucursales.value;
    const idSucursalOrigen = idProducto+"-"+sucursal;
    const valorCantidad = parseInt(cantidad.value);
    const bodySend = {
        "originBranch":idSucursalOrigen,
        "destinationBranch":idSucursalDestino,
        "amount":valorCantidad,
        "product":idProducto
    }
    const requestSend = new Request("http://localhost:8080/productBranch/sendProduct",{
        method:"POST",
        body:JSON.stringify(bodySend),
        headers:{
            "Content-Type":"application/json"
        }
    });
    return requestSend;
}
