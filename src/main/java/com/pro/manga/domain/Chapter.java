package com.pro.manga.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="chapters")
public class Chapter implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chapterId;
	@Column(nullable = false)
	private int chapterNumber;
	@Column(nullable = false)
	private int numberOfPages;
	
	@ManyToOne
	@JoinColumn(name = "mangaID")
	private Manga manga;
	
	@OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
	private Set<PageManga> pages;
	
	@OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
	private Set<Read>  reads;
}
