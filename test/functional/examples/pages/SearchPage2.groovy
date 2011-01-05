package examples.pages

import geb.Page
import examples.modules.BookRow
import examples.modules.AuthModule
import examples.modules.Pagination

/**
 * A different way to model the search page - here the search results
 * are a List<BookRow> which enables much richer manipulation in tests.
 */
class SearchPage2 extends Page {

	static url = "/book/search"
	static at = { title == "Book Search" }

	static content = {
		results {
			$("#book-results table tbody tr").collect {
				module BookRow, it
			}
		}

		pagination {
			module Pagination, $("nav.pagination")
		}

		// reusable module that appears on many pages
		authModule { module AuthModule, $("aside#auth") }
	}
}
