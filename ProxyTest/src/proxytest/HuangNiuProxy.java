package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuangNiuProxy implements InvocationHandler{
	//��ʵ����
	private Object target = null;
	
	/**
	 * �������������ʵ��������ϵ�������ش������
	 * @param target ��ʵ����
	 * @return �������
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		
	}
	
	/*
	 * �������߼�
	 * @param proxy �������
	 * @param method ��ǰ���Է���
	 * @param args ��ǰ��������
	 * @return �����������
	 * @throws Throwable �쳣
	 */
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		System.out.println("I am a HuangNiu. I can buy tickets for passengers.");
		System.out.println("I am belong to " + this.getClass().getName());
		System.out.println("I take more money.");
		System.out.println("Method: " + method);
		Object obj = method.invoke(target, args);
		System.out.println("I am a HuangNiu. I give passenger the tickets.");
		//���Է��ش������
		return proxy;
		//Ҳ���Է���method����ֵ
		//return obj;
	}
}