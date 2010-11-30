package examples

import examples.pages.SearchPage2
import grails.plugin.geb.GebSpec
import spock.lang.Stepwise

@Stepwise
class StatefulModuleSpec extends GebSpec {

	def "user sees first page of search results"() {
		when:
		to SearchPage2

		then:
		results.size() == 5
		pagination.currentPage == 1
		pagination.firstPage
		!pagination.lastPage
	}

	def "user navigates to 2nd page of results"() {
		when:
		pagination.toPage(2)

		then:
		at SearchPage2
		results.size() == 5
		pagination.currentPage == 2
		!pagination.firstPage
		!pagination.lastPage
	}

	def "user navigates to last page of results"() {
		when:
		pagination.toPage(3)

		then:
		at SearchPage2
		results.size() == 1
		pagination.currentPage == 3
		!pagination.firstPage
		pagination.lastPage
	}

	def "user navigates back to 1st page of results"() {
		when:
		pagination.toPage(1)

		then:
		at SearchPage2
		results.size() == 5
		pagination.currentPage == 1
	}

	def "user uses next button to go to 2nd page"() {
		when:
		pagination.next()
		
		then:
		at SearchPage2
		results.size() == 5
		pagination.currentPage == 2
	}

	def "user uses previous button to go back to 1st page"() {
		when:
		pagination.previous()

		then:
		at SearchPage2
		results.size() == 5
		pagination.currentPage == 1
	}

}
