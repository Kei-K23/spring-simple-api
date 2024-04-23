package dev.kei.springAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kei.springAPI.model.Content;
import dev.kei.springAPI.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository contentRepository;

    public ContentController(ContentCollectionRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentRepository.findAll();
    }
}
