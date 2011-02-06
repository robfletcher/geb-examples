<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle /></title>
		<style>
			body { font-family: sans-serif; }
			#auth { position: absolute; right: 1em; top: 1em; }
			#auth label { display: block; margin: 0.5em 0; text-align: right; }
			#auth .message { display: block; }
			#auth a { display: inline-block; }
		</style>
        <g:layoutHead />
    </head>
    <body>
		<header>
			<h1><g:layoutTitle /></h1>
		</header>
		<aside id="auth">
			<g:if test="${session.username}">
				<span class="message">Welcome back <span class="username">${session.username}</span></span>
				<g:link controller="auth" action="logout" class="logout">Log Out</g:link>
			</g:if>
			<g:else>
				<fieldset>
					<legend>Log In</legend>
					<g:form controller="auth" action="login">
						<label>Username: <input name="username"/></label>
						<label>Password: <input type="password" name="password"></label>
						<button name="login" type="submit">Log In</button>
					</g:form>
				</fieldset>
			</g:else>
		</aside>
        <g:layoutBody />
    </body>
</html>