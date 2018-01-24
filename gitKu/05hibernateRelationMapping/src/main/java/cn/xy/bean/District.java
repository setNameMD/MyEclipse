package cn.xy.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 区县对应的实体类
 * @author lenovo
 *
 */
public class District {
	private  Integer   id;  //区县id
    private  String   name; //区县名称
    // 一个区县对应多个街道
    List<Street> streets=new ArrayList<Street>();
	public District(Integer id, String name, List<Street> streets) {
		super();
		this.id = id;
		this.name = name;
		this.streets = streets;
	}
	public District() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + ", streets=" + streets
				+ "]";
	}
    
}
