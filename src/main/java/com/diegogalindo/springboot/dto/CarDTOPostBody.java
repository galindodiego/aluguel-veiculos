package com.diegogalindo.springboot.dto;

public class CarDTOPostBody extends CarDTO{
    private Boolean replaceable;

    public Boolean getReplaceable() {
        return replaceable;
    }

    public void setReplaceable(Boolean replaceable) {
        this.replaceable = replaceable;
    }
}
