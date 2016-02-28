package com.ijoy.plat.query;



public class MenuQuery extends BaseQuery {
	private String name;
  private Long parent_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "MenuQuery [name=" + name + ", parent_id=" + parent_id + "]";
	}

   

    
}
