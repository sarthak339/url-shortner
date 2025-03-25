package com.sarthak.URL.Shortener.controller;

import com.sarthak.URL.Shortener.entity.URL;
import com.sarthak.URL.Shortener.exception.NotFoundException;
import com.sarthak.URL.Shortener.service.URLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

    @Autowired
    private URLService service;

    @GetMapping("/{shortURL}")
    public RedirectView redirect(@PathVariable String shortURL) throws NotFoundException{
        return new RedirectView(service.get(shortURL));
    }

    @PostMapping("/shorten")
    public ResponseEntity<URL> saveNewURL(@RequestParam(name = "url") String url){
        return ResponseEntity.ok(service.save(url));
    }
}
