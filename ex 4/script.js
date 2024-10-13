document.getElementById('myForm').addEventListener('submit', function(event) {
    const errorElements = document.getElementsByClassName('error');
    while (errorElements.length > 0) {
        errorElements[0].remove();
    }

    let isValid = true;

    const fname = document.getElementById('fname').value;
    if (fname.trim() === '') {
        isValid = false;
        showError('fname', 'First name is required.');
    }

    const lname = document.getElementById('lname').value;
    if (lname.trim() === '') {
        isValid = false;
        showError('lname', 'Last name is required.');
    }

    const dob = document.getElementById('dob').value;
    if (dob === '') {
        isValid = false;
        showError('dob', 'Date of birth is required.');
    }

    const gender = document.querySelector('input[name="gender"]:checked');
    if (!gender) {
        isValid = false;
        showError('gender', 'Gender is required.');
    }

    const address = document.getElementById('address').value;
    if (address.trim() === '') {
        isValid = false;
        showError('address', 'Address is required.');
    }

    const email = document.getElementById('email').value;
    if (email.trim() === '' || !validateEmail(email)) {
        isValid = false;
        showError('email', 'Valid email is required.');
    }

    const medicalHistory = document.getElementById('medicalHistory').value;
    if (medicalHistory.trim() === '') {
        isValid = false;
        showError('medicalHistory', 'Medical history is required.');
    }

    if (!isValid) {
        event.preventDefault();
    }
});

function showError(fieldId, message) {
    const field = document.getElementById(fieldId);
    const error = document.createElement('div');
    error.className = 'error';
    error.innerText = message;
    field.parentNode.insertBefore(error, field.nextSibling);
}

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}
