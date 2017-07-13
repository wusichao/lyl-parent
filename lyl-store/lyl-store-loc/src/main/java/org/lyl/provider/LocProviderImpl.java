package org.lyl.provider;

import org.lyl.base.BaseProviderImpl;
import org.lyl.mappers.LocProviderMapper;
import org.lyl.model.LocGoodsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LocProviderImpl extends BaseProviderImpl<LocGoodsOrder,LocProviderMapper>implements LocProviderApi{
	@Autowired
    public void setMapper(LocProviderMapper locProviderMapper) {
        this.mapper = locProviderMapper;
    }
}
