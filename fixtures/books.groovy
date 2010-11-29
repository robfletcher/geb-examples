import examples.Book
import static examples.BookFormat.*

fixture {

	neuromancer(Book) {
		title = "Neuromancer"
		author = "William Gibson"
		format = Paperback
		price = 477
		releaseDate = new Date(84, 6, 1)
	}

	countZero(Book) {
		title = "Count Zero"
		author = "William Gibson"
		format = Paperback
		price = 449
		releaseDate = new Date(86, 0, 1)
	}

	monaLisaOverdrive(Book) {
		title = "Mona Lisa Overdrive"
		author = "William Gibson"
		format = Paperback
		price = 449
		releaseDate = new Date(88, 0, 1)
	}

	virtualLight(Book) {
		title = "Virtual Light"
		author = "William Gibson"
		format = Paperback
		price = 549
		releaseDate = new Date(93, 8, 6)
	}

	idoru(Book) {
		title = "Idoru"
		author = "William Gibson"
		format = Paperback
		price = 623
		releaseDate = new Date(96, 8, 4)
	}

	allTomorrowsParties(Book) {
		title = "All Tomorrow's Parties"
		author = "William Gibson"
		format = Paperback
		price = 623
		releaseDate = new Date(99, 9, 7)
	}

	patternRecognition(Book) {
		title = "Pattern Recognition"
		author = "William Gibson"
		format = Paperback
		price = 499
		releaseDate = new Date(103, 1, 3)
	}

	spookCountry(Book) {
		title = "Spook Country"
		author = "William Gibson"
		format = Paperback
		price = 500
		releaseDate = new Date(107, 7, 2)
	}

	zeroHistory(Book) {
		title = "Zero History"
		author = "William Gibson"
		format = Hardback
		price = 1134
		releaseDate = new Date(110, 8, 2)
	}

	zeroHistory(Book) {
		title = "Zero History"
		author = "William Gibson"
		format = Kindle
		price = 1199
		releaseDate = new Date(110, 8, 2)
	}

	theDifferenceEngine(Book) {
		title = "The Difference Engine"
		author = "William Gibson"
		format = Paperback
		price = 599
		releaseDate = new Date(90, 8, 1)
	}

}