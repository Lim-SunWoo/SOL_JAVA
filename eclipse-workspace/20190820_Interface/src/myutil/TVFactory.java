package myutil;

public class TVFactory {
	// single-ton pattern
	static TVFactory single = null;

	public static TVFactory getInstance() {
		if (single == null)
			single = new TVFactory();
		return single;
	}

	public RemoteCon createTV() {
		return new TV();
	}
}
