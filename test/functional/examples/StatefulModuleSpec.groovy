package examples

import grails.plugin.geb.GebSpec
import examples.pages.SearchPage2

class StatefulModuleSpec extends GebSpec {

	def "user sees first page of search results"() {
		when:
		to SearchPage2

		then:
		results.size() == 10
		pagination.currentPage == 1
	}

	def "user navigates to 2nd page of results"() {
		given:
		to SearchPage2

		when:
		pagination.toPage(2)

		then:
		results.size() == 1
		pagination.currentPage == 2
	}

}
