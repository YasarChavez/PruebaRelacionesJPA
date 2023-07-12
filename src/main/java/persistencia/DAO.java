package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    protected EntityManager em = emf.createEntityManager();

    protected void conectar(){
        if (!em.isOpen()){
            em = emf.createEntityManager();
        }
    }
    protected void desconectar(){
        if (em.isOpen()){
            em.close();
        }
    }
    public void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    public void actualizar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    public void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
