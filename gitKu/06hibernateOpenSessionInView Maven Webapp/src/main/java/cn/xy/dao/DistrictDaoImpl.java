package cn.xy.dao;

import java.io.Serializable;
import org.hibernate.classic.Session;
import cn.xy.bean.District;
import cn.xy.util.SessionFactoryUtil;

public class DistrictDaoImpl implements DistrictDao {

	public District getDistrictById(Serializable id) {
		Session session = SessionFactoryUtil.getCurrentSession();
		session.beginTransaction();
		District district=(District) session.load(District.class, id);
		System.out.println("DaoImpl中的"+session.hashCode());
		return district;
	}
}
