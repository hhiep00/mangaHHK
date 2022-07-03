package com.pro.manga.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaCategoryDto implements Serializable{
	private Long mangaCategoryId;
	private Long categoryId;
	private Long mangaId;
}
