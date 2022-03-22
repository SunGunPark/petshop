package com.spring.petshop.common.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
//	@Before("execution(* com.spring.pro27.*.service.*.*(..)) or "
//			+ " execution(* com.spring.pro27.*.dao.*.*(..))")
	@AfterReturning("execution(* com.spring.pro27.*.service.*.*(..)) or "
			+ " execution(* com.spring.pro27.*.dao.*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("------------------------------------");
		logger.info("------------------------------------");
		
		logger.info("1 : " + Arrays.toString(jp.getArgs())); // �Ķ���� ����
		logger.info("2 : " + jp.getKind()); // advice Ÿ��
		logger.info("3 : " + jp.getSignature().getName()); // �޼ҵ� ����
		logger.info("4 : " + jp.getTarget().toString()); // target ��ü
		logger.info("5 : " + jp.getThis().toString()); // advice ��ü
	}
	
	@Around("execution(* com.spring.pro27.*.service.*.*(..)) or "
			+ " execution(* com.spring.pro27.*.dao.*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		// �޼��� ���� �ð�
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		long endTime = System.currentTimeMillis();
		// �޼��� ���� �ð�
		logger.info(pjp.getSignature().getName() + " : " + (endTime -startTime));
		// ���� ���� �ð�
		logger.info("=====================================");
		
		return result; // Around �� ����� ��� �ݵ�� Object ���� ����� �Ѵ�.
	}
}
