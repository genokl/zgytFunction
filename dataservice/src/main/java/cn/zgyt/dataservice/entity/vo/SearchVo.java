package cn.zgyt.dataservice.entity.vo;

import javax.servlet.http.HttpServletRequest;

import cn.zgyt.dataservice.entity.TableVersion;

public class SearchVo {
	
	private HttpServletRequest req;
	private TableVersion tableversion;
	private String condition;
	private Integer page;//页数
	private String version;//表版本
	private Integer size;//每页显示条数
	private String queryType;//查询类型
	

	public TableVersion getTableversion() {
		return tableversion;
	}
	public void setTableversion(TableVersion tableversion) {
		this.tableversion = tableversion;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	
}
