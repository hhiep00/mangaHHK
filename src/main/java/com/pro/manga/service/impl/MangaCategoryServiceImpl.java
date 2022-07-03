package com.pro.manga.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.pro.manga.domain.Manga;
import com.pro.manga.domain.MangaCategory;
import com.pro.manga.repository.MangaCategoryRepository;
import com.pro.manga.service.MangaCategoryService;

@Service
public class MangaCategoryServiceImpl implements MangaCategoryService{
	@Autowired
	MangaCategoryRepository mangaCategoryRepository;

	
	



	@Override
	public List<MangaCategory> findByCategoryId(Long categoryId) {
		return mangaCategoryRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<MangaCategory> findByMangaId(Long mangaId) {
		return mangaCategoryRepository.findByMangaId(mangaId);
	}
	
	@Override
	public <S extends MangaCategory> S save(S entity) {
		return mangaCategoryRepository.save(entity);
	}

	@Override
	public <S extends MangaCategory> Optional<S> findOne(Example<S> example) {
		return mangaCategoryRepository.findOne(example);
	}

	@Override
	public List<MangaCategory> findAll() {
		return mangaCategoryRepository.findAll();
	}

	@Override
	public Page<MangaCategory> findAll(Pageable pageable) {
		return mangaCategoryRepository.findAll(pageable);
	}

	@Override
	public List<MangaCategory> findAll(Sort sort) {
		return mangaCategoryRepository.findAll(sort);
	}

	@Override
	public List<MangaCategory> findAllById(Iterable<Long> ids) {
		return mangaCategoryRepository.findAllById(ids);
	}

	@Override
	public Optional<MangaCategory> findById(Long id) {
		return mangaCategoryRepository.findById(id);
	}

	@Override
	public <S extends MangaCategory> List<S> saveAll(Iterable<S> entities) {
		return mangaCategoryRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		mangaCategoryRepository.flush();
	}

	@Override
	public <S extends MangaCategory> S saveAndFlush(S entity) {
		return mangaCategoryRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return mangaCategoryRepository.existsById(id);
	}

	@Override
	public <S extends MangaCategory> List<S> saveAllAndFlush(Iterable<S> entities) {
		return mangaCategoryRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends MangaCategory> Page<S> findAll(Example<S> example, Pageable pageable) {
		return mangaCategoryRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<MangaCategory> entities) {
		mangaCategoryRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends MangaCategory> long count(Example<S> example) {
		return mangaCategoryRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<MangaCategory> entities) {
		mangaCategoryRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return mangaCategoryRepository.count();
	}

	@Override
	public <S extends MangaCategory> boolean exists(Example<S> example) {
		return mangaCategoryRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		mangaCategoryRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		mangaCategoryRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(MangaCategory entity) {
		mangaCategoryRepository.delete(entity);
	}

	@Override
	public <S extends MangaCategory, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return mangaCategoryRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		mangaCategoryRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		mangaCategoryRepository.deleteAllInBatch();
	}

	@Override
	public MangaCategory getOne(Long id) {
		return mangaCategoryRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends MangaCategory> entities) {
		mangaCategoryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mangaCategoryRepository.deleteAll();
	}

	@Override
	public MangaCategory getById(Long id) {
		return mangaCategoryRepository.getById(id);
	}

	@Override
	public <S extends MangaCategory> List<S> findAll(Example<S> example) {
		return mangaCategoryRepository.findAll(example);
	}

	@Override
	public <S extends MangaCategory> List<S> findAll(Example<S> example, Sort sort) {
		return mangaCategoryRepository.findAll(example, sort);
	}
	
}
