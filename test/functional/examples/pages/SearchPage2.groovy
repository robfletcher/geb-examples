package examples.pages

import geb.Page
import examples.modules.BookRow
import examples.modules.AuthModule

/**
 * A different way to model the search page - here the search results
 * are a List<BookRow> which enables much richer manipulation in tests.
 */
class SearchPage2 extends Page {

	static url = "http://localhost:8080/search"
	static at = { title == "Book Search" }

	static content = {
		results {
			$("#book-results table tbody tr").collect {
				module BookRow, it
			}
		}

		// reusable module that appears on many pages
		authModule { module AuthModule }
	}
}
