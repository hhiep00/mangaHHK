package com.pro.manga.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesDto implements Serializable{
	private int favouritesId;
	private int userId;
	private int mangaId;
}
