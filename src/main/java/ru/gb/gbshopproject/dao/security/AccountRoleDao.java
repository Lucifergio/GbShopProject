package ru.gb.gbshopproject.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbshopproject.entity.security.AccountRole;

public interface AccountRoleDao extends JpaRepository<AccountRole, Long> {
}
