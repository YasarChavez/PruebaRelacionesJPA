package servicios;

import entidades.Libro;
import persistencia.LibroDAO;

import java.util.Scanner;

public class LibroService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private LibroDAO DAO;

    public LibroService() {
        this.DAO = new LibroDAO();
    }
    public void cargarLibro(){
        /*titulo; autor; editorial;*/
        Libro libro = new Libro();
        System.out.println("Ingrese el titulo del libro:");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese el autor del libro:");
        libro.setAutor(leer.next());
        System.out.println("Ingrese la editorial del libro:");
        libro.setEditorial(leer.next());
        try {
            DAO.guardar(libro);
            System.out.println("Libro guardado");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    public Libro buscarLibroPorISBN(){
        System.out.println("Ingrese el ISBN del libro a buscar:");
        long isbn = leer.nextLong();
        try {
            return DAO.buscarLibroPorISBN(isbn);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
}
