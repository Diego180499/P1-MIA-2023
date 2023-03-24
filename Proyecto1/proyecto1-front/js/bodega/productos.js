const linkRegresar = document.querySelector("#regresar");
const tabla = document.querySelector("#table-products");
let contenidoTabla = "<tr><th>Id</th><th>Nombre Producto</th><th>Categoria</th><th>Precio</th><th>Stock</th></tr>";

/*--------OBTENER EL ID DE SUCURSAL*/
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const idSucursal = arrayData[1][1];
const dpi = arrayData[0][1];

//-----------------configuracion link
const queryRegresar = "?dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href="./index.html"+queryRegresar;


/*-----------------------------*/
const request2 = new Request("http://localhost:8080/productBranch/find/sucursal/"+idSucursal);
fetch(request2)
    .then(res => res.json())
    .then(response =>{
        console.log(response);
        tabla.innerHTML = mostrarProductos(response);
    });
/*----------------------------------*/
function mostrarProductos(data){
    for(let i=0; i<data.length; i++){
        contenidoTabla+= "<tr><th>"+data[i].productBranchId+"</th><th>"+data[i].product.name+"</th><th>"+data[i].product.category.description+"</th><th>"+data[i].product.price+"</th><th>"+data[i].stockAmount+"</th></tr>";
    }
    return contenidoTabla;
}
