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

import com.pro.manga.domain.Favourite;
import com.pro.manga.repository.FavouriteRepository;
import com.pro.manga.service.FavouriteService;

@Service
public class FavouriteServiceImpl implements FavouriteService{
	@Autowired
	FavouriteRepository favouriteRepository;

	@Override
	public <S extends Favourite> S save(S entity) {
		return favouriteRepository.save(entity);
	}

	@Override
	public <S extends Favourite> Optional<S> findOne(Example<S> example) {
		return favouriteRepository.findOne(example);
	}

	@Override
	public List<Favourite> findAllByUserId(Long userId) {
		return favouriteRepository.findAllByUserId(userId);
	}

	@Override
	public List<Favourite> findAll() {
		return favouriteRepository.findAll();
	}

	

	@Override
	public Favourite findByMangaIdAndUserId(Long mangaId, Long userId) {
		return favouriteRepository.findByMangaIdAndUserId(mangaId, userId);
	}

	@Override
	public Page<Favourite> findAll(Pageable pageable) {
		return favouriteRepository.findAll(pageable);
	}

	@Override
	public List<Favourite> findAll(Sort sort) {
		return favouriteRepository.findAll(sort);
	}

	@Override
	public List<Favourite> findAllById(Iterable<Long> ids) {
		return favouriteRepository.findAllById(ids);
	}

	@Override
	public Optional<Favourite> findById(Long id) {
		return favouriteRepository.findById(id);
	}

	@Override
	public <S extends Favourite> List<S> saveAll(Iterable<S> entities) {
		return favouriteRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		favouriteRepository.flush();
	}

	@Override
	public <S extends Favourite> S saveAndFlush(S entity) {
		return favouriteRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return favouriteRepository.existsById(id);
	}

	@Override
	public <S extends Favourite> List<S> saveAllAndFlush(Iterable<S> entities) {
		return favouriteRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Favourite> Page<S> findAll(Example<S> example, Pageable pageable) {
		return favouriteRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Favourite> entities) {
		favouriteRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Favourite> long count(Example<S> example) {
		return favouriteRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Favourite> entities) {
		favouriteRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return favouriteRepository.count();
	}

	@Override
	public <S extends Favourite> boolean exists(Example<S> example) {
		return favouriteRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		favouriteRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		favouriteRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Favourite entity) {
		favouriteRepository.delete(entity);
	}

	@Override
	public <S extends Favourite, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return favouriteRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		favouriteRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		favouriteRepository.deleteAllInBatch();
	}

	@Override
	public Favourite getOne(Long id) {
		return favouriteRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Favourite> entities) {
		favouriteRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		favouriteRepository.deleteAll();
	}

	@Override
	public Favourite getById(Long id) {
		return favouriteRepository.getById(id);
	}

	@Override
	public <S extends Favourite> List<S> findAll(Example<S> example) {
		return favouriteRepository.findAll(example);
	}

	@Override
	public <S extends Favourite> List<S> findAll(Example<S> example, Sort sort) {
		return favouriteRepository.findAll(example, sort);
	}
	
}
