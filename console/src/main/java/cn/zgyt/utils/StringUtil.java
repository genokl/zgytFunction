package cn.zgyt.utils;

import java.util.ArrayList;
import java.util.List;

import cn.zgyt.util.CommonUtils;

public class StringUtil {

	private static List<String> ll=new ArrayList<String>();
	
	
	/**
	  * 去除对应标签的属性
	 * @param str
	 * @return
	 */
	public static String dealProductDetail(String str) {
		if(ll.size()==0) {
			ll.add("color");
			ll.add("face");
//			ll.add("style");
		}
		for (int i = 0; i < ll.size(); i++) {
			str=str.replaceAll(""+ll.get(i)+"=\"(.*?)\"", "");
		}
		//保留img标签样式
		String[] ss1= str.split("<");
		String res="";
		for (int i = 0; i < ss1.length; i++) {
			if(!CommonUtils.checkFull(ss1[i])) {
				if(ss1[i].startsWith("img")) {
					res+="<"+ss1[i];
				}else {
					res+="<"+ss1[i].replaceAll("style=\"(.*?)\"", "");
				}
			}
		}
		
//		str=str.replaceAll("face=\"Microsoft Yahei\"", "");
//		str=str.replaceAll("style=\"font-size: 16px;\"", "");
        return res;
    }
	
	public static void main(String[] args) {
		String ss="<p><img src=\"/zgytimg/upload/baiduUEImg/20190530/1559184456336051320.jpg\" title=\"1559184456336051320.jpg\" alt=\"4_1道路施工质量监控云服务平台v1.0.jpg\" style=\"width: 289.753px; height: 432.109px;\"></p>";
		String[] ss1= ss.split("<");
		String res="";
		for (int i = 0; i < ss1.length; i++) {
			if(ss1[i].startsWith("img")) {
				res+="<"+ss1[i];
			}else {
				res+="<"+ss1[i].replaceAll("style=\"(.*?)\"", "");
			}
		}
		System.out.println(res);
	}
}
