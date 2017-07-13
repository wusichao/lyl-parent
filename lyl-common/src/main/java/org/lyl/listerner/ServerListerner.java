package org.lyl.listerner;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




public class ServerListerner implements ServletContextListener {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	public void contextDestroyed(ServletContextEvent contextEvent) {
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		logger.info("=================================");
		logger.info(contextEvent.getServletContext().getServletContextName()+"系统启动完成!!!");
		logger.info("=================================");
	}
}