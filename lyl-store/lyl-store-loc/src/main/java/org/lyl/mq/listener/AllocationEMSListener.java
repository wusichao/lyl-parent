package org.lyl.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lyl.model.GoodsOrder;
import org.lyl.model.LocGoodsOrder;
import org.lyl.provider.LocProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 发送快递需求队列
 * 
 * @author ShenHuaJie
 * @version 2016年6月14日 上午11:00:53
 */
@Component
public class AllocationEMSListener implements MessageListener {
	private final Logger logger = LogManager.getLogger();
	@Autowired
	private LocProviderImpl locProviderImpl;
	@Transactional
	public void onMessage(Message message) {
		try {
			GoodsOrder goodsOrder =(GoodsOrder) ((ObjectMessage) message).getObject();
			logger.info("为订单号：" + goodsOrder.getId()+"分配快递");
			LocGoodsOrder m = new LocGoodsOrder();
			m.setName("顺丰");
			m.setOrderId(goodsOrder.getId());
			locProviderImpl.add(m);
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
