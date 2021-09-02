package com.senlainc.service;

import com.senlainc.config.RabbitProperties;
import com.senlainc.dao.CheckerDao;
import com.senlainc.dao.ProductDao;
import com.senlainc.dto.product.SaveProductCheckerRequest;
import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.entity.ProductChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.senlainc.enums.CheckerStatus;
import com.senlainc.mappers.product.ProductMapper;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckerService {

    private static final Logger LOGGER = Logger.getLogger(CheckerService.class);

    @Autowired
    private CheckerDao checkerDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private RabbitProperties properties;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("checkerTemplate")
    private RabbitTemplate checkerTemplate;

    @Autowired
    private ProductMapper productMapper;

    public CheckerService(CheckerDao checkerDao){
        this.checkerDao = checkerDao;
    }

    @Transactional(readOnly = true)
    public List<ProductChecker> getAllPendingProducts(){
        Optional<List<ProductChecker>> list = checkerDao.getAllPendingProducts();
        if(list.isPresent()){
            return list.get();
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public ProductChecker getProductById(Long id){
        return checkerDao.getById(id);
    }

    public void makerProducer(SaveProductCheckerRequest request) {
        ProductChecker productChecker = productMapper.fromSaveProductRequestToProductChecker(request);
        productChecker.setCheckerStatus(CheckerStatus.PENDING);
        rabbitTemplate.convertAndSend(productChecker);
    }

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "maker.queue")
    public void makerConsumer(){
        ProductChecker productChecker = (ProductChecker) rabbitTemplate.receiveAndConvert(properties.getMAKER_QUEUE_NAME());
        LOGGER.warn(productChecker.toString());
        LOGGER.warn(productChecker);
        LOGGER.info(productChecker);
        //ТУТ НЕ ОБРАБАТЫВАЕТ ВЗЯТЫЕ ОБЪЕКТЫ
        checkerDao.save(productChecker);
    }

    public void checkerProducer(long id) {
        ProductChecker productChecker = checkerDao.getById(id);
        Product product = productMapper.fromProductCheckerToProduct(productChecker);
        checkerTemplate.convertAndSend(product);
    }

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "checker.queue")
    public void checkerConsumer(){
        Product product = (Product) checkerTemplate.receiveAndConvert(properties.getCHECKER_QUEUE_NAME());
        productDao.save(product);
    }
}
