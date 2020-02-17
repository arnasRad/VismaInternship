package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;
import com.arnasrad.vismainternship.service.revolut.request.RevolutTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final RevolutTransferService revolutTransferService;

    @Autowired
    public TransferController(RevolutTransferService revolutTransferService) {

        this.revolutTransferService = revolutTransferService;
    }

    @PostMapping(value = "/revolut/transfer", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String createTransfer(@RequestBody TransferRequestBody body) {

        return revolutTransferService.createTransfer(body);
    }
}
