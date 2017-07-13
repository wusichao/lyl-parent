package org.lyl.provider;

import org.lyl.base.BaseProviderImpl;
import org.lyl.mappers.GoodsProviderMapper;
import org.lyl.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsProviderImpl extends BaseProviderImpl<Goods,GoodsProviderMapper> implements GoodsProviderApi{
	@Autowired
    public void setMapper(GoodsProviderMapper goodsProviderMapper) {
        this.mapper = goodsProviderMapper;
    }
}
