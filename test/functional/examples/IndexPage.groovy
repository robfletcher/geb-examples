package examples

import geb.Page

class IndexPage extends Page {

	static url = "http://localhost:8080/"
	static at = { title == "Geb Example Page" }

	static content = {
		// li elements converted to List<String>
		recentBooks { $("#recent-books ol li")*.text() }
		popularBooks { $("#popular-books ol li")*.text() }

		// reusable module that appears on many pages
		authModule { module AuthModule }
	}
}
