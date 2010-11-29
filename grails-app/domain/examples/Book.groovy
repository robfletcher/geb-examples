package examples

class Book {

	String title
	String author
	BookFormat format
	Integer price
	Date releaseDate

    static constraints = {
		title blank: false
		author blank: false
		price min: 0
    }
}

enum BookFormat {
	Hardback, Paperback, Kindle
}
