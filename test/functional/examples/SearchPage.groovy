package examples

import geb.Page

class SearchPage extends Page {

	static url = "http://localhost:8080/search"
	static at = { title == "Book Search" }

	static content = {
		// 2 different ways to approach a table of data
		bookTable { module BookTable, $("#book-results table") }
		books {
			$("#book-results table tbody tr").collect {
				module BookRow, it
			}
		}

		// reusable module that appears on many pages
		authModule { module AuthModule }
	}
}
