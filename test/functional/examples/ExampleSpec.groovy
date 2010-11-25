package examples

import grails.plugin.geb.GebSpec

class ExampleSpec extends GebSpec {

	def "handle HTML lists as a list of Strings"() {
		given:
		to IndexPage

		expect:
		recentBooks == ["Zero History", "Surface Detail", "The Machine of Death"]
		popularBooks == ["The Girl With The Dragon Tattoo", "The Girl Who Played With Fire", "The Girl Who Kicked The Hornet's Nest"]
	}

	def "handle a table as an indexed content property"() {
		given:
		to IndexPage

		expect:
		bookTable.size() == 4

		and:
		bookTable.row(0).title == "Zero History"
		bookTable.row(3).title == "Pattern Recognition"
		bookTable.row(0).price == 12.29
	}

	def "handle a table as a list of Modules"() {
		given:
		to IndexPage

		expect:
		books.size() == 4

		and:
		books.title == ["Zero History", "Zero History", "Spook Country", "Pattern Recognition"]
		books.every { it.author == "William Gibson" }
		books.price.sum() == 34.27
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
