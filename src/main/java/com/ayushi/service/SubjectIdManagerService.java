package com.ayushi.service;

import java.util.Set;

public interface SubjectIdManagerService {
    void addIds(Set<String> newIds);
    Set<String> getIds();
    boolean containsId(String id);

}
