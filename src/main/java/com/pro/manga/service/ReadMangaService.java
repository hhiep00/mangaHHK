package com.pro.manga.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.pro.manga.domain.Read;

public interface ReadMangaService {

	<S extends Read> List<S> findAll(Example<S> example, Sort sort);

	<S extends Read> List<S> findAll(Example<S> example);

	Read getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Read> entities);

	Read getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Read, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Read entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Read> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Read> entities);

	<S extends Read> long count(Example<S> example);

	void deleteInBatch(Iterable<Read> entities);

	<S extends Read> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Read> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Read> S saveAndFlush(S entity);

	void flush();

	<S extends Read> List<S> saveAll(Iterable<S> entities);

	Optional<Read> findById(Long id);

	List<Read> findAllById(Iterable<Long> ids);

	List<Read> findAll(Sort sort);

	Page<Read> findAll(Pageable pageable);

	List<Read> findAll();

	<S extends Read> Optional<S> findOne(Example<S> example);

	<S extends Read> S save(S entity);

	List<Read> findAllByUserId(Long userId);

}
