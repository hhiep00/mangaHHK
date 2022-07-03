package com.pro.manga.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.pro.manga.domain.PageManga;
import com.pro.manga.repository.PageRepository;
import com.pro.manga.service.PageService;

@Service
public class PageServiceImpl implements PageService{
	@Autowired
	PageRepository pageRepository;

	@Override
	public <S extends PageManga> S save(S entity) {
		return pageRepository.save(entity);
	}

	@Override
	public <S extends PageManga> Optional<S> findOne(Example<S> example) {
		return pageRepository.findOne(example);
	}

	@Override
	public List<PageManga> findAllByChapterId(Long chapterId) {
		return pageRepository.findAllByChapterId(chapterId);
	}

	@Override
	public List<PageManga> findAll() {
		return pageRepository.findAll();
	}

	@Override
	public org.springframework.data.domain.Page<PageManga> findAll(Pageable pageable) {
		return pageRepository.findAll(pageable);
	}

	@Override
	public List<PageManga> findAll(Sort sort) {
		return pageRepository.findAll(sort);
	}

	@Override
	public List<PageManga> findAllById(Iterable<Long> ids) {
		return pageRepository.findAllById(ids);
	}

	@Override
	public Optional<PageManga> findById(Long id) {
		return pageRepository.findById(id);
	}

	@Override
	public <S extends PageManga> List<S> saveAll(Iterable<S> entities) {
		return pageRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		pageRepository.flush();
	}

	@Override
	public <S extends PageManga> S saveAndFlush(S entity) {
		return pageRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return pageRepository.existsById(id);
	}

	@Override
	public <S extends PageManga> List<S> saveAllAndFlush(Iterable<S> entities) {
		return pageRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends PageManga> org.springframework.data.domain.Page<S> findAll(Example<S> example, Pageable pageable) {
		return pageRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<PageManga> entities) {
		pageRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends PageManga> long count(Example<S> example) {
		return pageRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<PageManga> entities) {
		pageRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return pageRepository.count();
	}

	@Override
	public <S extends PageManga> boolean exists(Example<S> example) {
		return pageRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		pageRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		pageRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(PageManga entity) {
		pageRepository.delete(entity);
	}

	@Override
	public <S extends PageManga, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return pageRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		pageRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		pageRepository.deleteAllInBatch();
	}

	@Override
	public PageManga getOne(Long id) {
		return pageRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends PageManga> entities) {
		pageRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pageRepository.deleteAll();
	}

	@Override
	public PageManga getById(Long id) {
		return pageRepository.getById(id);
	}

	@Override
	public <S extends PageManga> List<S> findAll(Example<S> example) {
		return pageRepository.findAll(example);
	}

	@Override
	public <S extends PageManga> List<S> findAll(Example<S> example, Sort sort) {
		return pageRepository.findAll(example, sort);
	}
	
}
