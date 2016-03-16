package com.ijoy.yzjc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.LineStyle;
import com.ijoy.yzjc.domain.IncomeData;
import com.ijoy.yzjc.service.IncomeService;

@Service
public class IncomeServiceImpl  implements IncomeService{
	
	/**
	 * 模拟从数据库获取数据
	 *
	 * @return
	 */
	public List<IncomeData> getWeekData() {
	    List<IncomeData> list = new ArrayList<IncomeData>(7);
	    list.add(new IncomeData("09-16", 1L));
	    list.add(new IncomeData("09-17", 7L));
	    list.add(new IncomeData("09-18", 14L));
	    return list;
	}
	@Override
	public Option getAll() {
		List<IncomeData> list =getWeekData();
		
		Option option=new Option();
		//设置图表标题，并且居中显示
		option.title().text("最近7天访问量图表");

		//设置图例,居中底部显示，显示边框
		option.legend().data("访问量");

		

		//创建类目轴，并且不显示竖着的分割线，onZero=false
		CategoryAxis categoryAxis = new CategoryAxis();

		//创建Line数据
		Line line = new Line("访问量");

		//根据获取的数据赋值
		for (IncomeData data : list) {
		    //增加类目，值为日期
			
		    categoryAxis.data(data.getDate());

		    //日期对应的数据
		    line.data(data.getNums());
		}

		//设置x轴为类目轴
		option.xAxis(categoryAxis);
		option.yAxis(new ValueAxis().name("IP")
			    .axisLine(new AxisLine().show(true).lineStyle(new LineStyle().width(0))).max(400));

		//设置数据
		option.series(line);
		return option;
	}

}
