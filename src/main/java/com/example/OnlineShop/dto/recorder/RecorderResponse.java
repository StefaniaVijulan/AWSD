package com.example.OnlineShop.dto.recorder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
public class RecorderResponse {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRecorded;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExpected;

    public RecorderResponse(Date dateRecorded, Date dateExpected) {
        this.dateRecorded = dateRecorded;
        this.dateExpected = dateExpected;
    }

    public RecorderResponse() {
    }
}
