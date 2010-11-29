package examples

class BookController {

    def search = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (!params.sort) params.sort = "releaseDate"
		def books = Book.list(params)
		[books: books]
	}
}
