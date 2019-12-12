
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

function register(citizen_nameElement,citizen_lastnameElement,amkaElement,citizen_emailElement,usernameElement,citizen_passwordElement,citizen_phoneElement) {
    
    
    let citizen_name = citizen_nameElement && citizen_nameElement.value ? citizen_nameElement.value : "";
    let citizen_lastname = citizen_lastnameElement && citizen_lastnameElement.value ? citizen_lastnameElement.value : "";
    let amka = amkaElement && amkaElement.value ? amkaElement.value : "";
    let citizen_email = citizen_emailElement && citizen_emailElement.value ? citizen_emailElement.value : "";
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let citizen_password = citizen_passwordElement && citizen_passwordElement.value ? citizen_passwordElement.value : "";
    let citizen_phone = citizen_phoneElement && citizen_phoneElement.value ? citizen_phoneElement.value : "";

    if (username.length>5  && citizen_password.length>5 && citizen_name.length>5 && citizen_lastname.length>5 && amka.length>10 && citizen_phone.length>9){
    const ROOT_PATH = "http://localhost:8080";
    var fd = new FormData();
    fd.append( 'citizen_name', citizen_name);
    fd.append( 'citizen_lastname', citizen_lastname);
    fd.append( 'amka', amka);
    fd.append( 'citizen_email', citizen_email);
    fd.append( 'username', username);
    fd.append( 'citizen_password', citizen_password);
    fd.append( 'citizen_phone', citizen_phone);
    
    $.ajax({
      url: ROOT_PATH + '/api/register',
      data: fd,
      processData: false,
      contentType: false,
      type: 'POST',
      success: function(data){
        sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);
        window.location.replace(ROOT_PATH + "/register.html");
      },
      statusCode: {
        401 : function() {
                alert("Invalid username or password!");
            }
        }
    });

}
else {
  alert("Wrong");
}
}