package ru.jabori.potsg.crud.models.simple;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
public class Users implements Serializable {

    @OneToMany(mappedBy = "users")
    private List<Numbers> numbers;

    @OneToMany(mappedBy = "users1")
    private List<Links> links;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    public Users() {
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Numbers> numbers) {
        this.numbers = numbers;
    }
}
