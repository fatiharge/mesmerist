package com.fatiharge.product.resource;


import com.fatiharge.product.domain.Categories;
import com.fatiharge.product.domain.Menu;
import com.fatiharge.product.service.MenuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class MenuResource {

    @Inject
    MenuService menuService;

    @GET
    @Path("/categories")
    public List<Categories> getCategories() {
        return menuService.getAllCategories();
    }

    @GET
    @Path("/menus")
    public List<Menu> getMenus(@QueryParam("category") Long categoryId) {
        return menuService.getMenusByCategory(categoryId);
    }
}

