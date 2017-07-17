package day624;

public class TT {
	private Shiyanlou l1;
	public Shiyanlou l2;
	private Shiyanlou l3;
	private Shiyanlou l4;
	private Shiyanlou l5;

	public void setL1(Shiyanlou l1) {
		this.l1 = l1;
	}

	public void setL2(Shiyanlou l2) {
		this.l2 = l2;
	}

	public void setL3(Shiyanlou l3) {
		this.l3 = l3;
	}

	public void setL4(Shiyanlou l4) {
		this.l4 = l4;
	}

	public void setL5(Shiyanlou l5) {
		this.l5 = l5;
	}

	public void ls(String name) {
		System.out.println(l1.toUp(name));
		System.out.println(l2.toUp(name));
		System.out.println(l3.toUp(name));
		System.out.println(l4.toUp(name));
		System.out.println(l5.toUp(name));
	}
}
