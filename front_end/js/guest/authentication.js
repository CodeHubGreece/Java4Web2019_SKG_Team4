
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
                       citizen_lastname:citizen_lastname,
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

function appointmentpost() {
    
  let Dermatology = document.getElementById('Dermatology').value;
  //let Allergiology = document.getElementById('Alleriology').value;
  let Neurology = document.getElementById('Neurology').value;
  let Urology = document.getElementById('Urology').value;
  let D1 = document.getElementById('D1').value;
  let D2 = document.getElementById('D2').value;
  let D3 = document.getElementById('D3').value;
  let D4 = document.getElementById('D4').value;
  let date_time = document.getElementById('date_time').value;
             $.ajax({
                      url:'http://localhost:8080//appointment',
                      type: 'POST',
                       dataType: 'json',
                       data: JSON.stringify({
                        Allergiology:Allergiology,
                        Dermatology:Dermatology,
                        Neurology:Neurology,
                        Urology:Urology,
                        D1:D1,
                        D2:D2,
                        D3:D3,
                        D4:D4,
                        date_time:date_time
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





