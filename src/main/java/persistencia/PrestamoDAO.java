package persistencia;

import entidades.Prestamo;

import java.util.*;

public class PrestamoDAO extends DAO<Prestamo> {
    @Override
    public void guardar(Prestamo objeto) {
        super.guardar(objeto);
    }

    @Override
    public void actualizar(Prestamo objeto) {
        super.actualizar(objeto);
    }

    @Override
    public void eliminar(Prestamo objeto) {
        super.eliminar(objeto);
    }
    public void listarPrestamos(long idUsuario){
        List<Prestamo> listaPrestamos;
        listaPrestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.usuario.id = :idUsuario", Prestamo.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
        if(listaPrestamos != null){
            for (Prestamo p : listaPrestamos) {
                System.out.println(p);
            }
        }else {
            System.out.println("No hay prestamos");
        }
    }
}
