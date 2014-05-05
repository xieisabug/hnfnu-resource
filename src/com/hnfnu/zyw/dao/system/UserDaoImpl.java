package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserDto> implements IUserDao {

	public UserDto getUser(String hql) throws Exception {
		Query u = this.getSession().createQuery(hql);
		UserDto d = (UserDto) u.uniqueResult();
		return d;
	}

	public void updatePwd(int id, String newPassword) throws Exception {
		UserDto userDto = this.get(id);
		userDto.setPassword(newPassword);
		this.update(userDto);
	}

	public int addUserBalance(int count, String userIds) {
		Session session = this.getSession();
		String[] ids = null;
		if (userIds != null && !userIds.equals("")) {
			ids = userIds.split(";");
		} else {
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				UserDto s = this.get(id);
				s.setBalance(s.getBalance() + count);

				// 余额不能为负数
				if (s.getBalance() < 0) {
					t.rollback();
					return -1;
				}
				// 余额不能超过整数范围
				if (s.getBalance() > 1000000000) {
					return -2;
				}
				this.update(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public boolean addUsers(ArrayList<UserDto> users) {
		Session session = this.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < users.size(); i++) {
				UserDto s = users.get(i);
				this.add(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean editManyPassword(ArrayList<UserDto> users) {
		Session session = this.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < users.size(); i++) {
				UserDto s = users.get(i);
				this.update(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;

	}

	/**
	 * 批量给用户重置资源币，不管用户原有的资源币
	 */
	public int setUserBalance(int count, String userIds) {
		Session session = this.getSession();
		String[] ids = null;
		if (userIds != null && !userIds.equals("")) {
			ids = userIds.split(";");
		} else {
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				UserDto s = this.get(id);
				s.setBalance(count);

				// 余额不能为负数
				if (s.getBalance() < 0) {
					t.rollback();
					return -1;
				}
				// 余额不能超过整数范围
				if (s.getBalance() > 1000000000) {
					return -2;
				}
				this.update(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	/**
	 * 批量删除用户,0是删除不成功，1是成功
	 */
	public int deleteUsers(String userIds) {
		Session session = this.getSession();
		String[] ids = null;
		if (userIds != null && !userIds.equals("")) {
			ids = userIds.split(";");
		} else {
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				this.delete(id);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public int getTotalCount(String hql) {

		Query query = this.getSession().createQuery(hql);
		int count = ((Number) query.iterate().next()).intValue();
		return count;
	}

}
