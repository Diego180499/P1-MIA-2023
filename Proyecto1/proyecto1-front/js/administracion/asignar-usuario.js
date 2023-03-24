const linkRegresar = document.querySelector("#regresar");
const form = document.querySelector("#form");
const usuario = document.querySelector("#usuario");
const password = document.querySelector("#password");


form.addEventListener("submit",(e)=>{
    e.preventDefault();
    const req = asignarUsuario();
    fetch(req)
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            if(response.status == 201){
                alert("Usuario asignado");
            }else if(response.status == 400){
                alert(response.message);
            }
        });
});


function asignarUsuario(){
    const bodyRequest = {
        "user":usuario.value,
        "password": password.value
    }
    
    const request = new Request("http://localhost:8080/user/add",{
        method:"POST",
        body:JSON.stringify(bodyRequest),
        headers:{
            'Content-Type':'application/json'
        }
    });
    return request;
}


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