package examples

import grails.plugin.geb.GebSpec

class NonPageObjectSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.baseUrl ?: "http://localhost:8080"
	}

	def "navigate to a page and validate it has loaded"() {
		when:
		go "/"

		then:
		title == "Geb Example Page"
	}

	def "treat Geb Navigator as a collection"() {
		given:
		go "/"

		expect:
		$("#recent-books ol li")*.text() == ["Zero History", "Surface Detail", "The Machine of Death"]
		$("#popular-books ol li")*.text() == ["The Girl With The Dragon Tattoo", "The Girl Who Played With Fire", "The Girl Who Kicked The Hornet's Nest"]
	}

	def "fill in a form"() {
		given:
		go "/"

		when:
		$("#auth form").username = "blackbeard"
		$("#auth form").password = "yarrr!!!!1"
		$("button[name=login]").click()

		then:
		$("#auth").text() =~ /^Welcome back blackbeard/
	}

	def "fill in different form controls"() {
		given:
		go "/form.gsp"

		when:
		def form = $("form")
		form.textfield = "I has a bukkit!"
		form.selectfield = "2"
		form.multiselectfield = ["2", "4"]
		form.radiogroup = "2"
		form.checkbox1 = false
		form.checkbox2 = true
		form.textarea = "Lorem ipsum dolor sit amet"

		then:
		form.textfield == "I has a bukkit!"
		form.selectfield == ["2"]
		form.multiselectfield == ["2", "4"]
		form.radiogroup == "2"
		!form.checkbox1
		form.checkbox2
		form.textarea == "Lorem ipsum dolor sit amet"
	}
}
