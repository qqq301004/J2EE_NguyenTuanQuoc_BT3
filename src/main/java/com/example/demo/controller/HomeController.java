/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService; // Sử dụng Bean Service

    @GetMapping("/home")
    public String index(Model model) {
        // Truyền danh sách sách sang View
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "index"; // Trả về index.html
    }
}