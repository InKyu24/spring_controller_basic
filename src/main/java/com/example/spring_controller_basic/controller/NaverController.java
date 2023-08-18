package com.example.spring_controller_basic.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_controller_basic.naver_util.NaverTTS;

@RestController
public class NaverController {
    @PostMapping("tts")
    public ResponseEntity<?> tts(@RequestParam String message) {
        byte[] speechData = NaverTTS.processTTS(message);
        return new ResponseEntity<>(new ByteArrayResource(speechData), HttpStatus.OK);
    }
}
