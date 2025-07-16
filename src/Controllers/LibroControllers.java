package Controllers;

import Models.Book;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LibroControllers {
    public Map<Book, Book> procesarLibros(List<Book> libros) {
        Comparator<Book> bookComparator = Comparator
                .comparing(Book::getTitulo, Comparator.reverseOrder()) 
                .thenComparing(Book::getAnio); 

        Map<Book, Book> resultado = new TreeMap<>(bookComparator);

        for (Book libro : libros) {
            resultado.putIfAbsent(libro, libro);
        }

        return resultado;
    }

}
