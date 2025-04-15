// JavaScript for Interactivity

// Navigate to different pages
function navigateTo(page) {
    window.location.href = page;
}

// Handle form submissions
document.addEventListener("DOMContentLoaded", () => {
    const forms = document.querySelectorAll("form");
    forms.forEach(form => {
        form.addEventListener("submit", function (e) {
            e.preventDefault();
            alert("Form submitted!");
            // Add your form logic here
        });
    });
});

// Example: Add functionality to invite user in collaboration page
function sendInvite() {
    const emailInput = document.getElementById("email");
    if (emailInput && emailInput.value) {
        alert(`Invite sent to ${emailInput.value}`);
        emailInput.value = ""; // Clear input
    } else {
        alert("Please enter a valid email address.");
    }
}