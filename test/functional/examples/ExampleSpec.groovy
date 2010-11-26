package examples

import grails.plugin.geb.GebSpec

class ExampleSpec extends GebSpec {

	def "handle HTML lists as a list of Strings"() {
		given:
		to HomePage

		expect:
		recentBooks == ["Zero History", "Surface Detail", "The Machine of Death"]
		popularBooks == ["The Girl With The Dragon Tattoo", "The Girl Who Played With Fire", "The Girl Who Kicked The Hornet's Nest"]
	}

	def "handle a table as an indexed content property"() {
		given:
		to SearchPage1

		expect:
		results.size() == 4

		and:
		results.row(0).title == "Zero History"
		results.row(3).title == "Pattern Recognition"
		results.row(0).price == 12.29
	}

	def "handle a table as a list of Modules"() {
		given:
		to SearchPage2

		expect:
		results.size() == 4

		and:
		results.title == ["Zero History", "Zero History", "Spook Country", "Pattern Recognition"]
		results.every { it.author == "William Gibson" }
		results.price.sum() == 34.27
	}

	def "confirm non-logged in state"() {
		given:
		to HomePage

		expect:
		!authModule.loggedIn
		authModule.username == null
	}

	def "can log in"() {
		given:
		to HomePage

		when:
		authModule.form.username = "blackbeard"
		authModule.form.password = "yohoho!"
		authModule.loginButton.click()

		then:
		at HomePage

		and:
		authModule.loggedIn
		authModule.username == "blackbeard"

		cleanup:
		authModule.logoutButton.click()
	}
}
