package com.ijoy.common.comutil;

import org.springframework.stereotype.Component;

/**
 * 系统日志工具
 *
 */
@Component
public class SystemLogUtils {/*
	@Autowired
	private ISystemLogSerivce systemLogSerivce;
	@Autowired
	private UserContext userContext;
//	public void setSystemLogSerivce(ISystemLogSerivce systemLogSerivce) {
//		this.systemLogSerivce = systemLogSerivce;
//	}
//	
	public void writerLog(JoinPoint joinPoint){
//		System.out.println("=====================================");
//		System.out.println(joinPoint.getKind());//method-execution
//		System.out.println(joinPoint.getTarget().getClass());//class cn.itsource.group7.crm.service.impl.MenuServiceImpl
//		System.out.println(joinPoint.getThis().getClass());//class com.sun.proxy.$Proxy20
//		System.out.println(Arrays.asList(joinPoint.getArgs()));//[]
//		System.out.println(joinPoint.getClass());//class org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
//		System.out.println(joinPoint.getSignature());//PageResult cn.itsource.group7.crm.service.IEmployeeSerivce.query(EmployeeQuery)
//		System.out.println(joinPoint.getSourceLocation());//org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@4fd82f5
//		System.out.println(joinPoint.getStaticPart());//execution(PageResult cn.itsource.group7.crm.service.IEmployeeSerivce.query(EmployeeQuery))
//		System.out.println("=====================================");
		Object serviceObj = joinPoint.getTarget();
		System.out.println(serviceObj);
		Class serviceClz = joinPoint.getTarget().getClass();
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		String methodName = joinPoint.getSignature().getName();
		if (serviceObj instanceof ISystemLogSerivce) {
			return;
		}
		
		*//**
		 * 通过aop进入到该方法中,就new一个日志对象,设置对象的参数,把该日志对象添加到数据库红
		 *//*
		//创建日志对象
		SystemLog systemLog = new SystemLog();
//		//封装日志属性
		System.out.println("========================="+ userContext.getUser());
		
		Employee employee =userContext.getUser();
		if(employee==null){
			return;
		}
		systemLog.setOpUser(employee);
		systemLog.setOpIp(userContext.getRequestIp());
		*//**
		 * 要获取方法名,需要上下文,我们从req和resp中获取不到,那么需要spring传递给我们
		 * 因为调用该方法是aop自动调用的
		 * 
		 *//*
		systemLog.setFunction(serviceClz.getName()+":"+methodName);
		//保存到数据库
		systemLogSerivce.save(systemLog);
	}
	public ISystemLogSerivce getSystemLogSerivce() {
		return systemLogSerivce;
	}
	public void setSystemLogSerivce(ISystemLogSerivce systemLogSerivce) {
		this.systemLogSerivce = systemLogSerivce;
	}
	
*/}
