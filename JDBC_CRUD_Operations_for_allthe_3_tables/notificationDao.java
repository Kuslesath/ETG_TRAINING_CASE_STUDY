package com.sonata.notificationDao;

import java.util.List;

import com.sonata.notificationModel.Notification;

public interface notificationDao {

	public int save(Object object);
	public List<Notification> getData();
	public int update(Object object);
	public int delete(Object object);
}
