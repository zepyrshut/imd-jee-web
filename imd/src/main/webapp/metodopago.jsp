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
      
        
        <form method="GET" action="PaymentMethod">
            
       <label for="paypal">paypal</label>     <input type="radio" id="paypal" name="metodopago" value="paypal">
       <label for="transferencia">transferencia</label>     <input type="radio" id="transferencia" name="metodopago" value="transferencia">
       <label for="cuentacorriente">cuentacorriente</label>     <input type="radio" id="cuentacorriente" name="metodopago" value="cuentacorriente">
            
            
        <input type="text" id="correo-paypal" name="correopaypal">
                  
        <input type="text" id="string-key" name="stringkey">
            
             
            
            
            
            <input type="submit" class="uk-button uk-button-primary" value="Añadir" />
            
            
            
        </form>
        
        
        
        <a href="PaymentMethod">ejecutar</a>
        
        
        
    </body>
</html>
