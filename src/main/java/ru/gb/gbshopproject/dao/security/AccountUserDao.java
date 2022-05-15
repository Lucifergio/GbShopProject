package ru.gb.gbshopproject.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbshopproject.entity.security.AccountUser;

import java.util.Optional;

public interface AccountUserDao extends JpaRepository<AccountUser, Long> {
    Optional<AccountUser> findByUsername(String username);
}
