package examples

import grails.plugin.geb.GebSpec
import spock.lang.Stepwise
import examples.pages.HomePage
import examples.pages.SearchPage2

@Stepwise
class ReusedModuleSpec extends GebSpec {

	def "user is initially not logged in"() {
		given:
		to HomePage

		expect:
		!authModule.loggedIn
	}

	def "user can log in"() {
		when:
		authModule.form.username = "blackbeard"
		authModule.form.password = "yohoho!"
		authModule.loginButton.click()

		then:
		at HomePage

		and:
		authModule.loggedIn
		authModule.username == "blackbeard"
	}

	def "login state is remembered on other pages"() {
		when:
		to SearchPage2

		then:
		authModule.loggedIn
		authModule.username == "blackbeard"
	}

	def "user can log out"() {
		when:
		authModule.logoutButton.click()

		then:
		at HomePage

		and:
		!authModule.loggedIn
	}

	def "user can log in using an action method on the module"() {
		when:
		authModule.login "roundhouse"

		then:
		authModule.loggedIn
		authModule.username == "roundhouse"
	}

	def "the action method raises an exception if the module is in an incorrect state"() {
		when:
		authModule.login "blackbeard"

		then:
		def e = thrown(IllegalStateException)
		e.message == "already logged in"
	}

	def "user can log out using an action method on the module"() {
		when:
		authModule.logout()

		then:
		!authModule.loggedIn
	}
}
