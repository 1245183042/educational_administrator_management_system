package com.edu.util;

import java.util.Random;

public class RandomUtil {
	public static String getRandom(){
		String value = String.valueOf(Math.abs(new Random().nextInt()));
		if(value.length() == 9){
			value += 0;
		}
		return value;
	}
}
