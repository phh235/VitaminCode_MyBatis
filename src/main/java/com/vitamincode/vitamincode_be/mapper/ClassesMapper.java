package com.vitamincode.vitamincode_be.mapper;import com.vitamincode.vitamincode_be.entity.Classes;import org.apache.ibatis.annotations.Mapper;import java.util.List;@Mapperpublic interface ClassesMapper {    List<Classes> findAllClasses();}