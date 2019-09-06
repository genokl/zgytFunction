package cn.zgyt.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse帮助类
 */
public final class ResponseUtils {
	
	

	/**
	 * 发送json。使用UTF-8编码。
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}


	/**
	 * 发送内容。使用UTF-8编码。
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType,
			String text) {
//		System.out.println(text);
//		text.put("uid", LoginUtil.createUUid());
		response.setContentType(contentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void render1(HttpServletResponse response, String contentType,
			String text) {
//		System.out.println(text);
//		text.put("uid", LoginUtil.createUUid());
		response.setContentType(contentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

