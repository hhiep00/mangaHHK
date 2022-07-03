package com.pro.manga.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.pro.manga.domain.Favourite;

public interface FavouriteService {

	<S extends Favourite> List<S> findAll(Example<S> example, Sort sort);

	<S extends Favourite> List<S> findAll(Example<S> example);

	Favourite getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Favourite> entities);

	Favourite getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Favourite, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Favourite entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Favourite> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Favourite> entities);

	<S extends Favourite> long count(Example<S> example);

	void deleteInBatch(Iterable<Favourite> entities);

	<S extends Favourite> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Favourite> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Favourite> S saveAndFlush(S entity);

	void flush();

	<S extends Favourite> List<S> saveAll(Iterable<S> entities);

	Optional<Favourite> findById(Long id);

	List<Favourite> findAllById(Iterable<Long> ids);

	List<Favourite> findAll(Sort sort);

	Page<Favourite> findAll(Pageable pageable);

	List<Favourite> findAll();

	<S extends Favourite> Optional<S> findOne(Example<S> example);

	<S extends Favourite> S save(S entity);

	List<Favourite> findAllByUserId(Long userId);


	Favourite findByMangaIdAndUserId(Long mangaId, Long userId);

}
