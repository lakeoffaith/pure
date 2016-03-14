package com.ijoy.common.comutil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeJson implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int pid;
	private String name;
	private String iconCls;
	private String state;
	private String checked;
	private List<TreeJson> children=new ArrayList();
	
	//需要返回一个格式化了的list<treeJson>对象
	public static List<TreeJson> formatJson(List<TreeJson> list){
		
		//返回的json对象
		List<TreeJson> jsonlist=new ArrayList();
		//存放节点
		List<TreeJson> parentnodes=new ArrayList();
		//根节点
		TreeJson root=new TreeJson();
		TreeJson node=new TreeJson();
		if(list!=null && list.size()>0){
			root=list.get(0);
			for (int i = 1; i < list.size(); i++) {
				node= list.get(i);
			/*	//如果是根节点的子节点
				if(root.getId()==node.getPid()){
					root.getChildren().add(node);
					//将这个节点加入父节点中,让其余的字节找他,
					parentnodes.add(node);
				}else {
					//如果这个节点不是根节点的子节点,去到parentnodes中去找父节点
					getChildrenNodes(parentnodes,node);
					parentnodes.add(node);
				}*/
				/*都加入parentnodes中 在 最后遍历出父节点为root和父节点为null*/
				getChildrenNodes(parentnodes, node);
				parentnodes.add(node);
			}
		}
		for (int i = 0; i < parentnodes.size(); i++) {
			TreeJson n = parentnodes.get(i);
			if(n.getPid()==root.getId()){
				root.getChildren().add(n);
			}
		}
		jsonlist.add(root);
		return jsonlist;
	}
	
	private static void getChildrenNodes(List<TreeJson> parentnodes,
			TreeJson node) {
		//判断当前node,是否是集合中的某一个的菜单,或者是某一个的子菜单
		//如果是父菜单,则当前node,加入parentnodes,而原有的成为node的children,
		//如果是子菜单,则当前node,加入parentnode的childre,node也要加入parentnodes,才能继续添加其子菜单,
		if(parentnodes!=null && parentnodes.size()>0){
			for (int i = parentnodes.size()-1; i >=0; i--) {
				TreeJson parentnode = parentnodes.get(i);
				//找到子节点,很重要 有多个,
				if(node.getId()==parentnode.getPid()){
					node.getChildren().add(parentnode);
					/*父类集合中移除这个parentnode,因为他被当前node包含*/
				}else if(node.getPid()==parentnode.getId()){
					/*找到父节点    只有一个*/
					parentnode.getChildren().add(node);
					return;
				}
			}
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getText() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TreeJson> getChildren() {
		return children;
	}

	public void setChildren(List<TreeJson> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TreeJson [id=" + id + ", pid=" + pid + ", name=" + name
				+ ", iconCls=" + iconCls + ", state=" + state + ", checked="
				+ checked + ", children=" + children + "]";
	}
	
	
}

