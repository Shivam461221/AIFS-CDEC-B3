document.addEventListener('DOMContentLoaded', function() {
            fetch('https://dummyjson.com/products')
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    // Update product count
                    document.getElementById('product-count').textContent = `${data.products.length} Products`;
                    
                    // Clear loading spinner
                    const productsContainer = document.getElementById('products-container');
                    productsContainer.innerHTML = '';
                    
                    // Create product cards
                    data.products.forEach(product => {
                        const discountPercentage = Math.round(product.discountPercentage);
                        const stars = Math.round(product.rating);
                        
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
                                    <button class="btn btn-primary mt-3 w-100">
                                        <i class="fas fa-shopping-cart me-2"></i>Add to Cart
                                    </button>
                                </div>
                            </div>
                        `;
                        productsContainer.appendChild(card);
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