var a;
function mostrar_ocultar()

{
    if (a==1) {
        document.getElementById("pocosarticulos").style.display="inline-flex";
        document.getElementById("muchosarticulos").style.display="none";
         document.getElementById("mostrarmenosmas").innerHTML = "Mostrar mas";
        
        return a=0;
    } else {
        document.getElementById("pocosarticulos").style.display="none";
        document.getElementById("muchosarticulos").style.display="inline-flex";
       document.getElementById("mostrarmenosmas").innerHTML = "Mostrar menos";
        return a=1;
    }
    
}