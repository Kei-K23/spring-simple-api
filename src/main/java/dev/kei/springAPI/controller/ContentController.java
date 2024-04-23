package dev.kei.springAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.kei.springAPI.model.Content;
import dev.kei.springAPI.model.ErrorResponse;
import dev.kei.springAPI.repository.ContentCollectionRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository contentRepository;

    public ContentController(ContentCollectionRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findContentById(@PathVariable Integer id) {
        Optional<Content> contentOptional = contentRepository.findContentById(id);

        if (contentOptional.isPresent()) {
            return ResponseEntity.ok(contentOptional.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Content not found with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Content saveContent(@Valid @RequestBody Content content) {
        return contentRepository.save(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContent(@PathVariable Integer id, @RequestBody Content content) {
        try {
            Content updateContent = contentRepository.update(id, content);
            return ResponseEntity.status(HttpStatus.OK).body(updateContent);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContent(@PathVariable Integer id) {
        contentRepository.findContentById(id).ifPresent(c -> contentRepository.findAll().remove(c));
    }
}
