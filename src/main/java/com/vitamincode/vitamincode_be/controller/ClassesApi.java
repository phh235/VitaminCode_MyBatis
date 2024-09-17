package com.vitamincode.vitamincode_be.controller;import com.vitamincode.vitamincode_be.service.ClassesService;import lombok.RequiredArgsConstructor;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;import java.util.LinkedHashMap;import java.util.Map;@RestController@RequiredArgsConstructor@RequestMapping("/api/v1/classes/")public class ClassesApi {    private final ClassesService classesService;    @GetMapping("findAllClasses")    public ResponseEntity<?> findAllClasses() {        Map<String, Object> result = new LinkedHashMap<>();        try {            result.put("status", 200);            result.put("success", true);            result.put("data", classesService.findAllClasses());        }catch (Exception e) {            result.put("status", 500);            result.put("success", false);            result.put("message", e.getMessage());        }        return ResponseEntity.ok(result);//        return ResponseEntity.ok(classesService.findAllClasses());    }    @GetMapping("findClassById/{classId}")    public ResponseEntity<?> findClassById(@PathVariable("classId") Integer classId) {        return ResponseEntity.ok(classesService.findClassById(classId));    }}