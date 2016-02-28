package com.ijoy.common.comutil;

import org.apache.commons.lang.RandomStringUtils;

import com.ijoy.common.domain.Employee;
import com.ijoy.gh.domain.Schedule;

public class HttpYY {

	public static String  sendData(Employee employee, Schedule schedule) {
			return String.valueOf(RandomStringUtils.randomNumeric(8));
	}

}
