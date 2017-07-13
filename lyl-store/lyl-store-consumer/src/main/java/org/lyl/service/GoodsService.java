package org.lyl.service;

import org.lyl.base.BaseService;
import org.lyl.model.Goods;
import org.lyl.provider.GoodsProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsService extends BaseService<GoodsProviderApi, Goods>{
	@Autowired
    public void setProvider(GoodsProviderApi provider) {
        this.provider = provider;
    }
}
