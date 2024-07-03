package com.ayushi.controller;

import com.ayushi.service.SubjectIdManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SubjectIdController {

    @Autowired
    private final SubjectIdManagerServiceImpl subjectIdManagerServiceImpl;

    public SubjectIdController(SubjectIdManagerServiceImpl subjectIdManagerServiceImpl) {
        this.subjectIdManagerServiceImpl = subjectIdManagerServiceImpl;
    }

    @PostMapping("/addIds")
    public void addIds(@RequestBody Set<String> ids) {
        subjectIdManagerServiceImpl.addIds(ids);
    }

    @GetMapping("/getIds")
    public Set<String> getIds() {
        return subjectIdManagerServiceImpl.getIds();
    }
}
