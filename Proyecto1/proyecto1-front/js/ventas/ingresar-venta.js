const linkRegresar = document.querySelector("#regresar");
const nit = document.querySelector("#nit");
const fecha = document.querySelector("#fecha");
const form = document.querySelector("#form");
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
linkRegresar.href="./index.html"+queryRegresar;
//---------------------------------



//----------------LOGICA DE INGRESAR VENTA

form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const req = agregarVenta();
    fetch(req)
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            alert(response.message);
            const queryDetalle = queryRegresar+"&venta="+response.sale.saleId;
            console.log(queryDetalle);
            window.location.href="./detalle-venta.html"+queryDetalle;
        })
});



function agregarVenta(){
    const nitCliente = nit.value
    const fechaVenta = fecha.value;
    const sucursal = parseInt(idSucursal);
    const bodyAdd = {
        "employee":dpi,
        "client":nitCliente,
        "saleDate":fechaVenta,
        "branch":sucursal
    }
    console.log(fechaVenta);
    const request = new Request("http://localhost:8080/sale/add",{
        method:"POST",
        body:JSON.stringify(bodyAdd),
        headers:{
            "Content-Type":"application/json"
        }
    });
    return request;
}

