package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.recorder.RecorderRequest;
import com.example.OnlineShop.dto.recorder.RecorderResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Recorder;
import com.example.OnlineShop.service.RecorderService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recorder")
public class RecorderController {

    private final RecorderService recorderService;

    public RecorderController(RecorderService recorderService) {
        this.recorderService = recorderService;
    }
    @PostMapping("/addRecorder")
    public RecorderResponse addRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idOrder){
        return recorderService.addRecorder(recorder, idOrder);
    }

    @PutMapping("/editRecorder")
    public RecorderResponse editRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idRecorder){
        return  recorderService.editRecorder(recorder, idRecorder);
    }

    @DeleteMapping("/deleteRecorder")
    public String deleteRecorder(@RequestParam Integer idRecorder){

        return recorderService.deleteRecorder(idRecorder);
    }

    @GetMapping("/getAllRecorder")
    public List<Recorder> getAllRecorder(){
        return recorderService.getAllRecorders();
    }

    @PutMapping("/editDataExpected/{idRecorder}")
    public Recorder editDataExpected(@PathVariable Integer idRecorder, @RequestParam String dataExpected) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-DD").parse(dataExpected);
        return recorderService.editDataExpected(idRecorder, date1);

    }

}
