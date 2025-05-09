package com.fatiharge.resource;


import com.fatiharge.domain.Categories;
import com.fatiharge.domain.Menu;
import com.fatiharge.exception.NoDailyMenuException;
import com.fatiharge.service.MenuService;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)
@Authenticated
public class MenuResource {

    @Inject
    MenuService menuService;

    @GET
    @Path("/categories")
    public List<Categories> getAllCategories() {
        return menuService.getAllCategories( );
    }

    @GET
    @Path("/menus")
    public List<Menu> getMenus(
            @QueryParam("categoryId")
            Long categoryId
    ) {
        return menuService.getMenusByCategory(categoryId);
    }

    @GET
    @Path("/daily")
    public List<Menu> getDailyMenu() {
        List<Menu> dailyMenus = menuService.getDailyMenus( );
        if (dailyMenus.isEmpty( )) {
            throw new NoDailyMenuException( );
        }
        return dailyMenus;
    }
}

