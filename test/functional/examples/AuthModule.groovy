package examples

import geb.Module

/**
 * An example of a reusable module that would appear on many pages. The module defines its own `base` context and can
 * exist in 2 different states depending on whether a user is logged in or not.
 */
class AuthModule extends Module {

	static base = { $("aside#auth") }

	static content = {
		// elements present if the user is logged in
		username(required: false) { $(".username").text() }
		logoutButton(required: false, to: IndexPage) { $("a[name=logout]") }

		// elements present if the user is not logged in
		form(required: false) { $("form") }
		loginButton(required: false, to: IndexPage) { $("button[name=login]") }
	}

	boolean isLoggedIn() {
		username
	}
}
