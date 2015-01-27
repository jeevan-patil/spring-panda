var pageCtx = '';

$(document).ready(function() {
	pageCtx = $('#pageCtx').val();

	$("input[name='fullName']").focus();

	$("#saveBttn").click(function() {
		addUser();
	});

	listAllUsers();
});

var addUser = function() {
	var fullName = $.trim($("input[name='fullName']").val());
	var email = $.trim($("input[name='email']").val());
	var city = $.trim($("input[name='city']").val());
	var state = $.trim($("input[name='state']").val());
	var country = $.trim($("input[name='country']").val());
	var password = $.trim($("input[name='password']").val());
	var confirmPassword = $.trim($("input[name='confirmPassword']").val());
	
	if(!fullName || !email || !city || !state || !country || !confirmPassword || !password) {
		showError('Everything is mandatory!');
		return;
	} else if(password !== confirmPassword) {
		showError('Passwords must match.');
		return;
	} else {
		hideError();
	}

	var user = new Object();
	user.fullName = fullName;
	user.email = email;
	user.city = city;
	user.state = state;
	user.country = country;
	user.password = password;

	$.ajax({
		type : "POST",
		url : pageCtx + "/user/add",
		dataType : "application/json",
		headers: {
			"Accept": "application/json",
			"Content-Type" : "application/json; charset=utf-8"
		},
		data : JSON.stringify(user),
		success : function(response) {
			showError(response.message);
			listAllUsers();
			clearForm();
		},
		complete: function(response){
		},
		error : function(jqXHR, textStatus, errorThrown) {
			listAllUsers();
			clearForm();
		}
	});
};

var showError = function(msg) {
	$('#err').html(msg);
	$('#err').show();
};

var hideError = function() {
	$('#err').html('');
	$('#err').show();
};

var clearForm = function() {
	$("input[name='fullName']").val('');
	$("input[name='email']").val('');
	$("input[name='city']").val('');
	$("input[name='state']").val('');
	$("input[name='country']").val('');
	$("input[name='password']").val('');
	$("input[name='confirmPassword']").val('');
};

var listAllUsers = function() {
	$.ajax({
		type : "GET",
		url : pageCtx + "/user/list",
		success : function(response) {
			renderUsers(response);
		},
		complete: function(){
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('failure');
		}
	});
};

var renderUsers = function(data) {
	if(!data) {
		return;
	}

	var html = '<table style="width:100%">';
	html += '<tr style="text-align: left;background-color: gainsboro;"><th>Name</th><th>Email</th><th>City</th><th>State</th><th>Country</th></tr>';
	$.each(data, function(index, user) {
		html += '<tr>';
		html += '<td>' + user.fullName + '</td><td>' + user.email + '</td><td>' + user.city + '</td><td>' + user.state + '</td><td>' + user.country + '</td>';
		html += '</tr>';
	});

	html += '<table>';
	$('#allUsers').html(html);
};
