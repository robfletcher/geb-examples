<%@ page import="examples.Book" %>
<!DOCTYPE html>
<html>
  <head>
	  <title>Book Search</title>
	  <meta name="layout" content="main">
  </head>
  <body>
	  <section id="book-results">
		  <header><h1>Search Results</h1></header>
		  <table>
			  <thead>
				  <tr>
					  <g:sortableColumn property="title" title="Title"/>
					  <g:sortableColumn property="author" title="Author"/>
					  <g:sortableColumn property="format" title="Format"/>
					  <g:sortableColumn property="price" title="Price"/>
					  <g:sortableColumn property="releaseDate" title="Release Date"/>
				  </tr>
			  </thead>
			  <tbody>
				  <g:each var="book" in="${books}">
					  <tr>
						  <td>${book.title}</td>
						  <td>${book.author}</td>
						  <td>${book.format}</td>
						  <td><g:formatNumber number="${book.price / 100.0}" type="currency" currencyCode="GBP"/></td>
						  <td><g:formatDate date="${book.releaseDate}" type="date" style="MEDIUM"/></td>
					  </tr>
				  </g:each>
			  </tbody>
		  </table>
		  <g:paginate total="${Book.count()}"/>
	  </section>
  </body>
</html>