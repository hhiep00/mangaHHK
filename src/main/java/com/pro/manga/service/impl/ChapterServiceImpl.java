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

import com.pro.manga.domain.Chapter;
import com.pro.manga.domain.Manga;
import com.pro.manga.repository.ChapterRepository;
import com.pro.manga.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService{

	@Autowired
	ChapterRepository chapterRepository;

	

	@Override
	public Optional<Chapter> findChapterByMangaIdandNumbrChapter(Long mangaId, int chapterNumber) {
		return chapterRepository.findChapterByMangaIdandNumbrChapter(mangaId, chapterNumber);
	}

	@Override
	public List<Chapter> findChapterByMangaId(Long mangaId) {
		return chapterRepository.findChapterByMangaId(mangaId);
	}

	@Override
	public <S extends Chapter> S save(S entity) {
		return chapterRepository.save(entity);
	}

	@Override
	public <S extends Chapter> Optional<S> findOne(Example<S> example) {
		return chapterRepository.findOne(example);
	}

	@Override
	public List<Chapter> findAll() {
		return chapterRepository.findAll();
	}

	@Override
	public Page<Chapter> findAll(Pageable pageable) {
		return chapterRepository.findAll(pageable);
	}

	@Override
	public List<Chapter> findAll(Sort sort) {
		return chapterRepository.findAll(sort);
	}

	@Override
	public List<Chapter> findAllById(Iterable<Long> ids) {
		return chapterRepository.findAllById(ids);
	}

	@Override
	public Optional<Chapter> findById(Long id) {
		return chapterRepository.findById(id);
	}

	@Override
	public <S extends Chapter> List<S> saveAll(Iterable<S> entities) {
		return chapterRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		chapterRepository.flush();
	}

	@Override
	public <S extends Chapter> S saveAndFlush(S entity) {
		return chapterRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return chapterRepository.existsById(id);
	}

	@Override
	public <S extends Chapter> List<S> saveAllAndFlush(Iterable<S> entities) {
		return chapterRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Chapter> Page<S> findAll(Example<S> example, Pageable pageable) {
		return chapterRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Chapter> entities) {
		chapterRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Chapter> long count(Example<S> example) {
		return chapterRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Chapter> entities) {
		chapterRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return chapterRepository.count();
	}

	@Override
	public <S extends Chapter> boolean exists(Example<S> example) {
		return chapterRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		chapterRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		chapterRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Chapter entity) {
		chapterRepository.delete(entity);
	}

	@Override
	public <S extends Chapter, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return chapterRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		chapterRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		chapterRepository.deleteAllInBatch();
	}

	@Override
	public Chapter getOne(Long id) {
		return chapterRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Chapter> entities) {
		chapterRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		chapterRepository.deleteAll();
	}

	@Override
	public Chapter getById(Long id) {
		return chapterRepository.getById(id);
	}

	@Override
	public <S extends Chapter> List<S> findAll(Example<S> example) {
		return chapterRepository.findAll(example);
	}

	@Override
	public <S extends Chapter> List<S> findAll(Example<S> example, Sort sort) {
		return chapterRepository.findAll(example, sort);
	}
	
}
