package cn.zgyt.util;

import org.springframework.stereotype.Component;

@Component
public class Config {
	
	public static String PICPath;
	public static String PICRealPath;
	public static String PICUrlHeader;
	
	public static String FILEPath;
	public static String FILERealPath;
	public static String FILEUrlHeader;
	
	
	
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
	public static String getFILEPath() {
		return FILEPath;
	}
	public static void setFILEPath(String fILEPath) {
		FILEPath = fILEPath;
	}
	public static String getFILERealPath() {
		return FILERealPath;
	}
	public static void setFILERealPath(String fILERealPath) {
		FILERealPath = fILERealPath;
	}
	public static String getFILEUrlHeader() {
		return FILEUrlHeader;
	}
	public static void setFILEUrlHeader(String fILEUrlHeader) {
		FILEUrlHeader = fILEUrlHeader;
	}
	

}
