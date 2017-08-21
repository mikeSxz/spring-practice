package com.udemy.backendninja.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.CheckPointOneService;

@Service("checkPointOneService")
public class CheckPointOneServiceImpl implements CheckPointOneService{
	private static final Log LOG = LogFactory.getLog(CheckPointOneServiceImpl.class);

	@Override
	public void printLog() {
		LOG.info("punto 2: Crea un servicio de un solo metodo que muestre un mensaje en el log con Apache commons");
		// TODO Auto-generated method stub
		
	}
	
	

}
