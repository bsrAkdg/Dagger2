package com.bsrakdg.beginnerdagger2;

import javax.inject.Inject;

public class Wheels {
    // We don't own this class so we can't annotate it with @Inject
    // We should use Module and Provider for get instance : look at WheelsModule
    // If we cant inject constructor
    // or We should use Module and Provider we have to call another functions we created an instance

    private Rims rims;
    private Tires tires;

    @Inject
    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }

}
