package hello.springmvcwhs.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //반환할 문자열을 HTTP 응답 메시지의 메시지 바디에 바로 write 하기 위해 사용한다.
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

//        아래 방식으로 사용해선 안 된다. log.debug() 호출만으로 문자열 접합 같은 의미 없는 연산이 실행돼버리기 때문이다.
//        log.debug("String concat log = " + name);

        return "ok";
    }

}
