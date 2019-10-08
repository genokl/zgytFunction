package cn.zgyt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.zgyt.aop.WebLogAspect;
import cn.zgyt.entiry.user.MyException;
import cn.zgyt.repository.MyExceptionRepository;
 
@Component
public class TestTask {
 
	@Autowired
	private MyExceptionRepository rep;
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 
    // 定义天23点执行任务
    @Scheduled(cron="0 0 23 * * ?")
    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
    	List<MyException> list = WebLogAspect.exceptionLog;
    	if(list.size()>0) {
    		rep.save(list);
    	}
    	list.clear();
    }
}