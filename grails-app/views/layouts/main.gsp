<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle /></title>
        <g:layoutHead />
    </head>
    <body>
		<header>
			<h1><g:layoutTitle /></h1>
		</header>
		<aside id="auth">
			<g:if test="${session.username}">
				Welcome back <span class="username">${session.username}</span>
				<g:link controller="auth" action="logout" name="logout">Log Out</g:link>
			</g:if>
			<g:else>
				<fieldset>
					<g:form controller="auth" action="login">
						<legend>Log In</legend>
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