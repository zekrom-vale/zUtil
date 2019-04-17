package functions;

@SuppressWarnings("javadoc")
@FunctionalInterface
public interface QuFunction <A, B, C, D, R>{
	R apply(A a, B b, C c, D d);
}
