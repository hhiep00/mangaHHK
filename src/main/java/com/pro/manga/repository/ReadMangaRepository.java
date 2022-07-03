package com.pro.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Read;

@Repository
public interface ReadMangaRepository  extends JpaRepository<Read, Long>{
	@Query("Select r from Read r where r.user.userId=:cid")
	List<Read> findAllByUserId(@Param("cid") Long userId);
}
