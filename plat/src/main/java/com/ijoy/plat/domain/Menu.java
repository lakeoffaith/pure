package com.ijoy.plat.domain;

//实现排序，根据ord
public class Menu implements Comparable<Menu>{
	public static final int PERMISSIONMENU = 2;
	public static int INDEXMENU=1; //表示首页的权限元素(菜单)
	private Long id;
	private String name;
	private String url;
	private Long parent_id;
	private String iconCls;
	private Long orderid;
	private int type;   //默认为1 为普通菜单   2为菜单下面的按钮权限。
	private State state;  //为了jtree控制输出
	private String iconname;
	private Long childNum;  //默认为没有子类
	public Menu(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	
	
    public State getState() {
    	if(state==null){
    		return new State(false, false, false);
    	}
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}



	public class State{
    	private Boolean opened=false;
    	private Boolean disabled;
    	private Boolean selected;
		public State(Boolean opened, Boolean disabled, Boolean selected) {
			this.opened = opened;
			this.disabled = disabled;
			this.selected = selected;
		}
		
		@Override
		public String toString() {
			return "State [opened=" + opened + ", disabled=" + disabled
					+ ", selected=" + selected + "]";
		}

		public Boolean getOpened() {
			return opened;
		}
		public void setOpened(Boolean opened) {
			this.opened = opened;
		}
		public Boolean getDisabled() {
			return disabled;
		}
		public void setDisabled(Boolean disabled) {
			this.disabled = disabled;
		}
		public Boolean getSelected() {
			return selected;
		}
		public void setSelected(Boolean selected) {
			this.selected = selected;
		}
    	
    }


	public Long getChildNum() {
		return childNum;
	}
	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}
	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public int compareTo(Menu o) {
		if (this.orderid<o.orderid) {
			return -1;
		}else if (this.orderid>o.orderid) {
			return 1;
		}
		return 0;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
	
	public String getIconname() {
		return iconname;
	}

	public void setIconname(String iconname) {
		this.iconname = iconname;
	}
}
