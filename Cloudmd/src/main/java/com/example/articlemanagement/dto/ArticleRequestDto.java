package com.example.articlemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArticleRequestDto(
		@NotBlank(message = "Title is required") @Size(max = 500) String title,
		@NotBlank(message = "Content is required") String content,
		@NotBlank(message = "Author is required") @Size(max = 255) String author
) {}
