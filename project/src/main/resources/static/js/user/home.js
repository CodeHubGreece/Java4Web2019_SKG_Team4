function logout() {
    sessionStorage.clear();
    window.location.replace(ROOT_PATH + "/Login.html")
}