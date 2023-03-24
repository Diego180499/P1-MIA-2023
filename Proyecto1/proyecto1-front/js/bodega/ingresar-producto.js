const form = document.querySelector("#form");
const linkRegresar = document.querySelector("#regresar");
const selectProductos = document.querySelector("#productos");
const cantidad = document.querySelector("#stock");
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
linkRegresar.href="http://127.0.0.1:5500/vistas/bodega/index.html"+queryParam;

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



//----------LOGICA PARA INGRESAR UN PRODUCTO
form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const request = agregarproducto();
    fetch(request)
        .then(res => res.json())
        .then(response => {
            console.log(response);
            alert(response.message);
        })
});


function agregarproducto(){
    const idProduct = parseInt(selectProductos.value);
    const valueCantidad = parseInt(cantidad.value);
    const bodyAdd = {
        "product":idProduct,
        "branch":sucursal,
        "stockAmount":valueCantidad
    }
    const requestAdd = new Request("http://localhost:8080/productBranch/add",{
        method:"POST",
        body:JSON.stringify(bodyAdd),
        headers:{
            "Content-Type":"application/json"
        }
    });

    return requestAdd;
}
