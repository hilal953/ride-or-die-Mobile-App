package com.Hilal.CourseWork;

public class Types {
    private int carImage;
    private String type;

    public Types(int carImage, String type) {
        this.carImage = carImage;
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Types(String type){
        this.type=type;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }


}
