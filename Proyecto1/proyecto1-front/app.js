const form = document.querySelector("#form");
const usuario = document.querySelector("#user");
const password = document.querySelector("#password");

form.addEventListener("submit",(e)=>{
    e.preventDefault();
    console.log(usuario.value);
    console.log(password.value);
    obtnerUsuario(usuario.value);
});


function obtnerUsuario(user){
    const request = new Request("http://localhost:8080/user/find/"+user);
    fetch(request)
        .then(res => res.json())
        .then(response =>{
            console.log(response);
            if(response.status == undefined){
                if(validarUsuario(response.password)){
                    const idRol = response.employee.roleEmployeeDTO.roleId;
                    const dpi = response.employee.dpi;
                    const idBranch = response.employee.branchDTO.branchId;
                    redireccionar(idRol,dpi,idBranch);
                }   
            }else{
                alert(response.message);
            }
        });
}

function validarUsuario(passwordUser){
    if(password.value != passwordUser){
        alert("La contraseña es incorrecta");
        return false;
    }
    return true;
}

function redireccionar(idRol,dpi,idBranch){
    const queryParam = "?dpi="+dpi+"&sucursal="+idBranch;
    if(idRol == 1){
        window.location.href="http://127.0.0.1:5500/vistas/ventas/index.html"+queryParam;   
    }else if(idRol == 2){
        window.location.href="http://127.0.0.1:5500/vistas/inventario/index.html"+queryParam;
    }
    else if(idRol == 3){
        window.location.href="http://127.0.0.1:5500/vistas/bodega/index.html"+queryParam;
    }else if(idRol == 4){
        window.location.href="http://127.0.0.1:5500/vistas/administracion/index.html"+queryParam;
    }
}
