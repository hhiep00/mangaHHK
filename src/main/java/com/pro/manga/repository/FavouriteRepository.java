package com.pro.manga.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Chapter;
import com.pro.manga.domain.Favourite;
import com.pro.manga.domain.Read;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long>{
	@Query("Select r from Favourite r where r.user.userId=:cid")
	List<Favourite> findAllByUserId(@Param("cid") Long userId);
	
	@Query("select c from Favourite c where c.manga.mangaId=:mid and c.user.userId=:nid")
	Favourite findByMangaIdAndUserId(@Param("mid")Long mangaId, @Param("nid") Long userId);
}
