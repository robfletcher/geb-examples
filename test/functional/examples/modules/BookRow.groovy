package examples.modules

import geb.Module
import java.text.SimpleDateFormat

/**
 * A module representing the cells in a single row of a table.
 */
class BookRow extends Module {
	static content = {
		// generic cell accessor that takes an index
		cell { i -> $("td", i) }

		// meaningfully named and typed properties representing the data in each cell
		title { cell(0).text() }
		author { cell(1).text() }
		format { cell(2).text() }
		price { cell(3).text()[1..-1].toBigDecimal() }
		releaseDate { new SimpleDateFormat("d MMM yyyy").parse(cell(4).text()) }
	}
}
