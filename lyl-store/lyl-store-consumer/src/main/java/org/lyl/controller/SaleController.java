package org.lyl.controller;

import javax.servlet.http.HttpServletRequest;

import org.lyl.base.BaseController;
import org.lyl.model.GoodsOrder;
import org.lyl.service.SaleService;
import org.lyl.support.HttpCode;
import org.lyl.util.Request2ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/sale")
public class SaleController extends BaseController{
	@Autowired
	private SaleService saleService;
	
	@RequestMapping("/addOrder")
	public Object addOrder(ModelMap modelMap,@RequestParam(required=true)Long userId,
			@RequestParam(required=true)Long goodsId,@RequestParam(required=true)Long price,
			HttpServletRequest request){
		GoodsOrder goodsOrder = Request2ModelUtil.covert(GoodsOrder.class, request);
		saleService.addOrder(goodsOrder);
		return setSuccessModelMap(modelMap,HttpCode.OK);
	}
	
	@RequestMapping("/payOrder")
	public Object payOrder(ModelMap modelMap,@RequestParam(required=true)Long id){
		saleService.payOrder(id);
		return setSuccessModelMap(modelMap);
	}
	
}
