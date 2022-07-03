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

public interface MangaService {

	<S extends Manga> List<S> findAll(Example<S> example, Sort sort);

	<S extends Manga> List<S> findAll(Example<S> example);

	Manga getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Manga> entities);

	Manga getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Manga, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Manga entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Manga> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Manga> entities);

	<S extends Manga> long count(Example<S> example);

	void deleteInBatch(Iterable<Manga> entities);

	<S extends Manga> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Manga> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Manga> S saveAndFlush(S entity);

	void flush();

	<S extends Manga> List<S> saveAll(Iterable<S> entities);

	Optional<Manga> findById(Long id);

	List<Manga> findAllById(Iterable<Long> ids);

	List<Manga> findAll(Sort sort);

	Page<Manga> findAll(Pageable pageable);

	List<Manga> findAll();

	<S extends Manga> Optional<S> findOne(Example<S> example);

	<S extends Manga> S save(S entity);

}
