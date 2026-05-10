package com.example.articlemanagement.service;

import com.example.articlemanagement.dto.ArticleRequestDto;
import com.example.articlemanagement.dto.ArticleResponseDto;
import java.util.List;

public interface ArticleService {

	ArticleResponseDto create(ArticleRequestDto request);

	ArticleResponseDto update(Long id, ArticleRequestDto request);

	void delete(Long id);

	ArticleResponseDto getById(Long id);

	List<ArticleResponseDto> getAll();
}
