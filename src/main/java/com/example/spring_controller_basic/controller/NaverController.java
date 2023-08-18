package com.example.spring_controller_basic.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_controller_basic.naver_util.Naver_API;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("naver")
public class NaverController {
    @PostMapping("csr")
    public ResponseEntity<?> csr(HttpServletRequest req, @RequestBody MultipartFile uploadFile) {
        String uploadPath = req.getServletContext().getRealPath("/upload");
        
        String filename = uploadFile.getOriginalFilename();
        String filepath = uploadPath + File.separator + filename;
        System.out.println(filepath);
        String message;
        try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
		} catch (Exception e) {			
			e.printStackTrace();		
            message = "fail";
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        message = Naver_API.processSTT(filepath);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("cfr")
    public ResponseEntity<?> cfr(HttpServletRequest req, @RequestBody MultipartFile uploadFile, String select) {
        String uploadPath = req.getServletContext().getRealPath("/upload");
        
        String filename = uploadFile.getOriginalFilename();
        String filepath = uploadPath + File.separator + filename;
        System.out.println(filepath);
        String message;
        try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
			
		} catch (Exception e) {			
			e.printStackTrace();		
            message = "fail";
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        message = Naver_API.processCFR(filepath, select);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("tts")
    public ResponseEntity<?> tts(@RequestParam String message) {
        byte[] speechData = Naver_API.processTTS(message);
        return new ResponseEntity<>(new ByteArrayResource(speechData), HttpStatus.OK);
    }

    @PostMapping("ocr")
    public ResponseEntity<?> ocr(HttpServletRequest req, @RequestBody MultipartFile uploadFile) {
        String uploadPath = req.getServletContext().getRealPath("/upload");
        
        String filename = uploadFile.getOriginalFilename();
        String filepath = uploadPath + File.separator + filename;
        System.out.println(filepath);
        String message;
        try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
			
		} catch (Exception e) {			
			e.printStackTrace();		
            message = "fail";
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        message = Naver_API.processOCR(filepath);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
