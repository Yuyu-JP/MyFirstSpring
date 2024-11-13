/**
 * 
 */

$(document).ready(function() {
	$("#sendData").click(function() {
		const name = $("#name").val();

		$.ajax({
			url: "/api/submitData",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({ name: name }),
			success: function(response) {
				$("#responseMessage").text(response.message);
			},
			error: function(xhr, status, error) {
				$("#responseMessage").text("Error: " + error);
			}
		});
	});
});