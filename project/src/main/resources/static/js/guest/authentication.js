const SESSION_STORAGE_LOGIN_TOKEN_NAME = "userID";
const ROOT_PATH = "http::/localhost:8080";

function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    var fd = new FormData();
    fd.append( 'username', username);
    fd.append( 'password', password);
    $.ajax({
        url: "http://localhost:8080/login",
        data: fd,
        processData: false,
        contentType: false,
        type: 'POST',
        success: function(data){
            $.ajax({
                url: "http://localhost:8080/user",
                type: 'GET',
                dataType: 'json',
                success: function(data){
                    if (data.role==='CITIZEN'){
                        window.location.replace("http://localhost:8080/Profile.html");
                    }else {
                        window.location.replace("http://localhost:8080/doctor-profile.html");
                    }
                },
                statusCode: {
                    401 : function() {
                        alert("Invalid username or password!");
                    }
                }
            });
        }
    });
}

function logOut(){
    sessionStorage.clear();
    window.location.replace("login.html");
}

function register() {
    let username = document.getElementById('username').value;
    let citizen_password = document.getElementById('citizen_password').value;
    let citizen_lastname = document.getElementById('citizen_lastname').value;
    let citizen_name = document.getElementById('citizen_name').value;
    let citizen_email = document.getElementById('citizen_email').value;
    let amka = document.getElementById('amka').value;
    let citizen_phone = document.getElementById('citizen_phone').value;
    $.ajax({
        url: "http://localhost:8080/api/registration",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({
            username:username,
            citizen_password:citizen_password,
            citizen_lastname:citizen_lastname,
            citizen_name:citizen_name,
            citizen_phone:citizen_phone,
            citizen_email:citizen_email,
            amka:amka
        }),
        contentType: 'application/json',
        success: function (result) {
            sessionStorage.clear();
            window.location.replace("login.html");
        },
        error: function (xhr, resp, text) {
            alert("NOT Saved: " + text);
        }
    });
}
