package examples

class BookController {

    def search = {
		if (!params.sort) params.sort = "releaseDate"
		def books = Book.list(params)
		[books: books]
	}
}
