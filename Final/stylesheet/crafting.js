
document.addEventListener('DOMContentLoaded', function() {
    populateStates();
    toggleGiraffeInput();
    toggleElephantInput();
    toggleZebraInput();
    toggleSlothInput();
    toggleRacoonInput();

    document.getElementById('price-button').addEventListener('click', function() {
        if (validateInfo()) {
            DisplayTotal();
            document.getElementById('price-result').classList.remove('display-none');
        } else {
            console.log('Form data is invalid');
        }
    });
});



function validateInfo() {
    resetValidation();

    let fName = document.getElementById('fnameField').value;
    let fNameInput = document.getElementById('fnameField');
    let lName = document.getElementById('lnameField').value;
    let lNameInput = document.getElementById('lnameField');
    let eMail = document.getElementById('emailField').value;
    let eMailInput = document.getElementById('emailField');
    let address = document.getElementById('inputAddress');
    let city =  document.getElementById('inputCity');
    let state = document.getElementById('inputState');
    let zipcode = document.getElementById('inputZip');

    
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

    address.classList.add('is-valid');
    city.classList.add('is-valid');
    state.classList.add('is-valid');
    zipcode.classList.add('is-valid');

    isValid = document.querySelectorAll('.is-invalid').length === 0;

    return isValid;
}

function resetValidation() {
    formControls = document.getElementsByClassName('form-control');
    for (i = 0; i < formControls.length; i++) {
        formControls[i].classList.remove('is-valid', 'is-invalid');
    }
}




const states = [
    'Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut',
    'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas',
    'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
    'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey',
    'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon',
    'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah',
    'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
]

function populateStates() {
    const select = document.getElementById('inputState');
    states.forEach(state => {
        const option = document.createElement('option');
        option.value = state;
        option.text = state;
        select.appendChild(option);
    });
}




function toggleGiraffeInput() {
    const checkbox = document.getElementById('flexCheckGiraffe');
    const giraffeInput = document.getElementById('GiraffeInput');
    const inputField = document.getElementById('numOfGiraffeInput');

    checkbox.addEventListener('change', function() {
        if (checkbox.checked) {
            giraffeInput.classList.remove('display-none');
        } else {
            giraffeInput.classList.add('display-none');
            inputField.value = '';
        }
    });
}

function toggleElephantInput() {
    const checkbox = document.getElementById('flexCheckElephant');
    const giraffeInput = document.getElementById('ElephantInput');
    const inputField = document.getElementById('numOfElephantInput');


    checkbox.addEventListener('change', function() {
        if (checkbox.checked) {
            giraffeInput.classList.remove('display-none');
        } else {
            giraffeInput.classList.add('display-none');
            inputField.value = '';
        }
    });
}

function toggleZebraInput() {
    const checkbox = document.getElementById('flexCheckZebra');
    const giraffeInput = document.getElementById('ZebraInput');
    const inputField = document.getElementById('numOfZebraInput');


    checkbox.addEventListener('change', function() {
        if (checkbox.checked) {
            giraffeInput.classList.remove('display-none');
        } else {
            giraffeInput.classList.add('display-none');
            inputField.value = '';
        }
    });
}

function toggleSlothInput() {
    const checkbox = document.getElementById('flexCheckSloth');
    const giraffeInput = document.getElementById('SlothInput');
    const inputField = document.getElementById('numOfSlothInput');


    checkbox.addEventListener('change', function() {
        if (checkbox.checked) {
            giraffeInput.classList.remove('display-none');
        } else {
            giraffeInput.classList.add('display-none');
            inputField.value = '';
        }
    });
}

function toggleRacoonInput() {
    const checkbox = document.getElementById('flexCheckRacoon');
    const giraffeInput = document.getElementById('RacoonInput');
    const inputField = document.getElementById('numOfRacoonInput');


    checkbox.addEventListener('change', function() {
        if (checkbox.checked) {
            giraffeInput.classList.remove('display-none');
        } else {
            giraffeInput.classList.add('display-none');
            inputField.value = '';
        }
    });
}


function DisplayTotal() {
    let cost = 0;

    // Number of each product
    let GiraffeinputField = parseInt(document.getElementById('numOfGiraffeInput').value) || 0;
    let ElephantinputField = parseInt(document.getElementById('numOfElephantInput').value) || 0;
    let ZebrainputField = parseInt(document.getElementById('numOfZebraInput').value) || 0;
    let SlothinputField = parseInt(document.getElementById('numOfSlothInput').value) || 0;
    let RacooninputField = parseInt(document.getElementById('numOfRacoonInput').value) || 0;

    // Product checkbox
    let checkedGiraffe = document.getElementById('flexCheckGiraffe').checked;
    let checkedElephant = document.getElementById('flexCheckElephant').checked;
    let checkedZebra = document.getElementById('flexCheckZebra').checked;
    let checkedSloth = document.getElementById('flexCheckSloth').checked;
    let checkedRacoon = document.getElementById('flexCheckRacoon').checked;

    // Expedited checkbox
    let ExpiditedOrder = document.getElementById('ExpeditedSwitchCheck').checked;

    //Price list
    let priceResult = document.getElementById('price-result');

    if (checkedGiraffe) {
        cost += 25.00 * GiraffeinputField;
    }

    if (checkedElephant) {
        cost += 25.00 * ElephantinputField;
    }

    if (checkedZebra) {
        cost += 25.00 * ZebrainputField;
    }

    if (checkedSloth) {
        cost += 25.00 * SlothinputField;
    }

    if (checkedRacoon) {
        cost += 40.00 * RacooninputField;
    }

    if (ExpiditedOrder) {
        cost += 20;
    }

    let taxes = 0.25 * cost;
    let total = taxes + cost;

    document.getElementById('price-value').textContent = "$" + cost.toFixed(2);
    document.getElementById('taxes-value').textContent = "$" + taxes.toFixed(2);
    document.getElementById('total-value').textContent = "$" + total.toFixed(2);



    priceResult.classList.remove('display-none');
}