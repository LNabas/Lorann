package main;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		final Model model = new Model();
		/**
		 * View
		 */
		final View view = new View(model);
		/**
		 * Controller
		 */
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
	}
}