
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

function register(firstnameElement,lastnameElement,amkaElement,emailElement,usernameElement,passwordElement,phoneElement) {
    
    
    let firstname = firstnameElement && firstnameElement.value ? firstnameElement.value : "";
    let lastname = lastnameElement && lastnameElement.value ? lastnameElement.value : "";
    let amka = amkaElement && amkaElement.value ? amkaElement.value : "";
    let email = emailElement && emailElement.value ? emailElement.value : "";
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    let phone = phoneElement && phoneElement.value ? phoneElement.value : "";

    if (username.length>3  && password.length>3  ){
    const ROOT_PATH = "http://localhost:8080";
    var fd = new FormData();
    fd.append( 'firstname', firstname);
    fd.append( 'lastname', lastname);
    fd.append( 'amka', amka);
    fd.append( 'email', email);
    fd.append( 'username', username);
    fd.append( 'password', password);
    fd.append( 'phone', phone);
    
    $.ajax({
      url: ROOT_PATH + '/api/register',
      data: fd,
      processData: false,
      contentType: false,
      type: 'POST',
      success: function(data){
        sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);
        window.location.replace(ROOT_PATH + "/pages/user/register.html");
      },
      statusCode: {
        401 : function() {
                alert("Invalid username or password!");
            }
        }
    });

}
}