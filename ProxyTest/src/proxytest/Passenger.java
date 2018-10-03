package proxytest;

public class Passenger implements People{
	public People buyTickets(String trafficTool) {
		System.out.println("I am a prssenger.");
		System.out.println("I buy tickets of the " + trafficTool);
		return this;
	}
}