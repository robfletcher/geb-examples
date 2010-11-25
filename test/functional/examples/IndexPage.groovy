package examples

import geb.Page
import geb.Module

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
		authModule { module AuthModule }
	}
}

class BookTable extends Module {
	static content = {
		row { i -> module BookRow, $("tbody tr", i) }
		size { $("tbody tr").size() }
	}
}

class BookRow extends Module {
	static content = {
		cell { i -> $("td", i) }
		title { cell(0).text() }
		author { cell(1).text() }
		format { cell(2).text() }
		price { cell(3).text()[1..-1].toDouble() }
		releaseDate { cell(4).text() }
	}
}

class AuthModule extends Module {

	static base = { $("aside#auth") }

	static content = {
		username(required: false) { $(".username").text() }
		form(required: false) { $("form") }
		loginButton(required: false, to: IndexPage) { $("button[name=login]") }
		logoutButton(required: false, to: IndexPage) { $("a[name=logout]") }
	}

	boolean isLoggedIn() {
		username
	}
}
