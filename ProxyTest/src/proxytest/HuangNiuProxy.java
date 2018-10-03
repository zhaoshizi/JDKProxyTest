package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuangNiuProxy implements InvocationHandler{
	//真实对象
	private Object target = null;
	
	/**
	 * 建议代理对象和真实对象代理关系，并返回代理对象
	 * @param target 真实对象
	 * @return 代理对象
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		
	}
	
	/*
	 * 代理方法逻辑
	 * @param proxy 代理对象
	 * @param method 当前调试方法
	 * @param args 当前方法参数
	 * @return 代理结束返回
	 * @throws Throwable 异常
	 */
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		System.out.println("I am a HuangNiu. I can buy tickets for passengers.");
		System.out.println("I am belong to " + this.getClass().getName());
		System.out.println("I take more money.");
		System.out.println("Method: " + method);
		Object obj = method.invoke(target, args);
		System.out.println("I am a HuangNiu. I give passenger the tickets.");
		//可以返回代理对象
		return proxy;
		//也可以返回method返回值
		//return obj;
	}
}