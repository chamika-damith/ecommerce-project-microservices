package com.example.orderservice.controller;


import com.example.orderservice.customstatus.ErrorStatus;
import com.example.orderservice.customstatus.SuccessStatus;
import com.example.orderservice.dto.CustomStatus;
import com.example.orderservice.dto.impl.OrderDTO;
import com.example.orderservice.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    public OrderController( OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus saveOrder(@RequestBody OrderDTO orderDTO){
        if (orderDTO == null){
            return new ErrorStatus(204, "Error saving order");
        }

        orderService.save(orderDTO);
        return new SuccessStatus(201,"order saved successfully!");
    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus updateOrder(@RequestBody OrderDTO orderDTO,@PathVariable Long orderId){
        if (orderDTO == null){
            return new ErrorStatus(204, "Error update order");
        }

        orderService.update(orderId,orderDTO);
        return new SuccessStatus(201," order successfully!");
    }

    @GetMapping(value = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO getOrder(@PathVariable Long orderId){
        return orderService.get(orderId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return orderService.getAll();
    }

    @DeleteMapping(value = "/{orderId}")
    public CustomStatus deleteOrder(@PathVariable Long orderId){
        if (orderId == null){
            return new ErrorStatus(204, "Error delete order");
        }

        orderService.delete(orderId);
        return new SuccessStatus(200, "Success delete order");
    }



}
