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
		booksByAuthor(0).title == "Zero History"
		booksByAuthor(1).title == "Zero History"
		booksByAuthor(2).title == "Spook Country"
		booksByAuthor(3).title == "Pattern Recognition"
	}
}
