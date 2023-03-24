const linkRegresar = document.querySelector("#regresar");
const form = document.querySelector("#form");
const price = document.querySelector("#price");
const nameProduct = document.querySelector("#name");
const selectCategory = document.querySelector("#category");
let contenidoCategory = "";

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

//-----------------------------------
const requestCategory = new Request("http://localhost:8080/productCategory/all");
fetch(requestCategory)
    .then(res => res.json())
    .then(response => {
        console.log(response);
        selectCategory.innerHTML=llenarSelect(response);
    });

//llenar el select de category
function llenarSelect(data){
    contenidoCategory += "<option value=0>-Seleccione Categoria-</option>";
        for(let i=0; i<data.length; i++){
            contenidoCategory += "<option value="+data[i].categoryId+" >"+data[i].description+"</option>";
        }
    console.log(contenidoCategory)
    return contenidoCategory
}

form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const idCategory = selectCategory.value;
    const valuePrice = parseInt(price.value);
    console.log(idCategory);
    console.log(valuePrice);
    console.log(nameProduct.value);

    const req = ingresarProducto(idCategory,valuePrice, nameProduct.value);
    fetch(req)
        .then(res => res.json())
        .then(response => {
            console.log(response);
            if(response.status == 201){
                alert("producto creado");
                window.location.href="http://127.0.0.1:5500/vistas/inventario/index.html";
            }else if(response.status == 400){
                alert(response.message);
            }
        });
});

//------------INGRESAR PRODUCTO
function ingresarProducto(idCategory, price, nameProduct){
    const body = {
        "name": nameProduct,
        "category":idCategory,
        "price": price
    }

    const request = new Request("http://localhost:8080/product/save",{
        method:"POST",
        body:JSON.stringify(body),
        headers:{
            'Content-Type':'application/json'
        }
    });
    return request;
}