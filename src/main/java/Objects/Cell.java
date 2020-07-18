package Objects;

import Enums.Variant;

class Cell {

    Variant variant;

    public Cell(Variant variant) {
        this.variant = variant;
    }

    @Override
    public String toString() {
        return String.valueOf(variant);
    }
}
