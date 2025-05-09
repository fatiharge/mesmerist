package com.fatiharge.product.repository;

import com.fatiharge.product.domain.Menu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {

    public List<Menu> findByCategory(Long categoryId) {
        return list("category_id", categoryId);
    }
}

