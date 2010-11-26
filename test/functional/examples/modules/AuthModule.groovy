package examples.modules

import geb.Module
import examples.pages.HomePage

/**
 * An example of a reusable module that would appear on many pages. The module defines its own `base` context and can
 * exist in 2 different states depending on whether a user is logged in or not.
 */
class AuthModule extends Module {

	static base = { $("aside#auth") }

	static content = {
		// elements present if the user is logged in
		username(required: false) { $(".username").text() }
		logoutButton(required: false, to: HomePage) { $("a[name=logout]") }

		// elements present if the user is not logged in
		form(required: false) { $("form") }
		loginButton(required: false, to: HomePage) { $("button[name=login]") }
	}

	boolean isLoggedIn() {
		username
	}

	void login(String username, String password = "password") {
		if (loggedIn) throw new IllegalStateException("already logged in")
		form.username = username
		form.password = password
		loginButton.click()
	}

	void logout() {
		if (!loggedIn) throw new IllegalStateException("already logged out")
		logoutButton.click()
	}
}
