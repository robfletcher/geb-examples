package examples.modules

import geb.Module

class Pagination extends Module {

	static content = {
		links(required: false) { $("a") }
		currentPage(required: false) { $(".currentStep")?.text()?.toInteger() ?: 1 }
		nextLink(required: false) { links.filter(".nextLink") }
		previousLink(required: false) { links.filter(".prevLink") }
	}

	void toPage(int pageNumber) {
		def link = links.filter(text: "$pageNumber")
		if (!link) throw new IllegalArgumentException("Page number $pageNumber not present in pagination")
		link.click()
	}

	void next() {
		nextLink.click()
	}

	void previous() {
		previousLink.click()
	}

	boolean isFirstPage() {
		previousLink.empty
	}

	boolean isLastPage() {
		nextLink.empty
	}
}
