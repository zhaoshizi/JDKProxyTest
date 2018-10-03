//要想输出输出的.class文件，在运行时加上jvm参数	-javaagent:XXX/jagent.jar
//上面XXX为路径
package proxytest;

public class TestProxy{
	public static void main(String args[]) {
		
		HuangNiuProxy huangNiu = new HuangNiuProxy();
		//绑定关系
		People proxy = (People)huangNiu.bind(new Passenger());
		System.out.println("proxy:" + proxy.getClass().getName());
		proxy.buyTickets("train").buyTickets("bus");
	}
}