package com.fp.finterface;

public class ReceiptPrinterTest {
    public static void main(String[] args) {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter() {
            @Override
            public void print(Receipt receipt) {
                System.out.println(receipt);
            }
        };
        Receipt receipt = new Receipt("shirt", 100.00, 0.05, 0.01);
        receiptPrinter.print(receipt);
        System.out.println(receiptPrinter.computeTotal(receipt));
    }
}
