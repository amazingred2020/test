package com.senlainc.service;

import com.senlainc.dao.AccountDao;
import com.senlainc.dao.ProductDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Account;
import com.senlainc.entity.Product;
import com.senlainc.entity.User;
import com.senlainc.mappers.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product addProduct(SaveProductRequest request) {
        Product newProduct = productMapper.fromSaveProductRequestToProduct(request);
        User seller = userDao.findById(request.getUserId());
        checkUserAccount(seller);
        return productDao.save(newProduct);
    }

    @Override
    public void buyProduct(Long productId, Long buyerId) {
        Product product = productDao.findById(productId);
        User buyer = userDao.findById(buyerId);
        if(solvencyBuyerCheck(buyer, product)){
            accountDao.getAccountByUser(buyer.getId()).get().withdrawMoney(product.getPrice());
            accountDao.getAccountByUser(product.getUser().getId()).get().putMoney(product.getPrice());
            productDao.remove(productId);
        }
    }

    private boolean solvencyBuyerCheck(User buyer, Product product) {
        Account account = accountDao.getAccountByUser(buyer.getId()).get();
        if(account != null && account.getAccountMoney().compareTo(product.getPrice()) > 0){
            return  true;
        }
        return false;
    }

    private void checkUserAccount(User seller) {
        if(!accountDao.getAccountByUser(seller.getId()).isPresent()){
            Account account = new Account();
            account.setUser(seller);
            account.setAccountNumber(Long.valueOf(new Random().nextInt(100000000)));
            account.setAccountMoney(new BigDecimal(0.00));
            accountDao.save(account);
        }
    }




}