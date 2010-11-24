package examples

import geb.Page
import geb.Module

class IndexPage extends Page {

	static url = "http://localhost:8080/"
	static at = { title == "Geb Example Page" }

	static content = {
		recentBooks { $("#recent-books ol li")*.text() }
		popularBooks { $("#popular-books ol li")*.text() }
		booksByAuthor { i ->
			module BookRow, $("#books-by-author table tbody tr", i)
		}
	}

}

class BookRow extends Module {

	static content = {
		cell { i -> $("td", i) }
		title { cell(0).text() }
		author { cell(1).text() }
		format { cell(2).text() }
		price { cell(3).text() }
		releaseDate { cell(4).text() }
	}

}