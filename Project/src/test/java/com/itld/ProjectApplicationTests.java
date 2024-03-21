package com.itld;

import com.itld.demos.web.dao.Pet;
import com.itld.demos.web.mapper.petMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {
@Autowired(required = false)
private petMapper petMapper;
    @Test
    void selectList() {
        List<Pet> petList = petMapper.selectList(null);
        petList.forEach(System.out::println);
    }

}
