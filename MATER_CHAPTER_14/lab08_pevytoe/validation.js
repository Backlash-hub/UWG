function validateForm() {
    if ( document.getElementById("myLName").value == "") {
        alert("Please enter your last name");
        return false;
    }
    else {
        return true;
    }
}