package construction;

public class Temperature {

    private double fahrenheit;


    public Temperature() {
        this.fahrenheit = 0;
    }

    public double getCelsius() {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getKelvin() {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public void setCelsius(double celsius) {
        this.fahrenheit = celsius * 9 / 5 + 32;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public void setKelvin(double kelvin) {
        this.fahrenheit = kelvin * 9 / 5 - 459.67;
    }

}
