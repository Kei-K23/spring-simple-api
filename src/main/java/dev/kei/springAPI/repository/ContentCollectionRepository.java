package dev.kei.springAPI.repository;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Repository;

import dev.kei.springAPI.model.Content;
import dev.kei.springAPI.model.Status;
import dev.kei.springAPI.model.Type;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findContentById(Integer id) {
        return content.stream().filter((c) -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1, "This is test", "This is desc", Status.IDEA, Type.ARTICLE, LocalDateTime.now(),
                LocalDateTime.now(), "");
        this.content.add(c);
    }

    public Content save(Content c) {
        this.content.add(c);
        return c;
    }

    public Content update(Integer id, Content newContent) {
        Optional<Content> existingContent = findContentById(id);

        if (existingContent.isPresent()) {
            Content updatedContent = existingContent.get()
                    .withTitle(newContent.title())
                    .withDescription(newContent.description())
                    .withStatus(newContent.status())
                    .withContentType(newContent.contentType())
                    .withCreatedAt(newContent.createdAt())
                    .withUpdatedAt(LocalDateTime.now()) // Assuming updatedAt should be updated to current time
                    .withUrl(newContent.url());

            content.replaceAll(c -> c.id().equals(id) ? updatedContent : c);
            return updatedContent;
        } else {
            throw new IllegalArgumentException("Content not found with id: " + id);
        }
    }

}
