
function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";

    if (username.length>3  && password.length>3  ) {
        // localStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, true);
        // window.location.replace(ROOT_PATH + "/pages/user/Login.html");

        const ROOT_PATH = "http://localhost:8080";
        var fd = new FormData();
        fd.append( 'username', username);
        fd.append( 'password', password);
        $.ajax({
          url: ROOT_PATH + '/api/login',
          data: fd,
          processData: false,
          contentType: false,
          type: 'POST',
          success: function(data){
            sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);
            window.location.replace(ROOT_PATH + "/pages/user/Login.html");
          },
          statusCode: {
            401 : function() {
                    alert("Invalid username or password!");
                }
            }
        });


    }
    else {
        alert("Wrong password");
    }
}

function logOut(){
    localStorage.removeItem("isLoggedIn");
    window.location.replace("Login.html");
}

function register() {
    // TODO:
}