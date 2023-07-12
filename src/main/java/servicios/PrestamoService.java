package servicios;

import entidades.Libro;
import entidades.Prestamo;
import persistencia.DAO;
import persistencia.PrestamoDAO;

import java.time.LocalDate;
import java.util.Scanner;

public class PrestamoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroService libroService = new LibroService();
    UsuarioService usuarioService = new UsuarioService();
    private PrestamoDAO DAO;

    public PrestamoService() {
        this.DAO = new PrestamoDAO();
    }

    public void registrarPrestamo() {
        Prestamo prestamo = new Prestamo();
        System.out.println("Seleccion de libro...");
        Libro libro = libroService.buscarLibroPorISBN();
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }else {
            prestamo.setLibro(libro);
        }
        System.out.println("Seleccion de usuario...");
        prestamo.setUsuario(usuarioService.buscarUsuarioPorId());

        System.out.println("Ingrese la fecha de prestamo (formato: AAAA-MM-DD):");
        LocalDate fechaPrestamo;
        String fechaStr = leer.nextLine();
        fechaPrestamo = LocalDate.parse(fechaStr);
        prestamo.setFechaPrestamo(fechaPrestamo);

        System.out.println("Ingrese la fecha de devolucion (formato: AAAA-MM-DD):");
        LocalDate fechaDevolucion;
        fechaStr = leer.nextLine();
        fechaDevolucion = LocalDate.parse(fechaStr);
        prestamo.setFechaDevolucion(fechaDevolucion);

        try {
            DAO.guardar(prestamo);
        }catch (Exception e){
            System.out.println("Error al registrar prestamo " + e.getMessage());
        }
    }

    public void listarPrestamos() {
        System.out.println("Ingrese el id del usuario: ");
        int idUsuario = leer.nextInt();
        try {
            DAO.listarPrestamos(idUsuario);
        }catch (Exception e){
            System.out.println("Error al listar prestamos " + e.getMessage());
        }

    }
}
