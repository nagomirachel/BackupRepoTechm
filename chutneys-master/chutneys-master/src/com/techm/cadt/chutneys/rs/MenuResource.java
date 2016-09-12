package com.techm.cadt.chutneys.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.techm.cadt.chutneys.bo.Menu;
import com.techm.cadt.chutneys.bo.MenuItem;
import com.techm.cadt.chutneys.db.ChutneysDAO;

/**
 * REST Web Service
 *
 * @author SK69016
 */
@Path("/")
public class MenuResource {

	ChutneysDAO dao = new ChutneysDAO();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MenuResource
     */
    public MenuResource() {
    }

    /**
     * Retrieves representation of an instance of com.techm.cadt.pizzahut.rs.MenuResource
     * @return com.techm.cadt.pizzahut.model.Menu
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("menu")
    public List<Menu> getMenu() {
    	List<Menu> menuList = dao.loadMenu();
        return menuList;
    }


    /**
     * Retrieves representation of an instance of com.techm.cadt.pizzahut.rs.MenuResource
     * @param size String as size
     * @param isVeg True or false
     * @param cost String as cost
     * @return com.techm.cadt.pizzahut.model.Menu
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("query")
    public List<MenuItem> queryMenu(
            @QueryParam("item")String itemName,
            @QueryParam("cost")int cost) {
    	List<MenuItem> menuList = dao.filterMenu(itemName,cost);
        return menuList;
    }

    /**
     * PUT method for updating or creating an instance of MenuResource
     * @param item MenuItem
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void orderItem(MenuItem item) {
        System.out.println(item.getItemName());
        //PizzaDAO dao = new PizzaDAO();
        dao.saveOrder(item);
    }
}
