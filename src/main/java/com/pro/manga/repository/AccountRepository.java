package com.pro.manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Account;
import com.pro.manga.domain.User;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Optional<Account> findByUsername(String username);
}
