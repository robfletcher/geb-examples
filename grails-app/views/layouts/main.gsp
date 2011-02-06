<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle /></title>
		<style>
			body { font-family: sans-serif; }
			section { display: block; }
			@media screen and (min-width: 761px) {
				#auth { position: absolute; right: 1em; top: 1em; }
				#auth label { text-align: right; }
			}
			#auth label { display: block; margin: 0.5em 0; }
			#auth .message { display: block; }
			#auth a { display: inline-block; }
			label { display: block; }
			label, fieldset { margin: 1em 0 0.25em 0; }
			fieldset label { display: inline-block; margin: 0; vertical-align: middle; }
			input[type=radio] { margin: 0 1em 0 0; }
			#search-results { margin: 1em; }
			.ajax-loading { color: #999; font-style: italic; }
		</style>
		<script src="http://code.jquery.com/jquery-1.5.min.js"></script>
		<script>
			var ajaxCount = 0;
			$(document).ready(function() {
				$(document).ajaxSend(function() {
					ajaxCount++;
				}).ajaxComplete(function() {
					ajaxCount--;
				});
			});

			function isAjaxComplete() {
				return ajaxCount == 0;
			}
		</script>
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