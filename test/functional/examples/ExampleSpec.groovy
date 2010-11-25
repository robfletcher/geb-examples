package examples

import grails.plugin.geb.GebSpec

class ExampleSpec extends GebSpec {

	def "confirm contents of a list"() {
		given:
		to IndexPage

		expect:
		recentBooks == ["Zero History", "Surface Detail", "The Machine of Death"]
		popularBooks == ["The Girl With The Dragon Tattoo", "The Girl Who Played With Fire", "The Girl Who Kicked The Hornet's Nest"]
	}

	def "confirm contents of a table"() {
		given:
		to IndexPage

		expect:
		booksByAuthor.size() == 4

		and:
		booksByAuthor.row(0).title == "Zero History"
		booksByAuthor.row(3).title == "Pattern Recognition"
		booksByAuthor.row(0).price == 12.29

		and:
		booksByAuthor.rows.title == ["Zero History", "Zero History", "Spook Country", "Pattern Recognition"]
		booksByAuthor.rows.every { it.author == "William Gibson" }
	}

	def "confirm non-logged in state"() {
		given:
		to IndexPage

		expect:
		!authModule.loggedIn
		authModule.username == null
	}

	def "can log in"() {
		given:
		to IndexPage

		when:
		authModule.form.username = "blackbeard"
		authModule.form.password = "yohoho!"
		authModule.loginButton.click()

		then:
		at IndexPage

		and:
		authModule.loggedIn
		authModule.username == "blackbeard"

		cleanup:
		authModule.logoutButton.click()
	}
}
