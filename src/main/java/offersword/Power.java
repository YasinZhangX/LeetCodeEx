package offersword;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @author Yasin Zhang
 */
public class Power {
    public double Solution(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -1 * exponent;
        }

        if (exponent % 2 == 0) {
            if (flag) {
                return 1 / (Solution(base, exponent/2) * Solution(base, exponent/2));
            } else {
                return Solution(base, exponent/2) * Solution(base, exponent/2);
            }
        } else {
            if (flag) {
                return 1 / (base * Solution(base, exponent/2) * Solution(base, exponent/2));
            } else {
                return base * Solution(base, exponent/2) * Solution(base, exponent/2);
            }
        }
    }

    public double solution_better(double base, int exponent) {
        if (base == 0) {
            return 0;
        }

        double result = powerWithNonNegativeExponent(base, Math.abs(exponent));
        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    private double powerWithNonNegativeExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        double result = powerWithNonNegativeExponent(base, exponent >>> 1);
        result = result * result;
        if ((exponent & 1) != 0) {
            result = result * base;
        }

        return result;
    }
}
