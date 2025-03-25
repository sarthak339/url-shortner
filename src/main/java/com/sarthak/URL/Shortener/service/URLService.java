package com.sarthak.URL.Shortener.service;

import com.sarthak.URL.Shortener.entity.URL;
import com.sarthak.URL.Shortener.exception.NotFoundException;
import com.sarthak.URL.Shortener.repo.URLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class URLService {

    @Autowired
    URLRepo repo;

    public URL save(String urlStr){
        URL url = URL.builder()
                .fullURL(urlStr)
                .shortenedURL(generateShortURL())
                .date(new Date())
                .build();

        return repo.save(url);
    }

    public String get(String shortUrl) throws NotFoundException {
        Optional<URL> url = repo.findById(shortUrl);
        if (url.isEmpty()){
            throw new NotFoundException("url not found");
        }
        return url.get().getFullURL();
    }

    private String generateShortURL(){
        String validCharacters = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int idLength = 10;
        StringBuilder randomId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < idLength; i++) {
            randomId.append(validCharacters.charAt(random.nextInt(validCharacters.length())));
        }
        return randomId.toString();
    }


}
