package com.fatiharge.repository;

import com.fatiharge.domain.Menu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {

    public List<Menu> findByCategory(Long categoryId) {
        return list("category_id", categoryId);
    }
}

