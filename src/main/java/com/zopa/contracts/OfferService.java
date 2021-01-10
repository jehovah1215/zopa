package com.zopa.contracts;

import com.zopa.Exceptions.InsufficientOfferException;
import com.zopa.model.Loan;
import com.zopa.model.Offer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OfferService {

    /**
     * @return List of offers
     */
    default List<Offer> getLoanOffers(Loan loan) throws InsufficientOfferException, IOException {
        return new ArrayList<>();
    }

    default List<Offer> getAvailableOffers() throws InsufficientOfferException, IOException {
        return new ArrayList<>();
    }
}
