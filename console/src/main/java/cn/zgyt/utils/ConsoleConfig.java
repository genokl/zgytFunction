package cn.zgyt.utils;

import org.springframework.stereotype.Component;

@Component
public class ConsoleConfig {
	
	public static String tempPath;
	public static String tempRealPath;
	public static String tempHeader;
	
	public static String PICPath;
	public static String PICRealPath;
	public static String PICUrlHeader;
	
	
	public static String getPICUrlHeader() {
		return PICUrlHeader;
	}
	public static void setPICUrlHeader(String pICUrlHeader) {
		PICUrlHeader = pICUrlHeader;
	}
	public static String getPICPath() {
		return PICPath;
	}
	public static void setPICPath(String pICPath) {
		PICPath = pICPath;
	}
	public static String getPICRealPath() {
		return PICRealPath;
	}
	public static void setPICRealPath(String pICRealPath) {
		PICRealPath = pICRealPath;
	}
	public static String getTempPath() {
		return tempPath;
	}
	public static void setTempPath(String tempPath) {
		ConsoleConfig.tempPath = tempPath;
	}
	public static String getTempRealPath() {
		return tempRealPath;
	}
	public static void setTempRealPath(String tempRealPath) {
		ConsoleConfig.tempRealPath = tempRealPath;
	}
	public static String getTempHeader() {
		return tempHeader;
	}
	public static void setTempHeader(String tempHeader) {
		ConsoleConfig.tempHeader = tempHeader;
	}

}
