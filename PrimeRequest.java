package ru.mirea.dyachenkova.tasktwo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimeRequest {
    @JsonProperty("name")
    public String name;
    @JsonProperty("lenght")
    public int lenght;
    @JsonProperty("numbers")
    public String numbers;
    @JsonProperty("answer")
    public  boolean answer;

    public PrimeRequest(String name, int lenght, String numbers) {
        this.name = name;
        this.lenght = lenght;
        this.numbers = numbers;
    }

    public PrimeRequest() {
    }

    public String getName() {
        return name;
    }

    public int getLenght() {
        return lenght;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
