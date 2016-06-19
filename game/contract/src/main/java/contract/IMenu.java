package contract;

public interface IMenu extends Cloneable{
	/**
	 * Change Button State
	 * @param posMenu pos of the menu
	 * @param state ButtonState
	 */
	void changeButtonState(int posMenu, ButtonState state);
	/**
	 * Change Button State
	 * @param name name of the button
	 * @param state ButtonState
	 */
	public void changeButtonState(String name, ButtonState state);
	/**
	 * get ButtonState of a button
	 * @param pos pos in the menu
	 * @return ButtonState
	 */
	public ButtonState getButtonState(int pos);
}
