/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.arelance.domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Pedro
 */
public class main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imdPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("pedro");
        usuario.setApellidoUsuarioA("perez");
        usuario.setApellidoUsuarioB("banda");
        usuario.setEmailUsuario("pedro@");
        usuario.setTelefonoUsuario("12345");
        em.persist(usuario);
        tx.commit();
        em.close();
    }
}
