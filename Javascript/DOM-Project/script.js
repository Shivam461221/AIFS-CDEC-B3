
function signUp(e) {
    e.preventDefault();
    let username = document.getElementById('username').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if (username === '' || email === '' || password === '') {
        alert('Please fill data first');
        return;
    }
    let users = JSON.parse(localStorage.getItem("users")) || [];

    let existingUser = users.find(element => element.email === email);

    if (existingUser) {
        alert('User already exist');
        return;
    }
    let newUser = { username, email, password };
    users.push(newUser);

    localStorage.setItem("users", JSON.stringify(users));
    alert('Sign up successful');
    window.location.href = 'login.html';
}

function login(e) {
    e.preventDefault();

    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if (email === '' || password === '') {
        alert('All details required');
        return;
    }
    let users = JSON.parse(localStorage.getItem('users')) || [];

    // let foundUser = users.find(user => user.email === email && user.password === password);
    let foundUser = users.find(user => user.email === email);

    if(foundUser.password !== password){
        alert('Wrong Password');
        return
    }
    
    if (foundUser) {
        localStorage.setItem("loggedInUser", JSON.stringify(foundUser));
        window.location.href = 'index.html';
    }
    else {
        alert('Wrong credentials');
    }
}