package com.vitamincode.vitamincode_be.mapper;import com.vitamincode.vitamincode_be.entity.Students;import org.apache.ibatis.annotations.Mapper;import java.util.List;@Mapperpublic interface StudentsMapper {    List<Students> findAllStudents();    Students findStudentById(Integer studentId);}