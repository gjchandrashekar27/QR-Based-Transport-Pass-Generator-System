function showVerified(input, isValid, msgId) {
    const verifiedMsg = document.getElementById(msgId);
    if (isValid && input.value.length > 0) {
        verifiedMsg.textContent = '✔ Verified';
        verifiedMsg.style.color = '#388e3c';
    } else {
        verifiedMsg.textContent = '';
    }
}

function validateLoginForm() {
    const aadhaarInput = document.getElementById('aadhaarNumber');
    const emailInput = document.getElementById('email');
    let valid = true;

    // Aadhaar: 12 digits
    const aadhaarValid = /^\d{12}$/.test(aadhaarInput.value);
    showVerified(aadhaarInput, aadhaarValid, 'aadhaar-verified');
    if (!aadhaarValid) {
        aadhaarInput.focus();
        return false;
    }

    // Email: basic pattern
    const emailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailInput.value);
    showVerified(emailInput, emailValid, 'email-verified');
    if (!emailValid) {
        emailInput.focus();
        return false;
    }

    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    // Aadhaar: 12 digits
    const aadhaarInput = document.getElementById('aadhaarNumber');
    if (aadhaarInput) {
        aadhaarInput.addEventListener('input', function () {
            const isValid = /^\d{12}$/.test(aadhaarInput.value);
            showVerified(aadhaarInput, isValid, 'aadhaar-verified');
        });
    }

    // Email: basic pattern
    const emailInput = document.getElementById('email');
    if (emailInput) {
        emailInput.addEventListener('input', function () {
            const isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailInput.value);
            showVerified(emailInput, isValid, 'email-verified');
        });
    }
});