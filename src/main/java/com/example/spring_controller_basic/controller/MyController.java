package com.example.spring_controller_basic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_controller_basic.dto.Human;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api")
public class MyController {
    
    @GetMapping("getRequest")
    public String getRequest(Human human) {
        System.out.println("name: " + human.getName() + ", age: " + human.getAge());
        String response = "Hello " + human.getName() + ", your age is " + human.getAge();
        return response;
    }

    @PostMapping("postRequest")
    public String postRequest(@RequestBody Human human) {
        System.out.println("name: " + human.getName() + ", age: " + human.getAge());
        String response = "Hello " + human.getName() + ", your age is " + human.getAge();
        return response;
    }
    
    @GetMapping("getRequest_jsonResponse")
    public Human getRequest_jsonResponse() {
        Human human = new Human("홍길동", 30);
        return human;
    }

    @PostMapping("postRequest_withFormData")
    public String postRequest_withFormData(Human human) {
        System.out.println("name: " + human.getName() + ", age: " + human.getAge());
        String response = "Hello " + human.getName() + ", your age is " + human.getAge();
        return response;
    }

    @GetMapping("getRequest_ResponseEntity")
    public ResponseEntity<?> getRequest_ResponseEntity(String msg) {
        switch (msg) {
            case "정상":
                Human human = new Human("홍길동", 30);
                return new ResponseEntity<>(human, HttpStatus.OK);
            case "에러":
                return new ResponseEntity<>("500 에러 발생!!!",HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                String result = "400 에러 발생!!! '정상' 또는 '에러'라고 입력해주세요.";
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
