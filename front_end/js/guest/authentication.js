
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
            window.location.replace(ROOT_PATH + "/Login.html");
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
    
  let username = document.getElementById('username').value;
  let citizen_password = document.getElementById('citizen_password').value;
  let citizen_lastname = document.getElementById('citizen_lastname').value;
  let citizen_name = document.getElementById('citizen_name').value;
  let citizen_email = document.getElementById('citizen_email').value;
  let amka = document.getElementById('amka').value;
  let citizen_phone = document.getElementById('citizen_phone').value;
             $.ajax({
                      url: ROOT_PATH + '/registration',
                      type: 'POST',
                       dataType: 'json',
                       data: JSON.stringify({
                       username:username,
                       citizen_password:citizen_password,
                       citizen_firstname:citizen_lastname,
                       citizen_name:citizen_name,
                       citizen_phone:citizen_phone,
                       citizen_email:citizen_email,
                       amka:amka
                  }),
                  contentType: 'application/json',
                  success: function (result) {
                      alert("Data Saved: " + JSON.stringify(result));
                  },
                  error: function (xhr, resp, text) {
                      alert("NOT Saved: " + text);
                  }
              });
}

