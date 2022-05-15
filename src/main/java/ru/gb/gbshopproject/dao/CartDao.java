package ru.gb.gbshopproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbshopproject.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
    Cart save(Cart cart);

}
