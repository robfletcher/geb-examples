package examples

import geb.Page
import geb.Module

class IndexPage extends Page {

	static url = "http://localhost:8080/"
	static at = { title == "Geb Example Page" }

	static content = {
		recentBooks { $("#recent-books ol li")*.text() }
		popularBooks { $("#popular-books ol li")*.text() }
		booksByAuthor { module BookTable, $("#books-by-author table") }
	}
}

class BookTable extends Module {
	static content = {
		row { i -> module BookRow, $("tbody tr", i) }
		rows {
			$("tbody tr").collect {
				module BookRow, it
			}
		}
	}

	int size() {
		$("tbody tr").size()
	}
}

class BookRow extends Module {

	static content = {
		cell { i -> $("td", i) }
		title { cell(0).text() }
		author { cell(1).text() }
		format { cell(2).text() }
		price {
			use(NumberExtractionCategory) {
				cell(3).text().findNumeric(/£(\d+\.\d+)/)
			}
		}
		releaseDate { cell(4).text() }
	}
}

@Category(String)
class NumberExtractionCategory {

	Number findNumeric(regex, int group = 1) {
		def matcher = this =~ regex
		if (matcher.find()) {
			def n = matcher[0][group]
			n.contains(".") ? n.toBigDecimal() : n.toInteger()
		} else {
			null
		}
	}

}