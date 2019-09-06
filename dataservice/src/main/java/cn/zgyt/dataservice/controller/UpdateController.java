//package cn.zgyt.dataservice.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.epc.epcf4.common.Message;
//import com.epc.epcf4.common.MessageResource;
//import com.google.gson.Gson;
//
//import cn.zgyt.dataservice.entity.TableDefine;
//import cn.zgyt.dataservice.service.TableVersionServiceimpl;
//import cn.zgyt.dataservice.util.ResUrlUtil;
//import cn.zgyt.dataservice.util.UrlUtil;
//
//
//@Controller
//@RequestMapping("/update/**")
//public class UpdateController {
//	
//	private String prepath="update";
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
//	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.POST})
//	public ResponseEntity<MessageResource> updateData(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestBody(required=false) String str
//			)throws Exception{
//		ResponseEntity<MessageResource> res=null;
//		Message m=new Message();
//		try {
////			System.out.println(str);
//			String path = UrlUtil.getParamArrRest(prepath, request.getRequestURI());
//			TableDefine td = new Gson().fromJson(str, TableDefine.class);
//			tableVersionServiceimpl.updateDataWithCondition(td);
//			m.setMessage(ResUrlUtil.STATUS_SUCCESS);
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.OK);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			m.setMessage(e.getMessage());
//			res=new ResponseEntity<MessageResource>(new MessageResource(m),HttpStatus.EXPECTATION_FAILED);
//		}
//		return res;
//	}
//	
//	
//}
