package cn.zgyt.util;

import org.springframework.stereotype.Component;

@Component
public class PortalConfig {

	
	
	public static String PICPath;
	public static String PICRealPath;
	public static String PICUrlHeader;
	
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
	public static String getPICUrlHeader() {
		return PICUrlHeader;
	}
	public static void setPICUrlHeader(String pICUrlHeader) {
		PICUrlHeader = pICUrlHeader;
	}
	
	
	
	

}
