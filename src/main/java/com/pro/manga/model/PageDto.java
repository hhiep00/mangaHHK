package com.pro.manga.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto implements Serializable{
	private int pageId;
	private int numberPage;
	private MultipartFile content;
	private int chapterId;
}
