package cn.xy.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import cn.xy.bean.Teacher;
import cn.xy.util.SessionFactoryUtil;

public class TeacherTest {
	Session session;
	Transaction transaction;
	@Before
	public void befor(){
		session=SessionFactoryUtil.getCurrentSession();
		transaction=session.beginTransaction();
	}
	/**
	 * 测试代码
	 */
	/*
	@Test
	public void test01(){
		System.out.println(session.get(Teacher.class, 1));
	}*/
	/*@Test
	public void test02(){
		String hql="from Teacher";
		Query query = session.createQuery(hql);
		List<Teacher> list = query.list();
		for (Teacher t : list) {
			System.out.println(t);
		}
		//session.clear();
		list=query.list();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
	}*/
	/*@Test
	public void test03(){
		String hql="from Teacher";
		Query query = session.createQuery(hql);
		List<Teacher> list = query.list();
		for (Teacher t : list) {
			System.out.println(t);
		}
		session.get(Teacher.class, 1);
	}*/
	/*@Test
	public void test04(){
		String hql="from Teacher";
		Query query = session.createQuery(hql);
		Iterator<Teacher> iterate = query.iterate();
		while (iterate.hasNext()) {
			Teacher next = iterate.next();
			System.out.println(next);
			//Teacher teacher = (Teacher) iterate.next();
			
		}
		iterate = query.iterate();
		while (iterate.hasNext()) {
			Teacher next = iterate.next();
			System.out.println(next);
			//Teacher teacher = (Teacher) iterate.next();
			
		}
	}*/
	/**
	 * 验证 如果缓存你中没有数据 iterator 回去查数据库
	 */
	@Test
	public void test05(){
		//先获取两条数据的信息
		Teacher teacher = (Teacher)session.get(Teacher.class, 1);
		Teacher teacher1 = (Teacher) session.get(Teacher.class, 2);
		String hql="from Teacher";
		Iterator<Teacher> iterator = session.createQuery(hql).iterate();
		while (iterator.hasNext()) {
			Teacher t =iterator.next();
			System.out.println(t);
			
		}
	}
}
