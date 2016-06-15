package contract;

public interface IMenu {
	void changeButtonState(String name, ButtonState state);
	void changeButtonState(int pos, ButtonState state);
}
