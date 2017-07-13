package org.lyl.provider;

import java.util.List;
import java.util.Map;

import org.lyl.base.BaseApi;
import org.lyl.model.GoodsOrder;

public interface SaleProviderApi extends BaseApi<GoodsOrder>{
	public void add(GoodsOrder order);
	
	public List<GoodsOrder> select(Map<String, Object> params);

	public void update(GoodsOrder order);
}
