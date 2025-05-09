package com.fatiharge.product.service;

import com.fatiharge.product.domain.Categories;
import com.fatiharge.product.domain.Menu;
import com.fatiharge.product.repository.CategoriesRepository;
import com.fatiharge.product.repository.MenuRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Random;

@ApplicationScoped
public class MenuService {

    @Inject
    CategoriesRepository categoriesRepository;

    @Inject
    MenuRepository menuRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.listAll();
    }

    public List<Menu> getMenusByCategory(Long categoryId) {
        if (categoryId != null) {
            return menuRepository.findByCategory(categoryId);
        }
        return menuRepository.listAll();
    }

    @Transactional
    @Scheduled(cron = "0 0 2 * * ?") // Her gün saat 02:00'de çalışır
    public void generateDailyMenu() {
        List<Menu> allMenus = menuRepository.listAll();
        allMenus.forEach(menu -> menu.daily = false);
        menuRepository.persist(allMenus);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Menu selectedMenu = allMenus.get(random.nextInt(allMenus.size()));
            selectedMenu.daily = true;
        }

        menuRepository.persist(allMenus);
    }

    public List<Menu> getDailyMenus() {
        return menuRepository.find("daily = ?1", true).list();
    }
}

