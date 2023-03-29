const linkRegresar = document.querySelector("#regresar");
const form = document.querySelector("#form");
const dpi = document.querySelector("#dpi");
const nameEmpleado = document.querySelector("#name");
const lastName = document.querySelector("#lastName");
const birthDate = document.querySelector("#birthDate");
const salary = document.querySelector("#salary");
const phone = document.querySelector("#phone");
const branch = document.querySelector("#branch");
const rol = document.querySelector("#rol");
let idBranch =0;
let idRol = 0;
/*------------------------CAPTURAMOS QUERY PARAM-----------------------*/

console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const dpiEmpleado = arrayData[0][1]; //el empleado a modificar
const dpiEmpleadoActual = arrayData[1][1];//el empleado logeado
const sucursal = arrayData[2][1];
console.log(dpiEmpleadoActual+"   "+sucursal);
//----------------CONFIGURACION DE LINK 
const queryParamRegresar = "?dpi="+dpiEmpleadoActual+"&sucursal="+sucursal;
linkRegresar.href= "http://127.0.0.1:5500/vistas/administracion/empleados.html"+queryParamRegresar;


//-------------------------
branch.addEventListener("change",()=>{
    idBranch = parseInt(branch.value);
    console.log(idBranch);
});

rol.addEventListener("change",()=>{
    idRol = parseInt(rol.value);
    console.log(idRol);
});

//PETICION GET PARA OBTENER UN EMPLEADO
const request = new Request("http://localhost:8080/employee/find/"+dpiEmpleado);
fetch(request)
    .then(res => res.json())
    .then(response =>{
        console.log(response);
        mostrarEmpleado(response);
    });



function mostrarEmpleado(data){
    dpi.value = data.dpi;
    nameEmpleado.value = data.name;
    lastName.value = data.lastName;
    phone.value = data.phone;
    salary.value = data.phone;
}

/*+++++++++++++*/
let contenidoSelectBranch = '<option value=0>-Seleccione una opcion-</option>';
let contenidoSelectRole = '<option value=0>-Seleccione una opcion-</option>';


//----Llenamos el select de branch
const requestBranch = new Request("http://localhost:8080/branch/all");

fetch(requestBranch)
.then(res => res.json())
.then(response =>{
    console.log(response);
    for(let i=0; i<response.length; i++){
        contenidoSelectBranch+='<option value='+response[i].branchId+'>'+response[i].name+'</option>'
    }
    console.log(contenidoSelectBranch)
    branch.innerHTML=contenidoSelectBranch;
});


//Llenar el select de rol
const requestRole = new Request("http://localhost:8080/role/all");

fetch(requestRole)
.then(res => res.json())
.then(response =>{
    console.log(response);
    
    for(let i=0; i<response.length; i++){
        contenidoSelectRole+='<option value='+response[i].roleId+'>'+response[i].jobPosition+'</option>'
    }
    console.log(contenidoSelectRole)
    rol.innerHTML=contenidoSelectRole;
    
});



/*MODIFICAR EMPLEADO*/
form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const request = modificarEmpleado();
    fetch(request)
        .then(res => res.json())
        .then(response => {
            if(response.status == 201){
                alert("Empleado modificado");
            }
            console.log(response);
        });
    
});


function modificarEmpleado(){
    const phoneValue = parseInt(phone.value);
    const salaryValue = parseInt(salary.value);
    if(idBranch == 4){
        idRol = 3;
        console.log(rol);
    }
    const body = {
        "dpi":dpi.value,
        "name":nameEmpleado.value,
        "lastName":lastName.value,
        "birthDate": birthDate.value,
        "phone":phoneValue,
        "branch":idBranch,
        "salary":salaryValue,
        "role":idRol
    }

    const request = new Request("http://localhost:8080/employee/modify/"+dpiEmpleado,{
        method:"POST",
        body:JSON.stringify(body),
        headers:{
            'Content-Type':'application/json'
          }
    });

    return request;
}
