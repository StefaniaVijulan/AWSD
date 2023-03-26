package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.dto.recorder.RecorderRequest;
import com.example.OnlineShop.dto.recorder.RecorderResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Customer;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Recorder;
import com.example.OnlineShop.repository.CategoryRepository;
import com.example.OnlineShop.repository.OrderRepository;
import com.example.OnlineShop.repository.RecorderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecorderServiceTest {

    @InjectMocks
    private RecorderService recorderService;

    @Mock
    private RecorderRepository recorderRepository;

    @Mock
    private OrderRepository orderRepository;


    @Test
    @DisplayName("New recorder Test")
    void addRecorder() {
        //mock entity
        Customer customer = new Customer();
        customer.setIdCustomer(1);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        Order order = new Order();
        order.setIdOrder(1);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setCustomer(customer);
        order.setProducts(null);

        Recorder recorder = new Recorder();
        recorder.setDateRecorded(new Date(2023 - 01 - 02));
        recorder.setDateExpected(new Date(2023 - 01 - 12));
        recorder.setOrder(order);
        //mock response
        RecorderResponse recorderResponse = new RecorderResponse(new Date(2023 - 01 - 02), new Date(2023 - 01 - 12));
        //mock request
        RecorderRequest recorderRequest = new RecorderRequest(new Date(2023 - 01 - 02), new Date(2023 - 01 - 12), order);
        lenient().when(orderRepository.findById(1)).thenReturn(java.util.Optional.of(order));

        lenient().when(orderRepository.save(order)).thenReturn(order);

        lenient().when(recorderRepository.save(recorder)).thenReturn(recorder);
        RecorderResponse actual = recorderService.addRecorder(recorderRequest, order.getIdOrder());
        assertEquals(actual, recorderResponse);
    }

    @Test
    @DisplayName("Edit recorder - Test")
    void editRecorder() {
        Customer customer = new Customer();
        customer.setIdCustomer(3);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        Order order = new Order();
        order.setIdOrder(1);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setCustomer(customer);
        order.setProducts(null);

        Recorder recorder = new Recorder();
        recorder.setIdRecorder(2);
        recorder.setDateRecorded(new Date(2023 - 01 - 02));
        recorder.setDateExpected(new Date(2023 - 01 - 12));
        recorder.setOrder(order);
        //mock response
        RecorderResponse recorderResponse = new RecorderResponse(new Date(2023 - 05 - 02), new Date(2023 - 05 - 12));
        //mock request
        RecorderRequest recorderRequest = new RecorderRequest(new Date(2023 - 05 - 02), new Date(2023 - 05 - 12), order);
        lenient().when(orderRepository.findById(1)).thenReturn(java.util.Optional.of(order));
        lenient().when(orderRepository.save(order)).thenReturn(order);
        lenient().when(recorderRepository.findById(2)).thenReturn(java.util.Optional.of(recorder));
        lenient().when(recorderRepository.save(recorder)).thenReturn(recorder);
        RecorderResponse actual = recorderService.editRecorder(recorderRequest, recorder.getIdRecorder());
        assertEquals(actual, recorderResponse);

    }

    @Test
    @DisplayName("Get all recorder - Test")
    void getAllRecorder() {
        List<Recorder> recorderList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setIdCustomer(3);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        Order order = new Order();
        order.setIdOrder(1);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setCustomer(customer);
        order.setProducts(null);

        Recorder recorder = new Recorder();
        recorder.setIdRecorder(2);
        recorder.setDateRecorded(new Date(2023 - 01 - 02));
        recorder.setDateExpected(new Date(2023 - 01 - 12));
        recorder.setOrder(order);
        recorderList.add(recorder);
        recorder.setIdRecorder(4);
        recorder.setDateRecorded(new Date(2023 - 03 - 02));
        recorder.setDateExpected(new Date(2023 - 03 - 12));
        recorder.setOrder(order);
        recorderList.add(recorder);


        when(recorderRepository.findAll()).thenReturn(recorderList);
        List<Recorder> recorders = recorderService.getAllRecorders();
        assertEquals(recorders, recorderList);
    }

    @Test
    @DisplayName("Delete recorder - Test")
    void deleteRecorder(){

        Customer customer = new Customer();
        customer.setIdCustomer(3);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        Order order = new Order();
        order.setIdOrder(1);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setCustomer(customer);
        order.setProducts(null);

        Recorder recorder = new Recorder();
        recorder.setIdRecorder(2);
        recorder.setDateRecorded(new Date(2023 - 01 - 02));
        recorder.setDateExpected(new Date(2023 - 01 - 12));
        recorder.setOrder(order);

        when(recorderRepository.findById(recorder.getIdRecorder())).thenReturn(Optional.ofNullable(recorder));

        String result = recorderService.deleteRecorder(recorder.getIdRecorder());
        assertEquals(result, "Successfully delete");

    }


}
