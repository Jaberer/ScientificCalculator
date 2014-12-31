package jz.scientificcalculator;

/**
 * Created by Joseph on 12/31/2014.
 */
public class OperationClass
{
    private double first;
    private double second;
    private Operation currentOp;

    private enum Operation
    {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        STARTOVER,
        NONE
    }

    public OperationClass()
    {

    }

    public double divide(double first, double second)
    {
        return first / second;
    }

    public double multiply(double first, double second)
    {
        return first * second;
    }

    public double subtract(double first, double second)
    {
        return first - second;
    }

    public double plus(double first, double second)
    {
        return first + second;
    }

    public void setFirst(double _first)
    {
        first = _first;
    }

    public void setSecond(double _second)
    {
        second = _second;
    }
}
