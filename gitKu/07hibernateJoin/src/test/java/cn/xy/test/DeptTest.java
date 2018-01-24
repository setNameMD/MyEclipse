package cn.xy.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import cn.xy.bean.Dept;
import cn.xy.bean.Emp;
import cn.xy.util.SessionFactoryUtil;

/**
 * 测试类
 * @author lenovo
 *
 */
public class DeptTest {
	Session session=null;
	Transaction transaction=null;
	@Before
	public void befor(){
		 session = SessionFactoryUtil.getCurrentSession();
		 transaction=session.beginTransaction();
	}
	/**
	 * 新增部门的同事 新增员工
	 * 因为我们设置了cascade=all
	 * 
	 */
	/*@Test
	public void test(){
		Dept dept=new Dept();
		dept.setDeptId(1);
		dept.setName("财务部");
		dept.setLocation("1楼");
		Emp emp=new Emp(1,"员工1","财务员1",10000.0,dept);
		Emp emp1=new Emp(2,"员工2","财务员2",5000.0,dept);
		Emp emp2=new Emp(3,"员工3","财务员3",7000.0,dept);
		dept.getEmps().add(emp);
		dept.getEmps().add(emp1);
		dept.getEmps().add(emp2);
		session.save(dept);
		transaction.commit();
	}*/
	/*@Test
	public void test(){
		Dept dept=new Dept();
		dept.setDeptId(2);
		dept.setName("工程部");
		dept.setLocation("2楼");
		Emp emp=new Emp(4,"员工4","程序员1",10000.0,dept);
		Emp emp1=new Emp(5,"员工5","程序员2",50000.0,dept);
		Emp emp2=new Emp(6,"员工6","程序员3",60000.0,dept);
		dept.getEmps().add(emp);
		dept.getEmps().add(emp1);
		dept.getEmps().add(emp2);
		session.save(dept);
		transaction.commit();
	}*/
	/**
	 * 使用普通内连接查询部门和员工的信息
	 */
	/*@Test
	public void test(){
		String hql="from Emp e inner join e.dept";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}*/
	/**
	 * 使用迫切内连接查询
	 */
	/*@Test
	public void test(){
		String hql="from Emp e inner join fetch e.dept";
		List<Emp> list = session.createQuery(hql).list();
		for (Emp emp : list) {
			System.out.println(emp);
			System.out.println(emp.getDept());
		}
	}*/
	/**
	 * 使用普通外连接查询
	 */
	/*@Test
	public void test(){
		String hql="from Emp e left join e.dept";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] o : list) {
			System.out.println(o[0]);
			System.out.println(o[1]);
		}
	}*/
	@Test
	public void test(){
		String hql="from Emp e left join fetch e.dept";
		List<Emp> list = session.createQuery(hql).list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
