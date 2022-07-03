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

import com.pro.manga.domain.Read;
import com.pro.manga.repository.ReadMangaRepository;
import com.pro.manga.service.ReadMangaService;
@Service
public class ReadMangaImpl implements ReadMangaService{

		@Autowired
		ReadMangaRepository readMangaRepository;

		@Override
		public List<Read> findAllByUserId(Long userId) {
			return readMangaRepository.findAllByUserId(userId);
		}

		@Override
		public <S extends Read> S save(S entity) {
			return readMangaRepository.save(entity);
		}

		@Override
		public <S extends Read> Optional<S> findOne(Example<S> example) {
			return readMangaRepository.findOne(example);
		}

		@Override
		public List<Read> findAll() {
			return readMangaRepository.findAll();
		}

		@Override
		public Page<Read> findAll(Pageable pageable) {
			return readMangaRepository.findAll(pageable);
		}

		@Override
		public List<Read> findAll(Sort sort) {
			return readMangaRepository.findAll(sort);
		}

		@Override
		public List<Read> findAllById(Iterable<Long> ids) {
			return readMangaRepository.findAllById(ids);
		}

		@Override
		public Optional<Read> findById(Long id) {
			return readMangaRepository.findById(id);
		}

		@Override
		public <S extends Read> List<S> saveAll(Iterable<S> entities) {
			return readMangaRepository.saveAll(entities);
		}

		@Override
		public void flush() {
			readMangaRepository.flush();
		}

		@Override
		public <S extends Read> S saveAndFlush(S entity) {
			return readMangaRepository.saveAndFlush(entity);
		}

		@Override
		public boolean existsById(Long id) {
			return readMangaRepository.existsById(id);
		}

		@Override
		public <S extends Read> List<S> saveAllAndFlush(Iterable<S> entities) {
			return readMangaRepository.saveAllAndFlush(entities);
		}

		@Override
		public <S extends Read> Page<S> findAll(Example<S> example, Pageable pageable) {
			return readMangaRepository.findAll(example, pageable);
		}

		@Override
		public void deleteInBatch(Iterable<Read> entities) {
			readMangaRepository.deleteInBatch(entities);
		}

		@Override
		public <S extends Read> long count(Example<S> example) {
			return readMangaRepository.count(example);
		}

		@Override
		public void deleteAllInBatch(Iterable<Read> entities) {
			readMangaRepository.deleteAllInBatch(entities);
		}

		@Override
		public long count() {
			return readMangaRepository.count();
		}

		@Override
		public <S extends Read> boolean exists(Example<S> example) {
			return readMangaRepository.exists(example);
		}

		@Override
		public void deleteById(Long id) {
			readMangaRepository.deleteById(id);
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			readMangaRepository.deleteAllByIdInBatch(ids);
		}

		@Override
		public void delete(Read entity) {
			readMangaRepository.delete(entity);
		}

		@Override
		public <S extends Read, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			return readMangaRepository.findBy(example, queryFunction);
		}

		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			readMangaRepository.deleteAllById(ids);
		}

		@Override
		public void deleteAllInBatch() {
			readMangaRepository.deleteAllInBatch();
		}

		@Override
		public Read getOne(Long id) {
			return readMangaRepository.getOne(id);
		}

		@Override
		public void deleteAll(Iterable<? extends Read> entities) {
			readMangaRepository.deleteAll(entities);
		}

		@Override
		public void deleteAll() {
			readMangaRepository.deleteAll();
		}

		@Override
		public Read getById(Long id) {
			return readMangaRepository.getById(id);
		}

		@Override
		public <S extends Read> List<S> findAll(Example<S> example) {
			return readMangaRepository.findAll(example);
		}

		@Override
		public <S extends Read> List<S> findAll(Example<S> example, Sort sort) {
			return readMangaRepository.findAll(example, sort);
		}
		
}
