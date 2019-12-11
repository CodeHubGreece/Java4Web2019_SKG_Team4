
function logIn() {
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    if(user == "user" && pass == "user") {
        localStorage.setItem("isLoggedIn", true);
        alert("Logged in successfully.");
        window.location.replace("Profile.html");
    } 
else if (user == "doct" && pass == "doct") {
    localStorage.setItem("isLoggedIn", true);
    alert("Logged in successfully.");
    window.location.replace("doctor-profile.html");
} 

    else alert("Couldn't authenticate, try again.");
}

function logOut(){
    localStorage.removeItem("isLoggedIn");
    window.location.replace("Login.html");
}