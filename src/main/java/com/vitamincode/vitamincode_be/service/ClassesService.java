package com.vitamincode.vitamincode_be.service;import com.vitamincode.vitamincode_be.entity.Classes;import java.util.List;public interface ClassesService {    List<Classes> findAllClasses();    Classes findClassById(Integer classId);}