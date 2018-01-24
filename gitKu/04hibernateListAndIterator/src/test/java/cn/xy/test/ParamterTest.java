package cn.xy.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import cn.xy.bean.Teacher;
import cn.xy.util.SessionFactoryUtil;



/**
 * 动态参数的绑定
 * @author lenovo
 *
 */
public class ParamterTest {
	Session session;
	Transaction transaction;
	@Before
	public void before(){
		session=SessionFactoryUtil.getCurrentSession();
		transaction=session.beginTransaction();
	}
	/**
	 * 根据参数的位置进行绑定
	 * 查询id=2的老师的信息
	 */
	/*@Test
	public void test1(){
		String hql="from Teacher where id=?";
		Query query = session.createQuery(hql);
		//给参数赋值
		query.setParameter(0, 2);
		//得到唯一的结果
		Teacher teacher=(Teacher) query.uniqueResult();
		System.out.println(teacher);
	}*/
	/**
	 * 根据参数的名称进行绑定
	 * 查询id=2的老师信息
	 */
	/*@Test
	public void test2(){
		String hql="from Teacher where id=:tid";
		Query query = session.createQuery(hql);
		//给参数赋值
		query.setParameter("tid", 2);
		Teacher teacher=(Teacher) query.uniqueResult();
		System.out.println(teacher);
	}*/
	/**
	 * 动态参数的绑定
	 * 程序运行期间才能判断用户需要查询的内容；
	 * 查询教室表中 薪水是xx 地址是xx
	 * 我们不知道用户具体根据那个字段进行查询
	 * 封装一个对象传递
	 * 
	 */
	/*@Test
	public void test3(){
		StringBuffer buffer=new StringBuffer("from Teacher where 1=1");
		//创建一个Teacher对象 模拟用户给对象赋值
		Teacher teacher=new Teacher();
		teacher.setAdress("%区%");
		teacher.setSal(3000);
		//因为用户不知道要输入的参数 所以要非空判断
		if(teacher.getSal()>0){
			buffer.append(" and sal>:sal");
		}
		if(teacher.getAdress()!=null){
			buffer.append(" and adress like :adress");
		}
		Query query = session.createQuery(buffer.toString());
		//传递对象给参数赋值
		query.setProperties(teacher);
		//获取结果
		List<Teacher> list = query.list();
		for (Teacher teacher2 : list) {
			System.out.println(teacher2);
			}
		}*/
	
	/*@Test
	public void test4(){
		StringBuffer buffer=new StringBuffer("from Teacher where 1=1");
		//创建一个Teacher对象 模拟用户给对象赋值
		Teacher teacher=new Teacher();
		teacher.setAdress("sssss");
		teacher.setSal(2);
		//因为用户不知道要输入的参数 所以要非空判断
		if(teacher.getSal()>0){
			buffer.append(" and sal>:sals");
		}
		if(teacher.getAdress()!=null){
			buffer.append(" and adress like :adr");
		}
		Query query = session.createQuery(buffer.toString());
		//传递对象给参数赋值
		query.setParameter("sals", 3000.0);
		query.setParameter("adr", "%区%");
		//获取结果
		List<Teacher> list = query.list();
		for (Teacher teacher2 : list) {
			System.out.println(teacher2);
			}
		}*/
	/**
	 * 投影查询 查询指定的字段
	 * 01、将查询结果封装成Object对象；
	 */
	/*@Test
	public void test05(){
		String hql="select name from Teacher";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
	}*/
	/**
	 * 02、将查询的结果分装成Object数组
	 */
	/*@Test
	public void test6(){
		String hql="select name,sal from Teacher";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}*/
	/**
	 * 03、将查询的结构封装成对象 前提必须有对应的构造
	 */
	/*@Test
	public void test7(){
		String hql="select new Teacher(name,sal) from Teacher";
		List<Teacher> list = session.createQuery(hql).list();
		for (Teacher t : list) {
			System.out.println(t);
		}
	}*/
	/**
	 * 分页查询
	 * 01、查询总记录数
	 * 02、每页显示的条数
	 * 03、总页数
	 * 
	 * 
	 */
	@Test
	public void test8(){
		//查询记录总数
		String hql="select count(*) from Teacher";
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();
		//页大小
		int pageSize=2;
		 //总页数
		int pageTotalCount=(count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		//显示当前页的内容
		int pageIndex=1;
		hql="from Teacher";
		Query query = session.createQuery(hql);
		//设置从哪一条开始查询
		query.setFirstResult((pageIndex-1)*pageSize);
		//设置页大小
		query.setMaxResults(pageSize);
		List<Teacher> teachers = query.list();
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}
