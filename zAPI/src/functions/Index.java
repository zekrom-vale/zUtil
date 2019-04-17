package functions;

@SuppressWarnings("javadoc")
public class Index{
	public interface Double <O>{
		double apply(double r, O o, int i1);
	}
	public interface E <O>{
		O apply(O r, O o, int i1);
	}
	public interface Int <O>{
		int apply(int r, O o, int i1);
	}
	public interface Long <O>{
		long apply(long r, O o, int i1);
	}
}