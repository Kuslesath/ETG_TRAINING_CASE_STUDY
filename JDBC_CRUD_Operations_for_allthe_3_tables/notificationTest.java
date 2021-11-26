package com.sonata.notificationMain;

import java.util.ArrayList;
import java.util.List;

import com.sonata.notificationDaoImpl.notificationDaoImpl;
import com.sonata.notificationModel.Notification;

public class notificationTest {

	public static void main(String args[]) throws Exception{
		
		
		Notification e = new Notification();
		e.setTaskid(1);
		e.setTaskownerid(100);
		e.setNid(500);
		e.setStatus("pending");
		e.setCreated_on("2021-11-11 12:23:45");
		e.setStatus_changed_on("2021-11-11 12:23:45");
		
		notificationDaoImpl d= new notificationDaoImpl();
		int row = d.save(e);
		System.out.println(row);
		
		List<Notification> e1=new ArrayList<>();
		e1=d.getData();
		for(Notification f:e1) {
			System.out.println(f.getNid()+" "+f.getTaskid()+" "+f.getTaskownerid()+" "+f.getStatus()+" "+f.getCreated_on()+" "+f.getStatus_changed_on());
			System.out.println();
		}
		
		row=d.update(e);
		System.out.println(row);
		
		int row1=d.delete(e);
		System.out.println(row1);
		
		}
}
