package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.recorder.RecorderRequest;
import com.example.OnlineShop.dto.recorder.RecorderResponse;
import com.example.OnlineShop.model.Recorder;
import com.example.OnlineShop.service.RecorderServiceInt;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recorder")
public class RecorderController {

    private final RecorderServiceInt recorderServiceInt;

    public RecorderController(RecorderServiceInt recorderServiceInt) {
        this.recorderServiceInt = recorderServiceInt;
    }

    @PostMapping
    public RecorderResponse addRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idOrder){
        return recorderServiceInt.addRecorder(recorder, idOrder);
    }

    @PutMapping
    public RecorderResponse editRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idRecorder){
        return  recorderServiceInt.editRecorder(recorder, idRecorder);
    }

    @DeleteMapping
    public String deleteRecorder(@RequestParam Integer idRecorder){

        return recorderServiceInt.deleteRecorder(idRecorder);
    }

    @GetMapping
    public List<Recorder> getAllRecorder(){
        return recorderServiceInt.getAllRecorders();
    }

}
