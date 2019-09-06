package cn.zgyt.util;

import org.springframework.stereotype.Component;

@Component
public class PortalConfig {

	
	
	public static String PICPath;
	public static String PICRealPath;
	
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
	
	
	
	

}
