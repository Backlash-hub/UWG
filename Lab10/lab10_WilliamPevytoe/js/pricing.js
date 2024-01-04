/**
 * Script to process the submitted form data of the form in file
 * pricing.html 
 */

//event listeners for number of guests and nights
document.getElementById('num-guests').addEventListener('focusout', validateNumberOfGuests);
document.getElementById('num-nights').addEventListener('focusout', validateNumberOfNights);
document.getElementById('price-button').addEventListener('click', calculateAndDisplayTotal);


//Checks the number of guests is < 0
function validateNumberOfGuests() {
    let numGuests = document.getElementById('num-guests').value
    let numberError = document.getElementById('guests-error');
    if (numGuests == "" || parseInt(numGuests) <= 0) {
        numberError.classList.remove('display-none');
        return false;
    } else {
        numberError.classList.add('display-none');
        return true;
    }
}


//Checks the number of nights is > 2   
function validateNumberOfNights() {
    let numNights = document.getElementById('num-nights').value
    let nightError = document.getElementById('nights-error');
    if (numNights == "" || parseInt(numNights) < 2) {
        nightError.classList.remove('display-none');
        return false;
    } else {
        nightError.classList.add('display-none');
        return true;
    }
}

//Calculates the total cost of the stay and displays it
function calculateAndDisplayTotal() {
    let numGuests = parseInt(document.getElementById('num-guests').value);
    let numNights = parseInt(document.getElementById('num-nights').value);
    let incBreakfast = document.getElementById('breakfast'). checked;
    let incDinner = document.getElementById('dinner').checked;
    let priceResult = document.getElementById('price-result');

    if (!validateNumberOfGuests(numGuests) || !validateNumberOfNights(numNights)) {
        priceResult.classList.add('display-none')
        return;
    }
        
    let cost = 30 * numGuests * numNights;
    if (incBreakfast) {
        cost += 10 * numGuests * numNights;
    }
    if (incDinner) {
        cost += 20 * numGuests * numNights;
    }

    let taxes = 0.21 * cost;

    let total = taxes + cost;

    document.getElementById('price-value').textContent = "$" + cost.toFixed(2);
    document.getElementById('taxes-value').textContent = "$" + taxes.toFixed(2);
    document.getElementById('total-value').textContent = "$" + total.toFixed(2);

    priceResult.classList.remove('display-none');
}
    
