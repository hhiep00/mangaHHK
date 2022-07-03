package com.pro.manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long>{

}
