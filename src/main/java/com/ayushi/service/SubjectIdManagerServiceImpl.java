package com.ayushi.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectIdManagerServiceImpl implements SubjectIdManagerService {

    private final Set<String> ids;

    /**
     * Initializes ids as a synchronizedSet which wraps an ArrayList.
     * * Collections.synchronizedSet ensures that all access to the list
     ** * is thread-safe by synchronizing on the list's internal monitor.
     * * This means that only one thread can modify the list at a time,
     * * preventing concurrent modification issues.*
     */
    public SubjectIdManagerServiceImpl() {
        this.ids = Collections.synchronizedSet(new HashSet<>());
    }

    // Method to add IDs if they are not already present (Set handles duplicates)
    public synchronized void addIds(Set<String> newIds) {
        ids.addAll(newIds);
    }

    // Method to retrieve all IDs
    public synchronized Set<String> getIds() {
        return new HashSet<>(ids);
    }

    // Method to check if a specific ID is present
    public synchronized boolean containsId(String id) {
        return ids.contains(id);
    }

}
