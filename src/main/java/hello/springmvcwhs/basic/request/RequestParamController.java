package hello.springmvcwhs.basic.request;

import hello.springmvcwhs.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username = {}, age = {}", memberName, memberAge);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username = {}, age = {}", username, age);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }


    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            //int, Integer, String 등 Java의 단순 기본(primitive) 타입으로 요청 파라미터 매핑 시 @RequestParam 생략 가능
            String username,
            int age
    ) {
        log.info("username = {}, age = {}", username, age);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    //경로 변수 별 필수 전달 여부 지정
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            //Optional한 age가 요청 파라미터에 포함되어 있지 않아 null로 전달받았을 때를 대비하기 위해 int의 Wrapped 타입인 Integer 사용 권장
            @RequestParam(required = false) Integer age
    ) {
        log.info("username = {}, age = {}", username, age);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    //빈 데이터로 전달받은 요청 파라미터에 대한 기본 값 적용 설정
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true) String username,
            @RequestParam(required = false, defaultValue = "-1") int age
    ) {
        log.info("username = {}, age = {}", username, age);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    //모든 요청 파라미터를 하나의 Map 타입을 통해 받아오도록 설정
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        Object username = paramMap.get("username");
        Object age = paramMap.get("age");
        log.info("username = {}, age = {}", username, age);

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    //요청 파라미터를 자동으로 객체에 바인딩하도록 설정
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }

    @ResponseBody
    @RequestMapping("/model-attrivute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";
        //이후 뷰 템플릿 조회 없이 바로 클라이언트에게 응답을 전달하는 프로세스 진행
    }
}
