package servicios;

import entidades.Prestamo;
import entidades.Usuario;
import persistencia.UsuarioDAO;

import java.util.List;
import java.util.Scanner;

public class UsuarioService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private UsuarioDAO DAO;

    public UsuarioService() {
        this.DAO = new UsuarioDAO();
    }

    public void cargarUsuario() {
        Usuario usuario = new Usuario();
        System.out.println("Ingrese el nombre del usuario:");
        usuario.setNombre(leer.next());
        System.out.println("Ingrese el apellido del usuario:");
        usuario.setApellido(leer.next());
        try {
            DAO.guardar(usuario);
            System.out.println("Usuario registrado");
        }catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    public Usuario buscarUsuarioPorId(){
        System.out.println("Ingrese el id del usuario a buscar:");
        try {
            return DAO.buscarUsuarioPorId(leer.nextLong());
        }catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return null;
        }
    }
//    public void mostrarPrestamosUsuario(){
//        System.out.println("Ingrese el id del usuario a buscar:");
//        try {
//            Usuario usuario = DAO.buscarUsuarioPorId(leer.nextLong());
//            System.out.println(usuario.toString());
//            List<Prestamo> prestamos = usuario.getPrestamos();
//            for (Prestamo p: prestamos) {
//                System.out.println(p.toString());
//            }
//        }catch (Exception e) {
//            System.out.println("Error: "+ e.getMessage());
//        }
//    }
}
