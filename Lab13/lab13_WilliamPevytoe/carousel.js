

document.getElementById('submit').addEventListener('click', validateInfo);


function validateInfo() {
    resetValidation();

    let fName = document.getElementById('fnameField').value;
    let fNameInput = document.getElementById('fnameField');
    let lName = document.getElementById('lnameField').value;
    let lNameInput = document.getElementById('lnameField');
    let eMail = document.getElementById('emailField').value;
    let eMailInput = document.getElementById('emailField');
    let dateInput = document.getElementById('dateField');
    let nightsInput = document.getElementById('nightsField');
    let commentsInput = document.getElementById('commentsField');
    
    if (fName.trim() === '') {
        fNameInput.classList.add('is-invalid');
        //setInvalid('fnameField');
    } else {
        fNameInput.classList.add('is-valid');;
    }

    if (lName.trim() === '') {
        lNameInput.classList.add('is-invalid');
    } else {
        lNameInput.classList.add('is-valid');
    }

    if (eMail.trim() === '') {
        eMailInput.classList.add('is-invalid');
    } else {
        eMailInput.classList.add('is-valid');
    }

    dateInput.classList.add('is-valid');
    nightsInput.classList.add('is-valid');
    commentsInput.classList.add('is-valid');

    isValid = document.querySelectorAll('.is-invalid').length === 0;

    return isValid;
}

function resetValidation() {
    formControls = document.getElementsByClassName('form-control');
    for (i = 0; i < formControls.length; i++) {
        formControls[i].classList.remove('is-valid', 'is-invalid');
    }
}