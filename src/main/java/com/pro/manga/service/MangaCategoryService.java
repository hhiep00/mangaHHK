package com.pro.manga.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.pro.manga.domain.Manga;
import com.pro.manga.domain.MangaCategory;

public interface MangaCategoryService {

	<S extends MangaCategory> List<S> findAll(Example<S> example, Sort sort);

	<S extends MangaCategory> List<S> findAll(Example<S> example);

	MangaCategory getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends MangaCategory> entities);

	MangaCategory getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends MangaCategory, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(MangaCategory entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends MangaCategory> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<MangaCategory> entities);

	<S extends MangaCategory> long count(Example<S> example);

	void deleteInBatch(Iterable<MangaCategory> entities);

	<S extends MangaCategory> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends MangaCategory> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends MangaCategory> S saveAndFlush(S entity);

	void flush();

	<S extends MangaCategory> List<S> saveAll(Iterable<S> entities);

	Optional<MangaCategory> findById(Long id);

	List<MangaCategory> findAllById(Iterable<Long> ids);

	List<MangaCategory> findAll(Sort sort);

	Page<MangaCategory> findAll(Pageable pageable);

	List<MangaCategory> findAll();

	<S extends MangaCategory> Optional<S> findOne(Example<S> example);

	<S extends MangaCategory> S save(S entity);

	List<MangaCategory> findByMangaId(Long mangaId);

	List<MangaCategory> findByCategoryId(Long categoryId);




	
}
