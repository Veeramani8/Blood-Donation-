package com.example.App.Service;

import com.example.App.Model.Receiver;
import com.example.App.Repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    public Receiver createReceiver(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    public List<Receiver> getAllReceivers() {
        return receiverRepository.findAll();
    }

    public Receiver getReceiverById(Long id) {
        return receiverRepository.findById(id).orElse(null);
    }

    public  Receiver updateReceiver(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    public void deleteReceiver(Long id) {
        receiverRepository.deleteById(id);
    }
}
