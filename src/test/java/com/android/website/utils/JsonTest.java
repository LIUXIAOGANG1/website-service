package com.android.website.utils;

import com.android.website.beans.Person;
import com.android.website.service.JsonService;
import com.android.website.utils.JsonTools;

public class JsonTest {
	public JsonTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "";
		JsonService service = new JsonService();
		// 带有三个属性的person对象
		Person person = service.getPerson();
		msg = JsonTools.createJsonString("person", person);
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放两个person对象,这两个对象有各自的三个属性
		msg = JsonTools.createJsonString("persons", service.getListPerson());
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放三个字符串
		msg = JsonTools.createJsonString("listString", service.getListString());
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放两个Map，两个Map中分别存放三个不同的属性
		msg = JsonTools.createJsonString("listMap", service.getListMaps());
		System.out.println(msg);
	}
}
