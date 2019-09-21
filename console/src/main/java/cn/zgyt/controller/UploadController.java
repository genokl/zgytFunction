package cn.zgyt.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import cn.zgyt.util.CommonUtils;
import cn.zgyt.utils.ConsoleConfig;
 
/**
 * 首页重定向配置
 * @author wxy
 */
@Controller
@RequestMapping("/file")
public class UploadController {
	
//	@Autowired
//	@LoadBalanced
//	private OAuth2RestOperations client;
	
	@Autowired
	private ConsoleConfig config;
	
	@ResponseBody
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
    	ResponseEntity<?> res=null;
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("上传失败，请选择文件", HttpStatus.EXPECTATION_FAILED);
        }

        String fileName = file.getOriginalFilename();
        String filePath = config.getPICRealPath();
        SimpleDateFormat sdf = CommonUtils.loadSimpleDateFormat("yyyyMMdd");
//      File dest = new File(filePath + fileName);
        File today = new File(filePath+"/upload/"+sdf.format(new Date()));
        if(!today.exists()&&!today.isFile()){
        	today.mkdir();
		}
        String day = sdf.format(new Date());
        long cm = System.currentTimeMillis();
        String filepath=filePath+"upload/"+day+"/"+cm+fileSuffixName(fileName);
        String urlpath=config.getPICUrlHeader()+"upload/"+day+"/"+cm+fileSuffixName(fileName);
        File dest = new File(filepath);
        String mes="";
        try {
        	CloseableHttpClient httpclient = HttpClients.createDefault();  
            file.transferTo(dest);
            JsonObject jo=new JsonObject();
            jo.addProperty("filePath", urlpath);
            
            String uploadUrl="http://localhost:8089/file/upload";
            
            HttpPost httpPost = new HttpPost(uploadUrl);
            FileBody fileBody = new FileBody(new File(filepath));
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addPart("file",fileBody);


            HttpEntity reqEntity  = multipartEntityBuilder.build();
            httpPost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
            	if(response.getStatusLine().getStatusCode()==200) {
            		HttpEntity entity = response.getEntity();
            		mes= EntityUtils.toString(entity, "UTF-8");
            	}
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
              response.close();
              dest.delete();
            }
            return new ResponseEntity<Object>(mes, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return  new ResponseEntity<Object>("上传失败", HttpStatus.EXPECTATION_FAILED);
    }
    
    /**
	 * 获取文件后缀名
	 * @param fileName  文件名
	 * @return 返回后缀
	 */
	public String fileSuffixName(String fileName){
		return fileName.substring(fileName.lastIndexOf("."));
	}


}
