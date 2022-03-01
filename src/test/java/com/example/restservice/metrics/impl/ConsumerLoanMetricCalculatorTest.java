package com.example.restservice.metrics.impl;

import com.example.restservice.metrics.ILoanMetricCalculator;
import com.example.restservice.metrics.LoanMetricFactory;
import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanMetric;
import com.example.restservice.util.LoanGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsumerLoanMetricCalculatorTest {

    ILoanMetricCalculator metricCalculator = new ConsumerLoanMetricCalculator();

    @Test
    void testLoanMetric() {
        Loan loan = LoanGeneratorUtil.createLoan(10L);
        loan.setType(LoanMetricFactory.LOAN_TYPE_CONSUMER);
        loan.setAnnualInterest(6.0);
        loan.setTermMonths(24);

        LoanMetric loanMetric = metricCalculator.getLoanMetric(loan);

        Assertions.assertEquals(0.005, loanMetric.getMonthlyInterestRate());
        Assertions.assertEquals(443.20, loanMetric.getMonthlyPayment());
    }

}