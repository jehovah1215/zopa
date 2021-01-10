package com.zopa.service;

import com.zopa.Exceptions.InvalidRequestAmountException;
import com.zopa.contracts.ValidationService;
import com.zopa.model.Loan;

import static com.zopa.constants.Constants.INCREMENT_AMOUNT;
import static com.zopa.constants.Constants.LOWER_RANGE;
import static com.zopa.constants.Constants.UPPER_RANGE;

import java.math.BigDecimal;

public class LoanValidationService implements ValidationService {

    /**
     * @param requestedAmountArg
     * @return
     * @throws InvalidRequestAmountException
     */
    @Override
    public boolean isNumeric(String requestedAmountArg) {
        return requestedAmountArg != null && requestedAmountArg.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     * @param loan detail
     * @return
     * @throws InvalidRequestAmountException
     */
    @Override
    public boolean validateLoan(Loan loan) throws InvalidRequestAmountException {

        if (loan.getRequestedAmount().compareTo(LOWER_RANGE) < 0 || loan.getRequestedAmount().compareTo(UPPER_RANGE) > 0) {
            throw new InvalidRequestAmountException("The requested amount is out of range 1000 and 15000");
        }

        BigDecimal remainder = loan.getRequestedAmount().remainder(INCREMENT_AMOUNT);

        if (remainder.intValueExact() > 0)
            throw new InvalidRequestAmountException("The requested amount is not incremental of 100");

        return true;
    }
}
