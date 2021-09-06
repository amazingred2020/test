package com.senlainc.service;

import com.senlainc.dto.product.SaveProductCheckerRequest;
import com.senlainc.entity.Product;
import com.senlainc.entity.ProductChecker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CheckerService {
    @Transactional(readOnly = true)
    List<ProductChecker> getAllPendingProducts();

    @Transactional(readOnly = true)
    ProductChecker getProductById(Long id);

    void makerProducer(SaveProductCheckerRequest request);

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "maker.queue")
    void makerConsumer(ProductChecker productChecker);

    void checkerProducer(long id);

    @RabbitListener(containerFactory = "listenerContainerFactory", queues = "checker.queue")
    void checkerConsumer(Product product);

    void rejectUpdate(long id);
}
