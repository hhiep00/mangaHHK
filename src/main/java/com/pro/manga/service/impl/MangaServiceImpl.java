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
import com.pro.manga.repository.MangaRepository;
import com.pro.manga.service.MangaService;

@Service
public class MangaServiceImpl implements MangaService{
	@Autowired
	private MangaRepository mangaRepository;

	@Override
	public <S extends Manga> S save(S entity) {
		return mangaRepository.save(entity);
	}

	@Override
	public <S extends Manga> Optional<S> findOne(Example<S> example) {
		return mangaRepository.findOne(example);
	}

	@Override
	public List<Manga> findAll() {
		return mangaRepository.findAll();
	}

	@Override
	public Page<Manga> findAll(Pageable pageable) {
		return mangaRepository.findAll(pageable);
	}

	@Override
	public List<Manga> findAll(Sort sort) {
		return mangaRepository.findAll(sort);
	}

	@Override
	public List<Manga> findAllById(Iterable<Long> ids) {
		return mangaRepository.findAllById(ids);
	}

	@Override
	public Optional<Manga> findById(Long id) {
		return mangaRepository.findById(id);
	}

	@Override
	public <S extends Manga> List<S> saveAll(Iterable<S> entities) {
		return mangaRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		mangaRepository.flush();
	}

	@Override
	public <S extends Manga> S saveAndFlush(S entity) {
		return mangaRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return mangaRepository.existsById(id);
	}

	@Override
	public <S extends Manga> List<S> saveAllAndFlush(Iterable<S> entities) {
		return mangaRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Manga> Page<S> findAll(Example<S> example, Pageable pageable) {
		return mangaRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Manga> entities) {
		mangaRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Manga> long count(Example<S> example) {
		return mangaRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Manga> entities) {
		mangaRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return mangaRepository.count();
	}

	@Override
	public <S extends Manga> boolean exists(Example<S> example) {
		return mangaRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		mangaRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		mangaRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Manga entity) {
		mangaRepository.delete(entity);
	}

	@Override
	public <S extends Manga, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return mangaRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		mangaRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		mangaRepository.deleteAllInBatch();
	}

	@Override
	public Manga getOne(Long id) {
		return mangaRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Manga> entities) {
		mangaRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mangaRepository.deleteAll();
	}

	@Override
	public Manga getById(Long id) {
		return mangaRepository.getById(id);
	}

	@Override
	public <S extends Manga> List<S> findAll(Example<S> example) {
		return mangaRepository.findAll(example);
	}

	@Override
	public <S extends Manga> List<S> findAll(Example<S> example, Sort sort) {
		return mangaRepository.findAll(example, sort);
	}
	
	
}
