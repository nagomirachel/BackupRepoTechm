/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.chutneys.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.techm.cadt.chutneys.bo.Menu;
import com.techm.cadt.chutneys.bo.MenuItem;
import com.techm.cadt.chutneys.db.addons.JPAEntityManager;

public class ChutneysDAO {
	
	
	public List<Menu> loadMenu(){
		JPAEntityManager<Menu> entityManager = new JPAEntityManager<Menu>();
    	List<Menu> menuList = entityManager.queryLast(new Menu(),"Menu", 10);
    	return menuList;
	}
	
	public List<Menu> loadEntireMenu(){	
		JPAEntityManager<Menu> entityManager = new JPAEntityManager<Menu>();
    	List<Menu> menuList = (List<Menu>)entityManager.query("SELECT t FROM Menu t");
    	return menuList;
	}

	public List<MenuItem> filterMenu(String itemName, int cost) {
		JPAEntityManager<MenuItem> jpaEntityManager = new JPAEntityManager<MenuItem>();
		EntityManager entityManager = jpaEntityManager.getEntityManager();
		Query query = entityManager.createQuery("SELECT t FROM MenuItem t where t.itemName LIKE :itemName and t.cost <= :cost");
		query.setParameter("itemName", itemName);
		query.setParameter("cost", cost);
		List<MenuItem> list = (List<MenuItem>)query.getResultList();
    	entityManager.close();
		return list;
	}

	public void saveOrder(MenuItem item) {
		// TODO Auto-generated method stub		
	}
}
