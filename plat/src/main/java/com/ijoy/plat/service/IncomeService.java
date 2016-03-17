package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.query.IncomeQuery;

public interface IncomeService  {
		/**
		 * 通过incomeQuery去获取时间和收入的map的list.
		 */
		public List  queryIncome(IncomeQuery incomeQuery);
}
