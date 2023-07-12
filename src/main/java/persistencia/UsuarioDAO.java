package persistencia;

import entidades.Usuario;

import java.util.Scanner;

public class UsuarioDAO extends DAO<Usuario> {
    @Override
    public void guardar(Usuario objeto) {
        super.guardar(objeto);
    }

    @Override
    public void actualizar(Usuario objeto) {
        super.actualizar(objeto);
    }

    @Override
    public void eliminar(Usuario objeto) {
        super.eliminar(objeto);
    }

    public Usuario buscarUsuarioPorId(long id){
        Usuario usuario = null;
        conectar();
        try {
            usuario = em.find(Usuario.class, id);
        }catch (Exception e){
            System.out.println("Error al buscar usuario "+ e.getMessage());
        }
        desconectar();
        return usuario;
    }
}
