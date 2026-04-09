

interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        // Create a NEW object with same values
        return new Rectangle(this.width, this.height);
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        // Create a NEW object with same value
        return new Square(this.length);
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> clonedList = new ArrayList<>();

        for (Shape shape : shapes) {
            clonedList.add(shape.clone()); // clone each shape
        }

        return clonedList;
    }
}