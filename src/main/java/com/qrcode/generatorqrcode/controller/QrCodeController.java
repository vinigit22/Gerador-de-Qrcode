package com.qrcode.generatorqrcode.controller;

import com.google.zxing.WriterException;
import com.qrcode.generatorqrcode.service.QrCodeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/qrcode")
@CrossOrigin(origins = "*")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateQrCode(
            @RequestParam String url,
            @RequestParam(defaultValue = "300") int width,
            @RequestParam(defaultValue = "300") int height) {

        try {
            byte[] qrCode = qrCodeService.generateQrCode(url, width, height);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(qrCode);

        } catch (WriterException | IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}