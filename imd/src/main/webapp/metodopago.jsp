<%-- 
    Document   : metodopago
    Created on : 14-oct-2021, 19:40:01
    Author     : model
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        
  <ul uk-accordion>

        <li>
            <a class="uk-accordion-title" href="#">Añadir PayPal</a>
            <div class="uk-accordion-content">
                <form method="POST" action="actions?action=paymentmethod&metodopago=PAYPAL">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="descripcion">
                        <input class="uk-input" type="text" placeholder="Correo PayPal" name="correopaypal">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>


        <li>
            <a class="uk-accordion-title" href="#">Añadir tarjeta</a>
            <div class="uk-accordion-content">
                <form method="POST" action="actions?action=paymentmethod&metodopago=DEBIT">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="descripcion">
                        <input class="uk-input" type="text" placeholder="Número tarjeta" name="numerotarjeta">
                        <input class="uk-input" type="text" placeholder="Código seguridad" name="cvv">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>


        <li>
            <a class="uk-accordion-title" href="#">Añadir cuenta bancaria</a>
            <div class="uk-accordion-content">
                <form method="POST" action="actions?action=paymentmethod&metodopago=ACCOUNT">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="descripcion">
                        <input class="uk-input" type="text" placeholder="Número IBAN" name="iban">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>




    </ul>

        
        
    </body>
</html>
