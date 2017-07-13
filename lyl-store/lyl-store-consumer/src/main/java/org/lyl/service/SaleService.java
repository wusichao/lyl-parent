package org.lyl.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lyl.base.BaseService;
import org.lyl.model.GoodsOrder;
import org.lyl.provider.SaleProviderApi;
import org.lyl.support.mq.QueueSender;
import org.lyl.support.mq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SaleService extends BaseService<SaleProviderApi, GoodsOrder>{
	private final Logger logger = LogManager.getLogger();
	@Autowired
    public void setProvider(SaleProviderApi provider) {
        this.provider = provider;
    }
	@Autowired
	private QueueSender queueSender;
	@Autowired
	private TopicSender topicSender;
	
	public void addOrder(GoodsOrder goodsOrder) {
		Assert.notNull(goodsOrder);
		goodsOrder.setCreateDate(new Date());
		goodsOrder.setState(0);
		provider.add(goodsOrder);
	}
	
	public void payOrder(Long id) {
		GoodsOrder goodsOrder=this.selectById(id);
		provider.update(goodsOrder); //1.更改订单状态
		queueSender.send("lyl.stroe.goods.payOrder.loc", goodsOrder);//3.分配物流配送
		topicSender.send("lyl.stroe.goods.payOrder", goodsOrder); //发布订阅消息,处理次要任务
		logger.info("支付订单:"+id);
	}
	
}
