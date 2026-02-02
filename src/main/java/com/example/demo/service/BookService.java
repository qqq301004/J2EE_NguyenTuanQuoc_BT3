/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;



import com.example.demo.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int nextId = 4;

    public BookService() {
        // Tạo dữ liệu mẫu
        books.add(new Book(1, "Lập trình Java Web", "Nguyễn Văn A"));
        books.add(new Book(2, "Spring Boot Cơ Bản", "Trần Thị B"));
        books.add(new Book(3, "Microservices với Spring", "Lê Văn C"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        // Gán ID tự động tăng trước khi thêm vào danh sách
        book.setId(nextId++); 
        books.add(book);
    }
    public Optional<Book> getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public void updateBook(Book updatedBook) {
        getBookById(updatedBook.getId()).ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}