package examples

class BookController {

    def search = {
		params.max = Math.min(params.max ? params.int('max') : 5, 100)
		if (!params.sort) {
			params.sort = "releaseDate"
			params.order = "desc"
		}
		def books = Book.list(params)
		[books: books]
	}
}
