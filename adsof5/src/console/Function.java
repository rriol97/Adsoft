package console;

@FunctionalInterface
public interface Function {
	void execute(String ...args) throws IllegalArgumentException;
}
