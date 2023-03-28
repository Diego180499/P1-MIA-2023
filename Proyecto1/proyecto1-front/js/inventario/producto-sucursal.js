const form = document.querySelector("#form");
const linkRegresar = document.querySelector("#regresar");
const selectProductos = document.querySelector("#productos");
const cantidad = document.querySelector("#stock");
//------------CAPTURAMOS EL QUERY PARAM
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const idSucursal = arrayData[1][1];
const dpi = arrayData[0][1];
console.log(idSucursal);

//---------------------links
linkRegresar.href="./index.html?dpi="+dpi+"&sucursal="+idSucursal;


//-------PETICION A TODOS LOS PRODUCTOS
const request = new Request("http://localhost:8080/product/all");
fetch(request)
    .then(res => res.json())
    .then(response => {
        console.log(response);
        selectProductos.innerHTML = llenarSelect(response);
    })

//-----LLENAMOS EL SELECT DE LOS PRODUCTOS
function llenarSelect(data){
    let contenido = "<option value=0>-Seleccione un Producto-</option>";
    for(let i=0; i<data.length; i++){
        contenido+="<option value="+data[i].productId+">"+data[i].name+"</option>";
    }

    return contenido;
}


//------------------------------------------
let idProducto = 0;
selectProductos.addEventListener("change",()=>{
    idProducto = parseInt(selectProductos.value);
});

//-----------GUARDAMOS PRODUCTO SUCURSAL
form.addEventListener("submit",(e)=>{
    e.preventDefault();
    fetch(agregarProductoSucursal())
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            alert("Producto Agregado");
        })
});




function agregarProductoSucursal(){
    const valueIdSucursal = parseInt(idSucursal);
    const cantidadProducto = parseInt(cantidad.value);

    const requestBody = {
        "product":idProducto,
        "branch":valueIdSucursal,
        "stockAmount":cantidadProducto
    }

    const requestAdd = new Request("http://localhost:8080/productBranch/add",{
        method:"POST",
        body:JSON.stringify(requestBody),
        headers:{
            "Content-Type":"application/json"
        }
    });

    return requestAdd;
}






