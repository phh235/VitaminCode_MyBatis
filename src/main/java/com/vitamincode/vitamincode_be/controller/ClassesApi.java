package com.vitamincode.vitamincode_be.controller;import com.vitamincode.vitamincode_be.entity.Classes;import com.vitamincode.vitamincode_be.service.ClassesService;import lombok.RequiredArgsConstructor;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.LinkedHashMap;import java.util.Map;@RestController@RequiredArgsConstructor@RequestMapping("/api/v1/classes/")public class ClassesApi {    private final ClassesService classesService;    @GetMapping("findAllClasses")    public ResponseEntity<?> findAllClasses() {        Map<String, Object> result = new LinkedHashMap<>();        try {            result.put("status", 200);            result.put("success", true);            result.put("data", classesService.findAllClasses());        } catch (Exception e) {            result.put("status", 500);            result.put("success", false);            result.put("message", e.getMessage());        }        return ResponseEntity.ok(result);    }    @GetMapping("findClassByClassName")    public ResponseEntity<?> findClassByClassName(@RequestParam String className) {        Map<String, Object> result = new LinkedHashMap<>();        try {            result.put("status", 200);            result.put("success", true);            result.put("data", classesService.findClassByClassName(className));        } catch (Exception e) {            result.put("status", 500);            result.put("success", false);            result.put("message", e.getMessage());        }        return ResponseEntity.ok(result);    }    @GetMapping("findClassById/{classId}")    public ResponseEntity<?> findClassById(@PathVariable("classId") Integer classId) {        return ResponseEntity.ok(classesService.findClassById(classId));    }    @GetMapping("findClassByIdRQ")    public ResponseEntity<?> findClassByIdRQ(@RequestParam Integer classId) {        return ResponseEntity.ok(classesService.findClassById(classId));    }    @PostMapping("insertClass")    public ResponseEntity<?> insertClass(@RequestBody Classes classes) {        Map<String, Object> result = new LinkedHashMap<>();        try {            result.put("status", 200);            result.put("success", true);            result.put("data", classesService.insertClass(classes));        } catch (Exception e) {            result.put("status", 500);            result.put("success", false);            result.put("message", e.getMessage());        }        return ResponseEntity.ok(result);    }    @PostMapping("updateClass")    public ResponseEntity<?> updateClass(@RequestBody Classes classes) {        return ResponseEntity.ok(classesService.updateClass(classes));    }    @DeleteMapping("deleteClass")    public ResponseEntity<?> deleteClass(@RequestParam("classId") Integer classId) {        return ResponseEntity.ok(classesService.deleteClass(classId));    }}