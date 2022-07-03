package com.pro.manga.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.pro.manga.domain.PageManga;

public interface PageService {

	<S extends PageManga> List<S> findAll(Example<S> example, Sort sort);

	<S extends PageManga> List<S> findAll(Example<S> example);

	PageManga getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends PageManga> entities);

	PageManga getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends PageManga, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(PageManga entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends PageManga> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<PageManga> entities);

	<S extends PageManga> long count(Example<S> example);

	void deleteInBatch(Iterable<PageManga> entities);

	<S extends PageManga> org.springframework.data.domain.Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends PageManga> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends PageManga> S saveAndFlush(S entity);

	void flush();

	<S extends PageManga> List<S> saveAll(Iterable<S> entities);

	Optional<PageManga> findById(Long id);

	List<PageManga> findAllById(Iterable<Long> ids);

	List<PageManga> findAll(Sort sort);

	org.springframework.data.domain.Page<PageManga> findAll(Pageable pageable);

	List<PageManga> findAll();

	<S extends PageManga> Optional<S> findOne(Example<S> example);

	<S extends PageManga> S save(S entity);

	List<PageManga> findAllByChapterId(Long chapterId);

}
