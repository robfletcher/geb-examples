package geb.examples

class AuthController {

	static allowedMethods = [login: "POST"]

    def login = {
		session.username = params.username
		redirect uri: "/"
	}

	def logout = {
		session.username = null
		redirect uri: "/"
	}
}
