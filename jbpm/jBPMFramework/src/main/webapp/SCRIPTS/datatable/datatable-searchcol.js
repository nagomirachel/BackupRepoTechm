/**
 * Experiment to see if the datatable will work with search each individual
 * column
 */

var asInitVals = new Array();

$(document).ready(function() {
	var oTable = $('#somethingelse').dataTable({
		"oLanguage" : {
			"sSearch" : "Search all columns:"
		},
		//"sDom" : 'RC<"clear">lrtip', /* Show/Hide Columns */
	});

	$("tfoot input").keyup(function() {
		/* Filter on the column (the index) of this element */
		oTable.fnFilter(this.value, $("tfoot input").index(this));
	});

	/*
	 * Support functions to provide a little bit of 'user friendlyness' to the
	 * textboxes in the footer
	 */
	$("tfoot input").each(function(i) {
		asInitVals[i] = this.value;
	});

	$("tfoot input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});

	$("tfoot input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			this.value = asInitVals[$("tfoot input").index(this)];
		}
	});
});