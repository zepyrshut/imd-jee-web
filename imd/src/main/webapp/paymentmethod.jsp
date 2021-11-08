<%-- 
    Document   : metodopago
    Created on : 14-oct-2021, 19:40:01
    Author     : model
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
           <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>
  <ul uk-accordion>
        <li>
            <a class="uk-accordion-title" href="#">Añadir PayPal</a>
            <div class="uk-accordion-content">
                <form method="POST" action="actions?action=paymentmethod&paymentmethod=paypal&actionPayment=add">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="description">
                        <input class="uk-input" type="text" placeholder="Correo PayPal" name="email">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>


        <li>
            <a class="uk-accordion-title" href="#">Añadir tarjeta</a>
            <div class="uk-accordion-content">
                <form  method="POST" action="actions?action=paymentmethod&paymentmethod=debit&actionPayment=add">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="description">
                        <input class="uk-input" type="text" placeholder="Número tarjeta" name="number">
                        <input class="uk-input" type="text" placeholder="Código seguridad" name="cvv">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>


        <li>
            <a class="uk-accordion-title" href="#">Añadir cuenta bancaria</a>
            <div class="uk-accordion-content">
                <form  method="POST" action="actions?action=paymentmethod&paymentmethod=bank&actionPayment=add">
                    <div class="uk-margin">
                        <input class="uk-input" type="text" placeholder="Descripción" name="description">
                        <input class="uk-input" type="text" placeholder="Número IBAN" name="iban">
                    </div>
                    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top">
                </form>
            </div>
        </li>




    </ul>

                    <!-- Pie de página -->
            <%@ include file="/jspf/footer.jspf" %> 
        
    </body>
</html>
