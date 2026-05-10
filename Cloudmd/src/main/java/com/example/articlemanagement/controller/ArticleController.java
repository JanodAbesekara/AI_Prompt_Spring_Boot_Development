package com.example.articlemanagement.controller;

import com.example.articlemanagement.dto.ApiResponse;
import com.example.articlemanagement.dto.ArticleRequestDto;
import com.example.articlemanagement.dto.ArticleResponseDto;
import com.example.articlemanagement.service.ArticleService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

	private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@PostMapping
	public ResponseEntity<ApiResponse<ArticleResponseDto>> create(@Valid @RequestBody ArticleRequestDto request) {
		ArticleResponseDto created = articleService.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok("Article created successfully", created));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ArticleResponseDto>> update(@PathVariable Long id, @Valid @RequestBody ArticleRequestDto request) {
		return ResponseEntity.ok(ApiResponse.ok("Article updated successfully", articleService.update(id, request)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
		articleService.delete(id);
		return ResponseEntity.ok(ApiResponse.ok("Article deleted successfully", null));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ArticleResponseDto>> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ApiResponse.ok("Article retrieved successfully", articleService.getById(id)));
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<ArticleResponseDto>>> getAll() {
		return ResponseEntity.ok(ApiResponse.ok("Articles retrieved successfully", articleService.getAll()));
	}
}
