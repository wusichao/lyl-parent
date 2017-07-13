package org.lyl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.lyl.base.BaseController;
import org.lyl.model.Goods;
import org.lyl.service.GoodsService;
import org.lyl.support.HttpCode;
import org.lyl.util.Request2ModelUtil;
import org.lyl.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/addGoods")
	@RequiresPermissions("store:goods:select")
	public Object addGoods(ModelMap modelMap,@RequestParam(required=true)String name,@RequestParam(required=true)long price,HttpServletRequest request){
		Goods goods = Request2ModelUtil.covert(Goods.class, request);
		goodsService.add(goods);
		return setSuccessModelMap(modelMap,HttpCode.OK);
	}
	
	@RequestMapping("/getGoods")
	public Object getGoods(ModelMap modelMap,@RequestParam(required=false)String name,HttpServletRequest request){
		Map<String, Object> params = WebUtil.getParameterMap(request);	
		List<Goods> date = new ArrayList<Goods>();
		date=goodsService.select(params);
		return setSuccessModelMap(modelMap,date);
	}
	
	@RequestMapping("/deleteGoods")
	@RequiresPermissions("store:goods:select")
	public Object deleteGoods(ModelMap modelMap,long id){
		goodsService.delete(id);
		return setSuccessModelMap(modelMap, HttpCode.OK);
	}
	
	@RequestMapping("/updateGoods")
	@RequiresPermissions("store:goods:select")
	public Object updateGoods(ModelMap modelMap,@RequestParam(required=true)long id,@RequestParam(required=false)String name,@RequestParam(required=false)long price,HttpServletRequest request){
		Goods goods = Request2ModelUtil.covert(Goods.class, request);
		goodsService.update(goods);
		return setSuccessModelMap(modelMap, HttpCode.OK);
	}
}
