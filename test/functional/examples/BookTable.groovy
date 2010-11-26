package examples

import geb.Module

/**
 * A module representing a table with many rows. Each row is accessed by an indexed content property.
 */
class BookTable extends Module { 
	static content = {
		row { i -> module BookRow, $("tbody tr", i) }
		size { $("tbody tr").size() }
	}
}
