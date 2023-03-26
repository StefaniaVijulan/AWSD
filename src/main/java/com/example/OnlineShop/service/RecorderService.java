package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.recorder.RecorderRequest;
import com.example.OnlineShop.dto.recorder.RecorderResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Recorder;
import com.example.OnlineShop.repository.OrderRepository;
import com.example.OnlineShop.repository.RecorderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class RecorderService {

    private final RecorderRepository recorderRepository;

    private final OrderRepository orderRepository;

    public RecorderService(RecorderRepository recorderRepository, OrderRepository orderRepository) {
        this.recorderRepository = recorderRepository;
        this.orderRepository = orderRepository;
    }

    public RecorderResponse addRecorder(RecorderRequest recorder, Integer idOrder){

        Order order =  orderRepository.findById(idOrder).orElseThrow(
                () -> new Custom("This order cannot be find"));
        Recorder recorder1 = new Recorder();
        recorder1.setDateExpected(recorder.getDateExpected());
        recorder1.setDateRecorded(recorder.getDateRecorded());
        recorder1.setOrder(order);
        recorderRepository.save(recorder1);

        RecorderResponse recorderResponse = new RecorderResponse();
        recorderResponse.setDateRecorded(recorder1.getDateRecorded());
        recorderResponse.setDateExpected(recorder1.getDateExpected());
        return recorderResponse;
    }
    public RecorderResponse editRecorder(RecorderRequest recorderRequest, Integer idRecorder){

        Recorder recorder1 =  recorderRepository.findById(idRecorder).orElseThrow(
                () -> new Custom("This recorder doesnt exist"));
        recorder1.setDateRecorded(recorderRequest.getDateRecorded());
        recorder1.setDateExpected(recorderRequest.getDateExpected());

        recorderRepository.save(recorder1);

        RecorderResponse recorderResponse = new RecorderResponse();
        recorderResponse.setDateExpected(recorder1.getDateExpected());
        recorderResponse.setDateRecorded(recorder1.getDateRecorded());
        return recorderResponse;
    }
    public String deleteRecorder(Integer idRecorder){
        Recorder recorder1 =  recorderRepository.findById(idRecorder).orElseThrow(
                () -> new Custom("This recorder doesnt exist"));
        recorderRepository.delete(recorder1);
        return "Successfully delete";
    }
    public List<Recorder> getAllRecorders(){
        return recorderRepository.findAll();
    }
    public Recorder editDataExpected(Integer idRecorder, Date dataExpected){
        System.out.println(dataExpected);
        Recorder recorder1 =  recorderRepository.findById(idRecorder).orElseThrow(
                () -> new Custom("This recorder doesnt exist"));
        recorder1.setDateExpected(dataExpected);
        return recorder1;
    }
}
