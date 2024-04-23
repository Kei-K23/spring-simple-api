package dev.kei.springAPI.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

/**
 * Content
 */
public record Content(
                Integer id,
                @NotBlank String title,
                String description,
                Status status,
                Type contentType,
                LocalDateTime createdAt,
                LocalDateTime updatedAt,
                String url) {
        public Content withTitle(String title) {
                return new Content(id(), title, description(), status(), contentType(), createdAt(), updatedAt(),
                                url());
        }

        public Content withDescription(String description) {
                return new Content(id(), title(), description, status(), contentType(), createdAt(), updatedAt(),
                                url());
        }

        public Content withStatus(Status status) {
                return new Content(id(), title(), description(), status, contentType(), createdAt(), updatedAt(),
                                url());
        }

        public Content withContentType(Type contentType) {
                return new Content(id(), title(), description(), status(), contentType, createdAt(), updatedAt(),
                                url());
        }

        public Content withCreatedAt(LocalDateTime createdAt) {
                return new Content(id(), title(), description(), status(), contentType(), createdAt, updatedAt(),
                                url());
        }

        public Content withUpdatedAt(LocalDateTime updatedAt) {
                return new Content(id(), title(), description(), status(), contentType(), createdAt(), updatedAt,
                                url());
        }

        public Content withUrl(String url) {
                return new Content(id(), title(), description(), status(), contentType(), createdAt(), updatedAt(),
                                url);
        }
}
