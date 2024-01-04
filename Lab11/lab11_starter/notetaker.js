/**
 * notetaker.js implements the functionality of the note taker application:
 * - Tracks an array with the current notes
 * - Displays the notes on the web page
 * - Adds notes entered by the user
 * - Removes notes selected by the user 
 */

let notes = [];

updatePageContent();

document.getElementById('add').addEventListener('click', addNotes);
document.getElementById('delete').addEventListener('click', deleteNotes);

//Part 1
function updatePageContent() {
    if (notes.length == 0) {
        document.getElementById('display-notes').classList.add('display-none');
        document.getElementById('delete-note').classList.add('display-none');
    } else {
        document.getElementById('display-notes').classList.remove('display-none');
        document.getElementById('delete-note').classList.remove('display-none');
        updateList();
    }
}

function updateList() {
    let noteViz = document.getElementById('notelist');
    let noteDelList = document.getElementById('noteselection');
    noteViz.innerHTML = '';
    noteDelList.innerHTML = '';
    for (i =0; i < notes.length; i++) {
        //Displaying notes 
        addLi = document.createElement('li');
        addLi.textContent = notes[i];
        noteViz.appendChild(addLi);
        
        //Adding notes to the section to be able to delete them
        addOption = document.createElement('option');
        addOption.value = i;
        addOption.textContent = notes[i];
        noteDelList.appendChild(addOption);
    }
}

//Part2
function addNotes() {
    let newNote = document.getElementById('newnote').value;
    let emptyNote = document.getElementById('emptyinput');
    if (newNote.length == ''){
        emptyNote.classList.remove('display-none');
    } else {
        emptyNote.classList.add('display-none');
        notes.push(newNote);
        newNote.value = '';
        updatePageContent();
    }
}

//Part3

function deleteNotes() {
    let value = document.getElementById('noteselection').value;
    notes.splice(value, 1);
    updatePageContent();
}