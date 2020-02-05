package setsAndGenerics.model;

import java.util.Arrays;
import java.util.Objects;

public class Glasses implements Comparable<Glasses> {

    private String brand;
    private boolean isOptical;
    private String bordercolor;
    private Glass[] glasses = new Glass[2]; //the glasses[0]=left glass and glasses[1]=right glass


    public Glasses(String brand, String bordercolor, String leftGlassColor, String rightGlassColor,
                   double rightOpticalRange, double leftOpticalRange) {
        this.brand = brand;
        this.bordercolor = bordercolor;
        Glass left = new Glass();
        left.opticalRange = leftOpticalRange;
        left.color = leftGlassColor;

        Glass right = new Glass();
        right.opticalRange = rightOpticalRange;
        right.color = rightGlassColor;

        if (rightOpticalRange != 0 || leftOpticalRange != 0) {
            isOptical = true;
        }
        glasses[0] = left;
        glasses[1] = right;

    }

    //getters
    public String getBrand() {
        return this.brand;
    }

    public boolean getIsOptical() {
        return this.isOptical;
    }

    public String getBordercolor() {
        return this.bordercolor;
    }

    public Glass[] getGlasses() {
        return this.glasses;
    }

    /**
     * 2 Glasses are equa if all their fields are equal
     *
     * @param o the Glass object, to be tested for equality with 'this'
     * @return true, if the parameters are equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Glasses glasses1 = (Glasses) o;
        return this.isOptical == glasses1.isOptical &&
                this.brand.equals(glasses1.brand) &&
                this.bordercolor.equals(glasses1.bordercolor) &&
                Arrays.equals(this.glasses, glasses1.glasses);
    }

    /**
     * @return hashcode, based on all fields of the Glasses class
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(this.brand, this.isOptical, this.bordercolor);
        result = 31 * result + Arrays.hashCode(this.glasses);
        return result;
    }

    /**
     * Glasses are compared by their brand, than border color, than total optical range
     *
     * @param glasses the Glasses object to be compared to 'this'
     * @return negative int, if this<glasses, positive int, if this>glasses, and 0 otherwise
     */
    @Override
    public int compareTo(Glasses glasses) {
        int compareByBrand = this.brand.compareTo(glasses.brand);
        int compareByBorderColor = this.brand.compareTo(glasses.bordercolor);
        int compareByOpticalRange = (int) ((this.glasses[0].opticalRange + this.glasses[1].opticalRange) -
                (glasses.glasses[0].opticalRange + glasses.glasses[1].opticalRange));

        if (compareByBrand != 0) {
            return compareByBrand;
        } else if (compareByBorderColor != 0) {
            return compareByBorderColor;
        } else {
            return compareByOpticalRange;
        }

    }

    /**
     * Represents a single glass present in glasses.
     */
    private class Glass {
        String color = "transparent";
        double opticalRange;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            final Glass glass = (Glass) o;
            return Double.compare(glass.opticalRange, this.opticalRange) == 0 &&
                    Objects.equals(this.color, glass.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.color, this.opticalRange);
        }

    }

}
