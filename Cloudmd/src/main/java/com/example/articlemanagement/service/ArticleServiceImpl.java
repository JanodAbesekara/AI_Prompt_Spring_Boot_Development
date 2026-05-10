package com.example.articlemanagement.service;

import com.example.articlemanagement.dto.ArticleRequestDto;
import com.example.articlemanagement.dto.ArticleResponseDto;
import com.example.articlemanagement.entity.Article;
import com.example.articlemanagement.exception.ResourceNotFoundException;
import com.example.articlemanagement.repository.ArticleRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	@Transactional
	public ArticleResponseDto create(ArticleRequestDto request) {
		Article article = Article.builder()
				.title(request.title())
				.content(request.content())
				.author(request.author())
				.build();
		return mapToResponse(articleRepository.save(article));
	}

	@Override
	@Transactional
	public ArticleResponseDto update(Long id, ArticleRequestDto request) {
		Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
		article.setTitle(request.title());
		article.setContent(request.content());
		article.setAuthor(request.author());
		return mapToResponse(articleRepository.save(article));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		if (!articleRepository.existsById(id)) {
			throw new ResourceNotFoundException("Article not found");
		}
		articleRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ArticleResponseDto getById(Long id) {
		return articleRepository.findById(id).map(ArticleServiceImpl::mapToResponse).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArticleResponseDto> getAll() {
		return articleRepository.findAll().stream().map(ArticleServiceImpl::mapToResponse).toList();
	}

	private static ArticleResponseDto mapToResponse(Article entity) {
		return new ArticleResponseDto(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor(), entity.getCreatedAt());
	}
}
