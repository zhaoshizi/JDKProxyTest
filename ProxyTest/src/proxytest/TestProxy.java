//Ҫ����������.class�ļ���������ʱ����jvm����	-javaagent:XXX/jagent.jar
//����XXXΪ·��
package proxytest;

public class TestProxy{
	public static void main(String args[]) {
		
		HuangNiuProxy huangNiu = new HuangNiuProxy();
		//�󶨹�ϵ
		People proxy = (People)huangNiu.bind(new Passenger());
		System.out.println("proxy:" + proxy.getClass().getName());
		proxy.buyTickets("train").buyTickets("bus");
	}
}