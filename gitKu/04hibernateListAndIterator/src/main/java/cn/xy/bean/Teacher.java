package cn.xy.bean;
/**
 * teacher对应的实体类
 * @author lenovo
 *
 */
public class Teacher {
	private Integer id;
	private String name;
	private double sal;
	private String adress;
	public Teacher(Integer id, String name, double sal, String adress) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.adress = adress;
	}
	public Teacher(String name, double sal){
		this.name = name;
		this.sal = sal;
	}
	public Teacher() {
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sal=" + sal
				+ ", adress=" + adress + "]";
	}
	
}
