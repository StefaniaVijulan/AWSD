package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.recorder.RecorderRequest;
import com.example.OnlineShop.dto.recorder.RecorderResponse;
import com.example.OnlineShop.model.Recorder;

import java.util.Date;
import java.util.List;

public interface RecorderServiceInt {

    public RecorderResponse addRecorder(RecorderRequest recorder, Integer idOrder);
    public RecorderResponse editRecorder(RecorderRequest recorderRequest, Integer idRecorder);
    public String deleteRecorder(Integer idRecorder);
    public List<Recorder> getAllRecorders();
    public Recorder editDataExpected(Integer idRecorder, Date dataExpected);
}
