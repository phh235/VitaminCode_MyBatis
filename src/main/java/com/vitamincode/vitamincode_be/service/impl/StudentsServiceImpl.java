package com.vitamincode.vitamincode_be.service.impl;import com.vitamincode.vitamincode_be.convert.StudentMapStruct;import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;import com.vitamincode.vitamincode_be.dto.response.StudentDtoResponse;import com.vitamincode.vitamincode_be.exception.AppException;import com.vitamincode.vitamincode_be.exception.ErrorCode;import com.vitamincode.vitamincode_be.mapper.StudentsMapper;import com.vitamincode.vitamincode_be.service.StudentsService;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;import java.util.List;import java.util.Objects;@Service@RequiredArgsConstructorpublic class StudentsServiceImpl implements StudentsService {    private final StudentsMapper studentsMapper;    private final StudentMapStruct studentMapStruct;    @Override    public List<StudentDtoResponse> findAllStudents() {        var listEntityResult = studentsMapper.findAllStudents();        if(listEntityResult.isEmpty()) throw new AppException(ErrorCode.LIST_STUDENT_EMPTY);        return studentMapStruct.toStudentDtoResponseList(listEntityResult);    }    @Override    public StudentDtoResponse findStudentById(Integer studentId) {        var resultEntity = studentsMapper.findStudentById(studentId);        if (Objects.isNull(resultEntity)) throw new AppException(ErrorCode.STUDENT_EMPTY);        return studentMapStruct.toClassDtoResponse(resultEntity);    }    @Override    public Integer insertStudent(StudentDtoRequest studentDtoRequest) {        var studentEntity = studentMapStruct.toStudent(studentDtoRequest);        int result = studentsMapper.insertStudent(studentEntity);        if(result == 0) throw new AppException(ErrorCode.INSERT_FAIL);        return result;    }    @Override    public Integer updateStudent(StudentDtoRequest studentDtoRequest) {        var studentEntity = studentMapStruct.toStudent(studentDtoRequest);        int result = studentsMapper.updateStudent(studentEntity);        if(result == 0) throw new AppException(ErrorCode.UPDATE_FAIL);        return result;    }    @Override    public Integer deleteStudent(Integer studentId) {        int result = studentsMapper.deleteStudent(studentId);        if(result == 0) throw new AppException(ErrorCode.DELETE_FAIL);        return result;    }}