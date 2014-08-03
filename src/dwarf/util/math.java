package dwarf.util;

/**
 * Utility and fast math functions.
 *
 * @author sid_th3_sl0th
 * @see java.lang.Math
 */
public final class math {

    public math() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * The value PI as a float. (180 degrees)
     */
    public static final float PI = (float) Math.PI;
    /**
     * The value 2PI as a float. (360 degrees)
     */
    public static final float TWO_PI = 2.0f * PI;
    /**
     * The value PI/2 as a float. (90 degrees)
     */
    public static final float HALF_PI = 0.5f * PI;
    /**
     * The value PI/4 as a float. (45 degrees)
     */
    public static final float QUARTER_PI = 0.25f * PI;
    /**
     * The value 1/PI as a float.
     */
    public static final float INV_PI = 1.0f / PI;
    /**
     * The value 1/(2PI) as a float.
     */
    public static final float INV_TWO_PI = 1.0f / TWO_PI;

    public static int pow(int base, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("This function does not support negative powers.");
        } else {
            int ans = (base);
            for (int i = 1; i < power; i++) {
                ans *= (base);
            }
            return (ans);
        }
    }

    public static float pow(float base, float power) {
        float ans = (base);
        for (int i = 1; i < power; i++) {
            ans *= (base);
        }
        return (ans);
    }

    public static double pow(double base, double power) {
        double ans = (base);
        for (int i = 1; i < power; i++) {
            ans *= (base);
        }
        return (ans);
    }

    public static boolean isPrime(int num) {
        if (num != 2) {
            if (num % 2 == 0 || num == 1) {
                return (false);
            } else {
                for (int i = 3; i < Math.sqrt(num) + 1; i += 2) {
                    if (num % i == 0) {
                        return (false);
                    }
                }
            }
        }
        return (true);
    }

    public static boolean isPrime(long num) {
        if (num != 2) {
            if (num % 2 == 0 || num == 1) {
                return (false);
            } else {
                for (long i = 3; i < Math.sqrt(num) + 1; i += 2) {
                    if (num % i == 0) {
                        return (false);
                    }
                }
            }
        }
        return (true);
    }

    public static long fact(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static int fib(int num) {
        if (num < 2) {
            return (num);
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

    /**
     * Determines the greatest common divisor of a pair of natural numbers using
     * the Euclidean algorithm. This method only works with natural numbers. If
     * negative integers are passed in, the absolute values will be used. The
     * return value is always positive.
     *
     * @param a The first value.
     * @param b The second value.
     * @return The greatest common divisor.
     */
    public static long highestCommonFactor(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calculate logarithms for arbitrary bases.
     *
     * @param base The base for the logarithm.
     * @param arg The value to calculate the logarithm for.
     * @return The log of {@code arg} in the specified {@code base}.
     */
    public static double log(double base, double arg) {
        // Use natural logarithms and change the base.
        return Math.log(arg) / Math.log(base);
    }

    public static boolean isMultiple(long number, long value) {
        return isFactor(value, number);
    }

    public static boolean isFactor(long number, long value) {
        if (number == 0 || value == 0) {
            return false;
        } else {
            return number % value == 0;
        }
    }

    public static boolean hasDecimal(double number) {
        return number % 1.0 != 0.0;
    }

    public static boolean isWhole(double number) {
        return !hasDecimal(number);
    }

    public static boolean isEven(int input) {
        return (input % 2) == 0;
    }

    public static boolean isOdd(int input) {
        return !isEven(input);
    }

    public static boolean isPowerOfTwo(int number) {
        return (number > 0) && (number & (number - 1)) == 0;
    }

    public static int nearestPowerOfTwo(int number) {
        return (int) Math.pow(2, Math.ceil(Math.log(number) / Math.log(2)));
    }

    /**
     * Linear interpolation from startValue to endValue by the given percent.
     * Basically: ((1 - percent) * startValue) + (percent * endValue)
     *
     * @param scale scale value to use. if 1, use endValue, if 0, use
     * startValue.
     * @param startValue Begining value. 0% of f
     * @param endValue ending value. 100% of f
     * @return The interpolated value between startValue and endValue.
     */
    public static float interpolateLinear(float scale, float startValue, float endValue) {
        if (startValue == endValue) {
            return startValue;
        } else if (scale <= 0f) {
            return startValue;
        } else if (scale >= 1f) {
            return endValue;
        } else {
            return ((1f - scale) * startValue) + (scale * endValue);
        }
    }

    /**
     * Returns 1/sqrt(fValue)
     *
     * @param fValue The value to process.
     * @return 1/sqrt(fValue)
     * @see java.lang.Math#sqrt(double)
     */
    public static float invSqrt(float fValue) {
        return (float) (1.0f / Math.sqrt(fValue));
    }

    /**
     * Returns the logarithm of value with given base, calculated as
     * log(value)/log(base), so that pow(base, return)==value (contributed by
     * vear)
     *
     * @param value The value to log.
     * @param base Base of logarithm.
     * @return The logarithm of value with given base
     */
    public static float log(float value, float base) {
        return (float) (Math.log(value) / Math.log(base));
    }

    public static float sqr(float fValue) {
        return fValue * fValue;
    }

    public static double sqr(double dValue) {
        return dValue * dValue;
    }

    /**
     * Returns the square root of a given value.
     *
     * @param fValue The value to sqrt.
     * @return The square root of the given value.
     * @see java.lang.Math#sqrt(double)
     */
    public static float sqrt(float fValue) {
        return (float) Math.sqrt(fValue);
    }

    /**
     * Returns the tangent of a value. If USE_FAST_TRIG is enabled, an
     * approximate value is returned. Otherwise, a direct value is used.
     *
     * @param fValue The value to tangent, in radians.
     * @return The tangent of fValue.
     * @see java.lang.Math#tan(double)
     */
    public static float tan(float fValue) {
        return (float) Math.tan(Math.toDegrees(fValue));
    }

    /**
     * Returns the tangent of a value. If USE_FAST_TRIG is enabled, an
     * approximate value is returned. Otherwise, a direct value is used.
     *
     * @param dValue The value to tangent, in radians.
     * @return The tangent of fValue.
     * @see java.lang.Math#tan(double)
     */
    public static double tan(double dValue) {
        return Math.tan(Math.toDegrees(dValue));
    }

    /**
     * Returns the cosine of a value. If USE_FAST_TRIG is enabled, an
     * approximate value is returned. Otherwise, a direct value is used.
     *
     * @param fValue The value to cosine, in radians.
     * @return The tangent of dValue.
     * @see java.lang.Math#cos(double)
     */
    public static float cos(float fValue) {
        return (float) Math.cos(Math.toDegrees(fValue));
    }

    /**
     * Returns the cosine of a value. If USE_FAST_TRIG is enabled, an
     * approximate value is returned. Otherwise, a direct value is used.
     *
     * @param dValue The value to cosine, in radians.
     * @return The cos of dValue.
     * @see java.lang.Math#cos(double)
     */
    public static double cos(double dValue) {
        return Math.cos(Math.toDegrees(dValue));
    }

    /**
     * Returns the sine of a value. If USE_FAST_TRIG is enabled, an approximate
     * value is returned. Otherwise, a direct value is used.
     *
     * @param fValue The value to sin, in radians.
     * @return The sine of fValue.
     * @see java.lang.Math#sin(double)
     */
    public static float sin(float fValue) {
        return (float) Math.sin(Math.toDegrees(fValue));
    }

    /**
     * Returns the sine of a value. If USE_FAST_TRIG is enabled, an approximate
     * value is returned. Otherwise, a direct value is used.
     *
     * @param dValue The value to sine, in radians.
     * @return The sine of dValue.
     * @see java.lang.Math#sin(double)
     */
    public static double sin(double dValue) {
        return Math.sin(Math.toDegrees(dValue));
    }

    /**
     * Returns 1 if the number is positive, -1 if the number is negative, and 0
     * otherwise
     *
     * @param iValue The integer to examine.
     * @return The integer's sign.
     */
    public static int sign(int iValue) {
        if (iValue > 0) {
            return 1;
        } else if (iValue < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Returns 1 if the number is positive, -1 if the number is negative, and 0
     * otherwise
     *
     * @param fValue The float to examine.
     * @return The float's sign.
     */
    public static float sign(float fValue) {
        return Math.signum(fValue);
    }

    /**
     * Takes an value and expresses it in terms of min to max.
     *
     * @param val - the angle to normalize (in radians)
     * @param min the minimum value
     * @param max the maximum value
     * @return the normalized angle (also in radians)
     */
    public static float normalize(float val, float min, float max) {
        if (Float.isInfinite(val) || Float.isNaN(val)) {
            return 0f;
        }
        float range = max - min;
        while (val > max) {
            val -= range;
        }
        while (val < min) {
            val += range;
        }
        return val;
    }

    /**
     * @param x the value whose sign is to be adjusted.
     * @param y the value whose sign is to be used.
     * @return x with its sign changed to match the sign of y.
     */
    public static float copysign(float x, float y) {
        if (y >= 0 && x <= -0) {
            return -x;
        } else if (y < 0 && x >= 0) {
            return -x;
        } else {
            return x;
        }
    }

    /**
     * Take a float input and clamp it between min and max.
     *
     * @param input the value to be inputed
     * @param min the minimum value
     * @param max the maximum value
     * @return clamped input
     */
    public static float clamp(float input, float min, float max) {
        return (input < min) ? min : (input > max) ? max : input;
    }

    /**
     * Clamps the given float to be between 0 and 1.
     *
     * @param input the value to be inputed
     * @return input clamped between 0 and 1.
     */
    public static float saturate(float input) {
        return clamp(input, 0f, 1f);
    }

    /**
     * Linear extrapolation from startValue to endValue by the given scale. if
     * scale is between 0 and 1 this method returns the same result as
     * interpolateLinear if the scale is over 1 the value is linearly
     * extrapolated. Note that the end value is the value for a scale of 1.
     *
     * @param scale the scale for extrapolation
     * @param startValue the starting value (scale = 0)
     * @param endValue the end value (scale = 1)
     * @return an extrapolation for the given parameters
     */
    public static double extrapolateLinear(double scale, double startValue, double endValue) {
        return ((1f - scale) * startValue) + (scale * endValue);
    }

    /**
     * Linear extrapolation from startValue to endValue by the given scale. if
     * scale is between 0 and 1 this method returns the same result as
     * interpolateLinear if the scale is over 1 the value is linearly
     * extrapolated. Note that the end value is the value for a scale of 1.
     *
     * @param scale the scale for extrapolation
     * @param startValue the starting value (scale = 0)
     * @param endValue the end value (scale = 1)
     * @return an extrapolation for the given parameters
     */
    public static Vector3 extrapolateLinear(double scale, Vector3 startValue, Vector3 endValue) {
        double x, y, z;
        x = extrapolateLinear(scale, startValue.getX(), endValue.getX());
        y = extrapolateLinear(scale, startValue.getY(), endValue.getY());
        z = extrapolateLinear(scale, startValue.getZ(), endValue.getZ());

        return new Vector3(x, y, z);
    }

    /**
     * Interpolate a spline between at least 4 control points following the
     * Catmull-Rom equation. here is the interpolation matrix m = [ 0.0 1.0 0.0
     * 0.0 ] [-T 0.0 T 0.0 ] [ 2T T-3 3-2T -T ] [-T 2-T T-2 T ] where T is the
     * curve tension the result is a value between p1 and p2, t=0 for p1, t=1
     * for p2
     *
     * @param u value from 0 to 1
     * @param T The tension of the curve
     * @param p0 control point 0
     * @param p1 control point 1
     * @param p2 control point 2
     * @param p3 control point 3
     * @return catmull-Rom interpolation
     */
    public static double interpolateCatmullRom(double u, double T, double p0, double p1, double p2, double p3) {
        double c1, c2, c3, c4;
        c1 = p1;
        c2 = -1.0f * T * p0 + T * p2;
        c3 = 2 * T * p0 + (T - 3) * p1 + (3 - 2 * T) * p2 + -T * p3;
        c4 = -T * p0 + (2 - T) * p1 + (T - 2) * p2 + T * p3;

        return (((c4 * u + c3) * u + c2) * u + c1);
    }

    /**
     * Interpolate a spline between at least 4 control points following the
     * Catmull-Rom equation. here is the interpolation matrix m = [ 0.0 1.0 0.0
     * 0.0 ] [-T 0.0 T 0.0 ] [ 2T T-3 3-2T -T ] [-T 2-T T-2 T ] where T is the
     * tension of the curve the result is a value between p1 and p2, t=0 for p1,
     * t=1 for p2
     *
     * @param u value from 0 to 1
     * @param T The tension of the curve
     * @param p0 control point 0
     * @param p1 control point 1
     * @param p2 control point 2
     * @param p3 control point 3
     * @return catmull-Rom interpolation
     */
    public static Vector3 interpolateCatmullRom(float u, float T, Vector3 p0, Vector3 p1, Vector3 p2, Vector3 p3) {
        double x, y, z;
        x = interpolateCatmullRom(u, T, p0.getX(), p1.getX(), p2.getX(), p3.getX());
        y = interpolateCatmullRom(u, T, p0.getY(), p1.getY(), p2.getY(), p3.getY());
        z = interpolateCatmullRom(u, T, p0.getZ(), p1.getZ(), p2.getZ(), p3.getZ());

        return new Vector3(x, y, z);
    }

    /**
     * Interpolate a spline between at least 4 control points following the
     * Bezier equation. here is the interpolation matrix m = [ -1.0 3.0 -3.0 1.0
     * ] [ 3.0 -6.0 3.0 0.0 ] [ -3.0 3.0 0.0 0.0 ] [ 1.0 0.0 0.0 0.0 ] where T
     * is the curve tension the result is a value between p1 and p3, t=0 for p1,
     * t=1 for p3
     *
     * @param u value from 0 to 1
     * @param p0 control point 0
     * @param p1 control point 1
     * @param p2 control point 2
     * @param p3 control point 3
     * @return Bezier interpolation
     */
    public static double interpolateBezier(double u, double p0, double p1, double p2, double p3) {
        double oneMinusU = 1.0f - u;
        double oneMinusU2 = oneMinusU * oneMinusU;
        double u2 = u * u;

        return (p0 * oneMinusU2 * oneMinusU
                + 3.0f * p1 * u * oneMinusU2
                + 3.0f * p2 * u2 * oneMinusU
                + p3 * u2 * u);
    }

    /**
     * Interpolate a spline between at least 4 control points following the
     * Bezier equation. here is the interpolation matrix m = [ -1.0 3.0 -3.0 1.0
     * ] [ 3.0 -6.0 3.0 0.0 ] [ -3.0 3.0 0.0 0.0 ] [ 1.0 0.0 0.0 0.0 ] where T
     * is the tension of the curve the result is a value between p1 and p3, t=0
     * for p1, t=1 for p3
     *
     * @param u value from 0 to 1
     * @param p0 control point 0
     * @param p1 control point 1
     * @param p2 control point 2
     * @param p3 control point 3
     * @return Bezier interpolation
     */
    public static Vector3 interpolateBezier(float u, Vector3 p0, Vector3 p1, Vector3 p2, Vector3 p3) {
        double x, y, z;
        x = interpolateBezier(u, p0.getX(), p1.getX(), p2.getX(), p3.getX());
        y = interpolateBezier(u, p0.getY(), p1.getY(), p2.getY(), p3.getY());
        z = interpolateBezier(u, p0.getZ(), p1.getZ(), p2.getZ(), p3.getZ());

        return new Vector3(x, y, z);
    }

    /**
     * Returns the arc cosine of a value.<br>
     * Special cases:
     * <ul><li>If fValue is smaller than -1, then the result is PI.
     * <li>If the argument is greater than 1, then the result is 0.</ul>
     *
     * @param fValue The value to arc cosine.
     * @return The angle, in radians.
     * @see java.lang.Math#acos(double)
     */
    public static float acos(float fValue) {
        if (-1.0f < fValue) {
            if (fValue < 1.0f) {
                return (float) Math.acos(fValue);
            } else {
                return 0.0f;
            }
        } else {
            return PI;
        }
    }

    /**
     * Returns the arc sine of a value.<br>
     * Special cases:
     * <ul><li>If fValue is smaller than -1, then the result is -HALF_PI.
     * <li>If the argument is greater than 1, then the result is HALF_PI.</ul>
     *
     * @param fValue The value to arc sine.
     * @return the angle in radians.
     * @see java.lang.Math#asin(double)
     */
    public static float asin(float fValue) {
        if (-1.0f < fValue) {
            if (fValue < 1.0f) {
                return (float) Math.asin(fValue);
            } else {
                return HALF_PI;
            }
        } else {
            return -HALF_PI;
        }
    }

    public static float clampf(float v, float min, float max) {
        if (v < min) {
            return min;
        } else if (v > max) {
            return max;
        } else {
            return v;
        }
    }

    /**
     * Returns the lowest positive root of the quadric equation given by a* x *
     * x + b * x + c = 0. If no solution is given Float.Nan is returned.
     *
     * @param a the first coefficient of the quadric equation
     * @param b the second coefficient of the quadric equation
     * @param c the third coefficient of the quadric equation
     * @return the lowest positive root or Float.Nan
     */
    static public float lowestPositiveRoot(float a, float b, float c) {
        float det = b * b - 4 * a * c;

        if (det < 0) {
            return Float.NaN;
        } else {

            float sqrtD = (float) Math.sqrt(det);
            float invA = 1 / (2 * a);
            float r1 = (-b - sqrtD) * invA;
            float r2 = (-b + sqrtD) * invA;

            if (r1 > r2) {
                float tmp = r2;
                r2 = r1;
                r1 = tmp;
            }

            if (r1 > 0) {
                return r1;
            }
            if (r2 > 0) {
                return r2;
            }
            return Float.NaN;
        }
    }

    /**
     * Returns the next power of two. Returns the specified value if the value
     * is already a power of two.
     *
     * @param value the number to tested
     * @return the next power of two of the entered value
     */
    public static int nextPowerOfTwo(int value) {
        if (value == 0) {
            return 1;
        } else {
            value--;
            value |= value >> 1;
            value |= value >> 2;
            value |= value >> 4;
            value |= value >> 8;
            value |= value >> 16;
            return value + 1;
        }
    }
}
