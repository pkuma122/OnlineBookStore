package com.jlc.book.shop.listener;

import javax.servlet.*;
import org.apache.log4j.*;

public class JlcindiaContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent ctxEvent) {
	ServletContext ctx=ctxEvent.getServletContext();
	String path=ctx.getRealPath("/")+"logs\\";
	System.setProperty("jlcindia.root.path", path);
	String str=ctx.getRealPath("WEB-INF/classes/com/jlc/jlc-log4j.properties");
	PropertyConfigurator.configure(str);
	Logger log=Logger.getLogger(this.getClass());
	log.info("Properties file:"+str);
	}
	public void contextDestroyed(ServletContextEvent ctxEvent) {
	 	
	}
}
