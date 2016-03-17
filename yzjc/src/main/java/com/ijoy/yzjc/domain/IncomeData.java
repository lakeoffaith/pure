package com.ijoy.yzjc.domain;

public class IncomeData {
	 //日期
    private String date;
    //访问量
    private Long nums;

    public IncomeData(String date, Long nums) {
        this.date = date;
        this.nums = nums;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getNums() {
		return nums;
	}

	public void setNums(Long nums) {
		this.nums = nums;
	}

}
