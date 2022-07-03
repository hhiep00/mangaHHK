package com.pro.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.PageManga;

@Repository
public interface PageRepository extends JpaRepository<PageManga, Long>{
	@Query("select p from PageManga p where p.chapter.chapterId=:cid")
	List<PageManga> findAllByChapterId(@Param("cid") Long chapterId);
}
