package com.senlainc.service;

import com.senlainc.dao.AccountDao;
import com.senlainc.dao.ProductDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.product.AddProductRequest;
import com.senlainc.entity.Account;
import com.senlainc.entity.Product;
import com.senlainc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.remove(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Product addProduct(AddProductRequest request) {
        Product newProduct = new Product(request.getName(), request.getPrice());
        User seller = userDao.findById(request.getUserId());
        checkUserAccount(seller);
        newProduct.setUser(seller);
        if(request.getDescription() != null){
            newProduct.setDescription(request.getDescription());
        }
        return productDao.save(newProduct);
    }

    @Override
    public void buyProduct(Long productId, Long buyerId) {
        Product product = productDao.findById(productId);
        User buyer = userDao.findById(buyerId);
        if(solvencyBuyerCheck(buyer, product)){
            accountDao.getAccountByUserId(buyerId).withdrawMoney(product.getPrice());
            accountDao.getAccountByUserId(product.getSeller().getId()).putMoney(product.getPrice());
            productDao.remove(productId);
        }
    }

    private boolean solvencyBuyerCheck(User buyer, Product product) {
        Account account = accountDao.getAccountByUserId(buyer.getId());
        if(account != null && account.getAccountMoney().compareTo(product.getPrice()) > 0){
            return  true;
        }
        return false;
    }

    private void checkUserAccount(User seller) {
        if(accountDao.getAccountByUserId(seller.getId()) == null){
            Account account = new Account();
            account.setUser(seller);
            accountDao.save(account);
        }
    }




}