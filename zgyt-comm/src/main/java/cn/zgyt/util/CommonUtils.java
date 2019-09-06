package cn.zgyt.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *  系统工具类
 * @author wxy
 *
 */
public class CommonUtils {
	
	
	
	public static SimpleDateFormat loadSimpleDateFormat(String str){
		return new SimpleDateFormat(str);
	}
	
	
	/**
	 * 解析 手机，邮箱，微信 等如此格式的字段。 
	 * @param 字段格式:"1：xxxx,0:xxxxx,3:xxxxx"
	 * @return 返回标识为0的  xxxxxx,yyyyy,zzz
	 */
	public static String splitField(String field){
		if(checkFull(field)){
			return null;
		}
		String[] fArray = field.split(",");
		String result = "";
		for (int i = 0; i < fArray.length; i++) {
			String[] s = fArray[i].split(":");
			if(null == s || s.length < 1){
				break;
			}
			if(null != s[0] && "0".equals(s[0])){
			  result += s[1]+",";
			}
		}
		if(!checkFull(result) && result.length()-1 == result.lastIndexOf(",")){
			result = result.substring(0,result.lastIndexOf(","));
		}
		return result;
	}
	
	
	/**
	 *  将一个字符串通过分割符分割成int类型数组
	 * @param str  字符串
	 * @param seprator  分隔符
	 * @return
	 */
	public static int[] stringToIntArray(String str,String seprator){
		 if(checkFull(str) || checkFull(seprator)){
			 return null;
		 }
		String strArr[] = str.split(seprator);  
		int array[] = new int[strArr.length];  
		for(int i=0;i<strArr.length;i++){
		    array[i]=Integer.parseInt(strArr[i]);
		} 
		return array;
	}
	
	/**
	 * 将字符串按某个分隔符拆分成字符串数组
	 * @param str
	 * @param seprator
	 * @return String []
	 * @author wz
	 */
	public static String[] split(String str, String seprator) {
		 if(checkFull(str) || checkFull(seprator)){
			 return null;
		 }
		String strArr[] = str.split(seprator);  
		return strArr;
	}
	
	/**
	 * 将含有符号的字符串，以该符号进行分隔成List<String>集合
	 * @param str
	 * @param seprator
	 * @return List<String>
	 * @author wz
	 */
	public static List<String> splitToList(String str,String seprator){
		
		if(CommonUtils.isEmpty(str)){
			return null;
		}
		
		str = str.trim();
		String[] tmp = str.split(seprator);
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < tmp.length; i++) {
			if (!CommonUtils.isEmpty(tmp[i])) {
				list.add(tmp[i]);
			}
		}
		
		return list;
	}
	
	
	/**
	 * 将字符串转换成数组
	 * @param s
	 * @param cs
	 * @return
	 */
	public static byte[] getStrByte(String s, String cs) {
		try {
			return s.getBytes(cs);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * 检查字符串是否为空, 为空则返回true 反之返回false
	 * 
	 * @param param
	 * @return
	 */
	public static boolean checkFull(String param) {
		return ((null == param || "".equals(param.trim()) || "null"
				.equals(param.trim())) ? true : false);
	}
	
	/** 判断空字对象，空map,空collection **/
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof String) {
			return ((String) o).trim().length() == 0;
		} else if (o instanceof Collection) {
			return ((Collection<?>) o).size() == 0;
		} else if (o instanceof Map) {
			return ((Map<?, ?>) o).size() == 0;
		} else if (o.getClass().isArray()) {
			return Array.getLength(o) == 0;
		}
		return false;
	}
	
	/***
	 * 将字符串转换成MD5码
	 * type 加密位数 16 32 
	 * @return
	 */
	public static String strToMD5(String code,int type){
		String md5Code = null;
		if(!checkFull(code)){
			md5Code = bytesToMD5(code.getBytes(),type);
		}
		return md5Code;
	}
	/**
	 * 把字节数组转换成md5
	 * @param input 将要转换的字节数组
	 * @param type 进制数 16（默认） 32 64
	 * @return
	 */
	public static String bytesToMD5(byte[] input,int type) {
		String md5str = null;
		try {
			//创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算后获得字节数组
			byte[] buff = md.digest(input);
			md5str = bytesToHex(buff,type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5str;
	}
	/**
	 * 把字节数组转成16进位制数
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes,int type) {
		StringBuffer md5str = new StringBuffer();
		//把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			 digital = bytes[i];
			if(digital < 0) {
				digital += 256;
			}
			if(digital < 16){
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
			
		}
		if(type==16){
			return md5str.toString().substring(8,24);
		}else{//默认32				
			return md5str.toString();
		}
	}
	
	
	/**
	 * 验证IPv4
	 * @param ipAddress
	 * @return
	 */
	public static boolean isIpv4(String ipAddress) {
		if (ipAddress.equals("0:0:0:0:0:0:0:1")) {
			return true;
		}
		if(CommonUtils.checkFull(ipAddress)){
			return false;
		}
        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern pattern = Pattern.compile(ip);  
        Matcher matcher = pattern.matcher(ipAddress);  
        return matcher.matches();  
	}
	/**
	 * 生成指定位数的睡觉字符串 
	 * @param length 字符串长度
	 * @param type 生成类型  1：纯数字  2：数字字符结合
	 * @return
	 */
	public static String getRandom(int length,int type){
		String randomCode = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % type == 0 ? "num" : "char";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				//int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;//随机生成大小写字母
				//随机生成小写字母
				int choice = 97;
				randomCode += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				randomCode += String.valueOf(random.nextInt(10));
			}
		}
		return randomCode;
	}
	
	/**
	 * 对字符串进行 64位加密
	 * @param str 需要加密的字符串
	 * @return 字符串等于 null  或空  返回空  “”
	 * @throws UnsupportedEncodingException 
	 */
	public static String strToBase64(String str) throws UnsupportedEncodingException{
		if(checkFull(str)){
			return "";
		}else{
			return  new BASE64Encoder().encode(str.getBytes("utf-8"));
		}
	}
	
	
	
	
	/**
	 * 字符串 解密
	 * @param str
	 * @return
	 */
	public static String base64ToStr(String str){
		if(checkFull(str)){
			return "";
		}else{
			try {
				return new String(new BASE64Decoder().decodeBuffer(str));
			} catch (IOException e) {
				return null;
			}
		}
	}
	
	/**
	 * 将字符转换为日期类型
	 * @param str eg:2015-1-1 12:12:12     2015/12/12 12:12:12
	 * @return 返回date 类型
	 * @throws ParseException  格式转异常
	 */
	public static Date str2Date(String str,Integer...type) throws ParseException{
		str = str.replaceAll("/", "-");
		SimpleDateFormat sdf =null;
		if(type==null||type.length==0){
			sdf=   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(type[0]==1){
			sdf=   new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.parse(str);
	}
	
	/**
	 * 字节数字 转换 string
	 * @param byteArray 需要转换的字节数字
	 * @return 转换后的str
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	public static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}


//	/**
//	 * 刷新文章到缓存
//	 * @param article  需要向缓存中操作的对象
//	 * @param i  0添加对象  1更新对象  -1，删除对象
//	 */
//	public static void updateArticleToCache(Article article, Integer i) {
//		if (article!=null) {
//			if (i==0) {//新增对象
//				CacheUtil.addArticleToCache(article);
//			}else if (i==1) {//更新对象
//				CacheUtil.updateArticleToCache(article);
//			}else {//删除对象对象
//				
//			}
//		}
//	}
	
}
