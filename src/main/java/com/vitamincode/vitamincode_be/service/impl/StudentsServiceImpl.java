package com.vitamincode.vitamincode_be.service.impl;import com.vitamincode.vitamincode_be.convert.StudentMapStruct;import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;import com.vitamincode.vitamincode_be.dto.response.StudentDtoResponse;import com.vitamincode.vitamincode_be.entity.Students;import com.vitamincode.vitamincode_be.mapper.StudentsMapper;import com.vitamincode.vitamincode_be.service.StudentsService;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;import java.util.List;import java.util.Objects;@Service@RequiredArgsConstructorpublic class StudentsServiceImpl implements StudentsService {    private final StudentsMapper studentsMapper;    private final StudentMapStruct studentMapStruct;    @Override    public List<StudentDtoResponse> findAllStudents() {        List<StudentDtoResponse> studentDtoResponseList = studentsMapper.findAllStudents()                .stream()                .map(studentMapStruct::toClassDtoResponse)                .toList();        if (!studentsMapper.findAllStudents().isEmpty()) {            return studentDtoResponseList;        }        return null;    }    @Override    public StudentDtoResponse findStudentById(Integer studentId) {        var resultEntity = studentsMapper.findStudentById(studentId);        if(Objects.nonNull(resultEntity)) {            return studentMapStruct.toClassDtoResponse(resultEntity);        }        return null;    }    @Override    public Integer insertStudent(StudentDtoRequest studentDtoRequest) {        var studentEntity = studentMapStruct.toStudent(studentDtoRequest);        return studentsMapper.insertStudent(studentEntity);    }    @Override    public Integer updateStudent(StudentDtoRequest studentDtoRequest) {        var studentEntity = studentMapStruct.toStudent(studentDtoRequest);        return studentsMapper.updateStudent(studentEntity);    }    @Override    public Integer deleteStudent(Integer studentId) {        return studentsMapper.deleteStudent(studentId);    }}