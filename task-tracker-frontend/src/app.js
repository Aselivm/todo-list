document.addEventListener("DOMContentLoaded", function() {
    const registrationForm = document.getElementById("registerForm");
    const loginForm = document.getElementById("loginForm");
    const taskSection = document.getElementById("task-section");
    const registrationError = document.getElementById("registrationError");
    const loginError = document.getElementById("loginError");

    // Event listener for registration
    registrationForm.addEventListener("submit", async function(event) {
        event.preventDefault();
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        const response = await fetch("http://localhost:8080/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            document.getElementById("registration-form").classList.add("hidden");
            document.getElementById("task-section").classList.remove("hidden");
        } else {
            const errorData = await response.json();
            registrationError.textContent = errorData.message;
            registrationError.classList.remove("hidden");
        }
    });

    loginForm.addEventListener("submit", async function(event) {
        event.preventDefault();
        const email = document.getElementById("loginEmail").value;
        const password = document.getElementById("loginPassword").value;

        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem("jwt", data.token);
            document.getElementById("login-form").classList.add("hidden");
            document.getElementById("task-section").classList.remove("hidden");
        } else {
            const errorData = await response.json();
            loginError.textContent = errorData.message;
            loginError.classList.remove("hidden");
        }
    });

    document.getElementById("loadTasksButton").addEventListener("click", async function() {
        const token = localStorage.getItem("jwt");

        const response = await fetch("http://localhost:8080/tasks", {
            method: "GET",
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });

        if (response.ok) {
            const tasks = await response.json();
            const taskList = document.getElementById("taskList");
            taskList.innerHTML = "";
            tasks.forEach(task => {
                const li = document.createElement("li");
                li.textContent = task.description;
                taskList.appendChild(li);
            });
        } else {
            console.error("Failed to load tasks");
        }
    });
});
