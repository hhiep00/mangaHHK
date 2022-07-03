package com.pro.manga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(length = 30, nullable = false)
	private String username;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(nullable = false)
	private Boolean sex;
	private String email;
	@Column(nullable = false)
	private Boolean isAdmin;
	
	@OneToMany( mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Favourite> favourites;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Read> reads;
}
