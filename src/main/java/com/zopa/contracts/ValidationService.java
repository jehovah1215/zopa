package com.zopa.contracts;

import com.zopa.Exceptions.InvalidRequestAmountException;
import com.zopa.model.Loan;

public interface ValidationService {

    /**
     * @param requestedAmountArg
     * @return
     */
    default boolean isNumeric(String requestedAmountArg) {
        return false;
    }

    /**
     * @param loan detail
     * @return sucess/fail
     * @throws InvalidRequestAmountException
     */
    default boolean validateLoan(Loan loan) throws InvalidRequestAmountException {
        return false;
    }
}
