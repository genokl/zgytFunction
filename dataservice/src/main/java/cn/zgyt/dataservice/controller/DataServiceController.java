//package cn.zgyt.dataservice.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
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
//import cn.zgyt.dataservice.util.CommonUtil;
//import cn.zgyt.dataservice.util.ResUrlUtil;
//import cn.zgyt.dataservice.util.UrlUtil;
//
//
//@Controller
//@RequestMapping("/dataservice/**")
//public class DataServiceController {
//	
//	private String prepath="dataservice";
//	
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
//			)throws Exception{
//		ResponseEntity<MessageResource> res=null;
//		Message msg = new Message();
//		try {
//			String path = UrlUtil.getParamArrRest(prepath, request.getRequestURI());
//			TableDefine td = new Gson().fromJson(str, TableDefine.class);
//			tableVersionServiceimpl.updateDataForJson(td, path);
//			msg.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<>(new MessageResource(msg),HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			msg.setMessage(e.getMessage());
//			res=new ResponseEntity<>(new MessageResource(msg),HttpStatus.EXPECTATION_FAILED);
//		}
//		return res;
//	}
//	
//	
//	@ResponseBody
//	@PostMapping
//	public ResponseEntity<MessageResource> postData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestBody(required=false) String str
//			) throws Exception{
//		ResponseEntity<MessageResource> res=null;
//		Message m=new Message();
//		try {
//			String path = UrlUtil.getParamArrRest(prepath, request.getRequestURI());
////			String path = paramArrRest.substring(0, paramArrRest.lastIndexOf("/"));
//			tableVersionServiceimpl.insertDataForJson(str, path);
//			System.out.println(request.getRequestURI());
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
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
//		String affectedRows;
//		ResponseEntity<MessageResource> res=null;
//		Message m=new Message();
//		try {
//			String requestURI = request.getRequestURI();
//			String paramArrRest = UrlUtil.getParamArrRest(prepath, requestURI);
//			vo = CommonUtil.parseUrl(paramArrRest, vo, request);
//			affectedRows = tableVersionServiceimpl.delObjData(vo);
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			m.setMessage(e.getMessage());
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.EXPECTATION_FAILED);
//		}
//		return res;
//	}
//	
//	
//	@ResponseBody
//	@GetMapping
//	public ResponseEntity<Object> getData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			SearchVo vo
//			) throws Exception{
//		ResponseEntity<Object> res=null;
//		try {
//			Map<String, Object> map = new HashMap<>();
//			String requestURI = request.getRequestURI();
//			String paramArrRest = UrlUtil.getParamArrRest(prepath, requestURI);
//			vo = CommonUtil.parseUrl(paramArrRest, vo, request);
//			if (vo.getQueryType().equals("one")) {
//				map = tableVersionServiceimpl.findObjWithMap(vo);
//				if(map!=null) {
//					map = ResUrlUtil.addCRUDUrlToObj(map, vo);
//				}
//			} else if (vo.getQueryType().equals("list")) {
//				Map<String, Object> map2 = tableVersionServiceimpl.findListWithMap(vo);
//				if(map!=null) {
//					map2 = ResUrlUtil.addPageUrlToMap(map2, vo);
//					map.put("_embedded", map2);
//				}
//			} 
//			res = new ResponseEntity<>(map, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
//		}
//		return res; 
//	}
//}
