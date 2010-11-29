package examples.pages

import geb.Page
import examples.modules.BookTable
import examples.modules.AuthModule

/**
 * A first cut at modelling the search page. Here the results are an indexed
 * content property so the test needs to pass in the index of the row it's
 * interested in.
 */
class SearchPage1 extends Page {

	static url = "http://localhost:8080/book/search"
	static at = { title == "Book Search" }

	static content = {
		results { module BookTable, $("#book-results table") }

		// reusable module that appears on many pages
		authModule { module AuthModule }
	}
}
