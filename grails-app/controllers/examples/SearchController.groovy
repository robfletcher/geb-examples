package examples

class SearchController {
    def search = {
		Thread.sleep(2000)
		render text: "You searched for '$params.q'"
	}
}
