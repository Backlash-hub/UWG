/**
 * Script to process the submitted form data of the form in file
 * example.html 
 */
 
 // event listeners for validation of number
document.getElementById('number').addEventListener('focusout', validateNumber);
 
// event listeners for button click
document.getElementById('submit').addEventListener('click', handleFactorization);

/**
 * Checks if the entered number is valid. If so, the result is determined
 * and displayed using function showResult.
 */
function handleFactorization() {
    const result = document.getElementById('result');
    let validNumber = validateNumber();
    if (!validNumber) {
        result.classList.add('display-none');
    } else {
        showResult();
        result.classList.remove('display-none');
    }
}

/**
 * Determines the factors of the entered value and determines whether 
 * the number is a prime number if the checkbox is checked. 
 * The results are displayed on the webpage
 */
function showResult() {
    let number = document.getElementById("number").value;
    let checkPrime = document.getElementById("prime").checked;

    let factors = "";
    let numberFactors = 0;
    for (let factor = 1; factor <= number / 2; factor++) {
        if (number % factor == 0) {
            factors += factor + ", ";
            numberFactors++;
        }
    }
    factors += number;
    numberFactors++;

    let resultElement = document.getElementById("factors");
    if (checkPrime && numberFactors == 2) {
        resultElement.innerHTML = factors + "<br>The number is prime.";
    } else if (checkPrime) {
        resultElement.innerHTML = factors + "<br>The number is not prime.";
    } else {
        resultElement.innerHTML = factors;
    }
}

/**
 * Validates whether the number entered in the form field is positive
 * 
 * @returns {boolean} true if the number is valid
 */
function validateNumber() {
    const number = document.getElementById('number').value;
    const numberError = document.getElementById('number-error');
    if (number == "" || parseInt(number) < 1) {
        numberError.classList.remove('display-none');
        return false;
    } else {
        numberError.classList.add('display-none');
        return true;
    }
}

