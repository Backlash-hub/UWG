/**
 * example.js implements the functionality of the example application:
 * - Tracks an array with values 
 * - Displays the sum of the values
 * - Allows users to add values to the array
 * - Allows user to remove values from array
 */
let operands = [];

updatePageContent();

document.getElementById('add').addEventListener('click', addOperand);
document.getElementById('remove').addEventListener('click', removeOperand);

/**
 * Updates the displayed sum operation and updates the options of the drop-down
 * box (the <select> element) to reflect the content of array operations.
 */
function updatePageContent() {
    if (operands.length == 0) {
        document.getElementById('display-sum').classList.add('display-none');
        document.getElementById('delete-operand').classList.add('display-none');
    } else {
        updateOperation();
        updateDropdownBox();
    }
}

/**
 * Updates the displayed sum operation
 */
function updateOperation() {
    let operation = document.getElementById('operation');
    operation.innerHTML = "";
    let sum = 0;
    for (let index = 0; index < operands.length; index++) {
        if (index > 0) {
            operation.innerHTML += " + ";
        }
        operation.innerHTML += operands[index];
        sum += operands[index];
    }
    operation.innerHTML += " = " + sum;
    document.getElementById('display-sum').classList.remove('display-none');
}

/**
 * Updates the displayed sum operation and updates the options of the drop-down
 * box (the <select> element) to reflect the content of array operations.
 */
function updateDropdownBox() {
    let selection = document.getElementById('operandselection');
    selection.innerHTML = "";
    for (let index = 0; index < operands.length; index++) {
        selection.innerHTML += "<option value=\"" + index + "\">" + operands[index] + "</option>";
    }
	document.getElementById('delete-operand').classList.remove('display-none');
}
/**
 * The code below is an alternive implementation of the function above using
 * the appendChild method. 
 */
function updateDropdownBox_alternative() {
    let selection = document.getElementById('operandselection');
    selection.innerHTML = "";
    for (let index = 0; index < operands.length; index++) {
        let option = selection.appendChild(document.createElement("option"));
        option.setAttribute("value", index);
        option.innerHTML = operands[index];
    }
	document.getElementById('delete-operand').classList.remove('display-none');
}

/**
 * Adds the value of the text input element as element to array operands.
 */
function addOperand() {
    let newOperand = document.getElementById("newoperand").value;
    newOperand = Number.parseFloat(newOperand);
    operands.push(newOperand);
    document.getElementById("newoperand").value = "";
    updatePageContent();
}

/**
 * Deletes the element of array operands at the index specified by the drop-down
 * box.
 */
function removeOperand() {
    let removeIndex = document.getElementById("operandselection").value;
    operands.splice(removeIndex, 1);
    updatePageContent();
}