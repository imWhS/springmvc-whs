package hello.springmvcwhs.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    //HTTP 메서드의 종류 관계 없이 모든 요청 매핑
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    //특정 HTTP 메서드의 요청만 매핑
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    //@RequestMapping의 HTTP 메서드 속성이 축약된 어노테이션 사용
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /*
    경로 변수 활용 핸들러 메서드
     */

    //단일 경로 변수 사용
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    //다중 경로 변수 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(
            @PathVariable("userId") String userId,
            @PathVariable("orderId") String orderId
    ) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    //URL, HTTP 메서드 뿐 아니라 요청 파라미터까지 매핑 조건에 추가
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    //특정 헤더 키에 대한 값까지 매핑 조건에 추가
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

}
