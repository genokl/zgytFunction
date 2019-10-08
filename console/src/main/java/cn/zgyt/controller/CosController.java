package cn.zgyt.controller;

import java.io.File;

import org.bouncycastle.math.ec.ECCurve.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import cn.zgyt.utils.ConsoleConfig;

/**
 * user 工具类
 * @author dell
 *
 */
@Controller
@RequestMapping("/cos")
public class CosController {
	
	public COSClient cosClient=null;
	
	@Autowired
	private ConsoleConfig config;
	
	private static COSClient loadCOSClient() {
		// 1 初始化用户身份信息（secretId, secretKey）。
		String secretId = "AKID6A3sdC7OD40pnncDRgnkW6XnU5f7qi5M";
		String secretKey = "FJjxIWbXN5dM7zhLVbVEHE2ucHtAKA9w";
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
		// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
		Region region = new Region("ap-chengdu");
		ClientConfig clientConfig = new ClientConfig(region);
		// 3 生成 cos 客户端。
		COSClient cosClient = new COSClient(cred, clientConfig);
		return cosClient;
	}
	
	/**
	 * 上传图片
	 */
	public  String uploadFile(String filePath,String fileName) {
		if(cosClient==null) {
			cosClient = loadCOSClient();
		}
		try {
			String replace = fileName.replace(config.getPICUrlHeader(), "");
		    // 指定要上传的文件
		    File localFile = new File(filePath);
		    // 指定要上传到的存储桶
//		    String bucketName = "zgytpic-1252757547";
		    String bucketName = "zgyttest-1252757547";
		    // 指定要上传到 COS 上对象键
		    String key = "/zgytpic/"+replace;
		    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
		    PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
		    return key;
		} catch (CosServiceException serverException) {
		    serverException.printStackTrace();
		} catch (CosClientException clientException) {
		    clientException.printStackTrace();
		}
		return "";
	}
	
}
