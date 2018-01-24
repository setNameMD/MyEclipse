package cn.xy.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import cn.xy.bean.District;
import cn.xy.bean.Street;
import cn.xy.util.SessionFactoryUtil;

/**
 * 测试类
 * @author lenovo
 *
 */
public class StreetTest {
	Session session;
	Transaction transaction;
	@Before
	public void before(){
		session=SessionFactoryUtil.getCurrentSession();
		transaction=session.beginTransaction();
	}
	/**
	 * 创建出模拟数据
	 */
	/*@Test
	public void test1(){
		District district=new District(1,"海淀区", null);
		session.save(district);
		transaction.commit();
		
	}*/
	/**
	 * 新增街道的同事给对应的区县赋值
	 */
	/*@Test
	public void test2(){
		//创建一个街道
		Street street=new Street();
		street.setId(1);
		street.setName("海淀一街道");
		//从数据库获得一个区县的对象
		District district=(District) session.get(District.class, 1);
		street.setDistrict(district);
		session.save(street);
		transaction.commit();
	}*/
	/**
	 * 修改街道对应的区县
	 * 
	 */
	/*@Test
	public void test3(){
		//从数据库过得一个要修改的街道
		Street street=(Street)session.get(Street.class, 1);
		District district=(District)session.get(District.class, 2);
		street.setDistrict(district);
		transaction.commit();
	}*/
	/**
	 * 修改街道对应的区县为null
	 */
	/*@Test
	public void test4(){
		Street street=(Street)session.get(Street.class, 1);
		street.setDistrict(null);
		transaction.commit();
	}*/
	/**
	 * 新增区县的同时 新增 对应的街道
	 * 在一方中的hbm.xml中增加cascade=save-update
	 * cascade 只能设置在一的 一方
	 * 1、none:默认值 当我们操作对象时忽略其关联属性
	 * 2、save-update:在调用save,saveOrUpdate和update方法的时候会级联的修改或保存当前对象
	 * 以及所关联的对象
	 * 3、delete：在调用delete的时候会级联的删除关联对象
	 * 4、all:包含了 delete和save-update
	 * 
	 * 
	 */
	/*@Test
	public void test5(){
		//创建区县
		District district=new District();
		district.setId(3);
		district.setName("大兴区");
		//创建街道
		Street street=new Street();
		street.setId(5);
		street.setName("大兴一街道");
		Street street2=new Street();
		street2.setId(6);
		street.setName("大兴二街道");
		//把街道放进区县的集合中
		district.getStreets().add(street);
		district.getStreets().add(street2);
		//新增区县
		session.save(district);
		transaction.commit();
	}
*/
	/**
	 * 验证级联删除
	 */
	@Test
	public void test6(){
		District district=(District)session.get(District.class, 3);
		session.delete(district);//删除区县
		transaction.commit();
	}
}
