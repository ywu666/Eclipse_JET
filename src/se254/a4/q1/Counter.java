package se254.a4.q1;
//@formatter:off
public class Counter {
	public int c;
	public int d;
	public String e;
	public void increment() { c++; }

	public boolean decrement() { return false; }

	public int reset() { c = 0;  return c;}
	
	private String get(){return "abc";}
}
//@formatter:on