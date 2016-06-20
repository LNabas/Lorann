package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class DBProperties.
 *
 * @author Jean-Aymeric Diet
 */
class DBProperties extends Properties {

	/** The Constant serialVersionUID. */
	private static final long		serialVersionUID			= 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/**
	 * The url.
	 * @uml.property  name="url"
	 */
	private String							url										= "";

	/**
	 * The login.
	 * @uml.property  name="login"
	 */
	private String							login									= "";

	/**
	 * The password.
	 * @uml.property  name="password"
	 */
	private String							password							= "";

	/**
	 * Instantiates a new DB properties.
	 */
	public DBProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
		}
	}

	/**
	 * Gets the url.
	 * @return  the url
	 * @uml.property  name="url"
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 * @param url  the new url
	 * @uml.property  name="url"
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the login.
	 * @return  the login
	 * @uml.property  name="login"
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets the login.
	 * @param login  the new login
	 * @uml.property  name="login"
	 */
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * @return  the password
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 * @param password  the new password
	 * @uml.property  name="password"
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

}
