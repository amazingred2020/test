package com.senlainc.service;

import com.senlainc.config.RabbitProperties;
import com.senlainc.dao.CheckerDao;
import com.senlainc.dao.ProductDao;
import com.senlainc.dto.product.SaveProductCheckerRequest;
import com.senlainc.entity.Product;
import com.senlainc.entity.ProductChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.senlainc.enums.CheckerStatus;
import com.senlainc.mappers.product.ProductMapper;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckerServiceImpl implements CheckerService{

    @Autowired
    private CheckerDao checkerDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private RabbitProperties properties;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ProductChecker> getAllPendingProducts(){
        Optional<List<ProductChecker>> list = checkerDao.getAllPendingProducts();
        if(list.isPresent()){
            return list.get();
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    @Override
    public ProductChecker getProductById(Long id){
        return checkerDao.getById(id);
    }

    @Override
    public void makerProducer(SaveProductCheckerRequest request) {
        ProductChecker productChecker = productMapper.fromSaveProductRequestToProductChecker(request);
        productChecker.setCheckerStatus(CheckerStatus.PENDING);
        rabbitTemplate.setRoutingKey(properties.getMakerRoutingKey());
        rabbitTemplate.setExchange(properties.getMakerExchangeName());
        rabbitTemplate.convertAndSend(productChecker);
    }

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "maker.queue")
    @Override
    public void makerConsumer(ProductChecker productChecker){
        checkerDao.save(productChecker);
    }

    @Override
    public void checkerProducer(long id) {
        ProductChecker productChecker = checkerDao.getById(id);
        Product product = productMapper.fromProductCheckerToProduct(productChecker);
        productChecker.setCheckerStatus(CheckerStatus.APPROVE);
        checkerDao.save(productChecker);
        rabbitTemplate.setRoutingKey(properties.getCheckerRoutingKey());
        rabbitTemplate.setExchange(properties.getCheckerExchangeName());
        rabbitTemplate.convertAndSend(product);
    }

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "checker.queue")
    @Override
    public void checkerConsumer(Product product){
        Product targetProduct = productDao.findById(product.getId());
        targetProduct.setName(product.getName());
        targetProduct.setDescription(product.getDescription());
        targetProduct.setPrice(product.getPrice());
        productDao.save(product);
    }

    @Override
    public void rejectUpdate(long id) {
        ProductChecker productChecker = checkerDao.getById(id);
        productChecker.setCheckerStatus(CheckerStatus.REJECT);
        checkerDao.save(productChecker);
    }
}