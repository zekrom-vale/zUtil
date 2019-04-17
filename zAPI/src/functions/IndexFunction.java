package functions;

@SuppressWarnings("javadoc")
public interface IndexFunction <O>{
	long apply(long r, O o, int i1);
}