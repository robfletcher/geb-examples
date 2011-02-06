package examples

import grails.plugin.geb.GebSpec

class AjaxSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.baseUrl ?: "http://localhost:8080"
	}

	def setupSpec() {
		go "/ajax.gsp"
	}

	def "can trigger AJAX calls and wait for content to load"() {
		when:
		def form = $("#search-form form")
		form.q = "David Bowie"
		form.find("button").click()

		then:
		waitFor { !$(".ajax-loading") }
		$("#search-results").text() == "You searched for 'David Bowie'"
	}

	def "can interact with Javascript variables in the page"() {
		when:
		def form = $("#search-form form")
		form.q = "Bauhaus"
		form.find("button").click()

		then:
		waitFor { js.ajaxCount == 0 }
		$("#search-results").text() == "You searched for 'Bauhaus'"
	}

	def "can call Javascript methods in the page"() {
		when:
		def form = $("#search-form form")
		form.q = "The Clash"
		form.find("button").click()

		then:
		waitFor { js.isAjaxComplete() }
		$("#search-results").text() == "You searched for 'The Clash'"
	}

}
