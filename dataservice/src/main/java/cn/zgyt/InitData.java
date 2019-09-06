package cn.zgyt;

 
import java.io.File;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.zgyt.dataservice.entity.TableVersion;
import cn.zgyt.dataservice.liquibase.LiquiHelpUtil;
import cn.zgyt.dataservice.repository.TableVersionRepository;
/**
 * @author wxy
 */
@Component
public class InitData implements CommandLineRunner {
	
	@Autowired
    private DataSource dataSource;
	@Value("${spring.application.changeLogBasePath}")
	private String changeLogBasePath;
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private TableVersionRepository tableVersionRepository;
	
    @Override
    @Transactional
    public void run(String... args) {
		try {
			File file = new File(changeLogBasePath);//File类型可以是文件也可以是文件夹
			//如果路径不存在，新建
			if(!file.exists()&&!file.isDirectory()) {
			    file.mkdirs();
			}
			if(file.exists()) {
				File[] fileList = file.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					String name = fileList[i].getName();
					if(name.endsWith(".xml")) {
						String tableName = name.substring(0,name.lastIndexOf("."));
						List<TableVersion> ls = tableVersionRepository.findByTableName(tableName);
						if(ls.size()==0) {
							TableVersion tv = new TableVersion();
							//td.setPath(paramArrRest);
							//记录表创建关系记录
							tv.setCreateDate(new Date());
							tv.setTableName(tableName);
							tableVersionRepository.save(tv);//添加tableversion数据
							LiquiHelpUtil.excuteUpdate(fileList[i].getAbsolutePath(), jdbcTemplate);//执行xml文件
							System.out.println("liquibase: "+tableName+"已创建！");
						}else {
							System.out.println("liquibase: "+tableName+"已存在！");
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
  }

