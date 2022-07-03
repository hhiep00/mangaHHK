package com.pro.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Manga;
import com.pro.manga.domain.MangaCategory;
@Repository
public interface MangaCategoryRepository extends JpaRepository<MangaCategory, Long>{
	@Query("SELECT mc FROM MangaCategory mc where mc.manga.mangaId=:cid")
	List<MangaCategory> findByMangaId(@Param("cid") Long mangaId);
	
	@Query("SELECT mc FROM MangaCategory mc where mc.category.categoryId=:cid")
	List<MangaCategory> findByCategoryId(@Param("cid") Long categoryId);
}
