package com.zopa.dev;

import com.zopa.dev.Exceptions.InsufficientOfferException;
import com.zopa.dev.Exceptions.InvalidRequestAmountException;
import com.zopa.dev.contracts.CalculationService;
import com.zopa.dev.contracts.OfferService;
import com.zopa.dev.contracts.ValidationService;
import com.zopa.dev.model.Loan;
import com.zopa.dev.model.Offer;
import com.zopa.dev.service.CsvOfferService;
import com.zopa.dev.service.LoanValidationService;
import com.zopa.dev.service.QuoteCalculationService;

import java.io.IOException;
import java.util.List;

/*
 * This class the main entry point of the service
 */
public class AppEntry {

    // Following services will be auto injected by using dependency injection
    private static ValidationService validationService = new LoanValidationService();
    private static CalculationService calculationService;
    private static OfferService offerService;


    /**
     * @param args supplied file path and loan amount
     * @throws IOException and InvalidRequestAmountException
     */
    public static void main(String[] args) throws IOException, InvalidRequestAmountException {

        if (args.length < 2 || !validationService.isNumeric(args[1])) {
            System.err.println("Incomplete/invalid parameters supplied");
            System.exit(1);
        }

        try {
            Loan loan = new Loan(args[1]);

            // First call is to validate
            validationService.Validate(loan);

            // Create and initialize the offer service
            offerService = new CsvOfferService(args[0]);

            // Offers should only be obtained if request is valid
            List<Offer> offers = offerService.getLoanOffers(loan);

            // Create and initialize the calculation service
            calculationService = new QuoteCalculationService(loan, offers);

            // print the result
            System.out.println("Request Amount: £" + String.format("%.0f", loan.getRequestedAmount()));
            System.out.println("Rate: " + String.format("%.1f", calculationService.getAverageRate() * 100) + "%");
            System.out.println("Monthly repayment £" + String.format("%.2f", calculationService.getMonthlyPayment()));
            System.out.println("Total repayment: £" + String.format("%.2f", calculationService.getTotalPayment()));

        } catch (InvalidRequestAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientOfferException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}
