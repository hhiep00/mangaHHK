package com.pro.manga.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mangas")
public class Manga implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mangaId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(length=200)
	private String image;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String authur;
	@Column(nullable = false)
	private int numberOfChapters;
	@Column(nullable = false)
	private String status;
	@Column(columnDefinition = "nvarchar(500) not null")
	private String description;
	@Column(nullable = false)
	private int likes;
	
	@OneToMany(mappedBy = "manga", cascade = CascadeType.ALL)
	private Set<MangaCategory> mangaCategories;
	
	@OneToMany(mappedBy = "manga", cascade =CascadeType.ALL)
	private Set<Chapter> chapters;
	
	@OneToMany(mappedBy = "manga", cascade = CascadeType.ALL)
	private Set<Favourite> favourites;
}
