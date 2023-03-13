package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//공통 메소드 선언
@RequestMapping("/api/v1/get-api")
public class GetController {

    //1. RequestMapping으로 구현하기
    //localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String getHello(){
        return "Hello Welcome to JAVA World!";
    }

    //2. 매개변수가 없는 GET 메소드 구현
    //localhost:8080/api/v1/get-api/name
    @RequestMapping(value = "/name")
    public String getName(){
        return "Hyomin_JAVA";
    }

    //3. PathVariable을 활용한 GET 메소드
    //localhost:8080/api/v1/get-api/variable1/{String값}
    @RequestMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //어노테이션과 메소드 매개변수 명 다른 경우
    //localhost:8080/api/v1/get-api/variable2/{String값}
    @RequestMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //4. RequestParam을 활용한 GET메소드 구현
    //localhost:8080/api/v1/get-api/request1?name=value&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name+" "+email+" "+organization;
    }

    //어떤 값이 들어올 지 모르는 경우 : Map 사용
    //localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });

        return sb.toString();
    }
}
