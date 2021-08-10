/**
 * 
 */
$(document).ready(function () {

	    $("#ajaxForm").submit(function (event) {

	        event.preventDefault();

	        var formData = {}
	        ajaxForm["name"] = $("#name").val();
	        ajaxForm["city"] = $("#city").val();

	        $.ajax({
	            type: "POST",
	            dataType: "json",
	            contentType: "application/json; charset=utf-8",
	            url: "ajax",
	            data: JSON.stringify(formData),
	            cache: false,
	            timeout: 600000,
	            success: function (data) {
	                var json = "Ajax Cevap" + JSON.stringify(data, null, 5);
	                $('#result').html(json);
	            },
	            error: function (e) {
	                var json = "Ajax Hata" + e.responseText;
	                $('#result').html(json);
	            }
	        });

	    });

	});