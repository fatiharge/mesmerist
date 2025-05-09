package com.fatiharge.product.repository;

import com.fatiharge.product.domain.Categories;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriesRepository implements PanacheRepository<Categories> {

}

