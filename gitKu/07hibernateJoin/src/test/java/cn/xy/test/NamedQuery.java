package cn.xy.test;

import java.util.List;

import javax.xml.transform.Transformer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.junit.Before;
import org.junit.Test;

import cn.xy.bean.Emp;
import cn.xy.util.SessionFactoryUtil;

/**
 * 命名查询
 * @author lenovo
 *
 */
public class NamedQuery {
	Session session=null;
	Transaction transaction=null;
	@Before
	public void before(){
		session=SessionFactoryUtil.getCurrentSession();
		transaction=session.beginTransaction();
	}
	/**
	 * 命名查询 hibernate中 允许我们在xml文件中以及实体类中(使用注解)定义查询语句
	 * 
	 * 01、query hql语句
	 * 
	 * 02 sql-query sql语句
	 */
	/*@Test
	public void test(){
		List<Emp> list = session.getNamedQuery("getAllEmps").list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}*/
	/**
	 * 使用sql-query 来命名查询
	 * 
	 * 返回的是Object对象数组
	 */
	/*@Test
	public void tesst(){
		List<Object[]> list = session.getNamedQuery("getEmps").list();
		for (Object[] objects : list) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}*/
	/**
	 * 根据指定的id查询指定的对象
	 */
	/*@Test
	public void test(){
		List<Object[]> list = session.getNamedQuery("getEmpId").setParameter("id", 1).list();
		for (Object[] objects : list) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}*/
	@Test
	public void test(){
		Query query = session.getNamedQuery("emp").setParameter("id", 2);
		query.setResultTransformer(Transformers.aliasToBean(Emp.class));
		Emp emp = (Emp) query.uniqueResult();
		System.out.println(emp);
	}
}
