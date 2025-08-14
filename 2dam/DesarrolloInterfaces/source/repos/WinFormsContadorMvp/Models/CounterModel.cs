
namespace WinFormsContadorMvp.Models;

public class CounterModel
{
    private int _number = 0;

    public int Increment() => ++_number;
    public int Decrement() => --_number;

    internal int Get() => _number;
}
