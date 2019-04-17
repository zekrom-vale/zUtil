package functions;

@SuppressWarnings("javadoc")
public class BiIndex{
	public interface Double <O>{
		double apply(double r, O o2, int i1, int i2);
	}
	public interface E <O>{
		O apply(O r, O o2, int i1, int i2);
	}
	public interface Int <O>{
		int apply(int r, O o2, int i1, int i2);
	}
	public interface Long <O>{
		long apply(long r, O o2, int i1, int i2);
	}
}
