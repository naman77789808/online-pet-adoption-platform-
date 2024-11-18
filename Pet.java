// Pet.java

public class Pet {
    private int id;
    private String name;
    private String breed;
    private int age;
    private String description;
    private String image;

    // Constructor
    public Pet(int id, String name, String breed, int age, String description, String image) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.image = image;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", breed=" + breed + ", age=" + age + ", description=" + description + ", image=" + image + "]";
    }
}
