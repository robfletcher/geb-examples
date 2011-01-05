package examples.pages

import geb.Page
import examples.modules.AuthModule

class HomePage extends Page {

	static url = "/"
	static at = { title == "Geb Example Page" }

	static content = {
		// li elements converted to List<String>
		recentBooks { $("#recent-books ol li")*.text() }
		popularBooks { $("#popular-books ol li")*.text() }

		// reusable module that appears on many pages
		authModule { module AuthModule, $("aside#auth") }
	}
}
