package jp.wakui.spring.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBeanAspect {
	
	@Before("execution(* jp.wakui.spring.aop1.IMyBean.addData(..))")
	public void addDataBefore(JoinPoint joinpoint) {
		System.out.println("*addData before...");
		String args = "args: \"";
		
		for(Object ob:joinpoint.getArgs()) {
			args += ob + " \" ";
		}
		
		System.out.println(args);
	}
	@Around("execution (* jp.wakui.spring.aop1.IMyBean.addData(..))")
	public void toStringAround(ProceedingJoinPoint joinpoint) {
		System.out.println("*addData around");
		System.out.println("before:" + joinpoint.getTarget());
		try {
			joinpoint.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("after:" + joinpoint.getTarget());
		System.out.println("*..end around addData.*");
	}
}
