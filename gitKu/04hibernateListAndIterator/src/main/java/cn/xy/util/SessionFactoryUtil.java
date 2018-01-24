package cn.xy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 整个项目 只需要一个SessionFactory 就够了 
 * 所以创建单例模式
 * @author lenovo
 *
 */
public class SessionFactoryUtil {
	 private  static Configuration configuration;  //加载核心配置文件的类
	    private  static SessionFactory factory;  //单例对象

	    //在类加载的时候  指定静态代码块
	    static{
	        configuration=new Configuration().configure();  //默认加载项目根目录下的hibernate.cfg.xml
	        factory=configuration.buildSessionFactory();
	    }

	    //通过sessionFactory 创建session
	    public static Session  getCurrentSession(){
	        return  factory.getCurrentSession();
	        /**
	         *  不能直接用  需要在核心配置文件中增加一个节点
	         <property name="current_session_context_class">thread</property>
	         */
	    }
}
