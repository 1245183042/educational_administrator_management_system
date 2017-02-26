package com.edu.util;

/**
 * 返回类所在的目录
 * 
 * @author CJP
 * 
 */
public class ClassUtil {

	/**
	 * 返回Class文件所在的目录
	 * 
	 * @param c
	 * @return
	 */
	public static String getClassPath(Class<?> c) {
		return c.getResource("").getPath().replaceAll("%20", " ");
	}

	/**
	 * 返回Class文件所在的根目录
	 * 
	 * @param c
	 * @return
	 */
	public static String getClassRootPath(Class<?> c) {
		return c.getResource("/").getPath().replaceAll("%20", " ");
	}
}
