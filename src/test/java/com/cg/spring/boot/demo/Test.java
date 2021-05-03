package com.cg.spring.boot.demo;

import java.io.*;
import java.util.*;

public class Test {
	public static void main(String... args) throws Exception {

		Set<String> tSet = new TreeSet<>();
		tSet.add("one");
		tSet.add("two");
		tSet.add("three");
		tSet.add("four");
		System.out.println(tSet);
	}
}