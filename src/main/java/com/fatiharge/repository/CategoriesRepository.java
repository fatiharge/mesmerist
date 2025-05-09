package com.fatiharge.repository;

import com.fatiharge.domain.Categories;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriesRepository implements PanacheRepository<Categories> {

}

