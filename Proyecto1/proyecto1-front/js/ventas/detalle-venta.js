const venta = document.querySelector("#venta");
const productos = document.querySelector("#producto");
const cantidad = document.querySelector("#cantidad");
const linkRegresar = document.querySelector("#regresar");
const form = document.querySelector("#form");
const total = document.querySelector("#total");
//----OBTENER PARAMS
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpi = arrayData[0][1];
const idSucursal = arrayData[1][1];
const idVenta = arrayData[2][1];
//-----LLENAR VALOR DE VENTA
venta.value = idVenta;
//-------------configurar link
const queryRegresar = "?dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href = "./index.html"+queryRegresar;

//-----LLENAMOS EL SELEC DE PRODUCTOS

const request = new Request("http://localhost:8080/productBranch/find/sucursal/"+idSucursal);

fetch(request)
    .then(res => res.json())
    .then(response => {
        console.log(response);
        mostrarProductos(response)
    });

function mostrarProductos(data){
    let contenidoSelect="<option>-Seleccione Producto-</option>";

    for(let i=0; i<data.length; i++){
        contenidoSelect += "<option value="+data[i].product.productId+">"+data[i].product.name+"</option>";
    }
    productos.innerHTML = contenidoSelect;
}
//------LOGICA PARA DETALLAR UNA VENTA
form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const req = agregarDetalle();
    fetch(req)
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            alert(response.message);
            total.innerHTML="Q "+response.sale.total+".00";
        });
});


function agregarDetalle(){
    const valueIdVenta = parseInt(venta.value);
    const idProduct = parseInt(productos.value);
    const valueAmount = parseInt(cantidad.value);

    const bodySend = {
        "sale":valueIdVenta,
        "product":idProduct,
        "amount":valueAmount
    }

    const requestSaleDetail = new Request("http://localhost:8080/saleDetail/add/"+idSucursal,{
        method:"POST",
        body:JSON.stringify(bodySend),
        headers:{
            "Content-Type":"application/json"
        }
    });

    return requestSaleDetail;
}






