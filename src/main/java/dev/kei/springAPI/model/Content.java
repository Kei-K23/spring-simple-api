package dev.kei.springAPI.model;

import java.time.LocalDateTime;

/**
 * Content
 */
public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String url) {
}
