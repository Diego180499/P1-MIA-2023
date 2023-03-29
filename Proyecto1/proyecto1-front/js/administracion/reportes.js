const sucursales1 = document.querySelector("#sucursales");
const linkRegresar = document.querySelector("#regresar");
const reporte1 = document.querySelector("#reporte1");
const reporte2 = document.querySelector("#reporte2");
const reporte3 = document.querySelector("#reporte3");
const reporte4 = document.querySelector("#reporte4");
const reporte5 = document.querySelector("#reporte5");
const reporte6 = document.querySelector("#reporte6");
const reporte7 = document.querySelector("#reporte7");
const reporte8 = document.querySelector("#reporte8");
const reporte9 = document.querySelector("#reporte9");


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
linkRegresar.href="http://127.0.0.1:5500/vistas/administracion/index.html"+queryParam;

//--------LLENAMOS LOS SELECT DE LAS SUCURSALES---------------------
/*---------------------------------------------------------------*/
let contenidoSelectBranch = '<option value=0>-Seleccione Sucursal-</option>';

const request = new Request("http://localhost:8080/branch/all");

fetch(request)
.then(res => res.json())
.then(response =>{
    console.log(response);
    for(let i=0; i<response.length; i++){
        contenidoSelectBranch+='<option value='+response[i].branchId+'>'+response[i].name+'</option>'
    }
    console.log(contenidoSelectBranch)
    sucursales1.innerHTML=contenidoSelectBranch;
});

/*HACIENDO CLICK EN CADA REPORTE*/
//REPORTE 1
reporte1.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/productos/masVendidos.html"+queryParam;
});


//REPORTE 2
reporte2.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/clientes/clienteMasIngreso.html"+queryParam;
});


//REPORTE 3
reporte3.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/sucursales/masVentas.html"+queryParam;
});

//REPORTE 4
reporte4.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/sucursales/masIngresos.html"+queryParam;
});


//REPORTE 5
reporte5.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/empleados/masVentas.html"+queryParam;
});


//REPORTE 6
reporte6.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/empleados/masIngresos.html"+queryParam;
});


//REPORTE 7
reporte7.addEventListener("click",()=>{
    window.location.href="../administracion/reportes/productos/masIngresos.html"+queryParam;
});


//REPORTE 8
reporte8.addEventListener("click",()=>{
    if(sucursales1.value == 0){
        alert("debes elegir una sucursal");
    }else{
        window.location.href="../administracion/reportes/productos/masVendidosPS.html"+queryParam+"&sucursal="+sucursales1.value;
    }
});


//REPORTE 9
reporte9.addEventListener("click",()=>{
    if(sucursales1.value == 0){
        alert("debes elegir una sucursal");
    }else{
        window.location.href="../administracion/reportes/productos/masIngresosPS.html"+queryParam+"&sucursal="+sucursales1.value;
    }
});
