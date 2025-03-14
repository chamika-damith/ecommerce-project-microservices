package com.example.orderservice.service.impl;


import com.example.orderservice.dao.OrderDao;
import com.example.orderservice.dto.impl.OrderDTO;
import com.example.orderservice.entity.impl.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.util.Mapping;
import com.example.productservice.dto.impl.ProductDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final WebClient webClient;

    private final OrderDao orderDao;
    private final Mapping orderMapper;

    public OrderServiceImpl(WebClient webClient, OrderDao orderDao, Mapping productMapper) {
        this.webClient = webClient;
        this.orderDao = orderDao;
        this.orderMapper = productMapper;
    }

    @Override
    public void save(OrderDTO dto) {

        Integer productId = dto.getItemId();


        try {
            ProductDTO productDTO = webClient.get()
                    .uri("/product-service/{itemId}", productId)
                    .retrieve()
                    .bodyToMono(ProductDTO.class)
                    .block();

            if (productDTO != null && productDTO.getStock() >= dto.getAmount()) {
                int updatedStock = productDTO.getStock() - dto.getAmount();
                productDTO.setStock(updatedStock);

                webClient.put()
                        .uri("/product-service/{itemId}", productId)
                        .bodyValue(productDTO)
                        .retrieve()
                        .bodyToMono(Void.class)
                        .block();

                Order orderEntity = orderMapper.toOrderEntity(dto);
                orderDao.save(orderEntity);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Long id) {
        Optional<Order> byId = orderDao.findById(id);
        byId.ifPresent(orderDao::delete);
    }

    @Override
    public void update(Long id, OrderDTO dto) {
        Optional<Order> byId = orderDao.findById(id);
        if (byId.isPresent()){
            Order order = byId.get();

            order.setCustomerEmail(dto.getCustomerEmail());
            order.setOrderDate(dto.getOrderDate());
            order.setAmount(dto.getAmount());

            orderDao.save(order);
        }
    }

    @Override
    public OrderDTO get(Long id) {
        if (orderDao.existsById(id)) {
            Order referenceById = orderDao.getReferenceById(id);

            return orderMapper.toOrderDTO(referenceById);
        }
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderMapper.toOrderDTOList(orderDao.findAll());
    }
}
