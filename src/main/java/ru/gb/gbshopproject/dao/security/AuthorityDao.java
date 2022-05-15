package ru.gb.gbshopproject.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbshopproject.entity.security.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Long> {
}
