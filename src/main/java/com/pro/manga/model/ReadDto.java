package com.pro.manga.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadDto implements Serializable{
	private int readId;
	private int userId;
	private int chapterId;
}
