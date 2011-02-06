<!doctype html>
<html>
	<head>
		<title>AJAX-enabled Form</title>
		<meta name="layout" content="main">
		<script>
			$(document).ready(function() {
				$('#search-results').ajaxStart(function() {
					$(this).html('<span class="ajax-loading">Loading&hellip;</span>');
				});
				$('#search-form form').live('submit', function() {
					var url = '${createLink(controller: 'search')}';
					$('#search-results').load(url, $(this).serialize());
					return false;
				});
			});
		</script>
	</head>
	<body>
		<section id="search-form">
			<form>
				<input name="q"> <!-- should be type="search" but iPhone driver won't type in it then -->
				<button type="submit">Search</button>
			</form>
		</section>
		<section id="search-results"></section>
	</body>
</html>