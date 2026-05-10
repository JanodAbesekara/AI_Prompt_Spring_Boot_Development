package com.example.articlemanagement.dto;

import java.time.Instant;

public record ArticleResponseDto(
		Long id, String title, String content, String author, Instant createdAt
) {}
