const linkRegresar = document.querySelector("#regresar");
console.log(window.location.href);
const form = document.querySelector("#form");
const nombre = document.querySelector("#name");
const categoria = document.querySelector("#category");
const precio = document.querySelector("#price")
let idCategoria = 0;
let valorPrecio = 0;


//------------CAPTURAMOS EL QUERY PARAM
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const idProduct = arrayData[0][1];
const idSucursal = arrayData[1][1];
const dpi = arrayData[2][1];

//--------------CONFIGUEAR LINKS
const queryRegresar = "?idSucursal="+idSucursal+"&dpi="+dpi;
linkRegresar.href="./productos.html"+queryRegresar;

/*--------------LLENAR EL SELECT DE CATEGORIA----------*/
let contenidoSelect = "<option value = 0>-Seleccione una categoria-</option>";
const requestcategoria = new Request("http://localhost:8080/productCategory/all");
fetch(requestcategoria)
    .then(res => res.json())
    .then(response => {
        console.log(response);
      categoria.innerHTML =  mostrarCategorias(response);
    });

/*------------CAPTURAR LA CATEGORIA------------------*/
categoria.addEventListener("change",()=>{
    idCategoria = parseInt(categoria.value);
});


/*-----------BUSCAMOS EL PRODUCTO A MODIFICAR-------------*/

const request = new Request("http://localhost:8080/product/find/"+idProduct);
fetch(request)
    .then(res => res.json())
    .then(response => {
        console.log(response);
        mostrarProducto(response);
    });

//---------------MODIFICAR PRODUCTO--------------------------------
form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const reqModify = modificarProducto();
    fetch(reqModify)
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            alert("Producto MODIFICADO");
            window.location.href = "../../vistas/inventario/productos.html?idSucursal="+idSucursal;
        });

});


//-------FUNCIONES

function mostrarCategorias(data){
    for(let i=0; i<data.length; i++){
        contenidoSelect += "<option value = "+data[i].categoryId+">"+data[i].description+"</option>";
    }
    return contenidoSelect;
}


function mostrarProducto(data){
    nombre.value = data.name;
    precio.value = data.price;
}

function modificarProducto(){
    valorPrecio = parseInt(precio.value);

    const bodyModify = {
        "name":nombre.value,
        "category":idCategoria,
        "price": valorPrecio
    }

    const requestModify = new Request("http://localhost:8080/product/modify/"+idProduct,
    {
     method:"POST",
     body:JSON.stringify(bodyModify),
     headers:{
        'Content-Type':'application/json'
      } 
    });

    return requestModify;
}