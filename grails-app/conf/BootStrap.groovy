class BootStrap {

	def fixtureLoader

    def init = { servletContext ->
		fixtureLoader.load "books"
    }

    def destroy = {
    }

}
