import servicios.LibroService;
import servicios.PrestamoService;
import servicios.UsuarioService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        LibroService libroService = new LibroService();
        PrestamoService prestamoService = new PrestamoService();

//        Cargar Usuario
//        usuarioService.cargarUsuario();
//        Cargar Libro
//        libroService.cargarLibro();
//        prestamoService.registrarPrestamo();
//        usuarioService.mostrarPrestamosUsuario();
        prestamoService.listarPrestamos();

    }
}
