package cn.zgyt.comm;

/**
 */
public class Message {

	private boolean flag;
	
	/**
	 * 返回的message,支持spring国际化
	 */
	private String message;
	
	/**
	 * dialog显示时间(second)
	 * -1代表需要手动关闭,
	 */
	private int showTime;
	
	/**
	 * 传递的数据
	 */
	private Object entity;
	
	
    public static Message success(String message, int showTime) {
        return new Message(true, message, showTime, null);
    }
    
    public static Message success(String message, int showTime, Object data) {
        return new Message(true, message, showTime, data);
    }
    
    /**
	 * 工作流需要beanID
	 */
    public static Message success(String message, int showTime, Object data, String beanID) {
        return new Message(true, message, showTime, data);
    }
    
    public static Message failure(String message, int showTime) {
        return new Message(false, message, showTime, null);
    }
    
    public Message(boolean flag, String message, int showTime, Object enity) {
		super();
		this.flag = flag;
		this.message = message;
		this.showTime = showTime;
		this.entity = enity;
	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getShowTime() {
		return showTime;
	}

	public void setShowTime(int showTime) {
		this.showTime = showTime;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Message() {
		super();
	}

}
