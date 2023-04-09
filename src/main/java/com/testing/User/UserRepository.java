package com.testing.User;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// fake repository that's not connected to database
@Repository
public class UserRepository implements ObjectRepository<User> {
    private Map<Integer, User> repository;
    public UserRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(User emp) {
        repository.put(emp.getId(), emp);
    }

    @Override
    public User retrieve(int id) {
        return repository.get(id);
    }

    @Override
    public User search(String name) {
        Collection<User> emps = repository.values();
        for (User emp : emps) {
            if (emp.getName().equalsIgnoreCase(name))
                return emp;
        }
        return null;
    }

    @Override
    public User delete(int id) {
        User e = repository.get(id);
        this.repository.remove(id);
        return e;
    }
}

