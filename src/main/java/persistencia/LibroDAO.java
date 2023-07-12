package persistencia;

import entidades.Libro;

public class LibroDAO extends DAO<Libro>{
    @Override
    public void guardar(Libro objeto) {
        super.guardar(objeto);
    }

    @Override
    public void actualizar(Libro objeto) {
        super.actualizar(objeto);
    }

    @Override
    public void eliminar(Libro objeto) {
        super.eliminar(objeto);
    }
    public Libro buscarLibroPorISBN(long isbn){
        Libro libro = null;
        conectar();
        try {
            libro = em.find(Libro.class,isbn);
        }catch (Exception e){
            System.out.println("Error al buscar libro por ISBN "+ e.getMessage());
        }
        desconectar();
        return libro;
    }
}
