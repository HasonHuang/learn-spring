package com.ihason.learn.springboot.cache.api;

import com.ihason.learn.springboot.cache.config.PersonCache;
import com.ihason.learn.springboot.cache.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/persons")
@PersonCache
public class PersonApi {

    private List<PersonDto> persons = new ArrayList<>();

//    @Cacheable(cacheNames = "person")
    @Cacheable
    @GetMapping
    public List<PersonDto> listAll() {
        log.info("Generate all persons");
        persons = Arrays.asList(create(1L), create(2L), create(3L));
        return persons;
    }

//    @Cacheable(cacheNames = "person", key = "#p0")
    @Cacheable(key = "#p0")
    @GetMapping("/{id}")
    public PersonDto get(@PathVariable Long id) {
        log.info("Finding person by id: {}", id);
        return persons.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    private static PersonDto create(long id) {
        return new PersonDto(id, "Name-" + id);
    }

}
