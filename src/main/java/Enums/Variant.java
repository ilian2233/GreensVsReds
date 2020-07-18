package Enums;

import Exceptions.VariantNotFoundException;

public enum Variant {
    Green,
    Red;

    public static Variant valueOf(char val) throws VariantNotFoundException {
        if (val == '1') {
            return Green;
        } else if (val == '0') {
            return Red;
        } else {
            throw new VariantNotFoundException();
        }
    }
}
