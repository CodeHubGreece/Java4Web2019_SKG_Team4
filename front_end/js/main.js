
function logIn() {
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    if(user == "user" && pass == "user") {
        localStorage.setItem("isLoggedIn", true);
        alert("Logged In");
        window.location.replace("Profile.html");
    } 
    else alert("wrong user/pass");
}

function logOut(){
    localStorage.removeItem("isLoggedIn");
    window.location.replace("Login.html");
}