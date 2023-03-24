const form = document.querySelector("#form");
const linkRegresar = document.querySelector("#regresar");
const nit = document.querySelector("#nit");
const nameUser = document.querySelector("#name");
const lastName = document.querySelector("#lastName");
const address = document.querySelector("#address");
const phone = document.querySelector("#phone");

//*******************
console.log(window.location.href);
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
const nitClient = arrayData[0][1];
const dpi = arrayData[1][1];
const idSucursal = arrayData[2][1];


//-------configuar link
const queryRegresar = "?dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href="./clientes.html"+queryRegresar;

//PETICION GET de buscar a u cliente por su NIT
const request = new Request("http://localhost:8080/client/find/"+nitClient);
fetch(request)
    .then(res => res.json())
    .then(response =>{
        console.log(response);
        mostrarCliente(response);
    });


function mostrarCliente(response){
    nit.value = response.nit;
    nameUser.value = response.name;
    lastName.value = response.lastName;
    address.value = response.address;
    phone.value = response.phone;    

}


// logica para modificar un cliente

form.addEventListener('submit',(e)=>{
    e.preventDefault();
    //logica de modificacion
    const req = modificarCliente();
    fetch(req)
    .then(res => res.json())
    .then(response => {
        console.log(response)
        alert("Cliente Modificado");
        window.location.href="./clientes.html";
    });
});


function modificarCliente(){
    const newPhone = parseInt(phone.value);
    const request = new Request("http://localhost:8080/client/modify/"+nitClient, {
    method: "POST",
    body: JSON.stringify({
    "nit":nit.value,
    "name":nameUser.value,
    "lastName":lastName.value,
    "address":address.value,
    "phone":newPhone}),
    headers:{
      'Content-Type':'application/json'
    }
  });

  return request;
}