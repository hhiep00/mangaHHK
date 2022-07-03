package com.pro.manga.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDto implements Serializable{
	private int chapterId;
	private int chapterNumber;
	private int numberOfPages;
	private int mangaId;
}
