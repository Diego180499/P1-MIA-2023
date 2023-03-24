const linkRegresar = document.querySelector("#regresar");
const form = document.querySelector("#form");
const boton = document.querySelector("#btn");
const nit = document.querySelector("#nit");
const nameUser = document.querySelector("#name");
const lastName = document.querySelector("#lastName");
const address = document.querySelector("#address");
const phone = document.querySelector("#phone");

/*--------OBTENER EL ID DE SUCURSAL*/
const params = new URL(window.location.href).searchParams;
const data = new URLSearchParams(params).entries();
const arrayData = Array.from(data);
console.log(arrayData);
//------------
const dpi = arrayData[0][1];
const idSucursal = arrayData[1][1];

//-----------------configuracion link
const queryRegresar = "?dpi="+dpi+"&sucursal="+idSucursal;
linkRegresar.href="./index.html"+queryRegresar;
//---------------------------------

form.addEventListener('submit',(e)=>{
    e.preventDefault();
    const req = ingresarCliente();
    fetch(req)
    .then(res => res.json())
    .then(response => {
        console.log(response)
        alert("Cliente creado");
        window.location.href="http://127.0.0.1:5500/vistas/ventas/index.html";
      });
});


function ingresarCliente(){
  const newPhone = parseInt(phone.value);
  const request = new Request("http://localhost:8080/client/save", {
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



