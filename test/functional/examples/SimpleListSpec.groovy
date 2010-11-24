package examples

import grails.plugin.geb.GebSpec

class SimpleListSpec extends GebSpec {

	def "confirm contents of a list"() {
		given:
		to IndexPage

		expect:
		recentBooks == ["Zero History", "Surface Detail", "The Machine of Death"]
		popularBooks == ["The Girl With The Dragon Tattoo", "The Girl Who Played With Fire", "The Girl Who Kicked The Hornet's Nest"]
	}
}
