//package cn.zgyt.projection;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.rest.core.config.Projection;
//
//import com.epc.pm.entity.base.BaseArrangement;
//import com.epc.pm.entity.base.BaseArrangementType;
//import com.epc.pm.entity.base.BaseUser;
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//@Projection(name = "BaseArrangementProjection", types = { BaseArrangement.class }) 
//public interface BaseArrangementProjection {
//
//	public Long getId();
//
//	public String getSubject();
//
//	public String getPlace();
//
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//	public Date getStartTime();
//
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//	public Date getEndTime();
//
//	public Integer getNeedAlert();
//
//	public Integer getAlertAheadmin();
//
//	public Integer getNeedMail();
//
//	public Integer getIsPublic();
//
//	public String getContent();
//
//	public Integer getHasAlerted();
//
//	public Integer getMailAheadmin();
//
//	public Integer getHasMailed();
//
//	public Date getInputDate();
//
//	public Date getUpdateDate();
//
////	public BaseUser getBaseUserByUpdateBy();
////
////	public BaseUser getBaseUserByInputBy();
//
//	public BaseUser getBaseUserByUserid();
//
//	public BaseArrangementType getBaseArrangementType();
//	
//	@Value("#{target.baseUserByUserid.userNameCn}")
//	public String getUserName();
//	
//}