/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintest;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Paypal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Usuario;
import entitycontrol.PaypalJpaController;
import entitycontrol.TarjetaJpaController;
import entitycontrol.UsuarioJpaController;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imdPU");
        EntityManager em = emf.createEntityManager();
 
    
        Usuario u1 = new Usuario();
        u1.setIdUsuario(0);
        u1.setNombre("nombreuser");
        u1.setApellidoA("apellido1");
        u1.setApellidoB("apellido2");
        u1.setEmail("correouser");
        u1.setTelefono("62352");
        UsuarioJpaController usuarioJpaController = new UsuarioJpaController(emf);
        usuarioJpaController.create(u1);
        //CREAMOS TIPO PAGO PAYPAL
        MetodoPago p1 = new Paypal("correoj@jgjgj.com", 0, "esunpaypal", u1);
        PaypalJpaController paypalJpaController = new PaypalJpaController(emf);
        paypalJpaController.create((Paypal) p1);
        MetodoPago tarjeta1 = new Tarjeta("numerotarjeta", "cv222",0, "mi tarjeta", u1);
        TarjetaJpaController tarjetaJpaController = new TarjetaJpaController(emf);
        tarjetaJpaController.create((Tarjeta) tarjeta1);
               MetodoPago p2 = new Paypal("correoj2@jgjgj.com", 0, "esunpaypa2", u1);
     
        paypalJpaController.create((Paypal) p2);
           em.getTransaction().begin();
        emf.close();
    }
}
