package cn.zgyt.dataservice.util;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
	
	/**
	 * 动作类型 createTable创建表
	 */
	public static String TYPE_CTEATE_TABLE="createTable";
	/**
	 * 动作类型 updateTable修改表
	 */
	public static String TYPE_UPDATE_TABLE="updateTable";
	/**
	 *动作类型 addData添加表数据 
	 */
	public static String TYPE_ADD_DATA="addData";
	/**
	 *动作类型 updateData更新表数据
	 */
	public static String TYPE_UPDATE_DATA="updateData";
	
	//更新字段
	/**
	 * 加字段
	 */
	public static String ALTER_AddColum="addColum";
	/**
	 * 减字段
	 */
	public static String ALTER_DeleteColum="deleteColum";
	/**
	 * 修改字段类型或长度
	 */
	public static String ALTER_UpdateColum="updateColum";
	/**
	 * 修改字段名字
	 */
	public static String ALTER_UpdateName="updateName";
	
	
    /**  
      * 正则替换  
	  * @return  
	  */  
    public static String getUrlParameterReg(String url, String name) {
    	
        Map<String, String> mapRequest = new HashMap<String, String>();

          String[] arrSplit=null;

        String strUrlParam=TruncateUrlPage(url);
        if(strUrlParam==null)
        {
            return "";
        }
          //每个键值为一组 www.2cto.com
        arrSplit=strUrlParam.split("[&]");
        for(String strSplit:arrSplit)
        {
              String[] arrSplitEqual=null;         
              arrSplitEqual= strSplit.split("[=]");

              //解析出键值
              if(arrSplitEqual.length>1)
              {
                  //正确解析
                  mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

              }
              else
              {
                  if(arrSplitEqual[0]!="")
                  {
                  //只有参数没有值，不加入
                  mapRequest.put(arrSplitEqual[0], "");       
                  }
              }
        }   
        return mapRequest.get(name);  
    }  
    
    /**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String TruncateUrlPage(String strURL)
    {
    String strAllParam=null;
      String[] arrSplit=null;

      strURL=strURL.trim().toLowerCase();

      arrSplit=strURL.split("[?]");
      if(strURL.length()>1)
      {
          if(arrSplit.length>1)
          {
                  if(arrSplit[1]!=null)
                  {
                  strAllParam=arrSplit[1];
                  }
          }
      }

    return strAllParam;   
    }
    
    public static String getParamArrRest(String pre,String url) {
    	String ss = url.replace("/"+pre, "");
    	String res="";
    	if(ss.startsWith("/")) {
    		ss= ss.replaceFirst("/", "");
    	}
    	if(ss.endsWith("/")) {
    		ss= ss.substring(0, ss.length()-1);
    	}
		return ss;
    }
    
}
