package com.lsq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsq.common.exception.ActionException;
import com.lsq.model.Menu;
import com.lsq.service.MenuService;

@Controller
@RequestMapping("/system")
public class SystemController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/toMenuIndex")
	public String toMenuIndex() throws ActionException {
		return "sysadmin/menuadmin/menuIndex";
	}
	
	@RequestMapping("/getMenuJson")
	public String getMenuJson(ModelMap mm) throws ActionException{
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		List list = menuService.queryAll(" from Menu order by menuOrder");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> mp = new HashMap<String, Object>();
			Menu menu = (Menu) list.get(i);
			if ("0".equals(menu.getMenuLevel())) {
				mp.put("pId", null);
			} else {
				mp.put("pId", menu.getParentMenu().getMenuId());
			}
			mp.put("name", menu.getMenuName());
			mp.put("id", menu.getMenuId());
			mp.put("menuUrl", menu.getMenuUrl());
			mp.put("menuOrder", menu.getMenuOrder());
			listMap.add(mp);
		}
		mm.addAttribute("jsonData",listMap);
		return "listJson";
	}
	@RequestMapping("/addMenu")
	public String addMenu(Menu menu,String parentMenuId,ModelMap mm)throws ActionException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isNotBlank(parentMenuId)) {
				Menu parentMenu = (Menu) menuService.queryOne(Menu.class,
						parentMenuId);
				menu.setMenuLevel(String.valueOf(Integer.valueOf(parentMenu
						.getMenuLevel()) + 1));
				menu.setParentMenu(parentMenu);
				menuService.editSave(menu);
				map.put("success", true);
				map.put("menuId", menu.getMenuId());
				map.put("message", "新增菜单成功！");
			} else {
				map.put("success", false);
				map.put("message", "请选择菜单！");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		} finally {
			mm.addAttribute("jsonData", map);
		}
		return "listJson";
	}
	
	/**
	 * 修改菜单
	 * @return
	 * @throws ActionException
	 */
	@RequestMapping("/modifyMenu")
	public String modifyMenu(Menu menu,ModelMap mm) throws ActionException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isNotBlank(menu.getMenuId())) {
				Menu oldMenu = (Menu) menuService.queryOne(Menu.class, menu
						.getMenuId());
				oldMenu.setMenuOrder(menu.getMenuOrder());
				oldMenu.setMenuName(menu.getMenuName());
				oldMenu.setMenuUrl(menu.getMenuUrl());
				menuService.editUpdate(oldMenu);
				map.put("success", true);
				map.put("message", "修改菜单成功！");
			} else {
				map.put("success", false);
				map.put("message", "请选择菜单！");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		} finally {
			mm.addAttribute("jsonData", map);
		}
		return "listJson";
	}
	
	/**
	 * 删除菜单
	 * @return
	 * @throws ActionException
	 */
	@RequestMapping("/deleteMenu")
	public String deleteMenu(Menu menu,ModelMap mm) throws ActionException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isNotBlank(menu.getMenuId())) {
				Menu deleteMenu = (Menu) menuService.queryOne(Menu.class, menu
						.getMenuId());
				menuService.delete(deleteMenu);
				map.put("success", true);
				map.put("message", "删除菜单成功！");
			} else {
				map.put("success", false);
				map.put("message", "请选择菜单！");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		} finally {
			mm.addAttribute("jsonData", map);
		}
		return "listJson";
	}
}
