package com.fatiharge.product.service;

import com.fatiharge.product.domain.Categories;
import com.fatiharge.product.domain.Menu;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/menu")
public class MenuResource {

    @Inject
    MenuService menuService;

    @GET
    @Path("/categories")
    public Response getAllCategories() {
        List<Categories> categories = menuService.getAllCategories();
        return Response.ok(categories).build();
    }

    @GET
    @Path("/menus")
    public Response getMenus(@QueryParam("categoryId") Long categoryId) {
        List<Menu> menus = menuService.getMenusByCategory(categoryId);
        return Response.ok(menus).build();
    }

    @GET
    @Path("/daily")
    public Response getDailyMenu() {
        List<Menu> dailyMenus = menuService.getDailyMenus();
        if (dailyMenus.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No daily menu found")
                    .build();
        }
        return Response.ok(dailyMenus).build();
    }
}

