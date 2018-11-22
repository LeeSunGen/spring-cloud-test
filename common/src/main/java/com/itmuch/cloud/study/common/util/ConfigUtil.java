/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.itmuch.cloud.study.common.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件读取工具类
 *
 * @author wujing
 */
public final class ConfigUtil {

	private ConfigUtil() {

	}

	/**
	 * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
	 */
	private static final Properties properties = new Properties();

	// 通过类装载器装载进来
	static {
		try {
			// 从类路径下读取属性文件
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据key读取value
	 *
	 * @param keyName
	 *            key
	 * @return
	 */
	public static String getProperty(String keyName) {
		return getProperty(keyName, "");
	}

	/**
	 * 根据key读取value，key为空，返回默认值
	 *
	 * @param keyName
	 *            key
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static String getProperty(String keyName, String defaultValue) {
		return properties.getProperty(keyName, defaultValue).trim();
	}

	public static final String ALIYUN_DOMAIN = getProperty("aliyun.domain");
	public static final String ALIYUN_PREFIX = getProperty("aliyun.prefix");
	public static final String ALIYUN_END_POINT = getProperty("aliyun.end.point");
	public static final String ALIYUN_ACCESS_KEY_ID = getProperty("aliyun.access.key.id");
	public static final String ALIYUN_ACCESS_SECRET = getProperty("aliyun.access.key.secret");
	public static final String ALIYUN_BUCKET_NAME= getProperty("aliyun.bucket.name");


}
