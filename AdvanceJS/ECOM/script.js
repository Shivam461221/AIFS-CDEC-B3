let cart = JSON.parse(localStorage.getItem('cart')) || [];

function addToCart(product) {
    
    const existingItem = cart.find(item => item.id === product.id);

    if (existingItem) {
        existingItem.quantity += 1;
    } else {
        cart.push({
            id: product.id,
            title: product.title,
            price: product.price,
            thumbnail: product.thumbnail,
            quantity: 1
        });
    }


    localStorage.setItem('cart', JSON.stringify(cart));
    alert(`${product.title} added to cart!`);
    updateCartCount();
}


function updateCartCount() {
    const totalItems = cart.reduce((total, item) => total + item.quantity, 0);
    const cartCountElement = document.getElementById('cart-count');

    if (cartCountElement) {
        cartCountElement.textContent = totalItems;
    }
}


document.addEventListener('DOMContentLoaded', function () {
    fetch('https://dummyjson.com/products')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.getElementById('product-count').textContent = `${data.products.length} Products`;

            const productsContainer = document.getElementById('products-container');
            productsContainer.innerHTML = '';

            data.products.forEach(product => {
                const discountPercentage = Math.round(product.discountPercentage);
                const stars = Math.round(product.rating);

                const encodedProduct = encodeURIComponent(JSON.stringify(product));

                const card = document.createElement('div');
                card.className = 'col';
                card.innerHTML = `
                    <div class="card product-card h-100 position-relative">
                        ${discountPercentage > 0 ? `<span class="discount-badge">${discountPercentage}% OFF</span>` : ''}
                        <img src="${product.thumbnail}" class="card-img-top product-image" alt="${product.title}">
                        <div class="card-body">
                            <h5 class="card-title">${product.title}</h5>
                            <p class="card-text text-muted">${product.brand}</p>
                            <p class="card-text">${product.description.substring(0, 60)}...</p>
                        </div>
                        <div class="card-footer bg-transparent">
                            <div class="d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h5">$${product.price}</span>
                                    ${discountPercentage > 0 ?
                        `<small class="text-muted text-decoration-line-through ms-2">$${Math.round(product.price * (100 + discountPercentage) / 100)}</small>` :
                        ''}
                                </div>
                                <div class="rating">
                                    ${'★'.repeat(stars)}${'☆'.repeat(5 - stars)}
                                    <small class="text-muted">(${product.rating})</small>
                                </div>
                            </div>
                            <button class="btn btn-primary mt-3 w-100 add-to-cart-btn" data-product="${encodedProduct}">
                                <i class="fas fa-shopping-cart me-2"></i>Add to Cart
                            </button>
                        </div>
                    </div>
                `;
                productsContainer.appendChild(card);
            });

            // Attach event listeners AFTER cards are in the DOM
            document.querySelectorAll('.add-to-cart-btn').forEach(button => {
                button.addEventListener('click', function () {
                    const product = JSON.parse(decodeURIComponent(this.getAttribute('data-product')));
                    addToCart(product);
                });
            });
        })
        .catch(error => {
            console.error('Error fetching products:', error);
            document.getElementById('products-container').innerHTML = `
                <div class="col-12 text-center py-5">
                    <i class="fas fa-exclamation-triangle fa-3x text-danger mb-3"></i>
                    <h3>Failed to load products</h3>
                    <p class="text-muted">Please try again later</p>
                    <button class="btn btn-primary" onclick="window.location.reload()">
                        <i class="fas fa-sync-alt me-2"></i>Retry
                    </button>
                </div>
            `;
        });
});





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

    if (foundUser.password !== password) {
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

function logout() {
    localStorage.removeItem("loggedInUser");
    window.location.href = 'login.html';
}



updateCartCount();

function renderCartItems() {
    const cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    const cartContainer = document.getElementById('cart-container');

    if (!cartContainer) return;

    cartContainer.innerHTML = '';

    if (cartItems.length === 0) {
        cartContainer.innerHTML = `
            <div class="col-12 text-center py-5">
                <h3>Your cart is empty</h3>
                <p class="text-muted">Add some products to see them here.</p>
                <a href="index.html" class="btn btn-primary">
                    <i class="fas fa-arrow-left me-2"></i>Back to Shop
                </a>
            </div>
        `;
        return;
    }

    cartItems.forEach(item => {
        const totalPrice = item.price * item.quantity;
        const stars = Math.round(item.rating || 4); // Default to 4 if not available

        const card = document.createElement('div');
        card.className = 'col';
        card.innerHTML = `
            <div class="card product-card p-3 h-100 position-relative">
                <img src="${item.thumbnail}" class="card-img-top product-image" alt="${item.title}">
                <div class="card-body">
                    <h5 class="card-title">${item.title}</h5>
                    <p class="card-text text-muted">Quantity: ${item.quantity}</p>
                    <p class="card-text">Total: $${totalPrice.toFixed(2)}</p>
                </div>
                <div class="card-footer bg-transparent">
                    <div class="d-flex justify-content-between align-items-center">
                        <span class="h5">$${item.price} each</span>
                        <div class="rating">
                            ${'★'.repeat(stars)}${'☆'.repeat(5 - stars)}
                        </div>
                    </div>
                    <button class="btn btn-danger mt-3 w-100 remove-btn" data-id="${item.id}">
                        <i class="fas fa-trash me-2"></i>Remove
                    </button>
                </div>
            </div>
        `;
        cartContainer.appendChild(card);
    });

    // Attach event listeners to remove buttons
    document.querySelectorAll('.remove-btn').forEach(btn => {
        btn.addEventListener('click', function () {
            const id = parseInt(this.getAttribute('data-id'));
            removeFromCart(id);
            renderCartItems(); // Re-render after removal
            updateCartCount();
        });
    });
}

function removeFromCart(id) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart = cart.filter(item => item.id !== id);
    localStorage.setItem('cart', JSON.stringify(cart));
}

document.addEventListener('DOMContentLoaded', function () {
    renderCartItems();
});