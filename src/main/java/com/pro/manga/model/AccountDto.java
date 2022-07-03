package com.pro.manga.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable{
	private int userId;
	@NotEmpty
	@Length(min = 6)
	private String username;
	@NotEmpty
	@Length(min = 6)
	private String password;
	private Boolean isAdmin;
}
