//package cn.zgyt.dataservice.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.epc.epcf4.common.Message;
//import com.epc.epcf4.common.MessageResource;
//import com.google.gson.Gson;
//
//import cn.zgyt.dataservice.entity.TableDefine;
//import cn.zgyt.dataservice.entity.vo.SearchVo;
//import cn.zgyt.dataservice.service.TableVersionServiceimpl;
//import cn.zgyt.dataservice.util.ResUrlUtil;
//import cn.zgyt.dataservice.util.UrlUtil;
//
//@Controller
//@RequestMapping("/datatable/**")
//public class DataTableController {
//
//	private String prepath="datatable";
//	
//	@Value("${spring.application.changeLogBasePath:path}")
//	private String changeLogBasePath;
//	
//	@Autowired
//	private TableVersionServiceimpl tableVersionServiceimpl;
//	
//	/**
//	 * 更新表数据方法
//	 * 幂等性
//	 * @return
//	 */
//	@ResponseBody
//	@PutMapping
//	public ResponseEntity<MessageResource> putData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestBody(required=false) String str
//			){
//		Message m=new Message();
//		ResponseEntity<MessageResource> res=null;
//		try {
//			String paramArrRest = UrlUtil.getParamArrRest(prepath,request.getRequestURI());
//			String path=paramArrRest.substring(0, paramArrRest.lastIndexOf("/"));
//			tableVersionServiceimpl.updateTableForJson(str,path);
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//			return null; 
//		} catch (Exception e) {
//			e.printStackTrace();
//			m.setMessage(e.getMessage());
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//		}
//		return res;
//	}
//	
//	/**
//	 * 创建表
//	 * @throws Exception 
//	 */
//	@ResponseBody
//	@PostMapping
//	public ResponseEntity<MessageResource> postData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestBody(required=false) String str
//			) throws Exception{
//		Message m=new Message();
//		ResponseEntity<MessageResource> res=null;
//		String requestURI = request.getRequestURI();
//		String paramArrRest[] = UrlUtil.getParamArrRest(prepath,requestURI).split("/");
//		Gson g=new Gson();
//		TableDefine td = g.fromJson(str, TableDefine.class);
//		try {
//			//创建表
//			String tableName = tableVersionServiceimpl.createTableForJson(td,paramArrRest);
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//		} catch (Exception e) {
//			String filePath= changeLogBasePath + "/" + td.getTableName() + ".xml";
//			e.printStackTrace();
//			//删除liquibase记录和xml文件
//			tableVersionServiceimpl.delDatabasechangelog(filePath);
//			m.setMessage(e.getMessage());
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.EXPECTATION_FAILED);
//		}
//		return res; 
//	}
//	
//	@ResponseBody
//	@DeleteMapping
//	public ResponseEntity<MessageResource> delData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			SearchVo vo
//			) throws Exception{
//		Message m=new Message();
//		ResponseEntity<MessageResource> res=null;
//		String requestURI = request.getRequestURI();
//		String paramArrRest[] = UrlUtil.getParamArrRest(prepath,requestURI).split("/");
//		String tableName=paramArrRest[paramArrRest.length-1];
//		try {
//			tableVersionServiceimpl.delTable(tableName);
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//		} catch (Exception e) {
//			String filePath= changeLogBasePath + "/" + tableName + ".xml";
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.EXPECTATION_FAILED);
//			e.printStackTrace();
//			//删除liquibase记录和xml文件
//			tableVersionServiceimpl.delDatabasechangelog(filePath);
//			e.printStackTrace();
//		}
////		System.out.println(request.getRequestURI());
//		return res; 
//	}
//	
//}
