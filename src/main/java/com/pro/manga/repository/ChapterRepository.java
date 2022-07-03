package com.pro.manga.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long>{
	@Query("select c from Chapter c where c.manga.mangaId=:mid and c.chapterNumber=:nid")
	Optional<Chapter> findChapterByMangaIdandNumbrChapter(@Param("mid")Long mangaId, @Param("nid") int chapterNumber);
	
	@Query("select c from Chapter c where c.manga.mangaId=:mid")
	List<Chapter> findChapterByMangaId(@Param("mid")Long mangaId);
}
