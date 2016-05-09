package com.android.website.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.website.beans.Person;
import com.android.website.utils.JsonTools;

public class JsonTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msg = "";
		// 带有三个属性的person对象
		Person person = getPerson();
		msg = JsonTools.createJsonString("person", person);
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放两个person对象,这两个对象有各自的三个属性
		msg = JsonTools.createJsonString("persons", getListPerson());
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放三个字符串
		msg = JsonTools.createJsonString("listString", getListString());
		System.out.println(msg);

		System.out.println("------------------------------");
		// List中存放两个Map，两个Map中分别存放三个不同的属性
		msg = JsonTools.createJsonString("listMap", getListMaps());
		System.out.println(msg);
	}
	
	public static Person getPerson() {
		Person person = new Person(23, "AHuier", "XIAMEN");
		return person;
	}

	public static List<Person> getListPerson() {
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person(1001, "AHuier1", "Beijing");
		Person person2 = new Person(1002, "AHuier2", "shenzheng");
		list.add(person1);
		list.add(person2);
		return list;
	}

	public static List<String> getListString() {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("AHuier");
		return list;
	}

	public static List<Map<String, Object>> getListMaps() {
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("color", "red");
		map1.put("id", 01);
		map1.put("name", "Polu");
		listMap.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 07);
		map2.put("color", "green");
		map2.put("name", "Zark");
		listMap.add(map2);
		return listMap;
	}
}
