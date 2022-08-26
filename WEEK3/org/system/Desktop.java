package org.system;

public class Desktop extends Computer{
	public void desktopSize()
	{
		System.out.println("Desktop size 32IN");
	}

	public static void main (String[] args) {
		Desktop desk = new Desktop();
		desk.desktopSize();
		
		Computer comp = new Computer();
		comp.computerModel();
	}
}
