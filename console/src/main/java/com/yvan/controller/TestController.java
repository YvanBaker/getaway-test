package com.yvan.controller;


import org.springframework.web.bind.annotation.RestController;


/**
 * @author v_yangfeng01
 * @date 2021/2/12
 */
@RestController
public class TestController {



    /*@GetMapping("/test")
    public TestResponse test(@PathParam("s") String s) {
        TestResponse testResponse = new TestResponse();
        testResponse.setMsg(s);
        return testResponse;
    }

    @GetMapping("/testRedis")
    public Mono<TestResponse> testRedis(@PathParam("id") String id,@PathParam("s") String s) {
        TestResponse ret = new TestResponse();
        try {
            redisService.add(id,s,ret);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setCode("400");
            ret.setMsg(e.getMessage());
        }
        return Mono.just(ret);
    }

    @GetMapping("/url")
    public Mono<TestResponse> url() {
        String url = "http://www.baidu.com?word=12";
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
        TestResponse testResponse = new TestResponse();
        testResponse.setMsg(uri.toString());
        return Mono.just(testResponse);
    }*/
}
