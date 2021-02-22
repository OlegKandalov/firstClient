package com.example.client11;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReaderController {
    private final RestTemplate restTemplate;

    @Autowired
    public ReaderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/library/books/popular")
    public List<String> getOneBook() {
        ResponseEntity<Object[]> entity = restTemplate.getForEntity("http://library/books", Object[].class);
        Object[] objects = entity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        List<String> books = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Book.class))
                .filter(r -> r.getRating() > 7)
                .map(Book::getBook)
                .collect(Collectors.toList());

        return books;
    }
}
