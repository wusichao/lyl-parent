package org.lyl.provider;

import org.lyl.base.BaseProviderImpl;
import org.lyl.mappers.SaleProviderMapper;
import org.lyl.model.GoodsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SaleProviderImpl extends BaseProviderImpl<GoodsOrder,SaleProviderMapper> implements SaleProviderApi{
	@Autowired
    public void setMapper(SaleProviderMapper saleProviderMapper) {
        this.mapper = saleProviderMapper;
    }
}
