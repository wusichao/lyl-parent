package org.lyl.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lyl.Constants;
import org.lyl.model.GoodsOrder;
import org.lyl.util.JedisUtil;
import org.springframework.stereotype.Component;
@Component
public class CountSignListener implements MessageListener {
	private final Logger logger = LogManager.getLogger();
	@Override
	public void onMessage(Message message) {
		try {
			GoodsOrder goodsOrder = (GoodsOrder) ((ObjectMessage) message).getObject();
			String useId=goodsOrder.getUserId().toString();
			String goodsId=goodsOrder.getGoodsId().toString();
			if(JedisUtil.exists(Constants.LOC_COUNTSIGN_USER_NAMESPACE+useId)){
				JedisUtil.incr(Constants.LOC_COUNTSIGN_USER_NAMESPACE+useId);
			}else{
				JedisUtil.set(Constants.LOC_COUNTSIGN_USER_NAMESPACE+useId,Constants.NO_EXPIRE, 1);
			}
			if(JedisUtil.exists(Constants.LOC_COUNTSIGN_GOODS_NAMESPACE+goodsId)){
				JedisUtil.incr(Constants.LOC_COUNTSIGN_GOODS_NAMESPACE+goodsId);
			}else{
				JedisUtil.set(Constants.LOC_COUNTSIGN_GOODS_NAMESPACE+goodsId,Constants.NO_EXPIRE, 1);
			}
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
		
		
	}

}
