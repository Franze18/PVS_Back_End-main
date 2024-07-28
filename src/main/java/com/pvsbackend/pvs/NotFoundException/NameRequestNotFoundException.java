package com.pvsbackend.pvs.NotFoundException;

public class NameRequestNotFoundException extends RuntimeException {
    public NameRequestNotFoundException(Long id) {
        super("Could not find name request " + id);
    }
}
