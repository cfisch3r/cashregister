package de.agiledojo.tdd.cashregister;

/**
 * Created by chfischer on 18.10.16.
 */
public interface BarcodeService {
    BarcodeInformation getInformation(String barcode);
}