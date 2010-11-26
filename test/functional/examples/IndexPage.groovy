package examples

import geb.Page

class IndexPage extends Page {

	static url = "http://localhost:8080/"
	static at = { title == "Geb Example Page" }

	static content = {
		// li elements converted to List<String>
		recentBooks { $("#recent-books ol li")*.text() }
		popularBooks { $("#popular-books ol li")*.text() }

		// 2 different ways to approach a table of data
		bookTable { module BookTable, $("#books-by-author table") }
		books {
			$("#books-by-author table tbody tr").collect {
				module BookRow, it
			}
		}

		// reusable module that appears on many pages
		authModule { module AuthModule }
	}
}
