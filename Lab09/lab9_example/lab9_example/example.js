/**
 * Script to process the submitted form data of the form in file
 * example.html 
 */

/**
 * Displays feedback for the submitted data name, pi, and comments
 * 
 * @returns {boolean} true 
 */
function checkEnteredData() {
    let data = {
        name: document.forms[0].name.value,
        pi: document.forms[0].pi.value,
        comments: document.forms[0].comments.value
    }
    updateData(data);
    alert(getFeedbackString(data));
    return true;
}

/**
 * Updates the submitted data.
 * 
 * @param {object} data the object containing the submitted data
 * @param {string} data.name the name
 * @param {string} data.pi the value of pi represented as string
 * @param {string} data.comments any comments
 */
function updateData(data) {
    let feedback = "";
    if (data.name == "") {
        data.name += "none";
    }
    if (data.pi == "") {
        data.pi = "nothing"
    } else {
        let pi = Number.parseFloat(data.pi);
        if (Number.isNaN(pi)) {
            data.pi = "not a number"
        } else if (pi - 3.141592 > 0.0001 || pi - 3.141592 < -0.0001) {
            data.pi = "an incorrect value"
        } else {
            data.pi = "a decent estimate";
        }
    }
    if (data.comments == "") {
        data.comments= "none";
    } else {
        data.comments = data.comments.substring(0, 10) + "...";
    }
}

/**
 * Creates a string with feedback for the passed in data.
 * 
 * @param {object} data the object containing the submitted data
 * @param {string} data.name the name
 * @param {string} data.pi the value of pi represented as string
 * @param {string} data.comments any comments
 * returns a string with the feedback
 */
function getFeedbackString(data) {
    let feedback = "Submitted name: " + data.name;
    feedback += "\nFor pi, you entered " + data.pi + ".";
    feedback += "\nYour comments: " + data.comments;
    
    return feedback;
}