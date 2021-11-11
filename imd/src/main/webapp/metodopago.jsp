<%-- 
    Document   : iniciosesion
    Created on : 19 sept. 2021, 0:42:37
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
           <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>
        
        
        <div class="uk-container uk-container-xsmall uk-padding">
            <header class="padding-top-medium uk-text-center uk-padding">
                <h1 class="">Añadir un método de pago</h1>
            </header>

            <ul uk-accordion>

                <li>
                    <a class="uk-accordion-title" href="#">Añadir PayPal</a>
                    <div class="uk-accordion-content">
                        <form method="POST" action="addingpaymentmethod?metodopago=PAYPAL">
                            <ul class="uk-list">    
                                <li><input class="uk-input uk-margin-small" type="text" placeholder="Descripción" name="descripcion"></li>
                                <li><input class="uk-input uk-margin-small" type="text" placeholder="Correo PayPal" name="correopaypal"></li>
                                <li><input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top"></li>
                            </ul>
                        </form>
                    </div>
                </li>


                <li>
                    <a class="uk-accordion-title" href="#">Añadir tarjeta</a>
                    <div class="uk-accordion-content">
                        <form method="POST" action="addingpaymentmethod?metodopago=DEBIT">
                            <ul class="uk-list">   
                                <li>    <input class="uk-input uk-margin-small" type="text" placeholder="Descripción" name="descripcion"> </li>
                                <li>   <input class="uk-input uk-margin-small" type="text" placeholder="Número tarjeta" name="numerotarjeta"> </li>
                                <li>     <input class="uk-input uk-margin-small" type="text" placeholder="Código seguridad" name="cvv"></li>

                                <li>    <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top"></li>
                            </ul>
                        </form>
                    </div>
                </li>


                <li>
                    <a class="uk-accordion-title" href="#">Añadir cuenta bancaria</a>
                    <div class="uk-accordion-content">
                        <form method="POST" action="addingpaymentmethod?metodopago=ACCOUNT">
                            <ul class="uk-list">   
                                <li>         <input class="uk-input uk-margin-small" type="text" placeholder="Descripción" name="descripcion"></li>
                                <li>        <input class="uk-input uk-margin-small" type="text" placeholder="Número IBAN" name="iban"></li>

                                <li>      <input type="submit" value="Añadir" class="uk-button uk-button-primary uk-margin-small-top"></li>
                            </ul>
                        </form>
                    </div>
                </li>




            </ul>

        </div>
           <!-- Pie de página -->
            <%@ include file="/jspf/footer.jspf" %> 
    </body>
</html>
