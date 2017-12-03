package edu.nuaa.factory;


import edu.nuaa.dao.XuYangDao.IAnReDao;
import edu.nuaa.dao.XuYangDao.IUserDao;
import edu.nuaa.dao.ZhouShiQiDao.IAlgorithmModelDao;
import edu.nuaa.dao.ZhouShiQiDao.IAppInfoDao;
import edu.nuaa.dao.ZongZheDao.IExcelDao;

import edu.nuaa.proxy.XuYangProxy.IAnReDaoProxy;
import edu.nuaa.proxy.XuYangProxy.IUserDaoProxy;
import edu.nuaa.proxy.ZhouShiQiProxy.AlgorithmModelDaoProxy;
import edu.nuaa.proxy.ZhouShiQiProxy.AppInfoDaoProxy;
import edu.nuaa.proxy.ZongZheProxy.ExcelDaoProxy;

public class DaoFactory {

	public static IUserDao getUserDaoInstance()throws Exception{
		return new IUserDaoProxy();
	}


	public static IAnReDao getAnReDaoInstance() throws Exception{
		return new IAnReDaoProxy();
	}

	public static IExcelDao getExcelDaoInstance() throws Exception{
		return new ExcelDaoProxy();
	}

	public static IAppInfoDao getAppInfoDaoInstance() throws Exception{
		return new AppInfoDaoProxy();
	}

	public static IAlgorithmModelDao getAlgorithmModelDaoInstance() throws Exception{
		return new AlgorithmModelDaoProxy();
	}
}
