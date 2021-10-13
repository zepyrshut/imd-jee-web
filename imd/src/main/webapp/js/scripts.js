let htmlElements = document.getElementsByClassName('error-input');

function toError() {
   Array.from(htmlElements).forEach(function(element) {
        element.classList.add('uk-form-danger');
    });
}

function toNeutral() {
    Array.from(htmlElements).forEach(function(element) {
        element.classList.remove('uk-form-danger');
    });   
    let mensajeError = document.getElementById('error-message');
    mensajeError.remove();
}
