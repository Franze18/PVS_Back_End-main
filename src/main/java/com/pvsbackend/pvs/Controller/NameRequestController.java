package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.NameRequest;
import com.pvsbackend.pvs.NotFoundException.NameRequestNotFoundException;
import com.pvsbackend.pvs.Repository.NameRequestRepository;

@RestController
@RequestMapping("/api/v1/namerequest")
public class NameRequestController {
    
    private final NameRequestRepository repo;

    public NameRequestController(NameRequestRepository repo) {
        this.repo = repo;
    }

    // GET ALL NAME REQUESTS
    // http://127.0.0.1:8080/api/v1/namerequest/all
    @GetMapping("/all")
    public List<NameRequest> getNameRequests() {
        return repo.findAll();
    }

    // GET ONE NAME REQUEST
    // http://127.0.0.1:8080/api/v1/namerequest/{id}
    @GetMapping("/{id}")
    public NameRequest getNameRequestById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NameRequestNotFoundException(id));
    }

    // CREATE ENDPOINT
    // http://127.0.0.1:8080/api/v1/namerequest/new
    @PostMapping("/new")
    public String addNameRequest(@RequestBody NameRequest newNameRequest) {
        repo.save(newNameRequest);
        return "A new name request is added. Yey!";
    }

    // UPDATE ENDPOINT
    // http://127.0.0.1:8080/api/v1/namerequest/edit/{id}
    @PutMapping("/edit/{id}")
    public NameRequest updateNameRequest(@PathVariable Long id, @RequestBody NameRequest newNameRequest) {
        return repo.findById(id)
                .map(nameRequest -> {
                    nameRequest.setProductId(newNameRequest.getProductId());
                    nameRequest.setSurname(newNameRequest.getSurname());
                    nameRequest.setTeamName(newNameRequest.getTeamName());
                    nameRequest.setHasShort(newNameRequest.getHasShort());
                    nameRequest.setPlayerNumber(newNameRequest.getPlayerNumber());
                    return repo.save(nameRequest);
                }).orElseGet(() -> {
                    return repo.save(newNameRequest);
                });
    }

    // DELETE ENDPOINT
    // http://127.0.0.1:8080/api/v1/namerequest/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deleteNameRequest(@PathVariable Long id) {
        repo.deleteById(id);
        return "A name request is deleted!";
    }
}
