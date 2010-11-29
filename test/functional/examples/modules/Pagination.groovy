package examples.modules

import geb.Module

class Pagination extends Module {

	static content = {
		links { $("a") }
		currentPage { $(".currentStep").text().toInteger() }
	}

}
