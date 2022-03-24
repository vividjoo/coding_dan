package org.zerock.ex1.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.IsInstanceOf;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex1.dto.SampleDTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public String[] hello() {


        return new String[]{"Hello", "world!"};
    }

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1..");
//        return "sample/ex1";
    }

    @GetMapping({"/ex2", "/exLink"})
    public void exModel(Model model) {

        List<SampleDTO> list = IntStream.rangeClosed(1, 11).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder().sno(i).first("first..." + i).last("last..." + i).regTime(LocalDateTime.now()).build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping({"/exinline"})
    public String exInline(RedirectAttributes redirectAttributes) {
        log.info("exinline");
        SampleDTO dto = SampleDTO.builder().sno(100L).first("first ... 100L").last("last...100L").regTime(LocalDateTime.now()).build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);
        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void ex3() {
        log.info("ex03...");
    }

    @GetMapping("/exLayout1")
    public void exLayout1(){
        log.info("exlayout........");
     }

     @GetMapping("/exlayout1")
    public void exlayout1() {
        log.info("exlayout1...");
     }
}
