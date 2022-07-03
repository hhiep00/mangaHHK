package com.pro.manga.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaDto implements Serializable{
	private Long mangaId;
	private String name;
	private String image;
	private MultipartFile imageFile;
	
	private String authur;
	private int numberOfChapters;
	private String status;
	private String description;
	private int likes;
	
	private Boolean isEdit=false;
}
