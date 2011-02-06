<!doctype html>
<html>
	<head>
		<title>Example Form</title>
		<style>
		label { display: block; }
		label, fieldset { margin: 1em 0 0.25em 0; }
		fieldset label { display: inline-block; margin: 0; vertical-align: middle; }
		input[type=radio] { margin: 0 1em 0 0; }
		</style>
		<meta name="layout" content="main">
	</head>
	<body>
		<section id="form">
			<form>
				<label for="textfield">Text field</label>
				<input id="textfield" name="textfield">

				<label for="selectfield">Select field</label>
				<select id="selectfield" name="selectfield">
					<option value="1">option 1</option>
					<option value="2">option 2</option>
					<option value="3">option 3</option>
					<option value="4">option 4</option>
					<option value="5">option 5</option>
				</select>

				<label for="multiselectfield">Multiple select field</label>
				<select id="multiselectfield" name="multiselectfield" multiple>
					<option value="1">option 1</option>
					<option value="2">option 2</option>
					<option value="3">option 3</option>
					<option value="4">option 4</option>
					<option value="5">option 5</option>
				</select>

				<fieldset>
					<legend>Radio button group</legend>
					<label for="radio1">Radio 1</label>
					<input type="radio" name="radiogroup" id="radio1" value="1">
					<label for="radio2">Radio 2</label>
					<input type="radio" name="radiogroup" id="radio2" value="2">
					<label for="radio3">Radio 3</label>
					<input type="radio" name="radiogroup" id="radio3" value="3">
				</fieldset>

				<fieldset>
					<legend>Checkboxes</legend>
					<label for="checkbox1">Checkbox 1</label>
					<input type="checkbox" id="checkbox1" name="checkbox1">
					<label for="checkbox2">Checkbox 2</label>
					<input type="checkbox" id="checkbox2" name="checkbox2">
				</fieldset>

				<label for="textarea">Textarea</label>
				<textarea id="textarea" name="textarea"></textarea>
			</form>
		</section>
	</body>
</html>