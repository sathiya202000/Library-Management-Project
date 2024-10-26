package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Return;
import com.example.librarymanagementsystem.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    public List<Return> getAllReturns() {
        return returnRepository.findAll();
    }

    public Return getReturnById(Long returnId) {
        return returnRepository.findById(returnId).orElse(null);
    }

    public void saveReturn(Return returnRecord) {
        returnRepository.save(returnRecord);
    }

    public void deleteReturn(Long returnId) {
        returnRepository.deleteById(returnId);
    }
}
